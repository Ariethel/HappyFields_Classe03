package registrazione;

import model.ConnPool;
import model.Gestore;
import model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class registrazioneServiceImpl implements registrazioneService {



    public boolean doAddUser(Utente utente) {
        Pattern pattern = Pattern.compile("^[A-z0-9.#&]{1,30}$"); // Regex per username
        if (!pattern.matcher(utente.getUsername()).matches()) return false;
        Pattern patternC = Pattern.compile("^[A-z]$"); // Regex per citta
        if (!patternC.matcher(utente.getCitta()).matches()) return false;
        Pattern patternP = Pattern.compile("^[A-Z]{2}$"); // Regex per provincia
        if (!patternP.matcher(utente.getProvincia()).matches()) return false;
        Pattern patternV = Pattern.compile("^[A-z 0-9]{1,30}$"); // Regex per via
        if (!patternV.matcher(utente.getVia()).matches()) return false;
        Pattern patternN = Pattern.compile("^[0-9]{10,10}$"); // Regex per numero di telefono
        if (!patternN.matcher(String.valueOf(utente.getTelefono())).matches()) return false;
        Pattern patternPass = Pattern.compile("^(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,15}$"); // Regex per password
        if (!patternPass.matcher(utente.getPassword()).matches()) return false;


        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO utente VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getPassword());
            ps.setString(3,utente.getProvincia());
            ps.setString(4, utente.getCitta());
            ps.setString(5, utente.getVia());
            ps.setLong(6, utente.getTelefono());
            ps.setString(7, utente.getIban());
            ps.setString(8, utente.getPreferenza());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean doAddManager(Gestore gestore) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO gestore VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, gestore.getUsername());
            ps.setString(2, gestore.getPassword());
            ps.setString(3, gestore.getNome());
            ps.setString(4, gestore.getCognome());
            ps.setString(5, gestore.getProvincia());
            ps.setString(6, gestore.getCitta());
            ps.setString(7, gestore.getVia());
            ps.setString(8, gestore.getIban());
            ps.setLong(9, gestore.getTelefono());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

