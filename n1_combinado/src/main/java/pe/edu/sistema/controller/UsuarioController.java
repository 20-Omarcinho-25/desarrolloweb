package pe.edu.sistema.controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.sistema.dto.UsuarioDTO;
import pe.edu.sistema.facade.UsuarioFacade;
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {
UsuarioFacade facade = new UsuarioFacade();
protected void processRequest(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
String nombre = request.getParameter("txtNombre");
String correo = request.getParameter("txtCorreo");
UsuarioDTO dto = new UsuarioDTO();
dto.setNombre(nombre);
dto.setCorreo(correo);
facade.registrarUsuario(dto);
response.sendRedirect("index.jsp ?mensaje=ok");
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}
}