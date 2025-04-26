package GestionEmpleados;

import java.time.LocalDate;

import GestionVehiculos.CategoriaVehiculo;
import GestionVehiculos.Furgoneta;
import GestionVehiculos.Motocicleta;
import GestionVehiculos.TipoFurgoneta;
import GestionVehiculos.TipoMotocicleta;
import GestionVehiculos.TipoTurismo;
import GestionVehiculos.TipoVehiculo;
import GestionVehiculos.Turismo;
import GestionVehiculos.Vehiculo;

public class Administrador extends Empleado{

	// Constructor
	public Administrador(String nombre, String apellidos, String dni, String telefono, String email) {
		super(nombre, apellidos, dni, telefono, email, Rol.ADMINISTRADOR);
	}
	
	// Métodos
	
	public Vehiculo darAltaTurismo (TipoTurismo tipo, String modelo, LocalDate fechaMatriculacion) {

		Turismo nuevoTurismo = null;
		
		if (this.comprobarRol()) {
			nuevoTurismo = new Turismo(tipo, modelo, fechaMatriculacion);
		}
		
		return nuevoTurismo;
	}
	
	public Vehiculo darAltaMotocicleta (TipoMotocicleta tipo, String modelo, LocalDate fechaMatriculacion) {
		
		Motocicleta nuevaMotocicleta = null;
		
		if (this.comprobarRol()) {
			nuevaMotocicleta = new Motocicleta (tipo, modelo, fechaMatriculacion);
		}
		
		return nuevaMotocicleta;
	}
	
	public Vehiculo darAltaFurgoneta (TipoFurgoneta tipo, String modelo, LocalDate fechaMatriculacion) {
		
		Furgoneta nuevaFurgoneta = null;
		
		if (this.comprobarRol()) {
			nuevaFurgoneta = new Furgoneta (tipo, modelo, fechaMatriculacion);
		}
		
		return nuevaFurgoneta;
	}
	
	public void modificarTurismo (Turismo turismo, TipoTurismo nuevoTipo, String nuevoModelo, LocalDate nuevaFechaMatriculacion) {
		if (this.comprobarRol()) {
			if (turismo != null) {
				turismo.setTipo(nuevoTipo);
				turismo.setModelo(nuevoModelo);
				turismo.setFechaMatriculacion(nuevaFechaMatriculacion);
				System.out.println("Turismo modificado correctamente.");
			}
		}
	}
	
	public void modificarMotocicleta (Motocicleta motocicleta, TipoMotocicleta nuevoTipo, String nuevoModelo, LocalDate nuevaFechaMatriculacion) {
		if (this.comprobarRol()) {
			if (motocicleta != null) {
				motocicleta.setTipo(nuevoTipo);
				motocicleta.setModelo(nuevoModelo);
				motocicleta.setFechaMatriculacion(nuevaFechaMatriculacion);
				System.out.println("Motocicleta modificado correctamente.");
			}
		}
	}
	
	public void modificarFurgoneta (Furgoneta furgoneta, TipoFurgoneta nuevoTipo, String nuevoModelo, LocalDate nuevaFechaMatriculacion) {
		if (this.comprobarRol()) {
			if (furgoneta != null) {
				furgoneta.setTipo(nuevoTipo);
				furgoneta.setModelo(nuevoModelo);
				furgoneta.setFechaMatriculacion(nuevaFechaMatriculacion);
				System.out.println("Furgoneta modificado correctamente.");
			}
		}
	}
	
	public void modificarVehiculo (Vehiculo vehiculo, TipoVehiculo nuevoTipo, String nuevoModelo, LocalDate nuevaFechaMatriculacion) {
		
		if (vehiculo.getEstadoAlquiler()) {
			System.out.println("No se puede modificar el vehículo porque está alquilado.");
			
		} else {
			
			if (vehiculo instanceof Turismo) {
				if (nuevoTipo instanceof TipoTurismo) {
					Turismo turismo = (Turismo) vehiculo;
					turismo.setTipo((TipoTurismo) nuevoTipo);
					turismo.setModelo(nuevoModelo);
					turismo.setFechaMatriculacion(nuevaFechaMatriculacion);
					System.out.println("Turismo modificado correctamente.");
				}
			}
			else if (vehiculo instanceof Motocicleta) {
				if (nuevoTipo instanceof TipoMotocicleta) {
					Motocicleta motocicleta = (Motocicleta) vehiculo;
					motocicleta.setTipo((TipoMotocicleta) nuevoTipo);
					motocicleta.setModelo(nuevoModelo);
					motocicleta.setFechaMatriculacion(nuevaFechaMatriculacion);
					System.out.println("Motocicleta modificada correctamente.");
				}
			}
			else if (vehiculo instanceof Furgoneta) {
				if (nuevoTipo instanceof TipoFurgoneta) {
					Furgoneta furgoneta = (Furgoneta) vehiculo;
					furgoneta.setTipo((TipoFurgoneta) nuevoTipo);
					furgoneta.setModelo(nuevoModelo);
					furgoneta.setFechaMatriculacion(nuevaFechaMatriculacion);
					System.out.println("Furgoneta modificada correctamente.");
				}
			}
		}	
	}
	
	public void cambiarPrecioDia (TipoVehiculo tipoVehiculo, double nuevoPrecio) {
		if (this.comprobarRol()) {
			if (tipoVehiculo != null) {
				tipoVehiculo.setPrecioDia(nuevoPrecio);
	            System.out.println("Precio por día modificado correctamente a " + nuevoPrecio + "€");
	            
			} else {
		        System.out.println("No tienes permiso para cambiar el precio.");
		    }
		}
	}
	
	public void eliminarVehiculo (Vehiculo vehiculo) {
		if (this.comprobarRol()) {
			if (vehiculo.getEstadoAlquiler()) {
				System.out.println("No se puede eliminar el vehículo porque está alquilado.");
				
			} else {
				Vehiculo.getListaVehiculos().remove(vehiculo);
				System.out.println("Vehículo eliminado correctamente");
			}       
			
		} else {
	        System.out.println("No tienes permiso para eliminar vehículos.");
	    }
	}
	
	public void eliminarEmpleado(Empleado empleado) {
		if (this.comprobarRol()) {
			listaEmpleados.remove(empleado);
			System.out.println("Empleado eliminado correctamente");
            
		} else {
	        System.out.println("No tienes permiso para eliminar empleados.");
	    }
		
	}

}
