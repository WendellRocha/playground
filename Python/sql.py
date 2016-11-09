#coding: utf-8
import sqlite3

conn = sqlite3.connect("database.db") # cria o db ou conecta ao db
cursor = conn.cursor()

cursor.execute("""CREATE TABLE IF NOT EXISTS livro
	(nome TEXT,
	 autor TEXT,
	 codigo TEXT)
	""") # cria a tabela com 3 campos

cursor.execute("INSERT INTO livro VALUES ('Inferno', 'Dan Brown', '183192')")

conn.commit() # salva no database

livros = [('O Codigo da Vinci', 'Dan Brown', '123123'),
	('Harry Potter e a pedra filosofal', 'J.K Rowling', '888994'),
	('Ponto de Impacto', 'Dan Brown', '515089')]
cursor.executemany("INSERT INTO livro VALUES (?,?,?)", livros)

conn.commit()	

print "Tabela criada e atualizada."
conn.close()
