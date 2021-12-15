package btx.prog.one.miniproject.hospital.service;

import btx.prog.one.miniproject.hospital.domain.*;
import btx.prog.one.miniproject.hospital.repo.BaseEntity;
import btx.prog.one.miniproject.hospital.repo.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class Dispomanager {

    public void registerPatient(String surname, String lastname,String description){
        Patient p = new Patient(surname,lastname);
        p.addEvent(new Entry(description));
        p.setStatus(Patient.Status.NEW);
        PatientRepository.INMEMORYREPO.add(p);
    }

    public void setBed(Patient patient,Bed bed){
        patient.setBed(bed);
        patient.getBed().setPatient(patient);
        PatientRepository.INMEMORYREPO.update(patient);
    }

    public void leavebedBed(Patient patient){
        patient.getBed().setPatient(null);
        patient.setBed(null);
        PatientRepository.INMEMORYREPO.update(patient);
        }

    public void setStation(Patient patient, Station station) {
        patient.setStation(station);
        station.addPatient(patient);
        patient.setStatus(Patient.Status.ASSIGNED);
        PatientRepository.INMEMORYREPO.update(patient);
    }

    public void discharge(Patient patient,String description){
        patient.addEvent(new Discharge(description));
        patient.setStation(null);
        patient.setBed(null);
        patient.setStatus(Patient.Status.DISCHARGED);
        PatientRepository.INMEMORYREPO.update(patient);
    }

    public SortedMap searchAll(){
        return PatientRepository.INMEMORYREPO.findAll();
    }

    public BaseEntity searchForPatient(long id){
        return PatientRepository.INMEMORYREPO.findById(id);
    }
    }


