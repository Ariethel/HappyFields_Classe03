package gestioneEventi;

import model.Evento;
import model.Utente;

import java.util.ArrayList;

public interface gestioneEventiService {
    //Ci dovranno andare le funzioni per aggiungere user alla lista evento e altre cose del genere
    public void doAddUserToEvent(Utente u, Evento e);

    // Sport
    public ArrayList<String> doRetriveSportsName();
}
