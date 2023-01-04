package model;

public class Campo {

    public Campo(String nome_c, String provincia, String citta, String via, double costo, double lunghezza, double larghezza, int num_giocatori) {
        this.nome_c = nome_c;
        this.provincia = provincia;
        this.citta = citta;
        this.via = via;
        this.costo = costo;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.num_giocatori = num_giocatori;
    }

    public String getNome_c() {
        return nome_c;
    }

    public void setNome_c(String nome_c) {
        this.nome_c = nome_c;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(double lunghezza) {
        this.lunghezza = lunghezza;
    }

    public double getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(double larghezza) {
        this.larghezza = larghezza;
    }

    public int getNum_giocatori() {
        return num_giocatori;
    }

    public void setNum_giocatori(int num_giocatori) {
        this.num_giocatori = num_giocatori;
    }

    public String getIndirizzoCompleto(){
        return this.via + " " + this.citta + " " + this.provincia;
    }

    private String nome_c, provincia, citta, via;
    private double costo, lunghezza, larghezza;
    private int num_giocatori;
}
