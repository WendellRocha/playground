import sqlite3

conn = sqlite3.connect("database.db")
cursor = conn.cursor()
sql = "DELETE FROM livro;"
cursor.execute(sql)
conn.commit()
print "database limpo"
