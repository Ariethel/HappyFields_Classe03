package confermaEventoGestore;

import model.Campo;
import model.ConnPool;
import model.Evento;
import model.Sport;
import gestioneEventi.gestioneEventiServiceImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class confermaEventoGestoreImpl implements confermaEventoGestore{
    public Sport doRetriveSport(String name){
        Sport sport = new Sport(name);
        return sport;
    }

    public Campo doRetriveCampo(String nome){
        Campo campo = new Campo();
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM campo WHERE nome_c = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                campo.setNome_c(rs.getString("nome_c"));
                campo.setProvincia(rs.getString("provincia"));
                campo.setCitta(rs.getString("citta"));
                campo.setNum_giocatori(rs.getInt("numero_giocatori"));
                campo.setVia(rs.getString("via"));
                campo.setCosto(rs.getDouble("costo"));
                campo.setLarghezza(rs.getDouble("larghezza"));
                campo.setLunghezza(rs.getDouble("lunghezza"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return campo;
    }

    public ArrayList<Evento> doFetchWaitingMatch(String id) {
        ArrayList<Evento> eventi = new ArrayList<>();
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM attesa, gestisce WHERE attesa.campo = gestisce.campo" +
                    " AND gestisce.gestore = (?)");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                eventi.add(this.retriveEventoAttesaByName(rs.getString("titolo")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eventi;
    }

    public Evento retriveEventoAttesaByName(String titolo) {
        Evento evento = new Evento();
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM attesa WHERE titolo = (?)");
            ps.setString(1, titolo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Sport s = this.doRetriveSport(rs.getString("sport"));
                Campo c = this.doRetriveCampo(rs.getString("campo"));
                evento.setNome(rs.getString("titolo"));
                evento.setSport(s);
                evento.setCampo(c);
                evento.setData(rs.getDate("data_e"));
                evento.setOra(rs.getDouble("ora"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return evento;
    }

}
