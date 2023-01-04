package model;

import java.util.Date;

public class Evento {
    public Evento(String nome, Sport sport, Campo campo, Date data, double ora) {
        this.nome = nome;
        this.luogo = campo.getIndirizzoCompleto();
        this.sport = sport;
        this.campo = campo;
        this.data = data;
        this.ora = ora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getOra() {
        return ora;
    }

    public void setOra(double ora) {
        this.ora = ora;
    }

    private String nome, luogo;
    Sport sport;
    Campo campo;
    Date data;
    double ora;
}
