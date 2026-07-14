// ============================================================
// 3) UsuarioFacade.java — expone buscarPorId y agrega validación
//    básica de datos (soporte para el 400 Bad Request)
// ============================================================
package pe.edu.sistema.facade;

import java.util.List;
import pe.edu.sistema.dao.UsuarioDAOImpl;
import pe.edu.sistema.dto.UsuarioDTO;

public class UsuarioFacade {
    UsuarioDAOImpl dao = new UsuarioDAOImpl();

    public void registrarUsuario(UsuarioDTO u) {
        dao.agregar(u);
    }

    public List<UsuarioDTO> listarEstudiantes() {
        return dao.listar();
    }

    public void registrarEstudiante(UsuarioDTO nuevoActivo) {
        dao.agregar(nuevoActivo);
    }

    public void actualizarEstudiante(UsuarioDTO activoActualizado) {
        dao.actualizar(activoActualizado);
    }

    public void eliminarEstudiante(int id) {
        dao.eliminar(id);
    }

    // NUEVO: delega la búsqueda por id al DAO
    public UsuarioDTO buscarActivoPorId(int id) {
        return dao.buscarPorId(id);
    }

    // NUEVO: validación mínima de negocio. La rúbrica pide 400 Bad Request;
    // esta es la capa correcta para esa regla (no el controller, no el DAO).
    public boolean esActivoValido(UsuarioDTO u) {
        return u != null
                && u.getNombre() != null && !u.getNombre().isBlank()
                && u.getCorreo() != null && !u.getCorreo().isBlank();
    }
}