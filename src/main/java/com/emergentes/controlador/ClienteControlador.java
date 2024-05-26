package com.emergentes.controlador;
import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimp;
import com.emergentes.modelo.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ClienteDAO dao = new ClienteDAOimp();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            Cliente cli = new Cliente();
            switch (action) {
                case "add":
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmCliente.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cli = dao.getById(id);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmCliente.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ClienteControlador");
                case "view":
                    List<Cliente> lista = dao.getAll();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
                    break;
                default:
                    break;

            }

        } catch (Exception ex) {
            System.out.println("ERROR EN CLIENTE_CONTROLADOR:" + ex.getMessage());
        }
    }
//do post sirver para guardar los datos

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String celular = request.getParameter("celular");
        Cliente cli = new Cliente();
        cli.setId(id);
        cli.setNombre(nombre);
        cli.setCorreo(correo);
        cli.setCelular(celular);
        ClienteDAO dao = new ClienteDAOimp();
        if (id == 0) {
            try {
                //nuevo registro
                dao.insert(cli);
                

            } catch (Exception ex) {
                System.out.println("ERros al insertar:" + ex.getMessage());
            }
        } else if (id != 0) {
            try {

                dao.update(cli);
               

            } catch (Exception ex) {
                System.out.println("ERROR_al editar:" + ex.getMessage());
            }
        }
        response.sendRedirect("ClienteControlador");

    }
}
