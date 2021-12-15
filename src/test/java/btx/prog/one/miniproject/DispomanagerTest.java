package btx.prog.one.miniproject;

import btx.prog.one.miniproject.hospital.repo.PatientRepository;
import btx.prog.one.miniproject.hospital.service.Dispomanager;
import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLEngineResult;

public class DispomanagerTest {
        Dispomanager dispomanager = new Dispomanager();
    @Test
    public void registerPatientTest(){
        dispomanager.registerPatient("Hans","Hobler","ello he there");
        dispomanager.registerPatient("Quentin","Muster","ello he there");
        dispomanager.registerPatient("Qrt","Allemann","ello he there");
        dispomanager.registerPatient("Thomael","Hobler","ello he there");
    }


    public static void main(String[] args) {
        Dispomanager dispomanager = new Dispomanager();
        System.out.println(PatientRepository.INMEMORYREPO.findAll());
        dispomanager.registerPatient("Hans","Hobler","ello he there");
        dispomanager.registerPatient("Quentin","Muster","ello he there");
        dispomanager.registerPatient("Qrt","Allemann","ello he there");
        dispomanager.registerPatient("Thomael","Hobler","ello he there");
        System.out.println(PatientRepository.INMEMORYREPO.findById(3));
    }
}
