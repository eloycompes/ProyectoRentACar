package GestionVehiculos;

import java.time.LocalDate;

/**
 * Clase que representa un vehículo de categoría Turismo.
 * Extiende la clase Vehiculo y gestiona tipos específicos de turismos (Pequeño, Mediano, Lujo).
 *
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
public class Turismo extends Vehiculo {

	//Constructor
	/**
     * Constructor protegido para inicializar un turismo existente desde almacenamiento.
     * 
     * @param id ID del vehículo
     * @param tipoVehiculos Tipo específico de turismo (Pequeño, Mediano o Lujo)
     * @param modelo Modelo del vehículo
     * @param fechaMatriculacion Fecha de matriculación
     */
	protected Turismo(int id, TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion)
	{
	    super(id, CategoriaVehiculo.TURISMO, tipoVehiculos, modelo, fechaMatriculacion, tipoVehiculos.getPrecioDia());
	}
	
	/**
     * Constructor para crear un nuevo turismo.
     * Valida que el tipo de vehículo sea correcto (Pequeño, Mediano o Lujo).
     * 
     * @param tipoVehiculos Tipo específico de turismo
     * @param modelo Modelo del vehículo
     * @param fechaMatriculacion Fecha de matriculación
     * @throws Exception Si el tipo de vehículo no es válido para un turismo
     */
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