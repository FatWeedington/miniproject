package btx.prog.one.miniproject.hospital.domain;

import org.w3c.dom.events.EventException;

import java.util.HashSet;
import java.util.Set;

public class Bed {
    public static Set<Bed> beds = new HashSet<Bed>();

    public static Bed ONE = new Bed(1);
    public static Bed TWO = new Bed(2);
    public static Bed THREE = new Bed(3);
    public static Bed Four = new Bed(4);
    public static Bed Five = new Bed(5);

    private Patient patient;
    private long number;

    public Bed(long number){
        for (Bed bed: beds){
            if (number == bed.number){
                throw new EventException((short)3,"Bed already existing");
            }
        }
        this.number = number;
        beds.add(this);
    }

    public long getNumber() {
        return number;
    }

    public Patient getPatient(){return this.patient;}

    public void setPatient(Patient patient) {
        if (this.patient == null)
        this.patient = patient;
        else {throw new EventException((short)3,"Bed already taken");}
    }

    public void removepatient(){
        this.patient = null;
    }

}
