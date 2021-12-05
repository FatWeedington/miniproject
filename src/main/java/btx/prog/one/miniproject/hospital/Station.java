package btx.prog.one.miniproject.hospital;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Station {
    public static final Station NEUROLOGY = new Station("Neurologie");
    public static final Station ONCOLOGY = new Station("Onkologie");
    public static final Station EMERGENCY = new Station("Notfall");
    public static final Station RADIOLOGY = new Station("Radiologie");

    private String name;
    private Set<Patient> patients = new HashSet<>() {
    };

    public Station(String name){
        this.name = name;
    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public void removePatient(Patient patient){
        patients.remove(patient);
    }

    public String getName() {
        return name;
    }
}
