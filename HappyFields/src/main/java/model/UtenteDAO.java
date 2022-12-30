package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAO {

    public boolean doCheckUsernameAlredyUsed(Utente u){
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

    public boolean doCheckPassword(String username, String password){
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
    public void doAddUser(Utente utente){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO utente VALUES (?,?,?)");
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getPassword());
            ps.setString(3,utente.getTipo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
