package CajeroJava;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cuenta {
	
	protected String nombre;
	protected int pin;
	protected double saldo;
	protected ArrayList<String> movimientos;
	
	
	public Cuenta() {
		nombre = "Carlos";
		pin = 12345;
		saldo = 1000;
		movimientos = new ArrayList<String>();
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public int getPin() {
		return pin;
	}

	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	protected boolean retirarSaldo(double cantidad) {
		
		boolean estatus = false;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String mensaje = "";
		double saldoAnterior = saldo;
		
		if (cantidad < saldo) {
			setSaldo(saldo-cantidad);
			estatus = true;
			
			mensaje = "Fecha: "+dtf.format(LocalDateTime.now())+ " Cantidad movimiento: "+cantidad+ " Saldo Anterior: "+saldoAnterior;
			movimientos.add(mensaje);
		} else {
			estatus = false;
		}
		
		return estatus;
	}
	
	protected void mostrarMovimientos() {
		if (movimientos != null) {
			for (String s : movimientos) {
				System.out.println(s);
			}
		} else {
			System.out.println("Aun no hay movimientos");
		}
	}
	
}