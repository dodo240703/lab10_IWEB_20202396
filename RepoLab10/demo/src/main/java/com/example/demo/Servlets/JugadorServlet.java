package com.example.demo.Servlets;

import com.example.demo.Beans.Jugador;
import com.example.demo.Beans.Seleccion;
import com.example.demo.Daos.JugadorDao;
import com.example.demo.Daos.SeleccionDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "JugadorServlet", value = {"/JugadorServlet","/Jugadores"})
public class JugadorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        JugadorDao jugadorDao = new JugadorDao();
        SeleccionDao seleccionDao = new SeleccionDao();
        RequestDispatcher view;

        switch (action) {
            case "lista":
                ArrayList<Jugador> listaJugadores = jugadorDao.listarJugadores();
                request.setAttribute("listaJugadores", listaJugadores);

                view= request.getRequestDispatcher("listaJugadores.jsp");
                view.forward(request, response);

                break;

            case "formCrear":
                request.setAttribute("listaSelecciones", seleccionDao.listarSelecciones() );
                view = request.getRequestDispatcher("nuevoJugador.jsp");
                view.forward(request, response);
                break;

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        JugadorDao jugadorDao = new JugadorDao();
        RequestDispatcher view;

        switch (action) {
            case "crear":
                String nombre = request.getParameter("nombreJugador");
                String edad = request.getParameter("edad");
                String posicion = request.getParameter("posicion");
                String club = request.getParameter("club");
                String seleccion = request.getParameter("seleccion");

                Jugador jugador = new Jugador();

                jugador.setNombre(nombre);
                jugador.setEdad(Integer.parseInt(edad));
                jugador.setPosicion(posicion);
                jugador.setClub(club);
                jugador.setIdSeleccion(Integer.parseInt(seleccion));

                jugadorDao.crearJugador(jugador);

                response.sendRedirect("Jugadores");

                break;

            case "borrar":
                int id = Integer.parseInt(request.getParameter("idJugador"));
                jugadorDao.eliminarJugador(id);
                response.sendRedirect(request.getContextPath() + "/Jugadores");

                break;
        }
    }
}
