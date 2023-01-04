package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SportDAO {
    public ArrayList<String> doRetriveSportsName(){
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
