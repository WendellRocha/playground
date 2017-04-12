-- Create a new database called 'Empregados'
-- Connect to the 'master' database to run this snippet
USE master
GO
-- Create the new database if it does not exist already
IF NOT EXISTS (
  SELECT name
   FROM sys.databases
   WHERE name = 'Empregados'
)
CREATE DATABASE Empregados
GO
-- Create a new table called 'Empregados' in schema 'dbo'
-- Drop the table if it already exists
IF OBJECT_ID('dbo.Empregados', 'U') IS NOT NULL
DROP TABLE SchemaName.Empregados
GO
-- Create the table in the specified schema
CREATE TABLE dbo.Empregados
(
    EmpregadosId INT NOT NULL PRIMARY KEY, -- primary key column
    Name [NVARCHAR](50) NOT NULL,
    Location [NVARCHAR](50) NOT NULL
   -- specify more columns here
);
GO
INSERT INTO Empregados
    ([EmpregadosId], [Name], [Location])
VALUES
(1, 'Jared', 'Autralia'),
(2, 'Nikita', 'India'),
(3, 'Tom', 'Germany'),
(4, 'Jake', 'United States')
GO
SELECT COUNT(*) as EmpregadosId FROM dbo.Empregados;
SELECT e.EmpregadosId, e.Name, e.Location
FROM dbo.Empregados as e
GO