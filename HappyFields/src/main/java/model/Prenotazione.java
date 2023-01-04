package model;

public class Prenotazione {
    public Prenotazione(Utente admin, Evento evento) {
        this.admin = admin;
        this.evento = evento;
    }

    public Utente getAdmin() {
        return admin;
    }

    public void setAdmin(Utente admin) {
        this.admin = admin;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    Utente admin;
    Evento evento;
}
