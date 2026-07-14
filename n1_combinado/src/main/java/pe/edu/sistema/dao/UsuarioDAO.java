// ============================================================
// 1) UsuarioDAO.java — agrega el contrato buscarPorId
// ============================================================
package pe.edu.sistema.dao;

import pe.edu.sistema.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioDAO {
    public void agregar(UsuarioDTO u);
    public List<UsuarioDTO> listar();
    public void actualizar(UsuarioDTO u);
    public void eliminar(int id);

    // NUEVO: necesario para GET /activos/{id} y para validar existencia
    // antes de PUT/DELETE (permite responder 404 correctamente)
    public UsuarioDTO buscarPorId(int id);
}