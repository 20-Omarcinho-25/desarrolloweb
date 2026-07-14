package pe.edu.sistema.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.sistema.dto.UsuarioDTO;
import pe.edu.sistema.facade.UsuarioFacade;

@WebServlet(name = "EstudianteServlet", urlPatterns = {"/estudiante"})
public class EstudianteServlet extends HttpServlet {

    // 1. doGet: Encargado de consultar la BD y mostrar la tabla en listar.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsuarioFacade facade = new UsuarioFacade();
            
            // Obtenemos la lista de estudiantes desde MySQL
            List<UsuarioDTO> lista = facade.listarEstudiantes(); 
            // NOTA: Si tu método en el Facade se llama listarUsuarios(), cámbialo aquí a facade.listarUsuarios();
            
            // Enviamos la lista al JSP exactamente con el nombre que declaraste en el <c:forEach>
            request.setAttribute("listaEstudiantes", lista);
            
            // Renderizamos la vista de listado
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=true");
        }
    }

    // 2. doPost: Procesa el formulario de registro y redirige al listado
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");

        // Encapsular en el DTO
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNombre(nombre);
        dto.setCorreo(email);

        // Guardar en MySQL
        UsuarioFacade facade = new UsuarioFacade();
        facade.registrarUsuario(dto);

        // PATRÓN PRG (Post-Redirect-Get):
        // En lugar de hacer forward aquí, redirigimos hacia el doGet ("/estudiante") de este mismo Servlet.
        // Esto consulta la tabla recién actualizada en la BD y evita que al pulsar F5 en el navegador se duplique el registro.
        response.sendRedirect("estudiante");
    }
}