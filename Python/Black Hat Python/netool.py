#coding:utf-8
#!/opt/local/bin/python2.7

import sys
import socket
import getopt
import threading
import subprocess

listen                  = False
command                 = False
upload                  = False
execute                 = ""
target                  = ""
upload_destination      = ""
port                    = 0

def usage():
    print
    print "Usage: netool.py -t target -p port"
    print "-l --listen                      - listen on [host]:[port] for incoming connections"
    print "-e --execute=file_to_run         - execute the give file upon receiving a connection"
    print "-c --command                     - initialize a command shell"
    print "-u --upload=destination          - upon receiving connection upload a file and write to [destination]"
    print "\n\n"
    print "Exemples:"
    print "netool.py -t 0.0.0.0 -p 0000 -l -c"
    print "netool.py -t 0.0.0.0 -p 0000 -l -u=c:\\target.exe"
    print "netool.py -t 0.0.0.0 -p 0000 -l -e=\"cat /etc/passwd\""
    print "echo 'ABCDEFGHI' | ./netool.py -t 0.0.0.0 -p 0000"

def run_command(command):
    command = command.rstrip()
    try:
        output = subprocess.check_output(command, stderr=subprocess.STDOUT, shell=True)
    except:
        output = "Failed to execute command.\r\n"
    return output

def client_handler(client_socket):
    global upload
    global execute
    global command

    if len(upload_destination):
        file_buffer = ""
        while True:
            data = client_socket.recv(1024)
            if not data:
                break
            else:
                file_buffer += data
        try:
            file_descriptor = open(upload_destination, "wb")
            file_descriptor.write(file_buffer)
            file_descriptor.close()
            client_socket.send("Sucessfully saved file to %s\r\n" % upload_destination)
        except:
            client_socket.send("Failed to save file to %s \r\n" % upload_destination)
    if len(execute):
        output = run_command(execute)
        client_socket.send(output)

    if command:
        while True:
            client_socket.send("<netool:#> ")
            cmd_buffer = ""
            while "\n" not in cmd_buffer:
                cmd_buffer += client_socket.recv(1024)
                response = run_command(cmd_buffer)
                client_socket.send(response)

def client_sender(buffer):
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        client.connect((target,port))
        if len(buffer):
            client.send(buffer)
        while True:
            recv_len = 1
            response = ""
            while recv_len:
                data = client.recv(4096)
                recv_len = len(data)
                response += data
                if recv_len < 4096:
                    break
            print response,

            buffer = raw_input("")
            buffer += "\n"

            client.send(buffer)

    except:
        print "[*] Exception! Exiting."
        client.close()

def server_loop():
    global target

    if not len(target):
        target = "0.0.0.0"

    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((target,port))
    server.listen(5)

    while True:
        client_socket, addr = server.accept()
        client_thread = threading.Thread(target=client_handler, args=(client_socket,))
        client_thread.start()

def main():
    global listen
    global port
    global execute
    global command
    global upload_destination
    global target

    if not len(sys.argv[1:]):
        usage()

    try: 
        opts, args = getopt.getopt(sys.argv[1:], "hle:t:p:cu:", ["help", "listen", "execute", "target", "port", "command", "upload"])
    except getopt.GetoptError as err:
        print str(err)
        usage()

    for o,a in opts:
        if o in ("-h", "--help"):
            usage()
        elif o in ("-l", "--listen"):
            listen = True
        elif o in ("-c", "--commandshell"):
            command = True
        elif o in ("-u", "--upload"):
            upload_destination = a
        elif o in ("-t", "--target"):
            target = a
        elif o in ("-p", "--port"):
            port = int(a)
        else:
            assert False, "Unhandled Option"

    if not listen and len(target) and port > 0:
        # Lê o buffer da linha de comando.
        # Isso causará um bloqueio. Portanto, envie um ctrl+d
        #  se não estiver enviando dados de entrada para o stdin
        buffer = sys.stdin.read()
        client_sender(buffer)

        # Iremos ouvir a porta e, potencialmente, faremos o upload de dados,
        #  executaremos comandos e deixaremos um shell
        # de acordo com as opções de linha de comando anteriores
    if listen:
        server_loop()
main()