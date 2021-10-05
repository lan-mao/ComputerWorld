package pojo;

import java.io.Serializable;

/**
 * Create Date 2020/09/20 11:27:37
 * Created by lan-mao.top
 */

public class FormPOJO implements Serializable {
    private String username;
    private String password;
    //private FormPOJO partner;
    //
    //public FormPOJO getPartner() {
    //    return partner;
    //}
    //
    //public void setPartner(FormPOJO partner) {
    //    this.partner = partner;
    //}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FormPOJO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public FormPOJO() {
    }

    @Override
    public String toString() {
        return "FormPOJO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}