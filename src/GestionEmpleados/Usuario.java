package GestionEmpleados;

/**
 * Representa un empleado con rol de usuario.
 * Los usuarios tienen permisos limitados en el sistema.
 *
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
public class Usuario extends Empleado{

	//Constructores
	/**
     * Constructor utilizado al cargar datos existentes.
     * 
     * @param id ID del usuario
     * @param nombre Nombre del usuario
     * @param apellidos Apellidos del usuario
     * @param dni Documento de identidad
     * @param telefono Número de teléfono
     * @param email Correo electrónico
     */
	protected Usuario(int id, String nombre, String apellidos, String dni, String telefono, String email)
	{
		super(nombre, apellidos, dni, telefono, email, Rol.USUARIO);
	}
	
	/**
     * Constructor utilizado para crear un nuevo usuario.
     * El ID del usuario se genera automáticamente.
     * 
     * @param nombre Nombre del usuario
     * @param apellidos Apellidos del usuario
     * @param dni Documento de identidad
     * @param telefono Número de teléfono
     * @param email Correo electrónico
     */
	public Usuario(String nombre, String apellidos, String dni, String telefono, String email)
	{
		super(nombre, apellidos, dni, telefono, email, Rol.USUARIO);
	}
}
