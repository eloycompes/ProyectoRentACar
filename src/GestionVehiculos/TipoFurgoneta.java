package GestionVehiculos;

public enum TipoFurgoneta implements TipoVehiculo {
	ESTANDAR(100), GRAN_CARGA(150);
	
	//Atributos
	private double precioDia;
	
	//Constructor
	TipoFurgoneta(double precioDia) {
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
