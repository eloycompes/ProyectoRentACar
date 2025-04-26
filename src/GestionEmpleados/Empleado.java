package GestionEmpleados;

import java.util.ArrayList;

public abstract class Empleado {
	
	//Atributos
	protected static ArrayList<Empleado> listaEmpleados = new ArrayList<>();
	private int idEmpleado;
	private static int contadorId = 0;
	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;
	private String email;
	private Rol rol;
	
	//Constructor
	public Empleado(String nombre, String apellidos, String dni, String telefono, String email, Rol rol) {
		this.idEmpleado = ++contadorId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.rol = rol;
		
		listaEmpleados.add(this);
	}

	//Getters
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getDni() {
		return dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getEmail() {
		return email;
	}
	public Rol getRol() {
		return rol;
	}
	public static ArrayList<Empleado> getListaEmpleado(){
		return listaEmpleados;
	}
	
	//Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	//Métodos
	@Override
	public String toString() {
		return "Empleado {\n" +
				"  ID: " + idEmpleado + "\n" +
				"  Nombre: " + apellidos + ", " + nombre + "\n" +
				"  DNI: " + dni + "\n" +
				"  Teléfono: " + telefono + "\n" +
				"  Email: " + email + "\n" +
				"  Rol: " + rol + "\n" +
				'}';
			
	}
	
	public boolean comprobarRol() {
		return this.rol == rol.ADMINISTRADOR;
	}
	

}
