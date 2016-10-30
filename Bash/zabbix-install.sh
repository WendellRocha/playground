#!/bin/bash

echo "Instalação de dependências do Zabbix."
echo "Você deseja começar a instalação? [s/n]"
read RESPOSTA
test "$RESPOSTA" = "n" && echo "Okay. Finalizado." && exit
echo "Atualizando os pacotes..."
apt-get update
echo "Aplicando as atualizações..."
apt-get upgrade
echo "Instalando as dependências..."
apt-get install make gpp gpp apache2 php php-mysql libapache2-mod-php php-gd libsnmp-dev libcurl14-openssl-dev vim mysql-server mysql-client libmysqld-dev libcurl-dev php-mbstring php-xml
