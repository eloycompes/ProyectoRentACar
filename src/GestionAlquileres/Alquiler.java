package GestionAlquileres;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import GestionClientes.Cliente;
import GestionEmpleados.Empleado;
import GestionVehiculos.Vehiculo;

/**
 * Clase que representa un alquiler de vehículo en el sistema de gestión de alquileres de coches.
 * Permite gestionar la información del cliente, el empleado encargado del alquiler, 
 * el vehículo alquilado, las fechas de inicio y fin del alquiler, así como el coste total.
 * Además, incluye operaciones para calcular el coste, actualizar el estado del alquiler 
 * y realizar las operaciones CRUD (crear, leer, actualizar, eliminar) sobre los alquileres.
 * 
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
public class Alquiler {

	//Atributos
	protected static ArrayList<Alquiler> listaAlquileres = new ArrayList<>();
	private int idAlquiler;
	private static int contadorId = 0;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double costeTotal;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private Empleado empleado;
	private boolean estadoAlquiler;
	
	//Constructor
	/**
     * Constructor protegido para inicializar un alquiler existente desde almacenamiento.
     * 
     * @param idAlquiler ID único del alquiler.
     * @param cliente Cliente que alquila el vehículo.
     * @param vehiculo Vehículo alquilado.
     * @param empleado Empleado que gestionó el alquiler.
     * @param fechaInicio Fecha de inicio del alquiler.
     * @param fechaFin Fecha de fin del alquiler.
     * @param costeTotal Coste total del alquiler.
     * @param estado Estado del alquiler (activo o no).
     */
	protected Alquiler (int idAlquiler, Cliente cliente, Vehiculo vehiculo, Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, double costeTotal, boolean estado)
	{
		this.idAlquiler = idAlquiler;
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.empleado = empleado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costeTotal = costeTotal;
		this.estadoAlquiler = estado;
	}	
	
	/**
	 * Constructor público para crear un alquiler.
	 * El ID del alquiler se genera automáticamente.
	 *
     * Se verifica que el vehículo tenga el mantenimiento al día antes de permitir el alquiler.
     * 
     * @param cliente Cliente que alquila el vehículo.
     * @param vehiculo Vehículo alquilado.
     * @param empleado Empleado que gestionó el alquiler.
     * @param fechaInicio Fecha de inicio del alquiler.
     * @param fechaFin Fecha de fin del alquiler.
     */
	public Alquiler (Cliente cliente, Vehiculo vehiculo, Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin)
	{
		
		if (!vehiculo.mantenimientoAlDia()) {
			throw new IllegalArgumentException ("El vehículo no tiene el mantenimiento al día y no puede ser alquilado.");
		}
		
		this.idAlquiler = ++contadorId;
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.empleado = empleado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		
		actualizarEstadoAlquiler();
		
		calcularCosteTotal();
	}
	
	//Getters
	/**
     * Obtiene el ID del alquiler.
     * 
     * @return El ID del alquiler.
     */
	public int getIdAlquiler()
	{
		return idAlquiler;
	}
	
	/**
     * Obtiene la fecha de inicio del alquiler.
     * 
     * @return La fecha de inicio.
     */
	public LocalDate getFechaInicio()
	{
		return fechaInicio;
	}
	
	/**
     * Obtiene el cliente que alquila el vehículo.
     * 
     * @return El cliente.
     */
	public Cliente getCliente()
	{
		return cliente;
	}
	
	/**
     * Obtiene el empleado que gestionó el alquiler.
     * 
     * @return El empleado.
     */
	public Empleado getEmpleado()
	{
		return empleado;
	}

	/**
     * Obtiene la fecha de fin del alquiler.
     * 
     * @return La fecha de fin.
     */
	public LocalDate getFechaFin()
	{
		return fechaFin;
	}

	/**
     * Obtiene el coste total del alquiler.
     * 
     * @return El coste total.
     */
	public double getCosteTotal()
	{
		return costeTotal;
	}

	/**
     * Obtiene el estado del alquiler (activo o no).
     * 
     * @return true si el alquiler está activo, false si no lo está.
     */
	public boolean isEstadoAlquiler()
	{
		return estadoAlquiler;
	}
	
	/**
     * Obtiene la lista de todos los alquileres.
     * 
     * @return Lista de alquileres.
     */
	public static ArrayList<Alquiler> getListaAlquileres()
	{
		return listaAlquileres;
	}
	
	/**
     * Obtiene el vehículo alquilado.
     * 
     * @return El vehículo alquilado.
     */
	public Vehiculo getVehiculo()
	{
		return vehiculo;
	}

	//Setters
	/**
	 * Establece la fecha de inicio del alquiler.
	 * 
	 * @param fechaInicio La nueva fecha de inicio del alquiler.
	 */
	public void setFechaInicio(LocalDate fechaInicio)
	{
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Establece la fecha de fin del alquiler.
	 * 
	 * @param fechaFin La nueva fecha de fin del alquiler.
	 */
	public void setFechaFin(LocalDate fechaFin)
	{
		this.fechaFin = fechaFin;
		calcularCosteTotal();
	}

	/**
	 * Establece el coste total del alquiler.
	 * 
	 * @param costeTotal El nuevo coste total del alquiler.
	 */
	public void setCosteTotal(double costeTotal)
	{
		this.costeTotal = costeTotal;
	}

	/**
	 * Establece el estado del alquiler (activo o no).
	 * 
	 * @param estadoAlquiler El nuevo estado del alquiler.
	 */
	public void setEstadoAlquiler(boolean estadoAlquiler)
	{
		this.estadoAlquiler = estadoAlquiler;
	}
	
	/**
	 * Establece el cliente asociado al alquiler.
	 * 
	 * @param cliente El nuevo cliente asociado alquiler.
	 */
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	/**
	 * Establece el vehículo asociado al alquiler.
	 * 
	 * @param vehiculo El nuevo vehículo asociado alquiler.
	 */
	public void setVehiculo(Vehiculo vehiculo)
	{
		this.vehiculo = vehiculo;
	}

	//Métodos
	/**
     * Representación en cadena del alquiler.
     * 
     * @return Información detallada del alquiler.
     */
    @Override
    public String toString()
    {
    	return "Alquiler {\n" +
                "  ID: " + idAlquiler + "\n" +
                "  Empleado: " + empleado.getNombre() + "\n" +
                "  Cliente: " + cliente.getApellidos() + ", " + cliente.getNombre() + "\n" +
                "  Vehículo: " + vehiculo.getModelo() + "\n" +
                "  Fecha inicio: " + fechaInicio + "\n" +
                "  Fecha fin: " + fechaFin + "\n" +
                "  Coste total: " + costeTotal + "€\n" +
                "  Estado: " + estadoAlquiler +
                "}";
    }
    
    /**
     * Calcula el coste total del alquiler basado en la duración del alquiler y el coste diario del vehículo.
     */
	private void calcularCosteTotal()
	{
		long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
		
		if (dias <= 0) dias = 1;
		
		this.costeTotal = dias * vehiculo.getPrecioDia();
	}
	
	/**
     * Actualiza el estado del alquiler en función de las fechas de inicio y fin, y la fecha actual.
     * El alquiler se considera activo si la fecha actual está entre la fecha de inicio y la fecha de fin.
     */
	public void actualizarEstadoAlquiler() {
		LocalDate hoy = LocalDate.now();
		
		if (hoy.isAfter(fechaInicio.minusDays(1)) && hoy.isBefore(fechaFin.plusDays(1))) {
			estadoAlquiler = true; //Alquiler activo
		} else {
			estadoAlquiler = false; //Alquiler inactivo
		}
	}
	
	/**
     * Finaliza el alquiler, actualizando su estado a inactivo y ajustando la fecha de fin a la fecha actual.
     */
    public void finalizarAlquiler() {
    	this.estadoAlquiler = false; //Forzamos finalizar alquiler
    	this.fechaFin = LocalDate.now();
    }
	
    //CRUD
    /**
     * Inserta un alquiler en la lista de alquileres si no existe un alquiler con el mismo ID.
     * 
     * @param alquiler El alquiler a insertar.
     */
    public static void Insertar(Alquiler alquiler)
	{
		Boolean existe = false;
		int i = 0;
		while (i < listaAlquileres.size() && !existe)
		{
			if (listaAlquileres.get(i).getIdAlquiler() == alquiler.getIdAlquiler())
			{
				existe = true;
			}
			i++;
		}
		
		// Añadir alquiler a listaAlquileres
		if (!existe)
		{
			listaAlquileres.add(alquiler);
		}		
		else
		{
			System.out.println("Ya existe un alquiler con la ID " + alquiler.getIdAlquiler());
		}
	}	
	
    /**
     * Lee un alquiler por su ID desde la lista de alquileres.
     * 
     * @param id ID del alquiler a buscar.
     * @return El alquiler encontrado o null si no existe.
     */
	public static Alquiler Leer(int id)
	{
		Alquiler alquiler = null;
		int i = 0;
		while (i < listaAlquileres.size() && alquiler == null)
		{
			if (listaAlquileres.get(i).getIdAlquiler() == id)
			{
				alquiler = listaAlquileres.get(i);
			}
			i++;
		}
		return alquiler;
	}
	
	/**
     * Modifica un alquiler existente en la lista de alquileres.
     * 
     * @param alquilerActualizado El alquiler con los nuevos datos.
     */
	public static void Modificar(Alquiler alquilerActualizado)
	{
		Alquiler alquilerExistente = null;
		int i = 0;
		while (i < listaAlquileres.size() && alquilerExistente == null)
		{
			if (listaAlquileres.get(i).getIdAlquiler() == alquilerActualizado.getIdAlquiler())
			{
				alquilerExistente = listaAlquileres.get(i);
			}
			i++;
		}
		if (alquilerExistente != null)
		{
			alquilerExistente.setCliente(alquilerActualizado.getCliente());
			alquilerExistente.setVehiculo(alquilerActualizado.getVehiculo());
			alquilerExistente.setFechaInicio(alquilerActualizado.getFechaInicio());
			alquilerExistente.setFechaFin(alquilerActualizado.getFechaFin());
		}
	}
	
	/**
     * Elimina un alquiler de la lista de alquileres por su ID.
     * 
     * @param id ID del alquiler a eliminar.
     */
	public static void Eliminar(int id)
	{
		Boolean borrado = false;
		int i = 0;
		while (i < listaAlquileres.size() && !borrado)
		{
			if (listaAlquileres.get(i).getIdAlquiler() == id)
			{
				listaAlquileres.remove(i);
			}
			i++;
		}		
	}
	
	/**
     * Guarda los cambios de los alquileres actuales en un archivo JSON.
     */
	public static void GuardarCambios() {
		String ruta = "data/listaAlquileres.json";
		File file = new File (ruta);
		file.getParentFile().mkdirs();
		
		JSONArray jsonArray = new JSONArray();

        try {
        	for (int i = 0; i < listaAlquileres.size(); i++)
        	{
        		Alquiler alquiler = listaAlquileres.get(i);
        		
                JSONObject alquilerJson = new JSONObject();
                
                alquilerJson.put("id", alquiler.getIdAlquiler());
                alquilerJson.put("cliente", (alquiler.getCliente().getApellidos() + ", " + alquiler.getCliente().getNombre()));
                alquilerJson.put("vehiculo", alquiler.getVehiculo().getModelo());
                alquilerJson.put("empleado", alquiler.getEmpleado().getNombre());
                alquilerJson.put("fechaInicio", alquiler.getFechaInicio().toString());
                alquilerJson.put("fechaFin", alquiler.getFechaFin().toString());
                alquilerJson.put("costeTotal", alquiler.getCosteTotal());
                alquilerJson.put("estado", alquiler.isEstadoAlquiler());
                               

                jsonArray.put(alquilerJson);
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
	 * Lee los datos de los alquileres desde un archivo JSON y los carga en la lista de alquileres.
	 */
	public static void LeerDisco()
	{
		String ruta = "data/listaAlquileres.json";
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
            
            listaAlquileres.clear();
            int maxId = 0;
            for (int i = 0; i < jsonArray.length(); i++)
            {
            	JSONObject alquilerJson = (JSONObject) jsonArray.get(i);
            	
            	Cliente cliente = Cliente.Leer(alquilerJson.getInt("id"));
            	Vehiculo vehiculo = Vehiculo.Leer(alquilerJson.getInt("id"));
            	Empleado empleado = Empleado.Leer(alquilerJson.getInt("id"));
            	
            	Alquiler alquiler = new Alquiler(
            			alquilerJson.getInt("id"),
            			cliente,
            			vehiculo,
            			empleado,
            			LocalDate.parse(alquilerJson.getString("fechaInicio")),
                        LocalDate.parse(alquilerJson.getString("fechaFin")),
                        alquilerJson.getDouble("costeTotal"),
                        alquilerJson.getBoolean("estado")
            			);
        		
            	listaAlquileres.add(alquiler);
        		
        		if(alquiler.getIdAlquiler() > maxId)
        		{
        			maxId = alquiler.getIdAlquiler();
        		}
        		contadorId = maxId;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}	
}
