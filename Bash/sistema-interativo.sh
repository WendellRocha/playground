#!/bin/bash
echo "Voi buscar os dados do sistema. Posso continuar? [s/n]"
read RESPOSTA
test "$RESPOSTA" = "n" && exit
echo "Data e horário:"
date
echo
echo "Uso do disco:"
df
echo
echo "Usuarios conectados:"
w
