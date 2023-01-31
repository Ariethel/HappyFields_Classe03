package gestioneDatiGestore;

import model.Campo;
import model.ConnPool;

import java.sql.*;
import java.util.ArrayList;

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


    public ArrayList<Campo> doFetchCampiById(String id) {
        ArrayList<Campo> campi = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM campo c, gestisce g WHERE c.nome_c = g.campo AND g.gestore = (?)");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                campi.add(new Campo(rs.getString("nome_c"), rs.getString("provincia"), rs.getString("citta"), rs.getString("via"), rs.getDouble("costo"), rs.getDouble("lunghezza"), rs.getDouble("larghezza"), rs.getInt("numero_giocatori")));
            }
        } catch (SQLException i) {
            i.printStackTrace();
        }

        return campi;
    }

    public void doModificaCampo(String idC, String nome_c, int numero_giocatori, String provincia, String citta, String via, double costo, double lunghezza, double larghezza) {
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE campo SET nome_c = (?), numero_giocatori = (?), provincia = (?), " +
                    "citta = (?), via = (?), costo = (?), lunghezza = (?), larghezza = (?) WHERE nome_c = (?)");
            ps.setString(1, nome_c);
            ps.setInt(2, numero_giocatori);
            ps.setString(3, provincia);
            ps.setString(4, citta);
            ps.setString(5, via);
            ps.setDouble(6, costo);
            ps.setDouble(7, lunghezza);
            ps.setDouble(8, larghezza);
            ps.setString(9, idC);
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    public void doAddCampo(Campo c){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO campo (nome_c, numero_giocatori, provincia, citta, via, costo, lunghezza, larghezza) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, c.getNome_c());
            ps.setInt(2, c.getNum_giocatori());
            ps.setString(3, c.getProvincia());
            ps.setString(4, c.getCitta());
            ps.setString(5, c.getVia());
            ps.setDouble(6, c.getCosto());
            ps.setDouble(7, c.getLunghezza());
            ps.setDouble(8, c.getLarghezza());
            ps.executeUpdate();
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }
}
