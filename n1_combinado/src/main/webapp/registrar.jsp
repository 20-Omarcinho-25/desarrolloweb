<!DOCTYPE html>
<html>
<head>
     <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sidereum Lacertae - Sistema Web</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
    
    
    <meta charset="UTF-8">
    <title>Registrar Estudiante</title>
    <style>
        *{ margin:0; padding:0; box-sizing:border-box; font-family:'Segoe UI',sans-serif; }
        body{
            background: linear-gradient(rgba(15,23,42,0.80),rgba(15,23,42,0.80)), url('img/estudiantes.jpg');
            background-size:cover; background-position:center; background-attachment:fixed;
            display:flex; justify-content:center; align-items:center; height:100vh;
        }
        .contenedor{
            width:420px; background:rgba(255,255,255,0.10); backdrop-filter:blur(12px);
            border-radius:25px; padding:40px; box-shadow:0 10px 40px rgba(0,0,0,0.4);
            border:1px solid rgba(255,255,255,0.1);
        }
        .contenedor h1{ color:white; text-align:center; margin-bottom:10px; font-size:32px; }
        .contenedor p{ color:#d1fae5; text-align:center; margin-bottom:35px; line-height:1.6; }
        .input-group{ margin-bottom:20px; }
        .input-group label{ display:block; color:white; margin-bottom:8px; font-size:15px; }
        .input-group input{
            width:100%; padding:14px; border:none; border-radius:12px; outline:none;
            background:rgba(255,255,255,0.15); color:white; font-size:15px;
        }
        .input-group input::placeholder{ color:#d1d5db; }
        .btn{
            width:100%; padding:15px; border:none; border-radius:12px;
            background:#22c55e; color:white; font-size:16px; font-weight:bold;
            cursor:pointer; transition:0.3s; margin-top:10px;
        }
        .btn:hover{ background:#16a34a; transform:translateY(-3px); }
        .volver{ display:block; text-align:center; margin-top:25px; color:#d1fae5; text-decoration:none; }
        .volver:hover{ color:white; }
    </style>
</head>
<body class="bg-dark text-light py-5">

    <div class="container" style="max-width: 600px;">
        <div class="card bg-white text-dark shadow-lg border-0 rounded-4">
            
            <div class="card-header bg-primary text-white text-center py-3 rounded-top-4">
                <h2 class="mb-0 fs-4">Registro de Nuevo Estudiante</h2>
            </div>

            <div class="card-body p-4 p-md-5">
                
            <form action="estudiante" method="post">
                    
                    <div class="mb-3">
                        <label for="nombre" class="form-label fw-bold">Nombre Completo:</label>
                        <input type="text" class="form-control form-control-lg" id="nombre" name="nombre" 
                               placeholder="Ej. Juan Pérez" required>
                    </div>

                    <div class="mb-4">
                        <label for="email" class="form-label fw-bold">Correo Electrónico:</label>
                        <input type="email" class="form-control form-control-lg" id="email" name="email" 
                               placeholder="ejemplo@utp.edu.pe" required>
                    </div>

                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-success btn-lg shadow-sm">
                            Registrar y Continuar
                        </button>
                    </div>
                    
                </form>

            </div>

            <div class="card-footer bg-light text-center py-3">
                <a href="index.jsp" class="text-decoration-none text-muted fw-semibold">
                    ? Volver a la Portada
                </a>
            </div>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
