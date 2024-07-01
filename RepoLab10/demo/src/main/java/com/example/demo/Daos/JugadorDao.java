package com.example.demo.Daos;

import com.example.demo.Beans.Jugador;

import java.sql.*;
import java.util.ArrayList;

public class JugadorDao extends daoBase {

    public ArrayList<Jugador> listarJugadores() {

        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from jugador");) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Jugador jugador = new Jugador();
                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));
                jugador.setIdSeleccion(rs.getInt(6));

                listaJugadores.add(jugador);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaJugadores;
    }

    public void crearJugador(Jugador jugador) {
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from jugador");) {
            String sql = "INSERT INTO jugador (nombre, edad, posicion, club, sn_idSeleccion)\n" +
                    "                        VALUES (?, ?, ?, ?, ?);";
            try (PreparedStatement psmt = conn.prepareStatement(sql)) {
                psmt.setString(1, jugador.getNombre());
                psmt.setInt(2, jugador.getEdad());
                psmt.setString(3, jugador.getPosicion());
                psmt.setString(4, jugador.getClub());
                psmt.setInt(5, jugador.getIdSeleccion());
                psmt.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void eliminarJugador(int id) {

        String sql = "DELETE FROM jugador WHERE idJugador = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
