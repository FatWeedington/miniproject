package btx.prog.one.miniproject.hospital.repo;

import btx.prog.one.miniproject.hospital.domain.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    public static List<Patient> REPO = new ArrayList<>();

    public static void add(Patient patient){
        REPO.add(patient);
    }

}
