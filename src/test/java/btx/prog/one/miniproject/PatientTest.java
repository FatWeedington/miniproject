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


}

