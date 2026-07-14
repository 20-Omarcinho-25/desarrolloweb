<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sidereum Lacertae - Sistema Web</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
    
    <meta charset="UTF-8">
    <title>Sidereum Lacertae</title>
    <style>
        *{ margin:0; padding:0; box-sizing:border-box; font-family:'Segoe UI',sans-serif; }
        body{
            background: linear-gradient(rgba(15,23,42,0.75),rgba(15,23,42,0.75)), url('img/estudiantes.jpg');
            background-size:cover; background-position:center; background-attachment:fixed;
        }
        .navbar{
            width:100%; height:85px; background:rgba(255,255,255,0.08);
            backdrop-filter:blur(8px); display:flex; justify-content:space-between;
            align-items:center; padding:0 70px; border-bottom:1px solid rgba(255,255,255,0.1);
        }
        .logo{ font-size:30px; font-weight:bold; color:#dcfce7; }
        .menu a{ text-decoration:none; margin-left:35px; color:white; font-size:15px; transition:0.3s; }
        .menu a:hover{ color:#86efac; }
        .hero{
            min-height:calc(100vh - 85px); display:flex; justify-content:space-between;
            align-items:center; padding:80px 100px;
        }
        .hero-text{ width:55%; }
        .hero-text h1{ font-size:60px; color:white; line-height:1.2; margin-bottom:25px; }
        .hero-text p{ font-size:18px; color:#d1fae5; line-height:1.8; margin-bottom:35px; }
        .botones{ display:flex; gap:20px; }
        .btn{ padding:16px 30px; border-radius:12px; text-decoration:none; font-size:15px; font-weight:bold; transition:0.3s; }
        .btn-primary{ background:#22c55e; color:white; box-shadow:0 10px 20px rgba(34,197,94,0.3); }
        .btn-primary:hover{ background:#16a34a; transform:translateY(-4px); }
        .btn-secondary{ background:rgba(255,255,255,0.1); color:white; border:1px solid rgba(255,255,255,0.2); backdrop-filter:blur(5px); }
        .btn-secondary:hover{ background:rgba(255,255,255,0.2); }
        .hero-card{
            width:370px; background:rgba(255,255,255,0.12); backdrop-filter:blur(12px);
            border:1px solid rgba(255,255,255,0.1); border-radius:25px; padding:35px;
            box-shadow:0 10px 40px rgba(0,0,0,0.3); color:white;
        }
        .hero-card h3{ font-size:24px; margin-bottom:20px; }
        .hero-card p{ color:#dcfce7; margin-bottom:15px; line-height:1.8; }
        .info{ display:flex; justify-content:space-between; margin-top:30px; }
        .box{ text-align:center; }
        .box h2{ color:#4ade80; font-size:30px; margin-bottom:5px; }
        .box span{ color:#d1fae5; font-size:14px; }
    </style>
</head>
<body class="bg-dark text-light d-flex align-items-center justify-content-center" style="min-height: 100vh;">

    <div class="container" style="max-width: 500px;">
        <div class="card bg-secondary text-white shadow-lg border-0 rounded-4">
            <div class="card-body p-5 text-center">
                
                <h1 class="display-5 fw-bold mb-3">Sidereum Lacertae</h1>
                <p class="lead mb-4">Sistema de Gestión de Estudiantes y Desarrollo Web Integrado.</p>
                
                <div class="d-grid gap-2">
                    <a href="registrar.jsp" class="btn btn-primary btn-lg rounded-pill shadow">
                    Ingresar al Sistema   
                    </a>
                </div>
                
                <div class="d-grid gap-2 mt-3">
                    <a href="estudiante" class="btn btn-outline-light btn-lg rounded-pill">
                    Ver Lista de Estudiantes
                    </a>
                </div>
                
                
            </div>
        </div>
    </div>
    
    
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
