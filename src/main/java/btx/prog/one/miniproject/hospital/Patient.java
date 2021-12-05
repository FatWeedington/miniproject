package btx.prog.one.miniproject.hospital;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String surname;
    private String lastname;
    private List<Event> event = new ArrayList<>();
    private Station station;
    private Bed bed;

    public Patient(String surname,String lastname){
        this.surname = surname;
        this.lastname = lastname;
        this.event.add(new Entry());
    }

    public void setBed(Bed bed){
        if (this.bed == null)
        this.bed = bed;
        this.bed.setPatient(this);
    }

    public void changeBed(Bed bed){
        if (!(this.bed == bed)) {
            this.bed.removepatient();
            this.bed = bed;
            this.bed.setPatient(this);
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public Event getLastEvent() {
        return this.event.get(event.size() -1);
    }

    public Bed getBed() {
        return bed;
    }

    public void setStation(Station station) {
        if (this.station == null) {
            this.station = station;
            this.station.addPatient(this);
        }
    }

    public void changeStation(Station station){
        if (!(this.station == station)) {
        this.station.removePatient(this);
        this.station = station;
        this.station.addPatient(this);
        }
    }

    public void leaveStation(){
        if (!(this.station == null))
        this.station.removePatient(this);
        this.station = null;
    }

    public Station getStation() {
        return this.station;
    }

    public void leavebedBed(){
        if (!(this.bed == null))
        this.bed.removepatient();
        this.bed = null;
    }

    public void discharge(){
        if (this.getLastEvent() instanceof Entry)
        this.event.add(new Discharge());
        this.leaveStation();
        this.leavebedBed();
    }

    public void reEntry(){
        if ((this.getLastEvent() instanceof Discharge)){
            this.event.add(new Entry());}
    }

    @Override
    public String toString() {
        String output = "Surname: " + this.surname + ", " + "Lastname: " +
                this.lastname + ", " + "Status: ";

        if ((this.getLastEvent() instanceof Entry)){
            output += "in treatment, ";

        output += "Last Status Change: "+ this.getLastEvent()+", Station: ";


        if (this.station == null){
            output += "not currently assigned, ";
        }
        else{output += this.getStation().getName() + ", ";}

        output += "Bed Number: ";

        if (this.bed == null){
            output += "ambulant";
        }
        else{output += this.getBed().getNumber();}

        }
        else {output += "discharged, " +
                "Last Status Change: "+ this.getLastEvent();
        }

        return output;

    }

}
