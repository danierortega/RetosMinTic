cantidad_filas=input() 
cantidad_filas=int(cantidad_filas)

precio_final=float()#precio confirmado para la bici que cumple las caracteristicas

confirm=False
n=0
while n<cantidad_filas:
    pedalier_suelo,bielas,sillin,manilar,precio_dollar=input().split()
    #print(cantidad_filas,pedalier_suelo,bielas,sillin,manilar,precio_dollar)
    pedalier_suelo=float(pedalier_suelo)
    bielas=float( bielas)
    sillin=float(sillin)
    manilar=float(manilar)
    precio_dollar=float(precio_dollar)
    
    n+=1
    if (pedalier_suelo>=240 and pedalier_suelo<=300)\
        and (bielas>=160 and bielas<=180)\
             and (sillin>=240 and sillin<=275) and (manilar<=50):
        confirm=True
        precio_final=precio_dollar
    if n>=cantidad_filas and confirm==True:
        print(round(precio_final))
    elif n>=cantidad_filas and confirm==False:
        print('NO DISPONIBLE')
    