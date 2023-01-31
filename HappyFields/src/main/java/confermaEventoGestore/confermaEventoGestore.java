package confermaEventoGestore;

import model.Campo;
import model.Evento;
import model.Sport;

import java.util.ArrayList;

public interface confermaEventoGestore {
    public Sport doRetriveSport(String name);
    public Campo doRetriveCampo(String nome);
    Evento retriveEventoAttesaByName(String titolo);


    ArrayList<Evento> doFetchWaitingMatch(String id);

}
