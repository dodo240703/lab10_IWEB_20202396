<%@ page import="com.example.demo.Beans.Estadio" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: doria
  Date: 1/07/2024
  Time: 04:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Estadio> listaEstadios = (ArrayList<Estadio>) request.getAttribute("listaEstadios");

%>
<html>
<head>
    <title>Lista de estadios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<header class="container mt-4">
    <h1> Lista de estadios</h1>
</header>

<div class="container mt-4">
    <a href="${pageContext.request.contextPath}/Estadios?action=formCrear" class="btn btn-primary"> Nuevo estadio </a>

    <table class="table table-responsive mt-4">

        <thead>
        <tr>
            <th> Nombre </th>
            <th> Provincia </th>
            <th> Club </th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%for (Estadio estadio : listaEstadios) {%>
        <tr>
            <td><%=estadio.getNombreEstadio()%></td>
            <td><%=estadio.getProvinciaEstado()%></td>
            <td>
                <%= (estadio.getClub() != null) ? estadio.getClub() : "Sin Club" %>
            </td>
            <td></td>

            <td>
                <form action="<%=request.getContextPath()%>/Estadios" method="post" onsubmit="return confirm('¿Estás seguro de que quieres eliminar este estadio?');">
                    <input type="hidden" name="action" value="borrar">
                    <input type="hidden" name="idEstadio" value="<%=estadio.getIdEstadio()%>">
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

