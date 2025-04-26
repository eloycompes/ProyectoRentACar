package GestionEmpleados;

public class Usuario extends Empleado{

	public Usuario(String nombre, String apellidos, String dni, String telefono, String email) {
		super(nombre, apellidos, dni, telefono, email, Rol.USUARIO);
	}

	
}
