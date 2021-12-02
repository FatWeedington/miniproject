package btx.prog.one.miniproject.hospital;

import java.time.LocalDate;


public abstract class Event {

    private LocalDate timestamp;

    public Event(){
        this.timestamp = LocalDate.now();
    }

    @Override
    public String toString() {
        return "'Type: " + this.getClass().getSimpleName()+
                ", Timestamp: " + timestamp+"'";
    }
}
