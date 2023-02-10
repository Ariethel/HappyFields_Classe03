package registrazione;

import model.Gestore;
import model.Utente;

public interface registrazioneService {

    // Utente
    public boolean doAddUser(Utente utente);

    // Gestore
    public boolean doAddManager(Gestore gestore);
}
