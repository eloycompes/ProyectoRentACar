package JUnitTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import GestionEmpleados.Administrador;
import GestionEmpleados.Empleado;
import GestionEmpleados.Usuario;

/**
 * Pruebas unitarias para la clase Empleado.
 */
class EmpleadoTest {

    private Empleado empleado1;
    private Empleado empleado2;

    @Before
    public void setUp() {
        empleado1 = new Usuario("Juan", "Pérez", "12345678A", "123456789", "juan@correo.com");
        empleado2 = new Administrador("Ana", "Gómez", "87654321B", "987654321", "ana@correo.com");
    }
    
    @Test
    public void testCrearEmpleado() {
        assertEquals("Juan", empleado1.getNombre());
        assertEquals("Pérez", empleado1.getApellidos());
        assertEquals("12345678A", empleado1.getDni());
        assertEquals("123456789", empleado1.getTelefono());
        assertEquals("juan@correo.com", empleado1.getEmail());

        assertEquals("Ana", empleado2.getNombre());
        assertEquals("Gómez", empleado2.getApellidos());
        assertEquals("87654321B", empleado2.getDni());
        assertEquals("987654321", empleado2.getTelefono());
        assertEquals("ana@correo.com", empleado2.getEmail());
    }

    @Test
    public void testInsertar() {
        Empleado.Insertar(empleado1);
        assertTrue(Empleado.getListaEmpleado().contains(empleado1));
    }

    @Test
    public void testLeer() {
        Empleado.Insertar(empleado2);
        Empleado empleadoLeido = Empleado.Leer(empleado2.getIdEmpleado());
        assertEquals(empleado2.getIdEmpleado(), empleadoLeido.getIdEmpleado());
        assertEquals(empleado2.getNombre(), empleadoLeido.getNombre());
    }

    @Test
    public void testModificar() {
        Empleado.Insertar(empleado1);
        empleado1.setNombre("Juan Carlos");
        Empleado.Modificar(empleado1);
        Empleado empleadoModificado = Empleado.Leer(empleado1.getIdEmpleado());
        assertEquals("Juan Carlos", empleadoModificado.getNombre());
    }

    @Test
    public void testEliminar() {
        Empleado.Insertar(empleado1);
        Empleado.Eliminar(empleado1.getIdEmpleado());
        Empleado empleadoEliminado = Empleado.Leer(empleado1.getIdEmpleado());
        assertNull(empleadoEliminado);
    }
}