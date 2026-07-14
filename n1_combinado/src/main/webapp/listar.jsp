<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Importación obligatoria de JSTL Core --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sidereum Lacertae - Estudiantes Registrados</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(rgba(15,23,42,0.85), rgba(15,23,42,0.85)), url('img/estudiantes.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            min-height: 100vh;
        }
        .glass-card {
            background: rgba(255, 255, 255, 0.10);
            backdrop-filter: blur(12px);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 20px;
        }
    </style>
</head>
<body class="text-white py-5">

    <div class="container">
        <div class="glass-card p-4 p-md-5 shadow-lg">
            
            <div class="text-center mb-4">
                <span class="fs-1">✅</span>
                <h1 class="fw-bold mt-2">Estudiantes Registrados</h1>
                <p class="text-success fw-semibold">Control de Activos y Estudiantes - Sidereum Lacertae</p>
            </div>

            <div class="table-responsive mt-4">
                <table class="table table-dark table-striped table-hover align-middle rounded-3 overflow-hidden">
                    <thead class="table-success text-dark">
                        <tr>
                            <th scope="col" class="py-3">ID</th>
                            <th scope="col" class="py-3">Nombre Completo</th>
                            <th scope="col" class="py-3">Correo Electrónico</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <%-- Evaluamos si la lista tiene elementos utilizando Expression Language (EL) --%>
                            <c:when test="${not empty listaEstudiantes}">
                                <%-- Iteración dinámica de la lista enviada por el Servlet --%>
                                <c:forEach var="estudiante" items="${listaEstudiantes}">
                                    <tr>
                                        <th scope="row" class="py-3">${estudiante.id}</th>
                                        <td class="py-3">${estudiante.nombre}</td>
                                        <td class="py-3">${estudiante.correo}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="3" class="text-center py-4 text-muted">
                                        No se encontraron estudiantes registrados en el sistema.
                                    </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>

            <div class="mt-4 d-flex flex-column flex-sm-row justify-content-center gap-3">
                <a href="registrar.jsp" class="btn btn-success px-4 py-2 rounded-pill fw-bold shadow">
                    ➕ Registrar Nuevo Estudiante
                </a>
                <a href="index.jsp" class="btn btn-outline-light px-4 py-2 rounded-pill fw-bold">
                    🏠 Volver a la Portada
                </a>
            </div>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>