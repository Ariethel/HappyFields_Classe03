package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CampoDAO {
    public ArrayList<String> doRetriveFieldsName(){
        ArrayList<String> campi = new ArrayList<>();
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT nome_c FROM campo");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome_c");
                campi.add(nome);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return campi;
    }

    public Campo doRetrieveByNome(String campo) {
        try(Connection conn = ConnPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM campo where nome_c = (?)");
            ps.setString(1, campo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Campo c = new Campo(rs.getString("nome_c"), rs.getString("provincia"), rs.getString("citta"), rs.getString("via"), rs.getDouble("costo"), rs.getDouble("lunghezza"), rs.getDouble("larghezza"), rs.getInt("numero_giocatori"));
                return c;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
