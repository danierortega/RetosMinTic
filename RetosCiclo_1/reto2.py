distancia_metros,vel_max,tiempo_seg=input().split()

distancia_metros=float(distancia_metros)
vel_max=float(vel_max)
tiempo_seg=float(tiempo_seg)

vel_media_ms=float(distancia_metros/tiempo_seg)#formula de velocidad media
vel_media_km=float((vel_media_ms*3600)/1000)#formula para pasar la velocidad media metros/seg a km/hora

curso=float(vel_max+(vel_max*0.2))#velocidad maxima mas el 20%

if distancia_metros<0 or vel_max<0 or tiempo_seg<0:
    print('ERROR')
elif vel_media_km<=vel_max:
    print('OK')
elif vel_media_km>vel_max and vel_media_km<curso:
    print('MULTA')
elif vel_media_km>=curso:
    print('CURSO SENSIBILIZACION')
elif distancia_metros<0 or vel_max<0 or tiempo_seg<0:
    print('ERROR')