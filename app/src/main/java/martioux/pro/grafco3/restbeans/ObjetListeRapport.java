package martioux.pro.grafco3.restbeans;

public class ObjetListeRapport {

    int idrapports, code;
    String  textRappot;
    String  dates, heure;

    public ObjetListeRapport() {
    }

    public int getIdrapports() {
        return idrapports;
    }

    public void setIdrapports(int idrapports) {
        this.idrapports = idrapports;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTextRappot() {
        return textRappot;
    }

    public void setTextRappot(String textRappot) {
        this.textRappot = textRappot;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
