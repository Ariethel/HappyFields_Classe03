package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestoreDAO {
    public boolean doCheckUsernameAlredyUsed(Gestore g){
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

    public boolean doCheckPassword(String username, String password){
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
    public void doAddManager(Gestore gestore){
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
