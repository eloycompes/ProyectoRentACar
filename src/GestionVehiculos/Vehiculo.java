package GestionVehiculos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import GestionAlquileres.Alquiler;
import GestionMantenimientos.Mantenimiento;

/**
 * Clase que representa a un vehículo en el sistema de alquiler de coches.
 * Permite gestionar los atributos relacionados con el vehículo, como el modelo, 
 * la matrícula, la categoría, la fecha de matriculación, el precio por día, 
 * y el estado de mantenimiento.
 * 
 * @author [Eloy]
 * @version 1.0
 * @since 1.0
 */
public abstract class Vehiculo {	
	//Atributos
	protected static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
	private int idVehiculo;
	private static int contadorId = 0;
	private CategoriaVehiculo categoria;
	private TiposVehiculos tipoVehiculos;
	private String modelo;
	private LocalDate fechaMatriculacion;
	private Mantenimiento mantenimiento;

	
	//Constructor
	/**
     * Constructor protegido para inicializar un vehículo existente desde almacenamiento.
     * 
     * @param idVehiculo ID del vehículo
     * @param categoria Categoría del vehículo (Turismo, Furgoneta, Motocicleta)
     * @param tipoVehiculos Tipo específico de vehículo
     * @param modelo Modelo del vehículo
     * @param fechaMatriculacion Fecha de matriculación
     * @param precioDia Precio de alquiler por día
     */
    protected Vehiculo(int idVehiculo, CategoriaVehiculo categoria, TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion, double precioDia)
    {
        this.idVehiculo = idVehiculo;
        this.categoria = categoria;
        this.tipoVehiculos = tipoVehiculos;   
        this.modelo = modelo;
        this.fechaMatriculacion = fechaMatriculacion;
        this.mantenimiento = new Mantenimiento (this);
    }
    
    /**
     * Constructor para crear un nuevo vehículo.
     * El ID del vehículo se genera automáticamente.
     * 
     * @param categoria Categoría del vehículo
     * @param tipoVehiculos Tipo específico de vehículo
     * @param modelo Modelo del vehículo
     * @param fechaMatriculacion Fecha de matriculación
     * @param precioDia Precio de alquiler por día
     */
    public Vehiculo(CategoriaVehiculo categoria, TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion, double precioDia)
    {
        this.idVehiculo = ++contadorId;
        this.categoria = categoria;
        this.tipoVehiculos = tipoVehiculos;   
        this.modelo = modelo;
        this.fechaMatriculacion = fechaMatriculacion;
        this.mantenimiento = new Mantenimiento (this);
    }
	
	//Getters
    /**
	 * Obtiene el ID único del vehículo.
	 * 
	 * @return El ID del vehículo.
	 */
	public int getIdVehiculo()
	{
		return idVehiculo;
	}
	
	/**
	 * Obtiene la categoría del vehículo.
	 * 
	 * @return La categoría del vehículo.
	 */
	public CategoriaVehiculo getCategoria()
	{
		return categoria;
	}
	
	/**
	 * Obtiene el modelo del vehículo.
	 * 
	 * @return El modelo del vehículo.
	 */
	public String getModelo()
	{
		return modelo;
	}
	
	/**
	 * Obtiene el precio por día del vehículo.
	 * 
	 * @return El precio por día del vehículo.
	 */
    public double getPrecioDia()
    {
        return tipoVehiculos.getPrecioDia();
    }
    
    /**
	 * Obtiene la lista de los vehículos registrados.
	 * 
	 * @return La lista de los vehículos registrados.
	 */
    public static ArrayList<Vehiculo> getListaVehiculos()
    {
    	return listaVehiculos;
    }
    
    /**
	 * Obtiene la fecha de matriculación del vehículo.
	 * 
	 * @return La fecha de matriculación del vehículo.
	 */
	public LocalDate getFechaMatriculacion()
	{
		return fechaMatriculacion;
	}
	
	/**
	 * Obtiene los datos de mantenimiento del vehículo.
	 * 
	 * @return Los datos de mantenimiento del vehículo.
	 */
	public Mantenimiento getMantenimiento()
	{
		return mantenimiento;
	}
	
	/**
	 * Obtiene la fecha del último mantenimiento del vehículo.
	 * 
	 * @return La fecha del último mantenimiento del vehículo.
	 */
	public LocalDate getFechaUltimoMantenimiento()
	{
		LocalDate fecha = null;
        if (mantenimiento != null) {
            fecha = mantenimiento.getFechaMantenimiento();
        }        
        return fecha;
    }
	
	/**
	 * Obtiene el tipo del vehículo.
	 * 
	 * @return El tipo del vehículo.
	 */
	public TiposVehiculos getTipoVehiculos()
	{
		return tipoVehiculos;
	}

	//Setters
	/**
	 * Establece el ID del vehículo.
	 * 
	 * @param ID El ID del vehículo.
	 */
	public void setIdVehiculo(int idVehiculo)
	{
		this.idVehiculo = idVehiculo;
	}
	
