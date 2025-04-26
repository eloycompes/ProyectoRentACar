package GestionVehiculos;

import java.time.LocalDate;

public class Furgoneta extends Vehiculo {

	//Constructor
	protected Furgoneta(int id, TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion)
	{
	    super(id, CategoriaVehiculo.FURGONETA, tipoVehiculos, modelo, fechaMatriculacion, tipoVehiculos.getPrecioDia());
	}
	
	public Furgoneta(TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion) throws Exception
	{
		super(CategoriaVehiculo.FURGONETA, tipoVehiculos, modelo, fechaMatriculacion, tipoVehiculos.getPrecioDia());
		if (!(tipoVehiculos.equals(TiposVehiculos.Estandar)
				|| tipoVehiculos.equals(TiposVehiculos.GranCarga)))
		{
			throw new Exception ("Tipo no válido.");
		}
	}
}
