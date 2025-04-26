package GestionVehiculos;

import java.util.List;

/**
 * Clase que representa los diferentes tipos de vehículos, con su respectivo nombre y precio por día.
 * 
 * Los tipos de vehículos disponibles son:
 * - Pequeño
 * - Mediano
 * - Lujo
 * - Estandar
 * - GranCarga
 * - Motocicleta
 *
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
public class TiposVehiculos {
	
	public static TiposVehiculos Pequeño = new TiposVehiculos("Pequeño", 40);
	public static TiposVehiculos Mediano = new TiposVehiculos("Mediano", 50);
	public static TiposVehiculos Lujo = new TiposVehiculos("Lujo", 75);
	public static TiposVehiculos Estandar = new TiposVehiculos("Estandar", 60);
	public static TiposVehiculos GranCarga = new TiposVehiculos("GranCarga", 80);
	public static TiposVehiculos Motocicleta = new TiposVehiculos("Motocicleta", 30);
	
	private String tipo;
	private double precioDia;
	
	
	//Constructor
	/**
     * Constructor privado para crear un tipo de vehículo con nombre y precio por día.
     * 
     * @param tipo El nombre del tipo de vehículo.
     * @param precioDia El precio por día del tipo de vehículo.
     */
	private TiposVehiculos (String tipo, double precioDia)
	{
		this.tipo = tipo;
		this.precioDia = precioDia;
	}

	//Getters
	/**
     * Obtiene el nombre del tipo de vehículo.
     * 
     * @return El nombre del tipo de vehículo.
     */
	public String getTipo()
	{
		return tipo;
	}
	
	/**
     * Obtiene el precio por día del tipo de vehículo.
     * 
     * @return El precio por día del tipo de vehículo.
     */
	public double getPrecioDia()
	{
		return precioDia;
	}
	
	//Setters
	
	/**
     * Establece un nuevo precio por día para el tipo de vehículo.
     * 
     * @param nuevoPrecio El nuevo precio por día.
     */
	public void setPrecioDia(double nuevoPrecio)
	{
		this.precioDia = nuevoPrecio;
	}
	
	//Metodos
		
	/**
     * Compara dos tipos de vehículos por su nombre.
     * 
     * @param otro El otro tipo de vehículo con el que comparar.
     * @return true si los tipos son iguales, false en caso contrario.
     */
	public Boolean equals(TiposVehiculos otro)
	{
		return this.tipo.equals(otro.getTipo());
	}
	
	/**
     * Obtiene todos los tipos de vehículos disponibles.
     * 
     * @return Una lista con todos los tipos de vehículos disponibles.
     */
	public static List<TiposVehiculos> tiposDisponibles = List.of(
		    TiposVehiculos.Pequeño,
		    TiposVehiculos.Mediano,
		    TiposVehiculos.Lujo,
		    TiposVehiculos.Estandar,
		    TiposVehiculos.GranCarga,
		    TiposVehiculos.Motocicleta
		);
	
	/**
     * Obtiene un tipo de vehículo a partir de su nombre.
     * 
     * @param nombre El nombre del tipo de vehículo.
     * @return El tipo de vehículo correspondiente al nombre, o null si no se encuentra.
     */
	public static TiposVehiculos getTipoPorNombre(String nombre)
	{
		TiposVehiculos tipoVehiculo = null;
		boolean encontrado = false;
		
		for (TiposVehiculos tipo: TiposVehiculos.tiposDisponibles)
		{
			if (tipo.getTipo().equalsIgnoreCase(nombre) && !encontrado)
			{
				tipoVehiculo = tipo;
				encontrado = true;
			}
		}
		
		return tipoVehiculo;
	}
	
	/**
     * Obtiene los tipos de vehículos disponibles para la categoría "Turismo".
     * 
     * @return Una lista de tipos de vehículos disponibles para Turismo.
     */
	public static List<TiposVehiculos> getTipoTurismo() {
	    return List.of(Pequeño, Mediano, Lujo);
	}
	
	/**
     * Obtiene los tipos de vehículos disponibles para la categoría "Furgoneta".
     * 
     * @return Una lista de tipos de vehículos disponibles para Furgoneta.
     */
	public static List<TiposVehiculos> getTipoFurgoneta() {
	    return List.of(Estandar, GranCarga);
	}

	/**
     * Obtiene los tipos de vehículos disponibles para la categoría "Motocicleta".
     * 
     * @return Una lista de tipos de vehículos disponibles para Motocicleta.
     */
	public static List<TiposVehiculos> getTipoMotocicleta() {
	    return List.of(Motocicleta);
	}
	
	@Override
	public String toString()
	{
		return tipo;
	}
}
