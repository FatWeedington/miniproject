package btx.prog.one.miniproject.hospital.service;

import btx.prog.one.miniproject.hospital.domain.Bed;
import btx.prog.one.miniproject.hospital.domain.Patient;
import btx.prog.one.miniproject.hospital.repo.PatientRepository;

import java.util.ArrayList;
import java.util.List;

public class Dispomanager {

    public void registerPatient(String surname, String lastname){
        Patient p = new Patient(surname,lastname);
        PatientRepository.add(p);
    }

    public List searchAll(){
        return PatientRepository.REPO;
    }

    public List searchForPatient(String search){
        List<Patient> results = new ArrayList<>();
        for (Patient patient:PatientRepository.REPO){
            if (patient.getSurname().contains(search) || patient.getLastname().contains(search))
            results.add(patient);
        }
        return results;
    }

    public void setBed(Patient patient, Bed bed){
        patient.setBed(bed);
    }

    public void leaveBed(Patient patient){
        patient.leavebedBed();
    }

    public void changebed(Patient patient, Bed bed){
        patient.changeBed(bed);
    }

    public void discharge(Patient patient, String description){
        patient.discharge("description");
    }


}
