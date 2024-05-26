package com.emergentes.controlador;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimp;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            UsuarioDAO dao = new UsuarioDAOimp();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            Usuario usu = new Usuario();
            switch (action) {
                case "add":
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("frmUsuario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    usu = dao.getById(id);
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("frmUsuario.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("UsuarioControlador");
                case "view":
                    List<Usuario> lista = dao.getAll();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                    break;
                default:
                    break;

            }

        } catch (Exception ex) {
            System.out.println("ERROR EN CLIENTE_CONTROLADOR:" + ex.getMessage());
        }
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Usuario usu = new Usuario();
        usu.setId(id);
        usu.setEmail(email);
        usu.setPassword(password);
        UsuarioDAO dao = new UsuarioDAOimp();
        if (id == 0) {
            try {
                //nuevo registro
                dao.insert(usu);
                

            } catch (Exception ex) {
                System.out.println("ERros al insertar:" + ex.getMessage());
            }
        } else if (id != 0) {
            try {

                dao.update(usu);
               

            } catch (Exception ex) {
                System.out.println("ERROR_al editar:" + ex.getMessage());
            }
        }
        response.sendRedirect("UsuarioControlador");
      
    }

}
