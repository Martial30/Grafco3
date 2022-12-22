package martioux.pro.grafco3.restbeans;

import java.sql.Timestamp;

public class ObjetEcrireRapport {
    int idrapport, code;
    String texterapport;
    //Timestamp dateheure;

    public ObjetEcrireRapport() {
    }

    public int getIdrapport() {
        return idrapport;
    }

    public void setIdrapport(int idrapport) {
        this.idrapport = idrapport;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTexterapport() {
        return texterapport;
    }

    public void setTexterapport(String texterapport) {
        this.texterapport = texterapport;
    }
}
