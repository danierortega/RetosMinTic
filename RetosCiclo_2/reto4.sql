SHOW DATABASES;

CREATE DATABASE reto4;
USE reto4;
CREATE TABLE Productos(
	codigo INT PRIMARY KEY AUTO_INCREMENT, 
    nombre TEXT, 
    precio REAL,
    inventario INT
);

SHOW TABLES;

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

SELECT *FROM Productos;

/*1. Obtener el nombre y el inventario de los productos 
con un precio mayor o igual a 9000 en orden ascendente por nombre.*/
SELECT nombre, inventario FROM Productos WHERE precio >= 9000 ORDER BY nombre;

/*2. Obtener el promedio de precios de todos los productos en la tabla. 
Utilice el alias 'promedio' para la respuesta obtenida.*/
-- AVG() promedio, COUNT() contar # registros MIN() saber cual es el menor registro basado en un campo MAX() para el mayor
SELECT AVG(precio) AS promedio FROM Productos;

/*3. Obtener el nombre y el precio de todos los productos que comienzan con 'A' o con 'P' en orden ascendente.*/
-- % cero o varios caracteres _ un unico caracter por ejemplo i_ on (_o_ sol son)  
SELECT nombre, precio FROM Productos WHERE nombre LIKE "A%" OR nombre LIKE "P%" ORDER BY nombre;
-- 2da opcion
SELECT nombre, precio FROM Productos WHERE LEFT(nombre, 1) IN ("P", "A") ORDER BY nombre;

/*4. Obtener el numero total de productos cuyos precios están entre 3000 y 10000. 
Utilice el alias 'total' para la respuesta obtenida.*/

SELECT COUNT(*) AS total FROM Productos WHERE precio > 3000 AND precio < 10000;
-- 2da opcion
SELECT COUNT(*) AS total FROM Productos WHERE precio BETWEEN 3000 AND 10000;

/*5. Obtener valor total del inventario. Este valor se obtiene multiplicando
 el precio de cada producto por el inventario disponible y luego sumando todos los resultados. 
 Utilice el alias 'total_inventario' para la respuesta obtenida.
*/
-- SUM() gastos totales
SELECT SUM(precio*inventario) AS total_inventario FROM Productos;

