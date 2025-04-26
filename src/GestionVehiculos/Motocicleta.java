package GestionVehiculos;

import java.time.LocalDate;

public class Motocicleta extends Vehiculo {

	//Constructor
	protected Motocicleta(int id, TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion)
	{
	    super(id, CategoriaVehiculo.MOTOCICLETA, tipoVehiculos, modelo, fechaMatriculacion, tipoVehiculos.getPrecioDia());
	}
	
	public Motocicleta(TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion) throws Exception
	{
		super(CategoriaVehiculo.MOTOCICLETA, tipoVehiculos, modelo, fechaMatriculacion, tipoVehiculos.getPrecioDia());
		if (!(tipoVehiculos.equals(TiposVehiculos.Motocicleta)))
		{
			throw new Exception ("Tipo no válido.");
		}
	}
}
