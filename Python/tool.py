import sys

def usage():
	print "\nUsage: tool.py [file] [search key]\n"
	

def main():
	if len(sys.argv[1:]) == 0:
		usage()
	try:
		arquivo = open(sys.argv[1],"r")
		texto = arquivo.readlines()
		key = str(sys.argv[2])
		arq = open("out.txt", "w")

		for line in texto:
			if key in line:
				arq.write(line)
			
		arquivo.close()
		arq.close()
	except:
		print "File not exists"

def get_lines(fp):
	fl = open(fp, "r+")
	

main()
