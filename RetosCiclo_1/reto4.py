
#n=numero de baldosas a revisar
#k=numero de baldosas que el sensor es capaz de guardar
#b=baldosas revisadas por el sensor
def leer_datos():
    n,k=[int(x) for x in list(input().split(' '))]
    b=[int(x) for x in list (input().split(' '))]
    return n,k,b

def verificar_fallas(baldosa,k):
    fallas_totales=0
    falla_detectada=0
    diccionario=dict()
    for count,value in enumerate(baldosa):
        if(value in diccionario and count - diccionario.get(value)<=k):
            falla_detectada+=1
        if(value in diccionario):
            fallas_totales+=1
        diccionario[value]=count
    return fallas_totales,falla_detectada

n,k,b=leer_datos()
fallas_totales, falla_detectada=verificar_fallas(b,k)
print(fallas_totales, falla_detectada, len(b))