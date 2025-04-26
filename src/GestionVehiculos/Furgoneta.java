package GestionVehiculos;

import java.time.LocalDate;

public class Furgoneta extends Vehiculo {

	//Atributos
	private TipoFurgoneta tipo;
	
	//Constructor
	public Furgoneta(TipoFurgoneta tipo, String modelo, LocalDate fechaMatriculacion) {
		super(CategoriaVehiculo.FURGONETA, tipo, modelo, fechaMatriculacion);
	}

	//Metodos
	public void setTipo (TipoFurgoneta tipo) {
		this.tipo = tipo;
	}
}
