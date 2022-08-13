def leer_datos():
  operacion = input()
  producto = input().split()
  producto [0] = int(producto[0]) 
  producto [2] = float(producto[2]) 
  producto [3] = int(producto[3]) 
  return operacion, producto

database = {
    1: ["Manzanas", 5000.0, 25],
    2: ["Limones", 2300.0, 15],
    3: ["Peras", 2700.0, 33],
    4: ["Arandanos", 9300.0, 5],
    5: ["Tomates", 2100.0, 42],
    6: ["Fresas", 4100.0, 3],
    7: ["Helado", 4500.0, 41],
    8: ["Galletas", 500.0, 8],
    9: ["Chocolates", 3500.0, 80],
    10: ["Jamon", 15000.0, 10]
}

def borrar(database, producto):
    if producto[0] in database:
      database.pop(producto[0])
      return True
    return False

def agregar(database, producto):
    if producto[0] in database:
      return False
    index = producto[0]
    producto.pop(0)
    database[index] = producto
    return True

def actualizar(database, producto):
    if producto[0] in database:
      index = producto[0]
      producto.pop(0)
      database[index] = producto
      return True    
    return False

def precio_mayor(database):
  mayor = list(database.keys())[0]
  for i in database:
       if database[i][1] > database[mayor][1]:
          mayor = i
  return database[mayor][0]

def promedio_precios(database):
   promedio = 0
   for i in database:
         promedio += database[i][1]
   promedio /= len(database)
   return promedio

def precio_menor(database):
    menor = list(database.keys())[0]
    for i in database:
        if database[i][1] < database[menor][1]:
          menor = i
    return database[menor][0]

def valor_inventario(database):
  valor_inventario=0.0
  for i in database:
    valor_inventario += database[i][1] * database[i][2]
  return valor_inventario

operacion, producto = leer_datos()
 
if operacion == "AGREGAR":
        flag = agregar(database, producto)
elif operacion == "BORRAR":
        flag = borrar(database, producto)
elif operacion == "ACTUALIZAR":
        flag = actualizar(database, producto)

if flag == True:
  print(precio_mayor(database),precio_menor(database),round(promedio_precios(database),1),round(valor_inventario(database),1))
else:
  print('ERROR')