package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GestionAlquileres.Alquiler;
import GestionClientes.Cliente;
import GestionEmpleados.Usuario;
import GestionVehiculos.Turismo;
import GestionVehiculos.Furgoneta;
import GestionVehiculos.Motocicleta;
import GestionVehiculos.TiposVehiculos;

/**
 * Pruebas unitarias para la clase Alquiler.
 */
class AlquilerTest {

    private Cliente cliente;
    private Usuario empleado;
    private Turismo turismo;
    private Furgoneta furgoneta;
    private Motocicleta moto;

    @BeforeEach
    public void setUp() throws Exception {
        Alquiler.getListaAlquileres().clear();
        cliente = new Cliente("Juan", "Pérez", "12345678A", "Calle Falsa 123", "600123456", "juan@correo.com");
        empleado = new Usuario("Ana", "Gómez", "87654321B", "987654321", "ana@empresa.com");
        turismo = new Turismo(TiposVehiculos.Pequeño, "Seat Ibiza", LocalDate.of(2020, 1, 1));
        furgoneta = new Furgoneta(TiposVehiculos.Estandar, "Renault Kangoo", LocalDate.of(2019, 5, 10));
        moto = new Motocicleta(TiposVehiculos.Motocicleta, "Yamaha MT-07", LocalDate.of(2021, 3, 20));
    }

    @Test
    public void testCrearAlquiler() {
        Alquiler alq = new Alquiler(cliente, turismo, empleado, LocalDate.of(2022, 6, 1), LocalDate.of(2022, 6, 5));
        Alquiler.Insertar(alq);
        assertTrue(Alquiler.getListaAlquileres().contains(alq));
    }

    @Test
    public void testLeerAlquiler() {
        Alquiler alq = new Alquiler(cliente, furgoneta, empleado, LocalDate.now(), LocalDate.now().plusDays(2));
        Alquiler.Insertar(alq);

        Alquiler leido = Alquiler.Leer(alq.getIdAlquiler());
        assertNotNull(leido);
        assertEquals(alq.getIdAlquiler(), leido.getIdAlquiler());
        assertEquals(cliente.getDni(), leido.getCliente().getDni());
        assertEquals(furgoneta.getModelo(), leido.getVehiculo().getModelo());
        assertEquals(empleado.getDni(), leido.getEmpleado().getDni());
    }

    @Test
    public void testModificarAlquiler() {
        Alquiler alq = new Alquiler(cliente, moto, empleado, LocalDate.of(2022, 1, 10), LocalDate.of(2022, 1, 12));
        Alquiler.Insertar(alq);

        LocalDate nuevaFin = LocalDate.of(2022, 1, 15);
        alq.setFechaFin(nuevaFin);
        Alquiler.Modificar(alq);

        Alquiler mod = Alquiler.Leer(alq.getIdAlquiler());
        assertEquals(nuevaFin, mod.getFechaFin());
        assertFalse(mod.isEstadoAlquiler());
    }

    @Test
    public void testEliminarAlquiler() {
        Alquiler alq = new Alquiler(cliente, turismo, empleado, LocalDate.now(), LocalDate.now().plusDays(1));
        Alquiler.Insertar(alq);

        int id = alq.getIdAlquiler();
        Alquiler.Eliminar(id);
        assertNull(Alquiler.Leer(id));
    }

    @Test
    public void testFinalizarAlquiler() {
        Alquiler alq = new Alquiler(cliente, furgoneta, empleado, LocalDate.now().minusDays(2), LocalDate.now().plusDays(2));
        Alquiler.Insertar(alq);
        assertTrue(alq.isEstadoAlquiler());

        alq.finalizarAlquiler();
        assertFalse(alq.isEstadoAlquiler());
        assertEquals(LocalDate.now(), alq.getFechaFin());
    }
}
