package GestionEmpleados;

public class Administrador extends Empleado{

	// Constructor
	protected Administrador(int id, String nombre, String apellidos, String dni, String telefono, String email)
	{
	    super(id, nombre, apellidos, dni, telefono, email, Rol.ADMINISTRADOR);
	}
	
	public Administrador(String nombre, String apellidos, String dni, String telefono, String email)
	{
		super(nombre, apellidos, dni, telefono, email, Rol.ADMINISTRADOR);
	}
}
