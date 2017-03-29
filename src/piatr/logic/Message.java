package piatr.logic;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by piatr on 27.03.17.
 */
public class Message {
    private String message;
    private String nick;
    private LocalDateTime date;

    public Message(String message, String nick) {
        this.message = message;
        this.nick = nick;
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
