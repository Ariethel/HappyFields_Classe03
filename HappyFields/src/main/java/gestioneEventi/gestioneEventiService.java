package gestioneEventi;

import model.Campo;
import model.Evento;
import model.Sport;
import model.Utente;

import java.util.ArrayList;

public interface gestioneEventiService {
    //Ci dovranno andare le funzioni per aggiungere user alla lista evento e altre cose del genere
    public void doAddUserToEvent(Utente u, Evento e);

    // Sport
    public ArrayList<String> doRetriveSportsName();
    public Sport doRetriveSport(String nome);
    public Campo doRetriveCampo(String nome);
    public ArrayList<Evento> doRetriveAllMatch();

    void doAddPlayer(String id, String nomeE);

    boolean isPartecipating(String id, String nomeE);
}
