package persistenza;

import model.ConnPool;
import model.Evento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.util.regex.Pattern;

public class persistenzaServiceImpl implements persistenzaService {
    public boolean doAddEvento(Evento e) {
        Pattern pattern = Pattern.compile("^[A-z 0-9.#&]{1,20}$"); // Regex per nome
        if (!pattern.matcher(e.getNome()).matches()) return false;

        long milisecondsAttuale = System.currentTimeMillis();
        java.sql.Date data = (Date) e.getData();
        long milisecondsProva = data.getTime();

        if(milisecondsProva<=milisecondsAttuale) return false;
        if(e.getOra()<=0) return false;



        try (Connection conn = ConnPool.getConnection()) {

            PreparedStatement ps = conn.prepareStatement("INSERT INTO evento VALUES (?,?,?,?,?)");
            ps.setString(1, e.getNome());
            ps.setString(2, e.getSport().getNome_s());
            ps.setString(3,e.getCampo().getNome_c());
            ps.setDate(4, (Date) e.getData());
            ps.setDouble(5, e.getOra());
            ps.executeUpdate();

            return true;
        } catch (SQLException i) {
            i.printStackTrace();
        }
        return false;




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

    @Override
    public void doDropEvento(String nome) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM attesa WHERE titolo = (?)");
            ps.setString(1, nome);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    public void doDropUser(String nome) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM utente WHERE username = (?)");
            ps.setString(1, nome);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    public void doDropGestore(String nome) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM gestore WHERE username_g = (?)");
            ps.setString(1, nome);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }



    public void doAddEventoAttesa(Evento e) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO attesa VALUES (?,?,?,?,?)");
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
}
