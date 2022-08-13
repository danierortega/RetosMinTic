base,extra_hours,bonification=input().split()

base=float(base)
extra_hours=float(extra_hours)
bonification=float(bonification)


hour_value=base/192
extra_hour_value=hour_value*1.25
total_extra_hours=extra_hour_value*extra_hours


if bonification>0:
    bonification_total=base*0.05
else:
    bonification_total=0

value_without_discounts=base + total_extra_hours + bonification_total
eps=value_without_discounts*0.035
pension=value_without_discounts*0.04
compensation=value_without_discounts*0.01
total_dcto=eps+pension+compensation
base_final=value_without_discounts-total_dcto

total_extra_hours=int(total_extra_hours)

print(round(base_final,1))