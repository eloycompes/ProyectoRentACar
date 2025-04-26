package GestionVehiculos;

import java.time.LocalDate;

public class Turismo extends Vehiculo {

	//Constructor
	protected Turismo(int id, TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion)
	{
	    super(id, CategoriaVehiculo.TURISMO, tipoVehiculos, modelo, fechaMatriculacion, tipoVehiculos.getPrecioDia());
	}
	
	public Turismo(TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion) throws Exception
	{
		super(CategoriaVehiculo.TURISMO, tipoVehiculos, modelo, fechaMatriculacion, tipoVehiculos.getPrecioDia());
		if (!(tipoVehiculos.equals(TiposVehiculos.Pequeño)
				|| tipoVehiculos.equals(TiposVehiculos.Mediano)
				|| tipoVehiculos.equals(TiposVehiculos.Lujo)))
		{
			throw new Exception ("Tipo no válido.");
		}
	}
}