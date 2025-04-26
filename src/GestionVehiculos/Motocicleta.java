package GestionVehiculos;

import java.time.LocalDate;

public class Motocicleta extends Vehiculo {

	//Atributos
	private TipoMotocicleta tipo;
	
	//Constructor
	public Motocicleta(TipoMotocicleta tipo, String modelo, LocalDate fechaMatriculacion) {
		super(CategoriaVehiculo.MOTOCICLETA, tipo, modelo, fechaMatriculacion);
	}

	//Métodos
	public void setTipo (TipoMotocicleta tipo) {
		this.tipo = tipo;
	}
}
