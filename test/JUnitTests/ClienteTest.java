package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import GestionClientes.Cliente;

/**
 * Pruebas unitarias para la clase Cliente.
 */
class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("Juan", "Pérez", "12345678A", "Calle Falsa 123", "123456789", "juan@example.com");
    }

    @Test
    public void testCrearCliente() {
        assertEquals("Juan", cliente.getNombre());
        assertEquals("Pérez", cliente.getApellidos());
        assertEquals("12345678A", cliente.getDni());
        assertEquals("Calle Falsa 123", cliente.getDireccion());
        assertEquals("123456789", cliente.getTelefono());
        assertEquals("juan@example.com", cliente.getEmail());
    }

    @Test
    public void testInsertarCliente() {
        Cliente.Insertar(cliente);
        assertTrue(Cliente.getListaClientes().contains(cliente));
    }

    @Test
    public void testLeerCliente() {
        Cliente.Insertar(cliente);
        Cliente encontrado = Cliente.Leer(cliente.getIdCliente());
        assertNotNull(encontrado);
        assertEquals(cliente.getNombre(), encontrado.getNombre());
    }

    @Test
    public void testModificarCliente() {
        Cliente.Insertar(cliente);
        cliente.setNombre("Carlos");
        Cliente.Modificar(cliente);
        Cliente modificado = Cliente.Leer(cliente.getIdCliente());
        assertEquals("Carlos", modificado.getNombre());
    }

    @Test
    public void testEliminarCliente() {
        Cliente.Insertar(cliente);
        Cliente.Eliminar(cliente.getIdCliente());
        assertNull(Cliente.Leer(cliente.getIdCliente()));
    }
}