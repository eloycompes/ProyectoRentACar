package GestionVehiculos;

public enum TipoMotocicleta implements TipoVehiculo {
	ESTANDAR(40);
	
	//Atributos
	private double precioDia;
	
	//Constructor
	TipoMotocicleta(double precioDia) {
		this.precioDia = precioDia;
	}
	
	//Getter
	@Override
	public double getPrecioDia() {
		return precioDia;
	}
	
	//Setter
	@Override
	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}
}
