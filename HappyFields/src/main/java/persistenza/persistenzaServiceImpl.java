package persistenza;

import model.ConnPool;
import model.Evento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class persistenzaServiceImpl implements persistenzaService {
    public void doAddEvento(Evento e) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO evento VALUES (?,?,?,?,?)");
            ps.setString(1, e.getNome());
            ps.setString(2, e.getSport().getNome_s());
            ps.setString(3,e.getCampo().getNome_c());
            ps.setDate(4, (Date) e.getData());
            ps.setDouble(5, e.getOra());
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    public void doAddSport(String s) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO sport VALUES (?)");
            ps.setString(1, s);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }
}