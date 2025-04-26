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
	protected Alquiler (int idAlquiler, Cliente cliente, Vehiculo vehiculo, Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, double costeTotal, boolean estado)
	{
		
		if (!vehiculo.mantenimientoAlDia())
		{
			throw new IllegalArgumentException ("El vehículo no tiene el mantenimiento al día y no puede ser alquilado.");
		}
		
		this.idAlquiler = idAlquiler;
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.empleado = empleado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costeTotal = costeTotal;
		this.estadoAlquiler = estado;
		
	}	
	
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
	public int getIdAlquiler()
	{
		return idAlquiler;
	}
	
	public LocalDate getFechaInicio()
	{
		return fechaInicio;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}
	
	public Empleado getEmpleado()
	{
		return empleado;
	}

	public LocalDate getFechaFin()
	{
		return fechaFin;
	}

	public double getCosteTotal()
	{
		return costeTotal;
	}

	public boolean isEstadoAlquiler()
	{
		return estadoAlquiler;
	}
	public static ArrayList<Alquiler> getListaAlquileres()
	{
		return listaAlquileres;
	}
	public Vehiculo getVehiculo()
	{
		return vehiculo;
	}

	//Setters
	public void setFechaInicio(LocalDate fechaInicio)
	{
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(LocalDate fechaFin)
	{
		this.fechaFin = fechaFin;
		calcularCosteTotal();
	}

	public void setCosteTotal(double costeTotal)
	{
		this.costeTotal = costeTotal;
	}

	public void setEstadoAlquiler(boolean estadoAlquiler)
	{
		this.estadoAlquiler = estadoAlquiler;
	}
	
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	public void setVehiculo(Vehiculo vehiculo)
	{
		this.vehiculo = vehiculo;
	}

	//Métodos
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
    
	private void calcularCosteTotal()
	{
		long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
		
		if (dias <= 0) dias = 1;
		
		this.costeTotal = dias * vehiculo.getPrecioDia();
	}
	
	public void actualizarEstadoAlquiler() {
		LocalDate hoy = LocalDate.now();
		
		if (hoy.isAfter(fechaInicio.minusDays(1)) && hoy.isBefore(fechaFin.plusDays(1))) {
			estadoAlquiler = true; //Alquiler activo
		} else {
			estadoAlquiler = false; //Alquiler inactivo
		}
	}
	
    public void finalizarAlquiler() {
    	this.estadoAlquiler = false; //Forzamos finalizar alquiler
    	this.fechaFin = LocalDate.now();
    }
	
    //CRUD
    
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
