package martioux.pro.grafco3.restbeans;

public class ObjetListefacturepayee {

    int id;
    String nomclient, structures, datefacture, montant, datepaiement;

    public ObjetListefacturepayee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getStructures() {
        return structures;
    }

    public void setStructures(String structures) {
        this.structures = structures;
    }

    public String getDatefacture() {
        return datefacture;
    }

    public void setDatefacture(String datefacture) {
        this.datefacture = datefacture;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getDatepaiement() {
        return datepaiement;
    }

    public void setDatepaiement(String datepaiement) {
        this.datepaiement = datepaiement;
    }
}
