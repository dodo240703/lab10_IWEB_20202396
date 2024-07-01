package com.example.demo.Daos;

import com.example.demo.Beans.Estadio;
import com.example.demo.Beans.Jugador;
import com.mysql.cj.xdevapi.Type;

import java.sql.*;
import java.util.ArrayList;

public class EstadioDao extends daoBase{

    public ArrayList<Estadio> listarEstadios() {

        ArrayList<Estadio> listaEstadios = new ArrayList<>();

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from estadio");) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Estadio estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt("idEstadio"));
                estadio.setNombreEstadio(rs.getString("nombre"));
                estadio.setProvinciaEstado(rs.getString("provincia"));
                estadio.setClub(rs.getString("club"));

                listaEstadios.add(estadio);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaEstadios;
    }

    public void crearEstadio(Estadio estadio) {
        try (Connection conn = this.getConnection();) {
            String sql = "INSERT INTO estadio (nombre, provincia, club)\n" +
                    "                        VALUES (?, ?, ?);";
            try (PreparedStatement psmt = conn.prepareStatement(sql)) {
                psmt.setString(1, estadio.getNombreEstadio());
                psmt.setString(2, estadio.getProvinciaEstado());
                if(estadio.getClub() == null){
                    psmt.setNull(3, Types.VARCHAR );
                }else{
                    psmt.setString(3, estadio.getClub());
                }
                psmt.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void eliminarEstadio(int id) {

        String sql = "DELETE FROM estadio WHERE idEstadio = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
