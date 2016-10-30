#!/bin/bash
echo "Instalação fácil do Zabbix"
echo "Você deseja começar a instalação? [s/n]"
read RESPOSTA
test "$RESPOSTA" = "n" && exit
echo "Para que todo o processo seja realizado sem problemas, é preciso que seja feito pelo usuário root."
echo "Você deseja fazer o processo utilizando o usuário root? [s/n]"
read RESPOSTA2
test "$RESPOSTA2" = "n" && exit
sudo su
echo "Mudando para o diretório de downloads..."
cd Downloads
echo "Baixando o arquivo de fontes do Zabbix Server"
wget https://sourceforge.net/projects/zabbix/files/ZABBIX%20Latest%20Stable/3.0.5/zabbix-3.0.5.tar.gz/download
echo "Descompactando os arquivos fontes..."
tar -zxfv zabbix-3.0.5.tar.gz
echo "Entrando no diretório dos arquivos fontes..."
cd zabbix-3.0.0.5.tar.gz
echo "Atualizando os pacotes..."
sleep 3
apt-get update
echo "Aplicando as atualizações..."
sleep 3
apt-get upgrade
echo "Instalando as dependências..."
sleep 3
apt-get install make gpp gpp apache2 php php-mysql libapache2-mod-php php-gd libsnmp-dev libcurl14-openssl-dev vim mysql-server mysql-client libmysqld-dev libcurl-dev php-mbstring php-xml
