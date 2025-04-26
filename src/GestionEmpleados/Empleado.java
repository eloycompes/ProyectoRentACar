package GestionEmpleados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


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
	public int getIdEmpleado()
	{
		return idEmpleado;
	}
	public String getNombre()
	{
		return nombre;
	}
	public String getApellidos()
	{
		return apellidos;
	}
	public String getDni()
	{
		return dni;
	}
	public String getTelefono()
	{
		return telefono;
	}
	public String getEmail()
	{
		return email;
	}
	public Rol getRol()
	{
		return rol;
	}
	public static ArrayList<Empleado> getListaEmpleado()
	{
		return listaEmpleados;
	}
	
	//Setters
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos)
	{
		this.apellidos = apellidos;
	}
	public void setDni(String dni)
	{
		this.dni = dni;
	}
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setRol(Rol rol)
	{
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
	
	
	//CRUD
	
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
