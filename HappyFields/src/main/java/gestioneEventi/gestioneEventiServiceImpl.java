package gestioneEventi;

import model.*;
import gestioneEventi.gestioneEventiServiceImpl;
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


    public ArrayList<Evento> doRetriveAllMatch(){
        ArrayList<Evento> eventi = new ArrayList<>();
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM evento");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Evento e = new Evento();
                Sport s = this.doRetriveSport(rs.getString("sport"));
                Campo c = this.doRetriveCampo(rs.getString("campo"));

                e.setNome(rs.getString("titolo"));
                e.setSport(s);
                e.setCampo(c);
                e.setData(rs.getDate("data_e"));
                e.setOra(rs.getDouble("ora"));
                eventi.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eventi;
    }

    @Override
    public void doAddPlayer(String id, String nomeE) {
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("INSERT INTO partecipa VALUES (?, ?)");
            ps.setString(1, id);
            ps.setString(2, nomeE);
            ps.executeUpdate();
        } catch (SQLException er) {
            throw new RuntimeException(er);
        }
    }

    @Override
    public boolean isPartecipating(String id, String nomeE) {
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM partecipa WHERE username = (?) AND nomeEvento = (?)");
            ps.setString(1, id);
            ps.setString(2, nomeE);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public ArrayList<Evento> doFetchUserMatch(String id) {
        ArrayList<Evento> eventi = new ArrayList<>();
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM partecipa WHERE username = (?)");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                eventi.add(this.retriveEventoByName(rs.getString("nomeEvento")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eventi;

    }

    @Override
    public Evento retriveEventoByName(String nomeEvento) {
        Evento evento = new Evento();
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM evento WHERE titolo = (?)");
            ps.setString(1, nomeEvento);
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

    @Override
    public ArrayList<Evento> doFetchWaitingMatch(String id) {
        ArrayList<Evento> eventi = new ArrayList<>();
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM attesa join gestisce ON attesa.campo = gestisce.campo" +
                    " WHERE gestisce.gestore = (?)");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                eventi.add(this.retriveEventoByName(rs.getString("nomeEvento")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eventi;
    }


}
