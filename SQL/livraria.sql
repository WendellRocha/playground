IF NOT EXISTS (
    SELECT name
    FROM sys.databases
    WHERE name = 'livraria'
)
CREATE DATABASE livraria;
-- Create a new table called 'TableName' in schema 'SchemaName'
-- Drop the table if it already exists
IF OBJECT_ID('dbo.Livros', 'U') IS NOT NULL
DROP TABLE dbo.Livros
GO
-- Create the table in the specified schema
CREATE TABLE dbo.Livros
(
    LivrosId INT NOT NULL PRIMARY KEY, -- primary key column
    Titulo [NVARCHAR](255) NOT NULL,
    Preco [DECIMAL](18,2)
   -- specify more columns here
);
GO
INSERT INTO Livros ([LivrosId], [Titulo], [Preco])
VALUES 
(1, 'C#', 98.75),
(2, 'Introdução ao JSF 2', 129.5),
(3, 'Android', 159.0)
GO
SELECT * FROM livraria.dbo.Livros;
UPDATE livraria.dbo.Livros SET Preco = 115.9 WHERE Titulo = 'C#';
SELECT COUNT(*) as LivrosId FROM dbo.Livros;
SELECT l.LivrosId, l.Titulo, l.Preco
FROM dbo.Livros as l
GO
-- DELETE FROM livraria.dbo.Livros WHERE Titulo = 'C#';
-- SELECT * FROM livraria.dbo.Livros;