package martioux.pro.grafco3.restbeans;

public class ObjetListefactureimpayee {

     int ids;
    String nomclient, structure, datefactures, dateecheance, creance;

    public ObjetListefactureimpayee() {

    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getCreance() {
        return creance;
    }

    public void setCreance(String creance) {
        this.creance = creance;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getDatefactures() {
        return datefactures;
    }

    public void setDatefactures(String datefactures) {
        this.datefactures = datefactures;
    }

    public String getDateecheance() {
        return dateecheance;
    }

    public void setDateecheance(String dateecheance) {
        this.dateecheance = dateecheance;
    }
}
