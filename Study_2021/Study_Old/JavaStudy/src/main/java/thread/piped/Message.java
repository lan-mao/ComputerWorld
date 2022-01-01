package thread.piped;

import java.io.Serializable;

/**
 * Create Date 2020/11/03 19:07:46 <br>
 * Created by lan-mao.top <br>
 * <br>
 */

public class Message implements Serializable {

    private static final long serialVersionUID = -7123201060857219486L;
    public int number, id;

    public Message(int number, int id) {
        this.number = number;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Zhao_Message [number=" + number + ", id=" + id + "]";
    }
}
