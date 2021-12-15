package btx.prog.one.miniproject.hospital.service;

import btx.prog.one.miniproject.hospital.domain.*;
import btx.prog.one.miniproject.hospital.repo.PatientRepository;

import java.util.ArrayList;
import java.util.List;

public class Dispomanager {

    public void registerPatient(String surname, String lastname,String description){
        Patient p = new Patient(surname,lastname);
        p.addEvent(new Entry(description));
        PatientRepository.add(p);
    }

    public void setBed(Patient patient,Bed bed){
            patient.setBed(bed);
        patient.getBed().setPatient(patient);
    }

    public void leavebedBed(Patient patient){
            patient.getBed().setPatient(null);
            patient.setBed(null);
        }

    public void setStation(Patient patient, Station station) {
            patient.setStation(station);
            station.addPatient(patient);
    }

    public void discharge(Patient patient,String description){
            patient.addEvent(new Discharge(description));
            patient.setStation(null);
            patient.setBed(null);
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
    }


