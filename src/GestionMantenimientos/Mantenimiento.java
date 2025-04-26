package GestionMantenimientos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import GestionVehiculos.Vehiculo;

/**
 * Clase que representa un mantenimiento de un vehículo.
 * 
 * Cada mantenimiento tiene una fecha y un estado (si está vencido o en plazo), y se calcula automáticamente
 * el próximo mantenimiento basado en la antigüedad del vehículo y su categoría. También incluye 
 * métodos para verificar si el mantenimiento está actualizado y generar alertas.
 *
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
public class Mantenimiento {

	// Atributos
	private int idMantenimiento;
	private static int contadorId = 0;
	private LocalDate fechaMantenimiento;
	private boolean estadoMantenimiento;
	
	// Constructor
	/**
     * Constructor que crea un mantenimiento para un vehículo.
     * 
     * El ID del mantenimiento se genera automáticamente y se calcula la fecha del próximo mantenimiento
     * basado en la antigüedad y la categoría del vehículo.
     * 
     * @param vehiculo El vehículo para el cual se realiza el mantenimiento.
     */
	public Mantenimiento(Vehiculo vehiculo) {
		this.idMantenimiento = ++contadorId;
		this.fechaMantenimiento = calcularProximoMantenimiento(vehiculo);
		this.estadoMantenimiento = comprobarEstadoMantenimiento();
	}
	
	// Getters
	/**
     * Obtiene el ID del mantenimiento.
     * 
     * @return El ID del mantenimiento.
     */
	public int getIdMantenimiento() {
		return idMantenimiento;
	}
	
	/**
     * Obtiene la fecha del próximo mantenimiento.
     * 
     * @return La fecha del próximo mantenimiento.
     */
	public LocalDate getFechaMantenimiento() {
		return fechaMantenimiento;
	}
	
	/**
     * Obtiene el estado del mantenimiento (si está vencido o no).
     * 
     * @return true si el mantenimiento está vencido, false si está en plazo.
     */
	public boolean isEstadoMantenimiento() {
		return estadoMantenimiento;
	}
	
	// Setters
	/**
     * Establece el ID del mantenimiento.
     * 
     * @param idMantenimiento El nuevo ID para el mantenimiento.
     */
	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}
	
	/**
     * Establece la fecha del próximo mantenimiento.
     * 
     * @param fechaMantenimiento La nueva fecha del próximo mantenimiento.
     */
	public void setFechaMantenimiento(LocalDate fechaMantenimiento) {
		this.fechaMantenimiento = fechaMantenimiento;
	}
	
	/**
     * Establece el estado del mantenimiento (vencido o en plazo).
     * 
     * @param estadoMantenimiento El nuevo estado del mantenimiento.
     */
	public void setEstadoMantenimiento(boolean estadoMantenimiento) {
		this.estadoMantenimiento = estadoMantenimiento;
	}
	
	// Metodos
	/**
     * Comprueba el estado del mantenimiento.
     * 
     * Si la fecha de mantenimiento es posterior a la fecha actual, el mantenimiento está "en plazo".
     * Si la fecha de mantenimiento es anterior a la fecha actual, el mantenimiento está "vencido".
     * 
     * @return true si el mantenimiento está vencido, false si está en plazo.
     */
    public boolean comprobarEstadoMantenimiento() {
        LocalDate hoy = LocalDate.now();
        
        return fechaMantenimiento.isAfter(hoy);
    }
    
    /**
     * Genera una alerta sobre el estado del mantenimiento.
     * 
     * - "Vencido" si el mantenimiento ya pasó.
     * - "Próximo" si el mantenimiento es dentro de menos de un mes.
     * - "En plazo" si el mantenimiento está dentro del plazo.
     * 
     * @return El estado de la alerta: "Vencido", "Próximo" o "En plazo".
     */
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
	
    /**
     * Calcula la fecha del próximo mantenimiento basado en la antigüedad del vehículo y su categoría.
     * 
     * - Vehículos de la categoría "TURISMO" y "MOTOCICLETA": Se realiza mantenimiento cada 24 meses si tienen menos de 4 años,
     *   o cada 12 meses si tienen 4 años o más.
     * - Vehículos de la categoría "FURGONETA": Se realiza mantenimiento cada 12 meses si tienen menos de 2 años,
     *   o cada 6 meses si tienen 2 años o más.
     * 
     * @param vehiculo El vehículo para el cual se calcula la fecha de mantenimiento.
     * @return La fecha del próximo mantenimiento.
     */
	public LocalDate calcularProximoMantenimiento(Vehiculo vehiculo) {
		
		LocalDate fechaUltimoMantenimiento = vehiculo.getFechaUltimoMantenimiento();
		LocalDate hoy = LocalDate.now();
		LocalDate fechaProximoMantenimiento;
		
		LocalDate fechaReferencia = (fechaUltimoMantenimiento != null) ? fechaUltimoMantenimiento : vehiculo.getFechaMatriculacion();
		
		int aniosAntiguedad = hoy.getYear() - fechaReferencia.getYear();
		
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
	
	/**
     * Actualiza la fecha y el estado del mantenimiento en función de un nuevo cálculo.
     * 
     * Este método recalcula la fecha de mantenimiento y actualiza el estado (vencido o en plazo).
     * 
     * @param vehiculo El vehículo para el cual se actualiza el mantenimiento.
     */
	public void actualizarMantenimiento(Vehiculo vehiculo) {
		this.fechaMantenimiento = calcularProximoMantenimiento(vehiculo);
		this.estadoMantenimiento = comprobarEstadoMantenimiento();
	}
	
}
