package GestionVehiculos;

import java.util.List;

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
	private TiposVehiculos (String tipo, double precioDia)
	{
		this.tipo = tipo;
		this.precioDia = precioDia;
	}

	//Getters
	public String getTipo()
	{
		return tipo;
	}
	
	public double getPrecioDia()
	{
		return precioDia;
	}
	
	//Setters		
	public void setPrecioDia(double nuevoPrecio)
	{
		this.precioDia = nuevoPrecio;
	}
	
	//Metodos
		
	public Boolean equals(TiposVehiculos otro)
	{
		return this.tipo.equals(otro.getTipo());
	}
	
	public static List<TiposVehiculos> tiposDisponibles = List.of(
		    TiposVehiculos.Pequeño,
		    TiposVehiculos.Mediano,
		    TiposVehiculos.Lujo,
		    TiposVehiculos.Estandar,
		    TiposVehiculos.GranCarga,
		    TiposVehiculos.Motocicleta
		);
	
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
	
	public static List<TiposVehiculos> getTipoTurismo() {
	    return List.of(Pequeño, Mediano, Lujo);
	}
	
	public static List<TiposVehiculos> getTipoFurgoneta() {
	    return List.of(Estandar, GranCarga);
	}

	public static List<TiposVehiculos> getTipoMotocicleta() {
	    return List.of(Motocicleta);
	}
	
	@Override
	public String toString()
	{
		return tipo;
	}
}
