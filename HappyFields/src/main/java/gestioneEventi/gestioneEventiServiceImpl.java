package gestioneEventi;

import model.ConnPool;
import model.Evento;
import model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class gestioneEventiServiceImpl implements gestioneEventiService {
    public void doAddUserToEvent(Utente u, Evento e) {
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("INSERT INTO partecipa VALUES (?, ?)");
            ps.setString(1, u.getUsername());
            ps.setString(2, e.getNome());
            ps.executeQuery();
        } catch (SQLException er) {
            throw new RuntimeException(er);
        }
    }

    public ArrayList<String> doRetriveSportsName() {
        ArrayList<String> sport = new ArrayList<>();
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT nome_s FROM sport");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome_s");
                sport.add(nome);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sport;
    }
}
