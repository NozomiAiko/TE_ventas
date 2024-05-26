<%
//codigo en java
    if (session.getAttribute("loginUser") != "ok") {
        response.sendRedirect("Login");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Cliente cliente = (Cliente) request.getAttribute("Cliente");
%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap demo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="mystyle.css"/>
    </head>
    <body>
        <br><br><br>
        <jsp:include page="META-INF/menu.jsp" >
            <jsp:param name="opcion" value="clientes" />
        </jsp:include >
        <c:if test="${cliente.id == 0}">
            <h1>Nuevo Resgitro Cliente</h1>        
        </c:if>
        <c:if test="${cliente.id != 0}">
            <h1>Editar Registro de un Cliente</h1>  
        </c:if>
        <form action="ClienteControlador" method="post">
            <div >
                <input type="hidden" name="id" value="${cliente.id}">
            </div>   
            <div  >
                <label  >Nombre</label><br><br>
                <input type="text"  value="${cliente.nombre}" name="nombre">

            </div>
            <div  >
                <label >Correo:</label><br><br>
                <input type="email" value="${cliente.correo}" name="correo">
            </div>
            <div  >
                <label >Celular/Telefono:</label><br><br>
                <input type="number" value="${cliente.celular}" name="celular">
            </div><br><br>
            <button type="submit" id="btnSave">GUARDAR</button>
        </form>



    </div>
</body>
</html>
