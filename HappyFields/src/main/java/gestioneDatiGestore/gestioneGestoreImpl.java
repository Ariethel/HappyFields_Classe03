package gestioneDatiGestore;

import model.ConnPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class gestioneGestoreImpl implements gestioneGestoreService {

    public void doChangeEmail(String email, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE gestore SET username_g = (?) WHERE username_g = (?)");
            ps.setString(1, email);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }
    @Override
    public void doChangePassword(String password, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE gestore SET pass_g = (?) WHERE username_g = (?)");
            ps.setString(1, password);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void doChangeNome(String nome, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE gestore SET nome = (?) WHERE username_g = (?)");
            ps.setString(1, nome);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void doChangeCognome(String cognome, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE gestore SET cognome = (?) WHERE username_g = (?)");
            ps.setString(1, cognome);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }

    }

    @Override
    public void doChangeProvincia(String provincia, String id) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE gestore SET provincia = (?) WHERE username_g = (?)");
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
            PreparedStatement ps = conn.prepareStatement("UPDATE gestore SET citta = (?) WHERE username_g = (?)");
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
            PreparedStatement ps = conn.prepareStatement("UPDATE gestore SET via = (?) WHERE username_g = (?)");
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
            PreparedStatement ps = conn.prepareStatement("UPDATE gestore SET telefono_g = (?) WHERE username_g = (?)");
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
            PreparedStatement ps = conn.prepareStatement("UPDATE gestore SET iban_g = (?) WHERE username_g = (?)");
            ps.setString(1, Iban);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }


}
