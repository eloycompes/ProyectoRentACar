package GestionEmpleados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Clase abstracta que representa a un empleado del sistema de gestión.
 * Permite gestionar los atributos personales del empleado, como nombre, apellidos, 
 * DNI, teléfono, email y rol. Además, ofrece operaciones CRUD (crear, leer, actualizar, 
 * eliminar) sobre la lista de empleados, y permite cargar y guardar los datos en formato JSON.
 * 
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
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
	/**
	 * Constructor protegido para inicializar un empleado existente desde almacenamiento.
	 * 
	 * @param idEmpleado El ID único del empleado.
	 * @param nombre Nombre del empleado.
	 * @param apellidos Apellidos del empleado.
	 * @param dni DNI del empleado.
	 * @param telefono Teléfono de contacto del empleado.
	 * @param email Correo electrónico del empleado.
	 * @param rol Rol del empleado (Administrador, Usuario, etc.).
	 */
	protected Empleado(int idEmpleado, String nombre, String apellidos, String dni, String telefono, String email, Rol rol)
	{
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.rol = rol;
	}
	
	/**
	 * Constructor público para crear un empleado con los datos personales proporcionados y su rol específico.
	 * El ID del empleado se genera automáticamente.
	 * 
	 * @param nombre Nombre del empleado.
	 * @param apellidos Apellidos del empleado.
	 * @param dni DNI del empleado.
	 * @param telefono Teléfono de contacto del empleado.
	 * @param email Correo electrónico del empleado.
	 * @param rol Rol del empleado (Administrador, Usuario, etc.).
	 */
	public Empleado(String nombre, String apellidos, String dni, String telefono, String email, Rol rol)
	{
		this.idEmpleado = ++contadorId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.rol = rol;
	}

	//Getters
	/**
	 * Obtiene el ID único del empleado.
	 * 
	 * @return El ID del empleado.
	 */
	public int getIdEmpleado()
	{
		return idEmpleado;
	}
	
	/**
	 * Obtiene el nombre del empleado.
	 * 
	 * @return El nombre del empleado.
	 */
	public String getNombre()
	{
		return nombre;
	}
	
	/**
	 * Obtiene los apellidos del empleado.
	 * 
	 * @return Los apellidos del empleado.
	 */
	public String getApellidos()
	{
		return apellidos;
	}
	
	/**
	 * Obtiene el DNI del empleado.
	 * 
	 * @return El DNI del empleado.
	 */
	public String getDni()
	{
		return dni;
	}
	
	/**
	 * Obtiene el teléfono de contacto del empleado.
	 * 
	 * @return El teléfono de contacto del empleado.
	 */
	public String getTelefono()
	{
		return telefono;
	}
	
	/**
	 * Obtiene el correo electrónico del empleado.
	 * 
	 * @return El correo electrónico del empleado.
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * Obtiene el rol del empleado.
	 * 
	 * @return El rol del empleado.
	 */
	public Rol getRol()
	{
		return rol;
	}
	
	/**
	 * Obtiene la lista de empleados registrados.
	 * 
	 * @return La lista de empleados registrados.
	 */
	public static ArrayList<Empleado> getListaEmpleado()
	{
		return listaEmpleados;
	}
	
	//Setters
	/**
	 * Establece el nombre del empleado.
	 * 
	 * @param nombre El nombre del empleado.
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	/**
	 * Establece los apellidos del empleado.
	 * 
	 * @param apellidos Los apellidos del empleado.
	 */
	public void setApellidos(String apellidos)
	{
		this.apellidos = apellidos;
	}
	
	/**
	 * Establece el DNI del empleado.
	 * 
	 * @param dni El DNI del empleado.
	 */
	public void setDni(String dni)
	{
		this.dni = dni;
	}
	
	/**
	 * Establece el teléfono de contacto del empleado.
	 * 
	 * @param telefono El teléfono de contacto del empleado.
	 */
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	/**
	 * Establece el correo electrónico del empleado.
	 * 
	 * @param email El correo electrónico del empleado.
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * Establece el rol del empleado.
	 * 
	 * @param rol El rol del empleado.
	 */
	public void setRol(Rol rol)
	{
		this.rol = rol;
	}
	
	//Métodos
	/**
     * Representación en cadena del empleado.
     * 
     * @return Información detallada del empleado.
     */
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
	
	/**
	 * Comprueba si el empleado tiene rol de administrador.
	 * 
	 * @return Verdadero si el rol del empleado es ADMINISTRADOR, falso en caso contrario.
	 */
	public boolean comprobarRol() {
		return this.rol == rol.ADMINISTRADOR;
	}
	
	
	//CRUD
	
	/**
	 * Inserta un empleado en la lista de empleados, verificando que el ID no esté duplicado.
	 * 
	 * @param empleado El empleado a insertar.
	 */
	public static void Insertar(Empleado empleado)
	{
		Boolean existe = false;
		int i = 0;
		while (i < listaEmpleados.size() && !existe)
		{
			if (listaEmpleados.get(i).getIdEmpleado() == empleado.getIdEmpleado())
			{
				existe = true;
			}
			i++;
		}
		
		// Añadir empleado a listaEmpleados
		if (!existe)
		{
			listaEmpleados.add(empleado);
		}		
		else
		{
			System.out.println("Ya existe un empleado con la ID " + empleado.getIdEmpleado());
		}
	}
	
	/**
	 * Lee un empleado de la lista por su ID.
	 * 
	 * @param id El ID del empleado a buscar.
	 * @return El empleado correspondiente al ID, o null si no se encuentra.
	 */
	public static Empleado Leer(int id)
	{
		Empleado empleado = null;
		int i = 0;
		while (i < listaEmpleados.size() && empleado == null)
		{
			if (listaEmpleados.get(i).getIdEmpleado() == id)
			{
				empleado = listaEmpleados.get(i);
			}
			i++;
		}
		return empleado;
	}
	
	/**
	 * Modifica los datos de un empleado en la lista.
	 * 
	 * @param empleadoActualizado El empleado con los datos actualizados.
	 */
	public static void Modificar(Empleado empleadoActualizado)
	{
		Empleado empleadoExistente = null;
		int i = 0;
		while (i < listaEmpleados.size() && empleadoExistente == null)
		{
			if (listaEmpleados.get(i).getIdEmpleado() == empleadoActualizado.getIdEmpleado())
			{
				empleadoExistente = listaEmpleados.get(i);
			}
			i++;
		}
		if (empleadoExistente != null)
		{
			empleadoExistente.setNombre(empleadoActualizado.getNombre());
			empleadoExistente.setApellidos(empleadoActualizado.getApellidos());
			empleadoExistente.setDni(empleadoActualizado.getDni());
			empleadoExistente.setTelefono(empleadoActualizado.getTelefono());
			empleadoExistente.setEmail(empleadoActualizado.getEmail());
			empleadoExistente.setRol(empleadoActualizado.getRol());
		}
	}
	
	/**
	 * Elimina un empleado de la lista por su ID.
	 * 
	 * @param id El ID del empleado a eliminar.
	 */
	public static void Eliminar(int id)
	{
		Boolean borrado = false;
		int i = 0;
		while (i < listaEmpleados.size() && !borrado)
		{
			if (listaEmpleados.get(i).getIdEmpleado() == id)
			{
				listaEmpleados.remove(i);
			}
			i++;
		}		
	}
	
	/**
	 * Guarda los cambios realizados en la lista de empleados en un archivo JSON.
	 */
	public static void GuardarCambios() {
		String ruta = "data/listaEmpleados.json";
		File file = new File (ruta);
		file.getParentFile().mkdirs();
		
		JSONArray jsonArray = new JSONArray();

        try {
        	for (int i = 0; i < listaEmpleados.size(); i++)
        	{
        		Empleado empleado = listaEmpleados.get(i);
        		
                JSONObject empleadoJson = new JSONObject();
                
                empleadoJson.put("id", empleado.getIdEmpleado());
                empleadoJson.put("nombre", empleado.getNombre());
                empleadoJson.put("apellidos", empleado.getApellidos());
                empleadoJson.put("dni", empleado.getDni());
                empleadoJson.put("telefono", empleado.getTelefono());
                empleadoJson.put("email", empleado.getEmail());
                empleadoJson.put("rol", empleado.getRol());

                jsonArray.put(empleadoJson);
        	}

            // Escribir en archivo
            FileWriter writer = new FileWriter(file);
            writer.write(jsonArray.toString(4));
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Lee los datos de los empleados desde un archivo JSON y los carga en la lista de empleados.
	 */
	public static void LeerDisco()
	{
		String ruta = "data/listaEmpleados.json";
		File file = new File (ruta);
		file.getParentFile().mkdirs();
		
		JSONArray jsonArray = new JSONArray();

        try {
            // Leer contenido existente
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder json = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }
                reader.close();

                if (!json.toString().isEmpty()) {
                    jsonArray = new JSONArray(json.toString());
                }
            }
            
            listaEmpleados.clear();
            
            int maxId = 0;
            for (int i = 0; i < jsonArray.length(); i++)
            {
            	JSONObject empleadoJson = (JSONObject) jsonArray.get(i);
            	
            	String rolStr = empleadoJson.getString("rol");
            	Rol rol = Rol.valueOf(rolStr.toUpperCase());

            	Empleado empleado = null;

            	switch (rol) {
            	    case ADMINISTRADOR:
            	        empleado = new Administrador(
            	            empleadoJson.getInt("id"),
            	            empleadoJson.getString("nombre"),
            	            empleadoJson.getString("apellidos"),
            	            empleadoJson.getString("dni"),
            	            empleadoJson.getString("telefono"),
            	            empleadoJson.getString("email")
            	        );
            	        break;
            	    case USUARIO:
            	        empleado = new Usuario(
            	            empleadoJson.getInt("id"),
            	            empleadoJson.getString("nombre"),
            	            empleadoJson.getString("apellidos"),
            	            empleadoJson.getString("dni"),
            	            empleadoJson.getString("telefono"),
            	            empleadoJson.getString("email")
            	        );
            	        break;
            	}
        		
            	listaEmpleados.add(empleado);
        		
        		if(empleado.getIdEmpleado() > maxId)
        		{
        			maxId = empleado.getIdEmpleado();
        		}
        		contadorId = maxId;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
