package btx.prog.one.miniproject.hospital;

import org.w3c.dom.events.EventException;

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
        this.bed = bed;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastEvent() {
        return this.event.get(event.size() -1 ).getClass().getSimpleName();
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Bed getBed() {
        return bed;
    }

    public void dischargeBed(){
        this.bed.setPatient(null);
        this.bed = null;
    }

    public void discharge(){
        if (this.event.get(event.size() -1).getClass().getSimpleName().equals("Entry"))
        this.event.add(new Discharge());
        else throw new EventException((short) 1,"Patient is already discharged");
    }

    public void reEntry(){
        if (this.event.get(event.size() -1).getClass().getSimpleName().equals("Discharge"))
            this.event.add(new Entry());
        else throw new EventException((short) 1,"Patient is already in Treatment");
    }

    @Override
    public String toString() {
        return                "surname='" + surname + '\'' +
                ", lastname= '" + lastname + '\'' +
                ", event= " + event.get(event.size()-1) +
                ", station=" + station +
                ", bed=" + bed;
    }

}
