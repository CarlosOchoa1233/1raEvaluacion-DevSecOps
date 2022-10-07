package CajeroJava;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cajero {
	
	public static void main(String[] args) {
		
		int pin;
		int intento = 1;
		boolean acceso = false;
		
		Cuenta cuenta = new Cuenta();
		Scanner sc = new Scanner(System.in);
		
		while (!acceso && intento <= 3) {
			try {
				System.out.print("Digite su pin: ");
				pin = sc.nextInt();
				
				if (pin == cuenta.getPin()) {
					acceso = true;
				} else {
					System.out.println("Error");
					intento++;
				}
				
			} catch (ArithmeticException e) {
				System.out.println(e);
				
			} catch (InputMismatchException e) {
				System.out.println("Error en el tipo de datos!!!");
				sc.nextLine();
			}
		}
		
		if (acceso) {
			menu(cuenta, sc);
		}		
	}
	
	protected static void menu(Cuenta cuenta, Scanner sc) {
		System.out.println("Bienvenido "+cuenta.getNombre());
		System.out.println("Opciones a elegir: \n1.Consultar Saldo \n2.Retirar Saldo \n3.Historico de Movimientos \n0.Salir");
		
		boolean activo = true;
		
		while (activo) {
			try {
                System.out.print("Opcion: ");
				int opcion = sc.nextInt();
				
				if (opcion == 1) {
					System.out.println("Saldo actual: "+cuenta.getSaldo());
					
					System.out.println("Opciones a elegir: \n1.Regresar al menu \n0.Salir");
                    System.out.print("Opcion: ");
					int opcionInterna = sc.nextInt();
					
					if (opcionInterna == 1) {
						menu(cuenta, sc);
					} else if (opcionInterna == 0) {
						break;
					}
					
				} else if (opcion == 2) {
					double cantidad;
					boolean estatus;
					
					System.out.println("Cantidad a retirar: ");
					cantidad = sc.nextDouble();
					
					estatus = cuenta.retirarSaldo(cantidad);
					
					if (estatus) {
						System.out.println("Nuevo saldo: "+cuenta.getSaldo());
					} else {
						System.out.println("No cuentas con saldo suficiente para realizar este movimiento");
					}
					
					System.out.println("Opciones a elegir: \n1.Regresar al menu \n0.Salir");
                    System.out.print("Opcion: ");
					int opcionInterna = sc.nextInt();
					
					if (opcionInterna == 1) {
						menu(cuenta, sc);
					} else if (opcionInterna == 0) {
						break;
					}
					
					
				} else if (opcion == 3) {
					cuenta.mostrarMovimientos();
					
					System.out.println("Opciones a elegir: \n1.Regresar al menu \n0.Salir");
                    System.out.print("Opcion: ");
					int opcionInterna = sc.nextInt();
					
					if (opcionInterna == 1) {
						menu(cuenta, sc);
					} else if (opcionInterna == 0) {
						break;
					}
					
				} else {
					System.out.println("Gracias, vuelva pronto");
					activo = false;
				}
				
			} catch (ArithmeticException e) {
				System.out.println(e);
				
			} catch (InputMismatchException e) {
				System.out.println("Error en el tipo de datos!!!");
				sc.nextLine();
			}
		}
	}

}
