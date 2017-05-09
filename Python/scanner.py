# coding:utf-8

from ctypes import *
from netaddr import IPNetwork, IPAddress

import struct
import os
import socket
import threading
import time

# host que ouvirá
host = "192.168.192.3"

# sub-rede alvo
'''
IP/Mask = 192.168.192.0/255.255.255.240
Binary: 11111111.11111111.11111111.11110000 = 28 bits 1.
CIDR: 28
'''
subnet = "192.168.192.0/28"

# string mágica em relação à qual verificaremos as respostas ICMP
magic_message = "$W#ndros%"
# este código espalhaos datagramas UDP
def udp_sender(subnet, magic_message):
    sender = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    for ip in IPNetwork(subnet):
        try:
            sender.sendto(magic_message,("%s" % ip,65212))
        except:
            pass

# cabeçalho ip
class IP(Structure):
    _fields_ = [
        ("ihl",           c_ubyte, 4),
        ("version",       c_ubyte, 4),
        ("tos",           c_ubyte),
        ("len",           c_ushort),
        ("id",            c_ushort),
        ("offset",        c_ushort),
        ("ttl",           c_ubyte),
        ("protocol_num",  c_ubyte),
        ("sum",           c_ushort),
        ("src",           c_ulong),
        ("dst",           c_ulong)
    ]

    def __new__(self, socket_buffer=None):
        return self.from_buffer_copy(socket_buffer)

    def __init__(self, socket_buffer=None):
        # mapeia as constantes do protocolo aos seus nomes
        self.protocol_map = {1:"ICMP", 6:"TCP", 17:"UDP"}

        # endereços IP legíveis aos seres humanos
        self.src_address = socket.inet_ntoa(struct.pack("<L", self.src))
        self.dst_address = socket.inet_ntoa(struct.pack("<L", self.dst))

        try:
            self.protocol = self.protocol_map[self.protocol_num]
        except:
            self.protocol = str(self.protocol_num)

class ICMP(Structure):
    _fields_ = [
        ("type",         c_ubyte),
        ("code",         c_ubyte),
        ("checksum",     c_ushort),
        ("unused",       c_ushort),
        ("next_hop_mtu", c_ushort)
    ]

    def __new__(self, socket_buffer):
        return self.from_buffer_copy(socket_buffer)

    def __init__(self, socket_buffer):
        pass

# cria um socket puro e associa-o à interface pública
if os.name == "nt":
    socket_protocol = socket.IPPROTO_IP
else:
    socket_protocol = socket.IPPROTO_ICMP

sniffer = socket.socket(socket.AF_INET, socket.SOCK_RAW, socket_protocol)
sniffer.bind((host, 0))

# incluindo os cabeçalhos IP na captura
sniffer.setsockopt(socket.IPPROTO_IP, socket.IP_HDRINCL, 1)

# se estivermos utilizando o Windows, deveremos enviar um IOCTL
# para configurar o modo promíscuo
if os.name == "nt":
    sniffer.ioctl(socket.SIO_RCVALL, socket.RCVALL_ON)

# começa a enviar pacotes
t = threading.Thread(target=udp_sender,args=(subnet,magic_message))
t.start()

try:
    while True:
        # lê um único pacote
        raw_buffer = sniffer.recvfrom(65565)[0]

        # cria um cabeçalho ip a partir dos 20 primeiros bytes do buffer
        ip_header = IP(raw_buffer[0:20])
        print "Protocol: %s %s -> %s" % (ip_header.protocol, ip_header.src_address, ip_header.dst_address)

        # se for o ICMP que estamos procurando
        if ip_header.protocol == "ICMP":
            # calcula onde o nosso pacote começa
            offset = ip_header.ihl * 4
            buf = raw_buffer[offset:offset + sizeof(ICMP)]

            # cria a nossa estrutura ICMP
            icmp_header = ICMP(buf)

            print "ICMP -> Type: %d Code: %d" % (icmp_header.type, icmp_header.code)

            # verifica se o TYPE e o CODE são iguais a 3
            if icmp_header.code == 3 and icmp_header.type == 3:
                # garante que o host está em nossa sub-rede alvo
                if IPAddress(ip_header.src_address) in IPNetwork(subnet):
                    # garante que contém a nossa mensagem mágica
                    if raw_buffer[len(raw_buffer)-len(magic_message):] == magic_message:
                        print "Host Up: %s" % ip_header.src_address
# trata o Ctrl+C
except KeyboardInterrupt:
    print "Bye, bye"
    # se estivermos usando Windows, desabilitará o modo promíscuo
    if os.name == "nt":
        sniffer.ioctl(socket.SIO_RCVALL, socket.RCVALL_OFF)
