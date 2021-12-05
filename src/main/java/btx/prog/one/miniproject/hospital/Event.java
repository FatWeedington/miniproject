package btx.prog.one.miniproject.hospital;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public abstract class Event {

    private String  timestamp;

    public Event(){
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
    }

    @Override
    public String toString() {
        return ""+timestamp;
    }
}
