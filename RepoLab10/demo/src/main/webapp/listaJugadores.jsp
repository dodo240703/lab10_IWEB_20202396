<%@ page import="com.example.demo.Beans.Jugador" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: doria
  Date: 28/06/2024
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Jugador> listaJugadores = (ArrayList<Jugador>) request.getAttribute("listaJugadores");

%>
<html>
<head>
    <title>Lista de jugadores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <header class="container mt-4">
        <h1> Lista de jugadores</h1>
    </header>

    <div class="container mt-4">
        <a href="${pageContext.request.contextPath}/Jugadores?action=formCrear" class="btn btn-primary"> Nuevo jugador </a>

        <table class="table table-responsive mt-4">

            <thead>
                <tr>
                    <th> Nombre </th>
                    <th> Edad </th>
                    <th> Posición </th>
                    <th> Club </th>
                    <th> Selección </th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <%for (Jugador jugador : listaJugadores) {%>
            <tr>
                <td><%=jugador.getNombre()%></td>
                <td><%=jugador.getEdad()%></td>
                <td><%=jugador.getPosicion()%></td>
                <td><%=jugador.getClub()%></td>
                <td><%=jugador.getIdSeleccion()%></td>
                <td>
                    <form action="<%=request.getContextPath()%>/Jugadores" method="post" onsubmit="return confirm('¿Estás seguro de que quieres eliminar este jugador?');">
                        <input type="hidden" name="action" value="borrar">
                        <input type="hidden" name="idJugador" value="<%=jugador.getIdJugador()%>">
                        <button type="submit" class="btn btn-danger btn-sm">Borrar</button>
                    </form>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>

</body>
</html>
