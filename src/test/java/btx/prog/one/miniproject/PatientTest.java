package btx.prog.one.miniproject;

import btx.prog.one.miniproject.hospital.*;
import org.junit.jupiter.api.Test;
import org.w3c.dom.events.EventException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PatientTest {

    private Patient test = new Patient("Aron", "Binggeli");
    private Patient muster = new Patient("Max","Mustermann");

    @Test
    public void PatientTest() {
        assertEquals("Aron", test.getSurname());
        assertEquals("Binggeli", test.getLastname());
    }

    @Test
    public void dischargeTest() {
        assertEquals(Entry.class, test.getLastEvent().getClass());
        test.discharge("patient Left");
        assertThrows(EventException.class, () -> test.discharge(""));
    }

    @Test
    public void ReEntryTest(){
        test.discharge("patient Left");
        assertEquals(Discharge.class,test.getLastEvent().getClass());
        test.reEntry("patient came again");
        assertEquals(Entry.class,test.getLastEvent().getClass());
}

    public static void main(String[] args) {
        Patient test = new Patient("Aron", "Binggeli");
        test.leaveStation();
        System.out.println(test);
        test.setBed(Bed.ONE);
        System.out.println(test);
        test.leavebedBed();
        System.out.println(test);
        test.setStation(Station.EMERGENCY);
        System.out.println(test);
        test.discharge("succesfully treated");
        System.out.println(test);
    }
}

