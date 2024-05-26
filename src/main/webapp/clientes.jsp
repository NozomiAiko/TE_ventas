<%
//codigo en java
if(session.getAttribute("loginUser") != "ok"){
    response.sendRedirect("Login");
    }
%>

<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<Cliente> cliente = (List<Cliente>) request.getAttribute("Cliente");
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
                <title>CLIENTES</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                <link rel="stylesheet" href="mystyle.css"/>
    </head>
<body >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        
    <br><br>
    <div >
        
        <jsp:include page="META-INF/menu.jsp" >
            <jsp:param name="opcion" value="clientes" />
        </jsp:include ><br><br>
        <h1>CLIENTES</h1>
         <a href="ClienteControlador?action=add" id="btnAdd"> Nuevo cliente</a><br>
        <table>
            <br>
                <tr id="cabecera">
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Celular</th>
                    <th colspan="2">OPCIONES</th>
                </tr>
                <c:forEach var="item" items="${clientes}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nombre}</td>
                        <td>${item.correo}</td>
                        <td>${item.celular}</td>
                        <td><a id="btnEdit" href="ClienteControlador?action=edit&id=${item.id}">EDITAR</a></td>
                        <td><a id="btnDelete" href="ClienteControlador?action=delete&id=${item.id}" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))">ELIMINAR</a></td>
                    </tr>
                </c:forEach>
        </table>
    </div>
</body>
</html>