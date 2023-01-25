package persistenza;

import model.Evento;

public interface persistenzaService {
    public void doAddEvento(Evento e);

    public void doAddSport(String s);

    public void doDropEvento(String nome);
}
