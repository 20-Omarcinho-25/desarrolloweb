package pe.edu.sistema.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.sistema.dto.UsuarioDTO;
import pe.edu.sistema.facade.UsuarioFacade;

@WebServlet(name = "EstudianteServlet", urlPatterns = {"/estudiante"})
public class EstudianteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");

        // Guardar en MySQL
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNombre(nombre);
        dto.setCorreo(email);

        UsuarioFacade facade = new UsuarioFacade();
        facade.registrarUsuario(dto);

        // Pasar datos a listar.jsp para mostrarlos
        request.setAttribute("nombre", nombre);
        request.setAttribute("email", email);
        request.getRequestDispatcher("listar.jsp").forward(request, response);
    }
}
