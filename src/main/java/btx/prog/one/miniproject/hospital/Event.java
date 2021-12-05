package btx.prog.one.miniproject.hospital;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public abstract class Event {

    private String timestamp;
    private String description;

    public Event(String description){
        this.description = description;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return ""+timestamp;
    }
}
