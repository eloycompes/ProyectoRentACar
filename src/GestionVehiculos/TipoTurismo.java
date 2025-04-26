package GestionVehiculos;

public enum TipoTurismo implements TipoVehiculo {
	PEQUEÑO(50), MEDIANO(80), LUJO(120);
	
	//Atributos
	private double precioDia;
	
	//Constructor
	TipoTurismo(double precioDia) {
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
