package GestionVehiculos;

import java.time.LocalDate;

public class Turismo extends Vehiculo {

	//Atributos
	private TipoTurismo tipo;
	
	//Constructor
	public Turismo(TipoTurismo tipo, String modelo, LocalDate fechaMatriculacion) {
		super(CategoriaVehiculo.TURISMO, tipo, modelo, fechaMatriculacion);
	}
	
	//Metodos
	public void setTipo (TipoTurismo tipo) {
		this.tipo = tipo;
	}

}
