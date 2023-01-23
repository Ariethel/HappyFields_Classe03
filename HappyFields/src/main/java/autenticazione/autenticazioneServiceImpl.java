package autenticazione;

import model.ConnPool;
import model.Gestore;
import model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class autenticazioneServiceImpl implements autenticazioneService {

    public boolean doCheckUsernameAlredyUsed(Utente u) {
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente u WHERE u.username = (?)");
            ps.setString(1, u.getUsername());
            ResultSet rs = ps.executeQuery();
            //Restituisce false se l'username non e' gia' in uso
            if (!rs.next()) return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //altrimenti true
        return true;
    }

    public boolean doCheckPassword(String username, String password) {
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente WHERE username = (?) AND pass = (?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            //Se non matchano ritorna falso
            if (!rs.next()) return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //altrimenti true
        return true;
    }

    public boolean doCheckUsernameManagerAlredyUsed(Gestore g) {
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM gestore u WHERE u.username_g = (?)");
            ps.setString(1, g.getUsername());
            ResultSet rs = ps.executeQuery();
            //Restituisce false se l'username non e' gia' in uso
            if (!rs.next()) return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //altrimenti true
        return true;
    }

    public boolean doCheckManagerPassword(String username, String password) {
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM gestore WHERE username_g = (?) AND pass_g = (?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            //Se non matchano ritorna falso
            if (!rs.next()) return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //altrimenti true
        return true;
    }
}

