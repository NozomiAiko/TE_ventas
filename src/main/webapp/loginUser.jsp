<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="mystyle.css"/>
    </head>
    <body>
        <br><br><br>
        <h1>INICIO</h1>
        <form action="Login" id="frmLogin" method="post">
            <label>Correo
                <input type="text" name="email">
            </label><br>
            <label>Contraseña
                <input type="password" name="password">
            </label><br><br>
             <button type="submit">GUARDAR</button>
        </form>
    </body>
</html>
