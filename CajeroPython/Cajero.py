import time

#variables a usar
nombre = "Carlos"
pin = 12345
saldo = 1000
movimientos = list()

def contraseña():
    contador = 1
    activo = False
    while contador <= 3:
        pinSelect = int(input("Ingrese su pin: "))
        if pinSelect == pin:
            activo = True
            break
        else:
            print(f"Contraseña Incorrecta, le quedan {3 - contador} intentos")
            contador+=1

        if contador == 3:
            print("No puede realizar operaciones.")

    return activo

def consultar_saldo():
    global saldo
    print("Su saldo actual es: ", saldo)


def retirar_dinero():
    global saldo
    global movimientos
    ahora = time.strftime("%c")
    retiro = int(input("Cuanto va a retirar? "))
    if (retiro <= saldo):
        anterior = saldo
        saldo = saldo - retiro
        mensaje = "Fecha: "+ ahora + ", Saldo anterior: " + str(anterior), "Se retiro: "+str(retiro)
        movimientos.append(mensaje)
        print("Su nuevo saldo: ",saldo)

    else:
        print("Fondos insuficientes")

def consultar_movimientos():
    for movi in movimientos:
        print(movi)

def menu():
    print("Bienvenido ", nombre)
    print("1.Consultar Saldo \n2.Retirar Saldo \n3.Ver Movimientos")
    eleccion = input(("Selecciona lo que quieres hacer: "))

    if eleccion == "1":
        consultar_saldo()
        print("Opciones a elegir: \n1.Regresar al menu \n0.Salir")
        opcion = int(input("Opcion: "))
        if (opcion == 1):
            menu()
        elif (opcion == 0):
            exit()
    
    if eleccion == "2":
        retirar_dinero()
        print("Opciones a elegir: \n1.Regresar al menu \n0.Salir")
        opcion = int(input("Opcion: "))
        if (opcion == 1):
            menu()
        elif (opcion == 0):
            exit()

    if eleccion == "3":
        consultar_movimientos()
        print("Opciones a elegir: \n1.Regresar al menu \n0.Salir")
        opcion = int(input("Opcion: "))
        if (opcion == 1):
            menu()
        elif (opcion == 0):
            exit()
        
    if eleccion == "4":
        print("Saliendo...por favor espere.")
        time.sleep(2)
        print("Sesion cerrada")


def main():

    if contraseña():
        menu()
        

main()