package piatr.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by piatr on 27.03.17.
 */
public class Message {
    private String message;
    private String nick;
    private String formattedDate;
    public Message(String message, String nick) {
        this.message = message;
        this.nick = nick;
        this.formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }


    public String getFormattedDate() {
        return formattedDate;
    }

    public String getMessage() {
        return message;
    }



    public String getNick() {
        return nick;
    }


}
