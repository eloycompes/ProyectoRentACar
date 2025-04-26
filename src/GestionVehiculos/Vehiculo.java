package GestionVehiculos;

import java.time.LocalDate;
import java.util.ArrayList;

import GestionAlquileres.Alquiler;
import GestionMantenimientos.Mantenimiento;

public abstract class Vehiculo {

	//Atributos
	protected static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
	private int idVehiculo;
	private static int contadorId = 0;
	private CategoriaVehiculo categoria;
	private TipoVehiculo tipo;
	private String modelo;
	private LocalDate fechaMatriculacion;
	private Mantenimiento mantenimiento;
	//private double precioDia;
	
	//Constructor
    public Vehiculo(CategoriaVehiculo categoria, TipoVehiculo tipo, String modelo, LocalDate fechaMatriculacion) {
        this.idVehiculo = ++contadorId;
        this.categoria = categoria;
        this.tipo = tipo;   
        this.modelo = modelo;
        this.fechaMatriculacion = fechaMatriculacion;
        this.mantenimiento = new Mantenimiento (this);
        
        añadirVehiculo(this);
    }
	
	//Getters
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public CategoriaVehiculo getCategoria() {
		return categoria;
	}
	public String getModelo() {
		return modelo;
	}
    public double getPrecioDia() {
        return tipo.getPrecioDia();
    }
    public static ArrayList<Vehiculo> getListaVehiculos(){
    	return listaVehiculos;
    }
	public LocalDate getFechaMatriculacion() {
		return fechaMatriculacion;
	}
	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}

	//Setters
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public void setCategoria(CategoriaVehiculo categoria) {
		this.categoria = categoria;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	//Metodos
    @Override
    public String toString() {
    	String advertenciaMantenimiento = "";
    	
    	if(!mantenimientoAlDia()) {
    		advertenciaMantenimiento = " [Mantenimiento caducado]";
    	}
    		
    	return "Vehículo {\n" +
                "  ID: " + idVehiculo + "\n" +
                "  Categoria: " + categoria + "\n" +
                "  Tipo: " + tipo + "\n" +
                "  Modelo: " + modelo + "\n" +
                "  Precio/día: " + tipo.getPrecioDia() + "€\n" +
                "  Próximo mantenimiento: " + mantenimiento.getFechaMantenimiento() + advertenciaMantenimiento + "\n" +
                "  Estado alquiler: " + (getEstadoAlquiler() ? "Activo" : "Inactivo") + "\n" +
                "}";
    }
    
    public static void añadirVehiculo(Vehiculo vehiculo) {
    	listaVehiculos.add(vehiculo);
    }
    
    public boolean getEstadoAlquiler() {
    	boolean estadoAlquiler= false;
    	
    	for (Alquiler alquiler : Alquiler.getListaAlquileres()) {
    		if (alquiler.getVehiculo().equals(this) && alquiler.isEstadoAlquiler()) {
    				estadoAlquiler = true;
    			}
    	}
    	return estadoAlquiler;
    }
    
    public boolean mantenimientoAlDia() {
    	return mantenimiento.comprobarEstadoMantenimiento();
    }
    
}
