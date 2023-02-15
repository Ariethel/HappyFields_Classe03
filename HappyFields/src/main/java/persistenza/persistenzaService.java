package persistenza;

import model.Evento;

public interface persistenzaService {
    public boolean doAddEvento(Evento e);

    public void doAddSport(String s);

    public void doDropEvento(String nome);

    public boolean doAddEventoAttesa(Evento e);

    public void doDropGestore(String nome);

    public void doDropUser(String nome);
}
