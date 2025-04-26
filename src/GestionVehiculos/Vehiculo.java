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
    protected Vehiculo(int idVehiculo, CategoriaVehiculo categoria, TiposVehiculos tipoVehiculos, String modelo, LocalDate fechaMatriculacion, double precioDia)
    {
        this.idVehiculo = idVehiculo;
        this.categoria = categoria;
        this.tipoVehiculos = tipoVehiculos;   
        this.modelo = modelo;
        this.fechaMatriculacion = fechaMatriculacion;
        this.mantenimiento = new Mantenimiento (this);
    }
    
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
	public int getIdVehiculo()
	{
		return idVehiculo;
	}
	public CategoriaVehiculo getCategoria()
	{
		return categoria;
	}
	public String getModelo()
	{
		return modelo;
	}
    public double getPrecioDia()
    {
        return tipoVehiculos.getPrecioDia();
    }
    public static ArrayList<Vehiculo> getListaVehiculos()
    {
    	return listaVehiculos;
    }
	public LocalDate getFechaMatriculacion()
	{
		return fechaMatriculacion;
	}
	public Mantenimiento getMantenimiento()
	{
		return mantenimiento;
	}
	public LocalDate getFechaUltimoMantenimiento()
	{
		LocalDate fecha = null;
        if (mantenimiento != null) {
            fecha = mantenimiento.getFechaMantenimiento();
        }        
        return fecha;
    }
	public TiposVehiculos getTipoVehiculos()
	{
		return tipoVehiculos;
	}

	//Setters
	public void setIdVehiculo(int idVehiculo)
	{
		this.idVehiculo = idVehiculo;
	}
	public void setCategoria(CategoriaVehiculo categoria)
	{
		this.categoria = categoria;
	}
	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}
	public void setFechaMatriculacion(LocalDate fechaMatriculacion)
	{
		this.fechaMatriculacion = fechaMatriculacion;
	}
	public void setFechaMantenimiento(LocalDate fechaMantenimiento)
	{
		this.mantenimiento.setFechaMantenimiento(fechaMantenimiento);
	}
	public void setTipoVehiculos(TiposVehiculos tipoVehiculos)
	{
		this.tipoVehiculos = tipoVehiculos;
	}

	//Metodos
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
    
    public boolean mantenimientoAlDia() {
    	return mantenimiento.comprobarEstadoMantenimiento();
    }
    
    public void actualizarMantenimiento() {
        if (this.mantenimiento != null) {
            this.mantenimiento.actualizarMantenimiento(this);
        }
    }
    
    
    //CRUD
    
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