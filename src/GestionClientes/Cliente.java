package GestionClientes;

import java.util.ArrayList;

public class Cliente {

	//Atributos
	protected static ArrayList<Cliente> listaClientes = new ArrayList<>();
	private int idCliente;
	private static int contadorId = 0;
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String telefono;
	private String email;
	
	//Constructor
	
	
	//Getters
	public int getIdCliente() {
		return idCliente;
	}
	public Cliente(String nombre, String apellidos, String dni, String direccion, String telefono, String email) {
		this.idCliente = ++contadorId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		
		listaClientes.add(this);
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
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getEmail() {
		return email;
	}
	public static ArrayList<Cliente> getListaClientes(){
		return listaClientes;
	}
	
	//Setters
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Métodos
	@Override
	public String toString() {
		return "Cliente {\n" +
				"  ID: " + idCliente + "\n" +
				"  Nombre: " + apellidos + ", " + nombre + "\n" +
				"  DNI: " + dni + "\n" +
				"  Dirección: " + direccion + "\n" +
				"  Teléfono: " + telefono + "\n" +
				"  Email: " + email + "\n" +
				'}';
	}
	
	public static void eliminarCliente(Cliente cliente) {
		listaClientes.remove(cliente);
	}
}
