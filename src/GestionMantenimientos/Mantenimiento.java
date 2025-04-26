package GestionMantenimientos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import GestionVehiculos.Vehiculo;

public class Mantenimiento {

	// Atributos
	private int idMantenimiento;
	private static int contadorId = 0;
	private LocalDate fechaMantenimiento;
	private boolean estadoMantenimiento;
	
	// Constructor
	public Mantenimiento(Vehiculo vehiculo) {
		this.idMantenimiento = ++contadorId;
		this.fechaMantenimiento = calcularProximoMantenimiento(vehiculo);
		this.estadoMantenimiento = comprobarEstadoMantenimiento();
	}
	
	// Getters
	public int getIdMantenimiento() {
		return idMantenimiento;
	}
	public LocalDate getFechaMantenimiento() {
		return fechaMantenimiento;
	}
	public boolean isEstadoMantenimiento() {
		return estadoMantenimiento;
	}
	
	// Setters
	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}
	public void setFechaMantenimiento(LocalDate fechaMantenimiento) {
		this.fechaMantenimiento = fechaMantenimiento;
	}
	public void setEstadoMantenimiento(boolean estadoMantenimiento) {
		this.estadoMantenimiento = estadoMantenimiento;
	}
	
	// Metodos
    public boolean comprobarEstadoMantenimiento() {
        LocalDate hoy = LocalDate.now();
        
        return fechaMantenimiento.isAfter(hoy);
    }
    
    public String alertaMantenimiento() {
    	LocalDate hoy = LocalDate.now();
    	String alerta = "";
    	
    	if (fechaMantenimiento.isBefore(hoy)) {
    		alerta = "Vencido";
    	} else {
    		long mesesRestantes = ChronoUnit.MONTHS.between(hoy, fechaMantenimiento);
    		
    		if (mesesRestantes < 1) {
    			alerta = "Próximo";
    		} else {
    			alerta = "En plazo";
    		}
    	}
    	
    	return alerta;
    }
	
	public LocalDate calcularProximoMantenimiento(Vehiculo vehiculo) {
		
		LocalDate fechaMatriculacion = vehiculo.getFechaMatriculacion();
		LocalDate hoy = LocalDate.now();
		LocalDate fechaProximoMantenimiento;
		
		int aniosAntiguedad = hoy.getYear() - fechaMatriculacion.getYear();
		
		int mesesHastaMantenimiento = 0;
		
		switch (vehiculo.getCategoria()) {
			case TURISMO:
				if (aniosAntiguedad < 4) {
					mesesHastaMantenimiento = 24;
				} else {
					mesesHastaMantenimiento = 12;
				}
				break;
				
			case MOTOCICLETA:
				if (aniosAntiguedad < 4) {
					mesesHastaMantenimiento = 24;
				} else {
					mesesHastaMantenimiento = 12;
				}
				break;
				
			case FURGONETA:
				if (aniosAntiguedad < 2) {
					mesesHastaMantenimiento = 12;
				} else {
					mesesHastaMantenimiento = 6;
				}
				break;
		}
		
		fechaProximoMantenimiento = hoy.plusMonths(mesesHastaMantenimiento);
		
		return fechaProximoMantenimiento;
	}
	
	public void actualizarMantenimiento(Vehiculo vehiculo) {
		// Calcular nueva fecha de mantenimiento automáticamente por Administrador
		this.fechaMantenimiento = calcularProximoMantenimiento(vehiculo);
		// Actualizar el estado de mantenimiento
		this.estadoMantenimiento = comprobarEstadoMantenimiento();
	}
	
}
