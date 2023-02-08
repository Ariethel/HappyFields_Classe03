package persistenza;

import model.Evento;

public interface persistenzaService {
    public void doAddEvento(Evento e);

    public void doAddSport(String s);

    public void doDropEvento(String nome);

    public void doAddEventoAttesa(Evento e);

    public void doDropGestore(String nome);

    public void doDropUser(String nome);
}
