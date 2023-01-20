package registrazione;

import model.Gestore;
import model.Utente;

public interface registrazioneService {

    // Utente
    public void doAddUser(Utente utente);

    // Gestore
    public void doAddManager(Gestore gestore);
}
