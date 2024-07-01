package com.example.demo.Daos;

import com.example.demo.Beans.Jugador;
import com.example.demo.Beans.Seleccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeleccionDao extends daoBase{

    public ArrayList<Seleccion> listarSelecciones() {

        ArrayList<Seleccion> listaSelecciones = new ArrayList<>();

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from seleccion");) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt("idSeleccion"));
                seleccion.setNombre(rs.getString("nombre"));
                seleccion.setTecnico(rs.getString("tecnico"));
                seleccion.setIdEstadio(rs.getInt("estadio_idEstadio"));

                listaSelecciones.add(seleccion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaSelecciones;
    }
}
