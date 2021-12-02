package btx.prog.one.miniproject;

import btx.prog.one.miniproject.hospital.Patient;
import org.junit.jupiter.api.Test;
import org.w3c.dom.events.EventException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PatientTest {

    private Patient test = new Patient("Aron", "Binggeli");

    @Test
    public void PatientTest() {
        assertEquals("Aron", test.getSurname());
        assertEquals("Binggeli", test.getLastname());
    }

    @Test
    public void dischargeTest() {
        assertEquals("Entry", test.getLastEvent());
        test.discharge();
        assertThrows(EventException.class, () -> test.discharge());
    }

    @Test
    public void ReEntryTest(){
        test.discharge();
        assertEquals("Discharge",test.getLastEvent());
        test.reEntry();
        assertEquals("Entry",test.getLastEvent());
}
}

