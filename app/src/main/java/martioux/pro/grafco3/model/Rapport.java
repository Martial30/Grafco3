package martioux.pro.grafco3.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Timestamp;

@Entity
public class Rapport {
    @PrimaryKey
    private Integer idraps;

    @ColumnInfo(name = "texte_rapport")
    private String texterapport;

    @ColumnInfo(name = "rowid")
    private Integer code;

    public Rapport() {
    }

    public Integer getIdraps() {
        return idraps;
    }

    public void setIdraps(Integer idraps) {
        this.idraps = idraps;
    }

    public String getTexterapport() {
        return texterapport;
    }

    public void setTexterapport(String texterapport) {
        this.texterapport = texterapport;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    //Code pour jolis design
    //https://youtu.be/9r8TJSVXoEg
}
