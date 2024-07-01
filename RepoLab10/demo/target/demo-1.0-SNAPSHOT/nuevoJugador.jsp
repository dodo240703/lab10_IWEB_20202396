<%--
  Created by IntelliJ IDEA.
  User: doria
  Date: 28/06/2024
  Time: 16:51
  To change this template use File | Settings | File Templates.
  <jsp:useBean id="listaSelecciones" type="java.util.ArrayList<Beans.Seleccion>" scope="request"></jsp:useBean>
--%>
<%@ page import="com.example.demo.Beans.Seleccion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    ArrayList<Seleccion> listaSelecciones = (ArrayList<Seleccion>) request.getAttribute("listaSelecciones");

%>
<html>
<head>
    <title>Nuevo Jugador</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
    <header class="container mt-4">
        <h1>Nuevo Jugador</h1>
    </header>

    <div class="container mt-4">
        <form method="post" action="<%=request.getContextPath()%>/Jugadores?action=crear">
            <div class="mb-3">
                <label for="nombreJugador" class="form-label"> Nombre </label>
                <input type="text" id="nombreJugador" name="nombreJugador" class="form-control" required>

                <label for="edad" class="form-label"> Edad </label>
                <input type="text" id="edad" name="edad" class="form-control" required>

                <label for="posicion" class="form-label"> Posición </label>
                <select class="form-select" id="posicion" name="posicion" aria-label="Default select example">
                    <option selected>Elegir</option>
                    <option value="delantero">Delantero</option>
                    <option value="defensa">Defensa</option>
                    <option value="centrocampista">Centro Campista</option>
                    <option value="portero">Portero </option>
                </select>

                <label for="club" class="form-label"> Club </label>
                <input type="text" id="club" name="club" class="form-control" required>

                <label for="seleccion" class="form-label"> Selección Nacional</label>
                <select class="form-select" id="seleccion" name="seleccion" aria-label="Default select example">
                    <option selected>Elegir</option>
                    <% for (Seleccion seleccion : listaSelecciones) {%>
                    <option value=<%=seleccion.getIdSeleccion()%>> <%=seleccion.getNombre()%> </option>
                    <% } %>
                </select>

                <div class="container mt-4">
                    <a  href="Jugadores" class="btn btn-danger"> Cancelar </a>
                    <button type="submit" class="btn btn-primary"> Guardar</button>
                </div>

            </div>
        </form>
    </div>


</body>
</html>
