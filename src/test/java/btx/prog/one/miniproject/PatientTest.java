package btx.prog.one.miniproject;

import btx.prog.one.miniproject.hospital.domain.*;
import org.junit.jupiter.api.Test;
import org.w3c.dom.events.EventException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PatientTest {

    private Patient test = new Patient("Aron", "Binggeli");
    private Patient muster = new Patient("Max","Mustermann");

    @Test
    public void PatientTest() {
        assertEquals(test, new Patient("Aron","Binggeli"));
    }

    @Test
    public void getSurnameTest(){
        assertEquals("Aron",test.getSurname());
        assertEquals("Max",muster.getSurname());
    }

    @Test
    public void getLastnameTest(){
        assertEquals("Binggeli",test.getLastname());
        assertEquals("Mustermann",muster.getLastname());
    }

    @Test
    public void setBedTest(){
        test.setBed(Bed.ONE);
        assertEquals(Bed.ONE,test.getBed());
        assertThrows(EventException.class,()->test.setBed(Bed.ONE));
    }

    @Test
    public void changeBedTest(){
        test.setBed(Bed.ONE);
        assertEquals(Bed.ONE,test.getBed());
        assertThrows(EventException.class,()->muster.changeBed(Bed.ONE));
        test.changeBed(Bed.TWO);
        assertEquals(Bed.TWO,test.getBed());
    }

    @Test
    public void leaveBedTest(){
        test.setBed(Bed.ONE);
        test.leavebedBed();
        assertEquals(null,test.getBed());
    }

    @Test
    public void getBed(){
        assertEquals(null,test.getBed());
        test.setBed(Bed.ONE);
        assertEquals(Bed.ONE,test.getBed());
    }

    @Test
    public void getLastEventTest(){
        assertEquals(new Entry("hallo").getClass(),test.getLastEvent().getClass());
        test.discharge("tschüss");
        assertEquals(new Discharge("ade").getClass(),test.getLastEvent().getClass());
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

