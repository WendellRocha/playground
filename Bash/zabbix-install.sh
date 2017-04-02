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
wget https://sourceforge.net/projects/zabbix/files/ZABBIX%20Latest%20Stable/3.0.8/zabbix-3.0.8.tar.gz
echo "Descompactando os arquivos fontes..."
tar xzvf zabbix-3.0.8.tar.gz
echo "Entrando no diretório dos arquivos fontes..."
cd zabbix-3.0.8
echo "Atualizando os pacotes..."
apt-get update
echo "Aplicando as atualizações..."
apt-get upgrade -y
echo "Instalando as dependências..."
apt-get install -y make build-essential libopenipmi-dev snmp gpp gpp apache2 php libapache2-mod-php php-gd fping curl
apt-get install -y libsnmp-dev libcurl4-openssl-dev vim libssh2-1-dev libssh2-1 libcurl3-gnutls-dev
apt-get install -y libcurl-dev php-mbstring php-xml php-net-socket php-ldap php-curl libopenipmi-dev libcurl4-gnutls-dev
apt-get install -y python-software-properties postgresql postgresql-contrib postgresql-client libpqxx-dev php-pgsql
echo "Antes de compilar os binários do Zabbix, é necessário criar o grupo e o usuário que o Zabbix irá utilizar"
useradd zabbix -s /bin/false
echo "Usuário Zabbix criado com sucesso!"
echo "Iniciando a compilação dos binários do Zabbix"
./configure --enable-server --enable-agent --with-postgresql --with-net-snmp --with-libcurl --with-libxml2 --with-openipmi
make install
echo "Agora vamos criar e configurar o banco de dados do Zabbix"
echo "Iniciando o PostgreSQL..."
service postgresql start
echo "Redefina a senha do root do PostgreSQL"
su -l postgres
echo "A nova senha de root do PostgreSQL está salva no arquivo pgsql_password.txt"
echo "Senha do usuário root do PostgreSQL: root@3297862" > ./pgsql_password.txt
echo "Criando o banco de dados do Zabbix"
echo "CREATE DATABASE zabbix" | psql -U postgres
echo "GRANT ALL PRIVILEGES ON zabbix.* TO zabbix@localhost IDENTIFIED BY 'zabbix' WITH GRANT OPTION;" | psql -U postgres
cat zabbix-3.0.8/database/postgresql/schema.sql | psql -U postgres
cat zabbix-3.0.8/database/postgresql/images.sql | psql -U postgres
cat zabbix-3.0.8/database/postgresql/data.sql | psql -U postgres
echo "Os informações do banco de dados estão salvas no arquivo zabbix_db.txt"
echo "listen_addresses = '*'" >> /etc/postgresql/9.1/main/postgresql.conf
echo "host all all 0.0.0.0/0 md5" >> /etc/postgresql/9.1/main/pg_hba.conf
service postgresql restart
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
cp zabbix-3.0.8/misc/init.d/debian/zabbix-server /etc/init.d/
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
cp -a . zabbix-3.0.8/frontends/php/ /var/www/html/zabbix/
chown -R www-data:www-data /var/www/html/zabbix/
touch /var/www/html/zabbix/conf/zabbix.conf.php
chmod 777 /var/www/html/zabbix/conf/zabbix.conf.php
