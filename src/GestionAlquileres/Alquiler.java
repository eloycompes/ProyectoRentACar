package GestionAlquileres;

import java.time.LocalDate;
import java.util.ArrayList;

import GestionClientes.Cliente;
import GestionEmpleados.Empleado;
import GestionVehiculos.Vehiculo;

public class Alquiler {

	//Atributos
	protected static ArrayList<Alquiler> listaAlquileres = new ArrayList<>();
	private int idAlquiler;
	private static int contadorId = 0;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double costeTotal;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private Empleado empleado;
	private boolean estadoAlquiler;
	
	//Constructor
	public Alquiler (Cliente cliente, Vehiculo vehiculo, Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin) {
		
		if (!vehiculo.mantenimientoAlDia()) {
			throw new IllegalArgumentException ("El vehículo no tiene el mantenimiento al día y no puede ser alquilado.");
		}
		
		this.idAlquiler = ++contadorId;
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.empleado = empleado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		
		actualizarEstadoAlquiler();
		
		calcularCosteTotal();
		
		listaAlquileres.add(this);
	}
	
	//Getters
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public double getCosteTotal() {
		return costeTotal;
	}

	public boolean isEstadoAlquiler() {
		return estadoAlquiler;
	}
	public static ArrayList<Alquiler> getListaAlquileres(){
		return listaAlquileres;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	//Setters
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setCosteTotal(double costeTotal) {
		this.costeTotal = costeTotal;
	}

	public void setEstadoAlquiler(boolean estadoAlquiler) {
		this.estadoAlquiler = estadoAlquiler;
	}

	//Métodos
    @Override
    public String toString() {
    	return "Alquiler {\n" +
                "  ID: " + idAlquiler + "\n" +
                "  Empleado: " + empleado.getNombre() + "\n" +
                "  Cliente: " + cliente.getApellidos() + ", " + cliente.getNombre() + "\n" +
                "  Vehículo: " + vehiculo.getModelo() + "\n" +
                "  Fecha inicio: " + fechaInicio + "\n" +
                "  Fecha fin: " + fechaFin + "\n" +
                "  Coste total: " + costeTotal + "€\n" +
                "}";
    }
    
	private void calcularCosteTotal() {
		long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
		
		if (dias <= 0) dias = 1;
		
		this.costeTotal = dias * vehiculo.getPrecioDia();
	}
	
	public void actualizarEstadoAlquiler() {
		LocalDate hoy = LocalDate.now();
		
		if (hoy.isAfter(fechaInicio.minusDays(1)) && hoy.isBefore(fechaFin.plusDays(1))) {
			estadoAlquiler = true;
		} else {
			estadoAlquiler = false;
		}
	}
	
	public static void eliminarAlquiler(Alquiler alquiler) {
		listaAlquileres.remove(alquiler);
	}
	
    public void finalizarAlquiler() {
    	this.estadoAlquiler = false; //Forzamos finalizar alquiler
    	this.fechaFin = LocalDate.now();
    }
	
}
