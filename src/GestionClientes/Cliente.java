package GestionClientes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Clase que representa a un cliente del sistema de alquiler de coches.
 * Permite gestionar los atributos personales del cliente, como nombre, apellidos, 
 * dirección, teléfono y email. También permite realizar operaciones CRUD (crear, leer, 
 * actualizar, eliminar) sobre la lista de clientes, así como cargar y guardar los datos 
 * en formato JSON.
 * 
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
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
	/**
	 * Constructor privado para inicializar un cliente existente desde almacenamiento.
	 * 
	 * @param idCliente El ID único del cliente.
	 * @param nombre Nombre del cliente.
	 * @param apellidos Apellidos del cliente.
	 * @param dni DNI del cliente.
	 * @param direccion Dirección del cliente.
	 * @param telefono Teléfono de contacto del cliente.
	 * @param email Correo electrónico del cliente.
	 */
	private Cliente(int idCliente, String nombre, String apellidos, String dni, String direccion, String telefono, String email)
	{
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	
	/**
	 * Constructor público para crear un cliente con los datos personales proporcionados.
	 * El ID del cliente se genera automáticamente.
	 * 
	 * @param nombre Nombre del cliente.
	 * @param apellidos Apellidos del cliente.
	 * @param dni DNI del cliente.
	 * @param direccion Dirección del cliente.
	 * @param telefono Teléfono de contacto del cliente.
	 * @param email Correo electrónico del cliente.
	 */
	public Cliente(String nombre, String apellidos, String dni, String direccion, String telefono, String email)
	{
		this.idCliente = ++contadorId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	
	
	//Getters
	/**
	 * Obtiene el ID único del cliente.
	 * 
	 * @return El ID del cliente.
	 */
	public int getIdCliente()
	{
		return idCliente;
	}
	
	/**
	 * Obtiene el nombre del cliente.
	 * 
	 * @return El nombre del cliente.
	 */
	public String getNombre()
	{
		return nombre;
	}
	
	/**
	 * Obtiene los apellidos del cliente.
	 * 
	 * @return Los apellidos del cliente.
	 */
	public String getApellidos()
	{
		return apellidos;
	}
	
	/**
	 * Obtiene el DNI del cliente.
	 * 
	 * @return El DNI del cliente.
	 */
	public String getDni()
	{
		return dni;
	}
	
	/**
	 * Obtiene la dirección del cliente.
	 * 
	 * @return La dirección del cliente.
	 */
	public String getDireccion()
	{
		return direccion;
	}
	
	/**
	 * Obtiene el teléfono de contacto del cliente.
	 * 
	 * @return El teléfono de contacto del cliente.
	 */
	public String getTelefono()
	{
		return telefono;
	}
	
	/**
	 * Obtiene el correo electrónico del cliente.
	 * 
	 * @return El correo electrónico del cliente.
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * Obtiene la lista de clientes registrados.
	 * 
	 * @return La lista de clientes registrados.
	 */
	public static ArrayList<Cliente> getListaClientes()
	{
		return listaClientes;
	}
	
	//Setters
	/**
	 * Establece el ID único del cliente.
	 * 
	 * @param id El ID único del cliente.
	 */
	public void setIdCliente(int idCliente)
	{
		this.idCliente = idCliente;
	}
	
	/**
	 * Establece el nombre del cliente.
	 * 
	 * @param nombre El nombre del cliente.
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	/**
	 * Establece los apellidos del cliente.
	 * 
	 * @param apellidos Los apellidos del cliente.
	 */
	public void setApellidos(String apellidos)
	{
		this.apellidos = apellidos;
	}
	
	/**
	 * Establece el DNI del cliente.
	 * 
	 * @param dni El DNI del cliente.
	 */
	public void setDni(String dni)
	{
		this.dni = dni;
	}
	
	/**
	 * Establece la dirección del cliente.
	 * 
	 * @param direccion La dirección del cliente.
	 */
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	/**
	 * Establece el teléfono del cliente.
	 * 
	 * @param telefono El teléfono del cliente.
	 */
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	/**
	 * Establece el correo electrónico del cliente.
	 * 
	 * @param email El correo electrónico del cliente.
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	//Métodos
	/**
     * Representación en cadena del cliente.
     * 
     * @return Información detallada del cliente.
     */
	@Override
	public String toString()
	{
		return "Cliente {\n" +
				"  ID: " + idCliente + "\n" +
				"  Nombre: " + apellidos + ", " + nombre + "\n" +
				"  DNI: " + dni + "\n" +
				"  Dirección: " + direccion + "\n" +
				"  Teléfono: " + telefono + "\n" +
				"  Email: " + email + "\n" +
				'}';
	}
	    
	
    //CRUD
	/**
	 * Inserta un cliente en la lista de clientes, verificando que el ID no esté duplicado.
	 * 
	 * @param cliente El cliente a insertar.
	 */
	public static void Insertar(Cliente cliente)
	{
		// Ver que cliente.Id no existe en ningún cliente
		Boolean existe = false;
		int i = 0;
		while (i < listaClientes.size() && !existe)
		{
			if (listaClientes.get(i).getIdCliente() == cliente.getIdCliente())
			{
				existe = true;
			}
			i++;
		}
		
		// Añadir cliente a listaClientes
		if (!existe)
		{
			listaClientes.add(cliente);
		}		
		else
		{
			System.out.println("Ya existe un cliente con la ID " + cliente.getIdCliente());
		}
	}
	
	/**
	 * Lee un cliente de la lista por su ID.
	 * 
	 * @param id El ID del cliente a buscar.
	 * @return El cliente correspondiente al ID, o null si no se encuentra.
	 */
	public static Cliente Leer(int id)
	{
		Cliente cliente = null;
		int i = 0;
		while (i < listaClientes.size() && cliente == null)
		{
			if (listaClientes.get(i).getIdCliente() == id)
			{
				cliente = listaClientes.get(i);
			}
			i++;
		}
		return cliente;
	}
	
	/**
	 * Modifica los datos de un cliente de la lista.
	 * 
	 * @param clienteActualizado El cliente a modificar.
	 */
	public static void Modificar(Cliente clienteActualizado)
	{
		Cliente clienteExistente = null;
		int i = 0;
		while (i < listaClientes.size() && clienteExistente == null)
		{
			if (listaClientes.get(i).getIdCliente() == clienteActualizado.getIdCliente())
			{
				clienteExistente = listaClientes.get(i);
			}
			i++;
		}
		if (clienteExistente != null)
		{
			clienteExistente.setNombre(clienteActualizado.getNombre());
			clienteExistente.setApellidos(clienteActualizado.getApellidos());
			clienteExistente.setDni(clienteActualizado.getDni());
			clienteExistente.setDireccion(clienteActualizado.getDireccion());
			clienteExistente.setTelefono(clienteActualizado.getTelefono());
			clienteExistente.setEmail(clienteActualizado.getEmail());
		}
	}
	
	/**
	 * Elimina un cliente de la lista por su ID.
	 * 
	 * @param id El ID del cliente a eliminar.
	 */
	public static void Eliminar(int id)
	{
		Boolean borrado = false;
		int i = 0;
		while (i < listaClientes.size() && !borrado)
		{
			if (listaClientes.get(i).getIdCliente() == id)
			{
				listaClientes.remove(i);
			}
			i++;
		}		
	}

	/**
	 * Guarda los cambios realizados en la lista de clientes en un archivo JSON.
	 */
	public static void GuardarCambios() {
		String ruta = "data/listaClientes.json";
		File file = new File (ruta);
		file.getParentFile().mkdirs();
		
		JSONArray jsonArray = new JSONArray();

        try {
        	for (int i = 0; i < listaClientes.size(); i++)
        	{
        		Cliente cliente = listaClientes.get(i);
        		
                JSONObject clienteJson = new JSONObject();
                
                clienteJson.put("id", cliente.getIdCliente());
                clienteJson.put("nombre", cliente.getNombre());
                clienteJson.put("apellidos", cliente.getApellidos());
                clienteJson.put("dni", cliente.getDni());
                clienteJson.put("direccion", cliente.getDireccion());
                clienteJson.put("telefono", cliente.getTelefono());
                clienteJson.put("email", cliente.getEmail());

                jsonArray.put(clienteJson);
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
	 * Lee los datos de los clientes desde un archivo JSON y los carga en la lista de clientes.
	 */
	public static void LeerDisco()
	{
		String ruta = "data/listaClientes.json";
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
            
            listaClientes.clear();
            int maxId = 0;
            for (int i = 0; i < jsonArray.length(); i++)
            {
            	JSONObject clienteJson = (JSONObject) jsonArray.get(i);
            	
            	Cliente cliente = new Cliente(
            			clienteJson.getInt("id"),
            			clienteJson.getString("nombre"),
            			clienteJson.getString("apellidos"),
            			clienteJson.getString("dni"),
            			clienteJson.getString("direccion"),
            			clienteJson.getString("telefono"),
            			clienteJson.getString("email")
            			);
        		
        		listaClientes.add(cliente);
        		
        		if(cliente.getIdCliente() > maxId)
        		{
        			maxId = cliente.getIdCliente();
        		}
        		contadorId = maxId;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
