package model;

public class Sport {

    public Sport (){

    }

    public Sport (String nome_s){
        this.nome_s = nome_s;
    }

    public String getNome_s() {
        return nome_s;
    }

    public void setNome_s(String nome_s) {
        this.nome_s = nome_s;
    }

    private String nome_s;
}
