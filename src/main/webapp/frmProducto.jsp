<%
//codigo en java
if(session.getAttribute("loginUser") != "ok"){
    response.sendRedirect("Login");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Producto producto = (Producto)  request.getAttribute("Producto");
%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap demo</title>
        <link rel="stylesheet" href="mystyle.css"/>
    </head>
    <body>
      
        <jsp:include page="META-INF/menu.jsp" >
            <jsp:param name="opcion" value="productos" />
        </jsp:include >
          <br><br><br><br>
        <c:if test="${producto.id == 0}">
        <h1>Nuevo Resgitro Producto</h1>        
        </c:if>
        <c:if test="${producto.id != 0}">
        <h1>Editar Registro de un Producto</h1>  
        </c:if>
        <br>
        <form action="ProductoControlador" method="post">
            <div id="inputFrm" >
                <input type="hidden" name="id" value="${producto.id}">
            </div>   
            <div id="inputFrm"  >
                <label  >Nombre</label><br><br>
                <input type="text"  value="${producto.nombre}" name="nombre">
                
            </div>
            <div  id="inputFrm" >
                <label >Descripcion</label><br><br>
                <input type="text"  value="${producto.descripcion}" name="descripcion">
            </div>
            <div  id="inputFrm" >
                <label >Precio [unitario]</label><br><br>
                <input type="number"  value="${producto.precio}" name="precio">
            </div><br><br>
            <button type="submit" id="btnSave">GUARDAR</button>
        </form>
    </div>
</body>
</html>
