package com.example.demo.Servlets;

import com.example.demo.Beans.Estadio;
import com.example.demo.Beans.Jugador;
import com.example.demo.Daos.EstadioDao;
import com.example.demo.Daos.JugadorDao;
import com.example.demo.Daos.SeleccionDao;
import com.example.demo.HelloServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EstadioServlet", value = {"/EstadioServlet","/Estadios"})
public class EstadioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        EstadioDao estadioDao = new EstadioDao();
        RequestDispatcher view;

        switch (action) {
            case "lista":
                ArrayList<Estadio> listaEstadios = estadioDao.listarEstadios();
                request.setAttribute("listaEstadios", listaEstadios);

                view= request.getRequestDispatcher("listaEstadios.jsp");
                view.forward(request, response);

                break;

            case "formCrear":
                view = request.getRequestDispatcher("nuevoEstadio.jsp");
                view.forward(request, response);
                break;

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        EstadioDao estadioDao = new EstadioDao();
        RequestDispatcher view;

        switch (action) {
            case "crear":
                String nombre = request.getParameter("nombreEstadio");
                String provincia = request.getParameter("provincia");
                String club = request.getParameter("club");

                Estadio estadio = new Estadio();

                estadio.setNombreEstadio(nombre);
                estadio.setProvinciaEstado(provincia);
                estadio.setClub(club);

                estadioDao.crearEstadio(estadio);

                response.sendRedirect("Estadios");

                break;

            case "borrar":
                int id = Integer.parseInt(request.getParameter("idEstadio"));
                estadioDao.eliminarEstadio(id);
                response.sendRedirect(request.getContextPath() + "/Estadios");

                break;
        }
    }

}
