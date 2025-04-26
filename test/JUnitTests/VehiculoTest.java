package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GestionVehiculos.CategoriaVehiculo;
import GestionVehiculos.Furgoneta;
import GestionVehiculos.Motocicleta;
import GestionVehiculos.TiposVehiculos;
import GestionVehiculos.Turismo;
import GestionVehiculos.Vehiculo;

/**
 * Pruebas unitarias para la clase Vehiculo.
 */
class VehiculoTest {

    private Vehiculo turismo;
    private Vehiculo furgoneta;
    private Vehiculo moto;

    @BeforeEach
    public void setUp() {
        Vehiculo.getListaVehiculos().clear();
    }

    @Test
    public void testCrearVehiculo() throws Exception {
        turismo = new Turismo(TiposVehiculos.Pequeño, "Seat Ibiza", LocalDate.of(2015, 6, 10));
        furgoneta = new Furgoneta(TiposVehiculos.Estandar, "Renault Kangoo", LocalDate.of(2012, 3, 15));
        moto = new Motocicleta(TiposVehiculos.Motocicleta, "Yamaha MT-07", LocalDate.of(2020, 7, 22));

        Vehiculo.Insertar(turismo);
        Vehiculo.Insertar(furgoneta);
        Vehiculo.Insertar(moto);

        assertTrue(Vehiculo.getListaVehiculos().contains(turismo));
        assertTrue(Vehiculo.getListaVehiculos().contains(furgoneta));
        assertTrue(Vehiculo.getListaVehiculos().contains(moto));
    }

    @Test
    public void testLeerVehiculo() throws Exception {
        furgoneta = new Furgoneta(TiposVehiculos.Estandar, "Renault Kangoo", LocalDate.of(2012, 3, 15));
        Vehiculo.Insertar(furgoneta);

        Vehiculo leido = Vehiculo.Leer(furgoneta.getIdVehiculo());
        assertEquals(furgoneta.getIdVehiculo(), leido.getIdVehiculo());
        assertEquals("Renault Kangoo", leido.getModelo());
        assertEquals(CategoriaVehiculo.FURGONETA, leido.getCategoria());
    }

    @Test
    public void testModificarVehiculo() throws Exception {
        moto = new Motocicleta(TiposVehiculos.Motocicleta, "Yamaha MT-07", LocalDate.of(2020, 7, 22));
        Vehiculo.Insertar(moto);

        moto.setModelo("Yamaha R3");
        LocalDate nuevaFecha = LocalDate.of(2021, 8, 1);
        moto.setFechaMatriculacion(nuevaFecha);
        Vehiculo.Modificar(moto);

        Vehiculo modificado = Vehiculo.Leer(moto.getIdVehiculo());
        assertEquals("Yamaha R3", modificado.getModelo());
        assertEquals(nuevaFecha, modificado.getFechaMatriculacion());
    }

    @Test
    public void testEliminarVehiculo() throws Exception {
        turismo = new Turismo(TiposVehiculos.Lujo, "BMW Serie 5", LocalDate.of(2018, 11, 5));
        Vehiculo.Insertar(turismo);

        Vehiculo.Eliminar(turismo.getIdVehiculo());
        assertNull(Vehiculo.Leer(turismo.getIdVehiculo()));
    }

    @Test
    public void testModificarPrecioTipoVehiculo() {
        double precioOriginal = TiposVehiculos.GranCarga.getPrecioDia();
        TiposVehiculos.GranCarga.setPrecioDia(120);
        assertEquals(120, TiposVehiculos.GranCarga.getPrecioDia());

        TiposVehiculos.GranCarga.setPrecioDia(precioOriginal);
    }
}