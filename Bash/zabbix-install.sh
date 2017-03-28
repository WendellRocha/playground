#!/bin/bash

# Detecta se eh um usuario com poderes de root que esta executando o script
MYUID=$(id | cut -d= -f2 | cut -d\( -f1)
if [ ! "$MYUID" -eq 0 ] ; then
        echo "voce deve ser root para executar este script."
        echo "execute o comando \"sudo $CMDLINE\""
        exit 1
fi

echo "Instalação fácil do Zabbix"
echo "Você deseja começar a instalação? [s/n]"
read RESPOSTA
test "$RESPOSTA" = "n" && exit
echo "Baixando o arquivo de fontes do Zabbix Server"
wget https://sourceforge.net/projects/zabbix/files/ZABBIX%20Latest%20Stable/3.0.8/zabbix-3.0.8.tar.gz/download
echo "Descompactando os arquivos fontes..."
tar xzvf zabbix-3.0.8.tar.gz
echo "Entrando no diretório dos arquivos fontes..."
cd zabbix-3.0.5
echo "Atualizando os pacotes..."
sleep 3
apt-get update
echo "Aplicando as atualizações..."
sleep 3
apt-get upgrade
echo "Instalando as dependências..."
sleep 3
apt-get install make build-essential libopenipmi-dev snmp gpp gpp apache2 php php-mysql libapache2-mod-php php-gd libsnmp-dev libcurl4-openssl-dev vim mysql-server mysql-client libmysqld-dev libcurl-dev php-mbstring php-xml php-net-socket php-ldap php-curl
echo "Antes de compilar os binários do Zabbix, é necessário criar o grupo e o usuário que o Zabbix irá utilizar"
useradd zabbix -s /bin/false
echo "Usuário Zabbix criado com sucesso!"
echo "Iniciando a compilação dos binários do Zabbix"
./configure --enable-server --enable-agent --with-mysql --with-net-snmp --with-libcurl --with-libxml2 --with-openipmi
make install
echo "Agora vamos criar e configurar o banco de dados do Zabbix"
echo "Iniciando o MySQL..."
service mysqld start
echo "Redefina a senha do root do MySQL"
MYADMIN=$(which mysqladmin)
$MYADMIN -u root password root@3297862
echo "A nova senha de root do MySQL está salva no arquivo mysql_password.txt"
echo "Senha do usuário root do MySQL: root@3297862" > ./mysql_password.txt
echo "Criando o banco de dados do Zabbix"
echo "create database zabbix character set utf8;" | mysql -uroot -proot@3297862
echo "GRANT ALL PRIVILEGES ON zabbix.* TO zabbix@localhost IDENTIFIED BY 'zabbix' WITH GRANT OPTION;" | mysql -uroot -proot@3297862
cat zabbix-3.0.5/database/mysql/schema.sql | mysql -uroot -proot@3297862 zabbix
cat zabbix-3.0.5/database/mysql/images.sql | mysql -uroot -proot@3297862 zabbix
cat zabbix-3.0.5/database/mysql/data.sql | mysql -uroot -proot@3297862 zabbix
echo "Os informações do banco de dados estão salvas no arquivo zabbix_db.txt"
echo "db name = zabbix" > ./zabbix_db.txt
echo "db password = zabbix" >> ./zabbix_db.txt
echo "Configurando o Zabbix"
echo "DBUser=zabbix" > /usr/local/etc/zabbix_server.conf
echo "DBPassword=zabbix" >> /usr/local/etc/zabbix_server.conf
echo "DBName=zabbix" >> /usr/local/etc/zabbix_server.conf
echo "CacheSize=32M" >> /usr/local/etc/zabbix_server.conf
echo "DebugLevel=3" >> /usr/local/etc/zabbix_server.conf
echo "PidFile=/tmp/zabbix_server.pid" >> /usr/local/etc/zabbix_server.conf
echo "LogFile=/tmp/zabbix_server.log" >> /usr/local/etc/zabbix_server.conf
echo "Timeout=3" >> /usr/local/etc/zabbix_server.conf
cp zabbix-3.0.5/misc/init.d/debian/zabbix-server /etc/init.d/
update-rc.d -f zabbix-server defaults
echo "Configurando o PHP"
PHPFile=/etc/php/7.0/apache2/php.ini
sed -i 's/max_execution_time/\;max_execution_time/g' $PHPFILE;
echo ' max_execution_time=300'>> $PHPFILE;
sed -i 's/max_input_time/\;max_input_time/g' $PHPFILE;
echo 'max_input_time=300' >> $PHPFILE;
sed -i 's/date.timezone/\;date.timezone/g' $PHPFILE;
echo ' date.timezone=America/Recife' >> $PHPFILE;
sed -i 's/post_max_size/\;post_max_size/g' $PHPFILE;
echo ' post_max_size=16M' >> $PHPFILE;
service apache2 restart
echo "Instalando o fronted do Zabbix"
mkdir /var/www/html/zabbix/
cp -a . zabbix-3.0.5/frontends/php/ /var/www/html/zabbix/
chown -R www-data:www-data /var/www/html/zabbix/
touch /var/www/html/zabbix/conf/zabbix.conf.php
chmod 777 /var/www/html/zabbix/conf/zabbix.conf.php
