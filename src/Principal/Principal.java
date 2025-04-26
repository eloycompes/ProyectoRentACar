package Principal;

import java.time.LocalDate;
import java.util.Scanner;

import GestionVehiculos.*;
import GestionMantenimientos.*;
import GestionAlquileres.*;
import GestionClientes.*;
import GestionEmpleados.*;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		Cliente cliente = new Cliente ("Pedro", "Ramírez Calles", "25639874K", "Calle Unamuno 1", "65842579", "calles@.es");
		Empleado admin = new Administrador ("Eloy", "Compes Cruz", "25658748E", "45826982", "compes@.es");
		
		Vehiculo turismo = new Turismo(TipoTurismo.LUJO, "Toyota Yaris", LocalDate.of(2000, 5, 20));
		
		Vehiculo furgoneta = new Furgoneta(TipoFurgoneta.GRAN_CARGA, "Mercedes Benz", LocalDate.of(2015, 6, 20));
		
		Vehiculo moto = new Motocicleta(TipoMotocicleta.ESTANDAR, "Yamaha IBR", LocalDate.of(2000, 5, 20));

		Alquiler alquiler = new Alquiler (cliente, turismo, admin, LocalDate.of(2025, 4, 10), LocalDate.of(2025, 4, 20));
		
		System.out.println("---------------VEHICULOS--------------------");
		for (Vehiculo v : Vehiculo.getListaVehiculos()) {
			System.out.println(v);			
		}
		
		((Administrador) admin).modificarTurismo((Turismo)turismo, TipoTurismo.MEDIANO, "Honda Civic", LocalDate.of(2023, 5, 20));
		((Administrador) admin).cambiarPrecioDia(TipoTurismo.LUJO, 130);
		((Administrador) admin).eliminarVehiculo(moto);
		
		((Administrador) admin).darAltaTurismo(TipoTurismo.MEDIANO, "Opel Corsa", LocalDate.of(2010, 8, 20));

		
		System.out.println("---------------VEHICULOS--------------------");
		for (Vehiculo v : Vehiculo.getListaVehiculos()) {
			System.out.println(v);			
		}
		
		System.out.println("---------------ALQUILERES--------------------");
		
		for (Alquiler a : alquiler.getListaAlquileres()) {
			System.out.println(a);
		}
		System.out.println("---------------CLIENTES--------------------");
		
		for (Cliente c : cliente.getListaClientes()) {
			System.out.println(c);
		}

	}

}
