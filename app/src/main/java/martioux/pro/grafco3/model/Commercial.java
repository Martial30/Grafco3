package martioux.pro.grafco3.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Commercial {


    @PrimaryKey
    Integer comid;

    @ColumnInfo(name = "login")
    String login;

    @ColumnInfo(name = "motdepasse")
    String  motdepasse;

    @ColumnInfo(name = "lastname")
    private String nomusers;

    @ColumnInfo(name = "firstname")
    private String prenomusers;

    @ColumnInfo(name = "photo")
    private String photousers;

    @ColumnInfo(name = "email")
    private String emailusers;


    public Commercial() {
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getNomusers() {
        return nomusers;
    }

    public void setNomusers(String nomusers) {
        this.nomusers = nomusers;
    }

    public String getPrenomusers() {
        return prenomusers;
    }

    public void setPrenomusers(String prenomusers) {
        this.prenomusers = prenomusers;
    }

    public String getPhotousers() {
        return photousers;
    }

    public void setPhotousers(String photousers) {
        this.photousers = photousers;
    }

    public String getEmailusers() {
        return emailusers;
    }

    public void setEmailusers(String emailusers) {
        this.emailusers = emailusers;
    }
}
