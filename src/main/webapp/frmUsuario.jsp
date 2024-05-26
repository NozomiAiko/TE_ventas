<%
//codigo en java
    if (session.getAttribute("loginUser") != "ok") {
        response.sendRedirect("Login");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.emergentes.modelo.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("Usuario");
%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Usuarios</title>
        <link rel="stylesheet" href="mystyle.css"/>
    </head>
    <body>
        <br><br><br>
        <jsp:include page="META-INF/menu.jsp" >
            <jsp:param name="opcion" value="usuarios" />
        </jsp:include >
        <c:if test="${usuario.id == 0}">
            <h1>Nuevo Resgitro Usuario</h1>        
        </c:if>
        <c:if test="${usuario.id != 0}">
            <h1>Editar Registro de un Usuario</h1>  
        </c:if>
        <br>
        <form action="UsuarioControlador" method="post">
            <div>
                <input type="hidden" name="id" value="${usuario.id}">
            </div>   
            <div class="mb-3">
                <labe >Ingrese un correo electronico</label><br><br>
                    <input type="email" class="form-control" value="${usuario.email}" name="email">

                    </div>
                    <div class="mb-3">
                        <labe >Ingrese su contraseña</label><br><br>
                            <input type="password" class="form-control" value="${usuario.password}" name="password">

                            </div>

                            <button type="submit" >GUARDAR</button>

                            </form>



                    </div>
                    </body>
                    </html>

