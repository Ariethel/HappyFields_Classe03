package gestioneDatiUtente;
import model.ConnPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class gestioneUtenteImpl implements gestioneUtenteService {

    @Override
    public void doChangePassword(String password, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE utente SET pass = (?) WHERE username = (?)");
            ps.setString(1, password);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void doChangeEmail(String email, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE utente SET username = (?) WHERE username = (?)");
            ps.setString(1, email);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void doChangeProvincia(String provincia, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE utente SET provincia = (?) WHERE username = (?)");
            ps.setString(1, provincia);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void doChangeCitta(String citta, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE utente SET citta = (?) WHERE username = (?)");
            ps.setString(1, citta);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void doChangeVia(String via, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE utente SET via = (?) WHERE username = (?)");
            ps.setString(1, via);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void doChangeTelefono(String telefono, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE utente SET telefono = (?) WHERE username = (?)");
            ps.setString(1, telefono);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void doChangeIban(String Iban, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE utente SET iban = (?) WHERE username = (?)");
            ps.setString(1, Iban);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void doChangeSport(String sport, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE utente SET preferenza = (?) WHERE username = (?)");
            ps.setString(1, sport);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }
}
