package GestionVehiculos;

import java.time.LocalDate;

/**
 * Clase que representa un vehículo de categoría Furgoneta.
 * Extiende la clase Vehiculo y gestiona tipos específicos de furgonetas (Estándar, Gran Carga).
 *
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
public class Furgoneta extends Vehiculo {

	//Constructor
	/**
     * Constructor protegido para inicializar una furgoneta existente desde almacenamiento.
     * 
     * @param id ID del vehículo
     * @param tipoVehiculos Tipo específico de furgoneta (Estándar o Gran Carga)
     * @param modelo Modelo del vehículo
     * @param fechaMatriculacion Fecha de matriculación
     */
	protected Furgoneta(int id, TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion)
	{
	    super(id, CategoriaVehiculo.FURGONETA, tipoVehiculos, modelo, fechaMatriculacion, tipoVehiculos.getPrecioDia());
	}
	
	/**
     * Constructor para crear una nueva furgoneta.
     * Valida que el tipo de vehículo sea correcto (Estándar o Gran Carga).
     * 
     * @param tipoVehiculos Tipo específico de furgoneta
     * @param modelo Modelo del vehículo
     * @param fechaMatriculacion Fecha de matriculación
     * @throws Exception Si el tipo de vehículo no es válido para una furgoneta
     */
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
