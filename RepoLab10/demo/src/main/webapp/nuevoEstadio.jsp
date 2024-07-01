<%--
  Created by IntelliJ IDEA.
  User: doria
  Date: 1/07/2024
  Time: 04:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo.Beans.Estadio" %>

<html>
<head>
    <title>Nuevo Estadio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<header class="container mt-4">
    <h1>Nuevo Estadio</h1>
</header>

<div class="container mt-4">
    <form method="post" action="<%=request.getContextPath()%>/Estadios?action=crear">
        <div class="mb-3">
            <label for="nombreEstadio" class="form-label"> Nombre </label>
            <input type="text" id="nombreEstadio" name="nombreEstadio" class="form-control" required>

            <label for="provincia" class="form-label"> Provincia </label>
            <input type="text" id="provincia" name="provincia" class="form-control" required>

            <label for="club" class="form-label"> Club </label>
            <input type="text" id="club" name="club" class="form-control" required>

            <div class="container mt-4">
                <a  href="Jugadores" class="btn btn-danger"> Cancelar </a>
                <button type="submit" class="btn btn-primary"> Guardar</button>
            </div>

        </div>
    </form>
</div>


</body>
</html>

