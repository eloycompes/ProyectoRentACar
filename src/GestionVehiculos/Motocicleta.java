package GestionVehiculos;

import java.time.LocalDate;

/**
 * Clase que representa un vehículo de categoría Motocicleta.
 * Extiende la clase Vehiculo y gestiona específicamente motocicletas.
 *
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
public class Motocicleta extends Vehiculo {

	//Constructor
	/**
     * Constructor protegido para inicializar una motocicleta existente desde almacenamiento.
     * 
     * @param id ID del vehículo
     * @param tipoVehiculos Tipo específico de vehículo (solo Motocicleta)
     * @param modelo Modelo del vehículo
     * @param fechaMatriculacion Fecha de matriculación
     */
	protected Motocicleta(int id, TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion)
	{
	    super(id, CategoriaVehiculo.MOTOCICLETA, tipoVehiculos, modelo, fechaMatriculacion, tipoVehiculos.getPrecioDia());
	}
	
	/**
     * Constructor para crear una nueva motocicleta.
     * Valida que el tipo de vehículo sea el correcto (Motocicleta).
     * 
     * @param tipoVehiculos Tipo específico de vehículo (debe ser Motocicleta)
     * @param modelo Modelo del vehículo
     * @param fechaMatriculacion Fecha de matriculación
     * @throws Exception Si el tipo de vehículo no es válido para una motocicleta
     */
	public Motocicleta(TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion) throws Exception
	{
		super(CategoriaVehiculo.MOTOCICLETA, tipoVehiculos, modelo, fechaMatriculacion, tipoVehiculos.getPrecioDia());
		if (!(tipoVehiculos.equals(TiposVehiculos.Motocicleta)))
		{
			throw new Exception ("Tipo no válido.");
		}
	}
}
