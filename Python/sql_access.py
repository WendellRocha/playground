import sqlite3

conn = sqlite3.connect("database.db")

cursor = conn.cursor()

sql = "SELECT * FROM livro WHERE autor=?"
cursor.execute(sql, [("Dan")])
print cursor.fetchall()

print "Lista de todos os registros da tabela:\n"
for row in cursor.execute("SELECT rowid, * FROM livro ORDER BY autor"):
	print row

print "Resultados de uma consulta com LIKE: \n"
sql = """SELECT * FROM livro WHERE nome LIKE 'Harry%'"""
cursor.execute(sql)
print cursor.fetchall()

cursor.execute("""SELECT * FROM livro""")
for linha in cursor.fetchall():
	print linha
