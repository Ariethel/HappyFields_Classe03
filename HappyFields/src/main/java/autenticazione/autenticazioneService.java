package autenticazione;

import model.Gestore;
import model.Utente;

public interface autenticazioneService {
    public boolean doCheckUsernameAlredyUsed(Utente username);
    public boolean doCheckPassword(String username, String password);
    public boolean doCheckUsernameManagerAlredyUsed(Gestore username);
    public boolean doCheckManagerPassword(String username, String password);
}
