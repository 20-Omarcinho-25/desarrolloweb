// ============================================================
// 5) ActivoResource.java — REFACTORIZADO COMPLETO
//    Ahora sí cubre 200, 201, 400 y 404 de forma semántica
// ============================================================
package com.mycompany.n1.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.sistema.dto.UsuarioDTO;
import pe.edu.sistema.facade.UsuarioFacade;
import java.util.List;

/**
 * REST Controller para la API RESTful de la Unidad 4.
 *
 * @RestController: combina @Controller + @ResponseBody -> serializa
 *                   automáticamente los objetos de retorno a JSON (Jackson)
 * @RequestMapping: fija la ruta base /activos para todos los endpoints
 */
@RestController
@RequestMapping("/activos")
public class ActivoResource {

    // Se reutiliza el patrón Facade/DAO clásico (instanciación directa,
    // SIN Spring Data JPA ni @Autowired sobre repositorios)
    private UsuarioFacade facade = new UsuarioFacade();

    // --------------------------------------------------------
    // 1. GET /activos -> Lista todos los activos
    // Código HTTP: 200 OK siempre que la consulta se ejecute (aunque
    // la lista esté vacía, una colección vacía SIGUE siendo 200 OK
    // según la semántica REST correcta; 404 aquí sería incorrecto)
    // --------------------------------------------------------
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerActivos() {
        List<UsuarioDTO> lista = facade.listarEstudiantes();
        return ResponseEntity.ok(lista);
    }

    // --------------------------------------------------------
    // 1.1 GET /activos/{id} -> Obtener UN activo puntual
    // NUEVO ENDPOINT. Buena práctica: si no existe, 404 Not Found;
    // si existe, 200 OK con el recurso
    // --------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerActivoPorId(@PathVariable int id) {
        UsuarioDTO activo = facade.buscarActivoPorId(id);
        if (activo == null) {
            // 404 Not Found: el recurso solicitado no existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("Activo con ID " + id + " no encontrado"));
        }
        return ResponseEntity.ok(activo);
    }

    // --------------------------------------------------------
    // 2. POST /activos -> Crear un nuevo activo
    // Buena práctica: POST es no-idempotente, se usa exclusivamente
    // para creación (nunca para actualizar, eso violaría la semántica HTTP)
    // Código HTTP: 201 Created si es válido, 400 Bad Request si no
    // --------------------------------------------------------
    @PostMapping
    public ResponseEntity<?> crearActivo(@RequestBody UsuarioDTO nuevoActivo) {
        // Validación de entrada -> soporta el 400 Bad Request de la rúbrica
        if (!facade.esActivoValido(nuevoActivo)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Datos inválidos: 'nombre' y 'correo' son obligatorios"));
        }
        try {
            facade.registrarEstudiante(nuevoActivo);
            // 201 Created: se usa SIEMPRE que se crea un recurso nuevo,
            // nunca 200 OK, para diferenciar semánticamente "creado" de "leído"
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoActivo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Error al crear el activo: " + e.getMessage()));
        }
    }

    // --------------------------------------------------------
    // 3. PUT /activos/{id} -> Actualizar un activo existente
    // Buena práctica: PUT reemplaza el recurso completo e ídempotente
    // Código HTTP: 200 OK si existía y se actualizó, 404 si no existía,
    // 400 si el body es inválido
    // --------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarActivo(
            @PathVariable int id,
            @RequestBody UsuarioDTO activoActualizado) {

        if (!facade.esActivoValido(activoActualizado)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Datos inválidos: 'nombre' y 'correo' son obligatorios"));
        }

        // Verificamos existencia ANTES de actualizar -> permite 404 real
        UsuarioDTO existente = facade.buscarActivoPorId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("No se puede actualizar: Activo con ID " + id + " no existe"));
        }

        activoActualizado.setId(id);
        facade.actualizarEstudiante(activoActualizado);
        return ResponseEntity.ok(activoActualizado);
    }

    // --------------------------------------------------------
    // 4. DELETE /activos/{id} -> Eliminar un activo
    // Buena práctica: DELETE es ídempotente (eliminar 2 veces el mismo
    // id produce el mismo estado final: recurso ausente)
    // Código HTTP: 200 OK si existía y se eliminó, 404 si nunca existió
    // --------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> eliminarActivo(@PathVariable int id) {
        UsuarioDTO existente = facade.buscarActivoPorId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("Activo con ID " + id + " no existe"));
        }

        facade.eliminarEstudiante(id);
        // Objeto tipado en vez de String armado a mano: Jackson lo
        // serializa correctamente con Content-Type: application/json
        return ResponseEntity.ok(new ApiResponse("Activo con ID " + id + " eliminado correctamente"));
    }
}