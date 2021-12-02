package btx.prog.one.miniproject.hospital;

public class Bed {

    public static int bedcount = 0;
    private Patient patient;
    private int number;


    public Bed(int number){
        this.number = number;
        Bed.bedcount ++;
    }

    public int getNumber() {
        return number;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