	/**
	 * Establece la categoría del vehículo.
	 * 
	 * @param categoria La categoría del vehículo.
	 */
	public void setCategoria(CategoriaVehiculo categoria)
	{
		this.categoria = categoria;
	}
	
	/**
	 * Establece el modelo del vehículo.
	 * 
	 * @param modelo El modelo del vehículo.
	 */
	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}
	
	/**
	 * Establece la fecha de matriculación del vehículo.
	 * 
	 * @param fechaMatriculacion La fecha de matriculación del vehículo.
	 */
	public void setFechaMatriculacion(LocalDate fechaMatriculacion)
	{
		this.fechaMatriculacion = fechaMatriculacion;
	}
	
	/**
	 * Establece la fecha de mantenimiento del vehículo.
	 * 
	 * @param fechaMantenimiento La fecha de mantenimiento del vehículo.
	 */
	public void setFechaMantenimiento(LocalDate fechaMantenimiento)
	{
		this.mantenimiento.setFechaMantenimiento(fechaMantenimiento);
	}
	
	/**
	 * Establece el tipo del vehículo.
	 * 
	 * @param tipoVehiculos El tipo del vehículo.
	 */
	public void setTipoVehiculos(TiposVehiculos tipoVehiculos)
	{
		this.tipoVehiculos = tipoVehiculos;
	}

	//Metodos
	/**
     * Representación en cadena del vehículo.
     * 
     * @return Información detallada del vehículo.
     */
    @Override
    public String toString()
    {
    	String advertenciaMantenimiento = "";
    	
    	if(!mantenimientoAlDia()) {
    		advertenciaMantenimiento = " [Mantenimiento caducado]";
    	}
    		
    	return "Vehículo {\n" +
                "  ID: " + idVehiculo + "\n" +
                "  Categoria: " + categoria + "\n" +
                "  Tipo: " + getTipoVehiculos() + "\n" +
                "  Modelo: " + modelo + "\n" +
                "  Precio/día: " + getPrecioDia() + "€\n" +
                "  Próximo mantenimiento: " + mantenimiento.getFechaMantenimiento() + advertenciaMantenimiento + "\n" +
                "  Estado mantenimiento: " + mantenimiento.alertaMantenimiento() +
                "  Estado alquiler: " + (getEstadoAlquiler() ? "Activo" : "Inactivo") + "\n" +
                "}";
    }
    
    /**
     * Verifica si el vehículo está actualmente alquilado.
     * 
     * @return true si está alquilado, false en caso contrario
     */
    public boolean getEstadoAlquiler()
    {
    	boolean estadoAlquiler= false;
    	
    	for (Alquiler alquiler : Alquiler.getListaAlquileres()) {
    		if (alquiler.getVehiculo().equals(this) && alquiler.isEstadoAlquiler()) {
    				estadoAlquiler = true;
    			}
    	}
    	return estadoAlquiler;
    }
    
    /**
     * Comprueba si el vehículo tiene el mantenimiento al día.
     * 
     * @return true si el mantenimiento está en regla, false si está caducado
     */
    public boolean mantenimientoAlDia() {
    	return mantenimiento.comprobarEstadoMantenimiento();
    }
    
    /**
     * Actualiza la información de mantenimiento del vehículo.
     */
    public void actualizarMantenimiento() {
        if (this.mantenimiento != null) {
            this.mantenimiento.actualizarMantenimiento(this);
        }
    }
    
    
    //CRUD
    /**
	 * Inserta un vehículo en la lista de vehículos, verificando que el ID no esté duplicado.
	 * 
	 * @param vehiculo El vehículo a insertar.
	 */
    public static void Insertar(Vehiculo vehiculo)
	{
		Boolean existe = false;
		int i = 0;
		while (i < listaVehiculos.size() && !existe)
		{
			if (listaVehiculos.get(i).getIdVehiculo() == vehiculo.getIdVehiculo())
			{
				existe = true;
			}
			i++;
		}
		
		// Añadir vehículo a listaVehículos
		if (!existe)
		{
			listaVehiculos.add(vehiculo);
		}		
		else
		{
			System.out.println("Ya existe un vehículo con la ID " + vehiculo.getIdVehiculo());
		}
	}
    
    /**
	 * Lee un vehiculo de la lista por su ID.
	 * 
	 * @param id El ID del vehiculo a buscar.
	 * @return El vehiculo correspondiente al ID, o null si no se encuentra.
	 */
	public static Vehiculo Leer(int id)
	{
		Vehiculo vehiculo = null;
		int i = 0;
		while (i < listaVehiculos.size() && vehiculo == null)
		{
			if (listaVehiculos.get(i).getIdVehiculo() == id)
			{
				vehiculo = listaVehiculos.get(i);
			}
			i++;
		}
		return vehiculo;
	}
	
	/**
	 * Modifica los datos de un vehículo en la lista.
	 * 
	 * @param vehiculoActualizado El vehículo con los datos actualizados.
	 */
	public static void Modificar(Vehiculo vehiculoActualizado)
	{
		Vehiculo vehiculoExistente = null;
		int i = 0;
		while (i < listaVehiculos.size() && vehiculoExistente == null)
		{
			if (listaVehiculos.get(i).getIdVehiculo() == vehiculoActualizado.getIdVehiculo())
			{
				vehiculoExistente = listaVehiculos.get(i);
			}
			i++;
		}
		if (vehiculoExistente != null)
		{
			vehiculoExistente.setCategoria(vehiculoActualizado.getCategoria());
			vehiculoExistente.setTipoVehiculos(vehiculoActualizado.getTipoVehiculos());
			vehiculoExistente.setModelo(vehiculoActualizado.getModelo());
			vehiculoExistente.setFechaMatriculacion(vehiculoActualizado.getFechaMatriculacion());
		}
	}
    
	/**
	 * Elimina un vehículo de la lista por su ID.
	 * 
	 * @param id El ID del vehículo a eliminar.
	 */
	public static void Eliminar(int id)
	{
		Boolean borrado = false;
		int i = 0;
		while (i < listaVehiculos.size() && !borrado)
		{
			if (listaVehiculos.get(i).getIdVehiculo() == id)
			{
				listaVehiculos.remove(i);
			}
			i++;
		}		
	}
	
	/**
	 * Guarda los cambios realizados en la lista de vehiculos en un archivo JSON.
	 */
	public static void GuardarCambios() {
		String ruta = "data/listaVehiculos.json";
		File file = new File (ruta);
		file.getParentFile().mkdirs();
		
		JSONArray jsonArray = new JSONArray();

        try {
        	for (int i = 0; i < listaVehiculos.size(); i++)
        	{
        		Vehiculo vehiculo = listaVehiculos.get(i);
        		
                JSONObject vehiculoJson = new JSONObject();
                
                vehiculoJson.put("id", vehiculo.getIdVehiculo());
                vehiculoJson.put("categoria", vehiculo.getCategoria());
                vehiculoJson.put("tipo", vehiculo.getTipoVehiculos().getTipo());
                vehiculoJson.put("modelo", vehiculo.getModelo());
                vehiculoJson.put("fechaMatriculacion", vehiculo.getFechaMatriculacion().toString());
                vehiculoJson.put("precioDia", vehiculo.getTipoVehiculos().getPrecioDia());
                vehiculoJson.put("fechaMantenimiento", vehiculo.getMantenimiento().getFechaMantenimiento().toString());
                vehiculoJson.put("estadoMantenimiento", vehiculo.getMantenimiento().alertaMantenimiento());
                
                
                //estado alquiler

                jsonArray.put(vehiculoJson);
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
	 * Lee los datos de los vehículos desde un archivo JSON y los carga en la lista de vehículos.
	 */
	public static void LeerDisco()
	{
	    String ruta = "data/listaVehiculos.json";
	    File file = new File(ruta);
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

	        listaVehiculos.clear();

	        int maxId = 0;
	        for (int i = 0; i < jsonArray.length(); i++)
	        {
	            JSONObject vehiculoJson = (JSONObject) jsonArray.get(i);

	            String categoriaStr = vehiculoJson.getString("categoria");
	            CategoriaVehiculo categoria = CategoriaVehiculo.valueOf(categoriaStr.toUpperCase());

	            String tipoStr = vehiculoJson.getString("tipo");
	            TiposVehiculos tipoVehiculos = TiposVehiculos.getTipoPorNombre(tipoStr);

	            Vehiculo vehiculo = null;

	            switch (categoria) {
	                case TURISMO:
	                    vehiculo = new Turismo(
	                        vehiculoJson.getInt("id"),
	                        tipoVehiculos,
	                        vehiculoJson.getString("modelo"),
	                        LocalDate.parse(vehiculoJson.getString("fechaMatriculacion"))
	                    );
	                    break;
	                case FURGONETA:
	                    vehiculo = new Furgoneta(
	                        vehiculoJson.getInt("id"),
	                        tipoVehiculos,
	                        vehiculoJson.getString("modelo"),
	                        LocalDate.parse(vehiculoJson.getString("fechaMatriculacion"))
	                    );
	                    break;
	                case MOTOCICLETA:
	                    vehiculo = new Motocicleta(
	                        vehiculoJson.getInt("id"),
	                        tipoVehiculos,
	                        vehiculoJson.getString("modelo"),
	                        LocalDate.parse(vehiculoJson.getString("fechaMatriculacion"))
	                    );
	                    break;
	            }

	            listaVehiculos.add(vehiculo);

	            if (vehiculo.getIdVehiculo() > maxId) {
	                maxId = vehiculo.getIdVehiculo();
	            }
	            contadorId = maxId;
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}  
}