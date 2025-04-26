package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GestionVehiculos.Turismo;
import GestionVehiculos.Furgoneta;
import GestionVehiculos.Motocicleta;
import GestionVehiculos.TiposVehiculos;
import GestionMantenimientos.Mantenimiento;

/**
 * Pruebas unitarias para la clase Mantenimiento.
 */
class MantenimientoTest {

    private Turismo turismo;
    private Motocicleta moto;
    private Furgoneta furgoneta;

    @BeforeEach
    public void setUp() throws Exception {
        turismo = new Turismo(TiposVehiculos.Pequeño, "Seat Ibiza", LocalDate.now().minusYears(3));
        moto = new Motocicleta(TiposVehiculos.Motocicleta, "Yamaha MT-07", LocalDate.now().minusYears(5));
        furgoneta = new Furgoneta(TiposVehiculos.Estandar, "Renault Kangoo", LocalDate.now().minusYears(1));
    }

    @Test
    public void testCrearMantenimiento() {
        Mantenimiento m = new Mantenimiento(turismo);
        // La fecha de próximo mantenimiento debe ser futura
        assertNotNull(m.getFechaMantenimiento());
        assertTrue(m.getFechaMantenimiento().isAfter(LocalDate.now()));
    }

    @Test
    public void testComprobarEstadoMantenimiento() {
        Mantenimiento m = new Mantenimiento(turismo);
        // Forzar fecha pasada
        m.setFechaMantenimiento(LocalDate.now().minusDays(1));
        assertFalse(m.comprobarEstadoMantenimiento());
    }

    @Test
    public void testAlertaMantenimiento() {
        Mantenimiento m = new Mantenimiento(turismo);
        // Vencido
        m.setFechaMantenimiento(LocalDate.now().minusDays(1));
        assertEquals("Vencido", m.alertaMantenimiento());
        // Próximo (<1 mes)
        m.setFechaMantenimiento(LocalDate.now().plusDays(15));
        assertEquals("Próximo", m.alertaMantenimiento());
        // En plazo (>1 mes)
        m.setFechaMantenimiento(LocalDate.now().plusMonths(2));
        assertEquals("En plazo", m.alertaMantenimiento());
    }

    @Test
    public void testCalcularProximoMantenimiento() throws Exception {
        // 1) Turismo (<4 años) → +24 meses
        LocalDate proxTur = turismo.getMantenimiento().getFechaMantenimiento();
        assertEquals(LocalDate.now().plusMonths(24), proxTur);

        // 2) Motocicleta (>=4 años) → +12 meses
        LocalDate proxMoto = moto.getMantenimiento().getFechaMantenimiento();
        assertEquals(LocalDate.now().plusMonths(12), proxMoto);

        // 3) Furgoneta (<2 años) → +12 meses
        LocalDate proxFur = furgoneta.getMantenimiento().getFechaMantenimiento();
        assertEquals(LocalDate.now().plusMonths(12), proxFur);
    }

    @Test
    public void testActualizarMantenimiento() {
        Mantenimiento m = new Mantenimiento(furgoneta);
        // Forzar vencido
        m.setFechaMantenimiento(LocalDate.now().minusDays(1));
        // Actualizar según lógica
        m.actualizarMantenimiento(furgoneta);
        assertTrue(m.comprobarEstadoMantenimiento());
        assertEquals(LocalDate.now().plusMonths(12), m.getFechaMantenimiento());
    }
}
