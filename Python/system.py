#coding: utf-8
import commands
import os
import os.path

def espaco_livre():
	if (os.path.exists("output")):
		var = commands.getoutput("df -h")
		arquivo = open("espaço.txt", "w")
		arquivo.write(var)
		arquivo.close()
	
	else:
		os.mkdir("output")
		espaco_livre()

	arquivo = open("espaço.txt", "r")

	for i in arquivo.readlines():
		print i
	
	arquivo.close()
