package btx.prog.one.miniproject.hospital.domain;

import btx.prog.one.miniproject.hospital.repo.BaseEntity;
import org.w3c.dom.events.EventException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient extends BaseEntity {

    public enum Status {NEW, ASSIGNED, DISCHARGED}

    private String surname;
    private String lastname;
    private List<Event> event = new ArrayList<>();
    private Station station;
    private Bed bed;
    private Status status;

    public Patient(String surname,String lastname){
        this.surname = surname;
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setBed(Bed bed){
        this.bed = bed;
    }

    public Bed getBed() {
        return bed;
    }

    public void addEvent(Event event){
        this.event.add(event);
    }

    public Event getLastEvent() {
        return this.event.get(event.size() -1);
    }

    public void setStation(Station station) {
            this.station = station;
        }

    public Station getStation() {
        return this.station;
    }

    public Status getStatus() {return status;}

    public void setStatus(Status status) {this.status = status;}

    @Override
    public String toString() {
        String output = "Surname: " + this.surname + ", " + "Lastname: " +
                this.lastname + ", " + "Status: ";

        if ((this.getLastEvent() instanceof Entry)){
            output += "in treatment, " + "reason: " + this.getLastEvent().getDescription() +", ";

        output += "Last Status Change: "+ this.getLastEvent()+", Station: ";

        if (this.station == null){
            output += "not currently assigned, ";
        }
        else{output += this.getStation().getName() + ", ";}


        if (this.bed == null){
            output += "Ambulant";
        }

        else{output += "Bed Number: "+this.getBed().getNumber();}

        }
        else {output += "discharged, " +"reason: " + this.getLastEvent().getDescription() +", "+
                "Last Status Change: "+ this.getLastEvent();
        }

        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getSurname(), patient.getSurname()) && Objects.equals(getLastname(), patient.getLastname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getLastname());
    }
}
