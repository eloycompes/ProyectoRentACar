package GestionEmpleados;

/**
 * Representa un empleado con rol de administrador.
 * Los administradores tienen permisos completos en el sistema.
 *
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
public class Administrador extends Empleado{

	// Constructor
	/**
     * Constructor utilizado al cargar datos existentes.
     * 
     * @param id ID del administrador
     * @param nombre Nombre del administrador
     * @param apellidos Apellidos del administrador
     * @param dni Documento de identidad
     * @param telefono Número de teléfono
     * @param email Correo electrónico
     */
	protected Administrador(int id, String nombre, String apellidos, String dni, String telefono, String email)
	{
	    super(id, nombre, apellidos, dni, telefono, email, Rol.ADMINISTRADOR);
	}
	
	/**
     * Constructor utilizado para crear un nuevo administrador.
     * El ID del administrador se genera automáticamente.
     * 
     * @param nombre Nombre del administrador
     * @param apellidos Apellidos del administrador
     * @param dni Documento de identidad
     * @param telefono Número de teléfono
     * @param email Correo electrónico
     */
	public Administrador(String nombre, String apellidos, String dni, String telefono, String email)
	{
		super(nombre, apellidos, dni, telefono, email, Rol.ADMINISTRADOR);
	}
}
