SHOW DATABASES;

CREATE DATABASE reto5;
USE reto5;

CREATE TABLE Productos(
	codigo INTEGER AUTO_INCREMENT, 
    nombre TEXT,
    precio REAL,
    inventario INT,
    PRIMARY KEY(codigo)
);

SHOW TABLES;

SELECT * FROM Productos;

INSERT INTO Productos(nombre, precio, inventario) values ('Manzanas', 5000, 25);
INSERT INTO Productos(nombre, precio, inventario) values ('Limones', 2300, 15);
INSERT INTO Productos(nombre, precio, inventario) values ('Peras', 2700, 33);
INSERT INTO Productos(nombre, precio, inventario) values('Arandanos', 9300, 5);
INSERT INTO Productos(nombre, precio, inventario) values('Tomates', 2100, 42);
INSERT INTO Productos(nombre, precio, inventario) values('Fresas', 4100, 3);
INSERT INTO Productos(nombre, precio, inventario) values('Helado', 4500, 41);
INSERT INTO Productos(nombre, precio, inventario) values('Galletas', 500, 8);
INSERT INTO Productos(nombre, precio, inventario) values('Chocolates', 3500, 80);
INSERT INTO Productos(nombre, precio, inventario) values('Jamon', 15000, 10);

SELECT * FROM Productos;

-- DELETE FROM Productos WHERE codigo > 10;