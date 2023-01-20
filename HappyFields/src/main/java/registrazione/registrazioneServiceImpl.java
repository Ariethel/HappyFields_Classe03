package registrazione;

import model.ConnPool;
import model.Gestore;
import model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class registrazioneServiceImpl implements registrazioneService {



    public void doAddUser(Utente utente) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void doAddManager(Gestore gestore) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

