// ============================================================
// 2) UsuarioDAOImpl.java — implementa buscarPorId y propaga errores
//    En vez de tragar la SQLException con System.out.println,
//    la relanzamos como RuntimeException para que el controller
//    pueda capturarla y devolver 500/404 según corresponda.
// ============================================================
package pe.edu.sistema.dao;

import pe.edu.sistema.conexion.dbConexion;
import pe.edu.sistema.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    dbConexion con = new dbConexion();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void agregar(UsuarioDTO u) {
        String sql = "INSERT INTO usuario(nombre,correo) VALUES(?,?)";
        try {
            cn = con.conectar();
            ps = cn.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.executeUpdate();
        } catch (SQLException e) {
            // Propagamos el error: el controller REST necesita saber
            // que la operación falló para responder con el código HTTP correcto
            throw new RuntimeException("Error al registrar usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public List<UsuarioDTO> listar() {
        List<UsuarioDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            cn = con.conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioDTO dto = new UsuarioDTO();
                dto.setId(rs.getInt("id"));
                dto.setNombre(rs.getString("nombre"));
                dto.setCorreo(rs.getString("correo"));
                lista.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar usuarios: " + e.getMessage(), e);
        }
        return lista;
    }

    // NUEVO: busca un solo registro por id. Retorna null si no existe,
    // el Facade/Controller decide qué código HTTP corresponde (200 vs 404)
    @Override
    public UsuarioDTO buscarPorId(int id) {
        String sql = "SELECT * FROM usuario WHERE id=?";
        try {
            cn = con.conectar();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                UsuarioDTO dto = new UsuarioDTO();
                dto.setId(rs.getInt("id"));
                dto.setNombre(rs.getString("nombre"));
                dto.setCorreo(rs.getString("correo"));
                return dto;
            }
            return null; // No encontrado
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public void actualizar(UsuarioDTO u) {
        String sql = "UPDATE usuario SET nombre=?, correo=? WHERE id=?";
        try {
            cn = con.conectar();
            ps = cn.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setInt(3, u.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id=?";
        try {
            cn = con.conectar();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar usuario: " + e.getMessage(), e);
        }
    }
}