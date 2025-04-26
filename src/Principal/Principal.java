package Principal;

import java.time.LocalDate;
import java.util.Scanner;

import GestionVehiculos.*;
import GestionMantenimientos.*;
import GestionAlquileres.*;
import GestionClientes.*;
import GestionEmpleados.*;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		/*//PRUEBA CLIENTE
		Cliente.LeerDisco();
		Cliente cliente = new Cliente ("Juan", "Aragón Gutiérrez", "14785269D", "Calle Gran Vía 122", "695888777", "aragon@.es");
		Cliente.Insertar(cliente);
		cliente = new Cliente ("Amparo", "Giménez Gil", "25874819G", "Calle Mayor 27", "635222111", "gimenez@.es");
		Cliente.Insertar(cliente);
		cliente = new Cliente ("Alex", "García Val", "36985214L", "Plaza de Europa 2", "678444576", "garcia@.es");
		Cliente.Insertar(cliente);
		Cliente.GuardarCambios();
		
		cliente.setApellidos("Cruz Marqués");
		Cliente.Modificar(cliente);
		Cliente.GuardarCambios();
		
		Cliente.Eliminar(3);
		Cliente.GuardarCambios();
				
		Cliente clienteLeido = Cliente.Leer(2);
		System.out.println("Cliente leido con ID 2:" + clienteLeido.toString());
		*/
		
		//-------------------------------------------------------------------//
		
		/*//PRUEBA EMPLEADO
		Empleado.LeerDisco();
		Empleado empleado = new Administrador ("Eloy", "Compes Cruz", "25658748E", "45826982", "compes@.es");
		Empleado.Insertar(empleado);
		empleado = new Usuario ("Sofía", "Gómez Gómez", "14589635X", "65874258", "sofia@.es");
		Empleado.Insertar(empleado);
		empleado = new Usuario ("Paula", "Yamariz", "14589635X", "65874258", "paula@.es");
		Empleado.Insertar(empleado);
		Empleado.GuardarCambios();
		
		empleado.setApellidos("García García");
		Empleado.Modificar(empleado);
		Empleado.GuardarCambios();
		
		Empleado.Eliminar(2);
		Empleado.GuardarCambios();
		
		System.out.println(empleado.toString());
		System.out.println("-----------------");
		System.out.println(Empleado.getListaEmpleado());
		*/
		
		//-------------------------------------------------------------------//
		
		//PRUEBA VEHICULO
		/*
		Vehiculo.LeerDisco();
		Vehiculo vehiculo = new Turismo(TiposVehiculos.Pequeño, "Seat León", LocalDate.of(2010, 8, 19));
		Vehiculo.Insertar(vehiculo);
		vehiculo = new Furgoneta(TiposVehiculos.GranCarga, "Mercedes Benz", LocalDate.of(2008, 1, 4));
		Vehiculo.Insertar(vehiculo);
		vehiculo = new Motocicleta(TiposVehiculos.Motocicleta, "Yamaha YBR", LocalDate.of(2019, 5, 25));
		Vehiculo.Insertar(vehiculo);
		Vehiculo.GuardarCambios();
		
		//vehiculo.setTipoVehiculos(TiposVehiculos.Pequeño);
		vehiculo.setModelo("Honda MSX");
		Vehiculo.Modificar(vehiculo);
		Vehiculo.GuardarCambios();
		
		Vehiculo.Eliminar(1);
		Vehiculo.GuardarCambios();
		
		TiposVehiculos.GranCarga.setPrecioDia(150);
		Vehiculo.GuardarCambios();
		
		Vehiculo vehiculoLeido = Vehiculo.Leer(2);
		System.out.println("Cliente leido con ID 2:" + vehiculoLeido.toString());
		System.out.println("-----------------");
		System.out.println(Vehiculo.getListaVehiculos());
		*/
		
		//-------------------------------------------------------------------//
		
		//PRUEBA MANTENIMIENTO
		/*
		Vehiculo.LeerDisco();
		Vehiculo vehiculo = new Turismo(TiposVehiculos.Pequeño, "Fíat", LocalDate.of(2010, 8, 19));
		Vehiculo.Insertar(vehiculo);
		Vehiculo.GuardarCambios();
		
		//vehiculo.actualizarMantenimiento();
		vehiculo.setFechaMantenimiento(LocalDate.now().plusDays(1));
		Vehiculo.GuardarCambios();
		*/
		
		//-------------------------------------------------------------------//
		
		//PRUEBA ALQUILER
		/*
		Cliente.LeerDisco();
		Cliente cliente = new Cliente ("Juan", "Aragón Gutiérrez", "14785269D", "Calle Gran Vía 122", "695888777", "aragon@.es");
		Cliente.Insertar(cliente);
		Cliente.GuardarCambios();
		
		Empleado.LeerDisco();
		Empleado empleado = new Administrador ("Eloy", "Compes Cruz", "25658748E", "45826982", "compes@.es");
		Empleado.Insertar(empleado);
		Empleado.GuardarCambios();
		
		Vehiculo.LeerDisco();
		Vehiculo vehiculo = new Turismo(TiposVehiculos.Pequeño, "Seat León", LocalDate.of(2010, 8, 19));
		Vehiculo.Insertar(vehiculo);
		Vehiculo.GuardarCambios();
		
		Alquiler.LeerDisco();
		Alquiler alquiler = new Alquiler(cliente, vehiculo, empleado, LocalDate.now(), LocalDate.of(2025, 4, 30));
		Alquiler.Insertar(alquiler);
		Alquiler.GuardarCambios();
		
		alquiler.finalizarAlquiler();
		Alquiler.Modificar(alquiler);
		Alquiler.GuardarCambios();
		
		cliente = new Cliente ("Amparo", "Giménez Gil", "25874819G", "Calle Mayor 27", "635222111", "gimenez@.es");
		Cliente.Insertar(cliente);
		Cliente.GuardarCambios();
		
		vehiculo = new Motocicleta(TiposVehiculos.Motocicleta, "Yamaha YBR", LocalDate.of(2019, 5, 25));
		Vehiculo.Insertar(vehiculo);
		Vehiculo.GuardarCambios();
		
		Alquiler.LeerDisco();
		alquiler = new Alquiler(cliente, vehiculo, empleado, LocalDate.now(), LocalDate.of(2025, 4, 30));
		Alquiler.Insertar(alquiler);
		Alquiler.GuardarCambios();
		
		alquiler.setFechaFin(LocalDate.of(2025, 5, 1));
		Alquiler.GuardarCambios();
		*/
	}

}
