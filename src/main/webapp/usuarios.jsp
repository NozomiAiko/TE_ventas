<%
//codigo en java
if(session.getAttribute("loginUser") != "ok"){
    response.sendRedirect("Login");
    }
%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<Usuario> usuario = (List<Usuario>) request.getAttribute("Usuario");
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>USUARIOS</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <br><br><br><br>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <div>
            <h1>USUARIOS</h1>
            <jsp:include page="META-INF/menu.jsp" >
                <jsp:param name="opcion" value="usuarios" />
            </jsp:include >
            <a href="UsuarioControlador?action=add" id="btnAdd">  Nuevo usuario</a><br>
            <table >
                <br>
                <tr id="cabecera">
                    <th>ID</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th colspan="2">OPCIONES</th>
                </tr>
                <c:forEach var="item" items="${usuarios}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.email}</td>
                        <td>**********</td>
                        <td><a id="btnEdit" href="UsuarioControlador?action=edit&id=${item.id}">EDITAR</a></td>
                        <td><a id="btnDelete" href="UsuarioControlador?action=delete&id=${item.id}" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))">ELIMINAR</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
