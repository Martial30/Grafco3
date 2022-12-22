package martioux.pro.grafco3.restbeans;

public class ObjetListeClientCommercial {

   int idClient;
    String nom, nomalias, address, phone;

    public ObjetListeClientCommercial() {
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomalias() {
        return nomalias;
    }

    public void setNomalias(String nomalias) {
        this.nomalias = nomalias;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
