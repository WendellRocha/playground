#!/bin/bash
echo "Digite o arquivo: "
read $ARQUIVO
if [ -d "$ARQUIVO" ]; then	
	echo "O arquivo $ARQUIVO é um diretório."
elif [ -f "$ARQUIVO" ]; then
	echo "$ARQUIVO é um arquivo."
else
	echo "$ARQUIVO não encontrado."
fi
