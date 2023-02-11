package gestioneDatiGestore;

import model.Campo;

import java.util.ArrayList;

public interface gestioneGestoreService {
    public void doChangePassword(String password, String id);

    public void doChangeEmail(String email, String id);

    public void doChangeNome(String nome, String id);
    public void doChangeCognome(String cognome, String id);
    public void doChangeProvincia(String provincia, String id);
    public void doChangeCitta(String citta, String id);
    public void doChangeVia(String via, String id);
    public void doChangeTelefono(String telefono, String id);
    public void doChangeIban(String Iban, String id);
    public ArrayList<Campo> doFetchCampiById(String id);
    public boolean doModificaCampo(Campo c);
    public void doAddCampo(Campo c);
}
