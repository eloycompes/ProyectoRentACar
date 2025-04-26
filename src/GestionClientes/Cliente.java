package GestionClientes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

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
	public int getIdCliente()
	{
		return idCliente;
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
	public String getDireccion()
	{
		return direccion;
	}
	public String getTelefono()
	{
		return telefono;
	}
	public String getEmail()
	{
		return email;
	}
	public static ArrayList<Cliente> getListaClientes()
	{
		return listaClientes;
	}
	
	//Setters
	public void setIdCliente(int idCliente)
	{
		this.idCliente = idCliente;
	}
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
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	//Métodos
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
