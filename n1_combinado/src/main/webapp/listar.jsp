<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro Exitoso</title>
    <style>
        *{ margin:0; padding:0; box-sizing:border-box; font-family:'Segoe UI',sans-serif; }
        body{
            background: linear-gradient(rgba(15,23,42,0.80),rgba(15,23,42,0.80)), url('img/estudiantes.jpg');
            background-size:cover; background-position:center; background-attachment:fixed;
            display:flex; justify-content:center; align-items:center; height:100vh;
        }
        .success-box{
            width:450px; background:rgba(255,255,255,0.10); backdrop-filter:blur(12px);
            border-radius:25px; padding:45px; text-align:center;
            box-shadow:0 10px 40px rgba(0,0,0,0.4); border:1px solid rgba(255,255,255,0.1);
        }
        .icon{ font-size:70px; margin-bottom:20px; }
        .success-box h1{ color:white; margin-bottom:15px; font-size:34px; }
        .success-box p{ color:#d1fae5; line-height:1.8; margin-bottom:30px; font-size:16px; }
        .datos{
            background:rgba(255,255,255,0.08); border-radius:15px;
            padding:20px; margin-bottom:30px; text-align:left;
        }
        .datos h3{ color:#4ade80; margin-bottom:12px; }
        .datos span{ color:white; display:block; margin-bottom:10px; }
        .btn{
            display:inline-block; width:100%; padding:15px; background:#22c55e;
            color:white; text-decoration:none; border-radius:12px; font-weight:bold; transition:0.3s;
        }
        .btn:hover{ background:#16a34a; transform:translateY(-3px); }
    </style>
</head>
<body>
    <div class="success-box">
        <div class="icon">✅</div>
        <h1>Registro Exitoso</h1>
        <p>El estudiante ha sido registrado correctamente en el sistema academico Sidereum Lacertae y guardado en la base de datos.</p>
        <div class="datos">
            <h3>Informacion Registrada</h3>
            <span>Nombre: ${nombre}</span>
            <span>Correo: ${email}</span>
        </div>
        <a href="registrar.jsp" class="btn">Registrar otro estudiante</a>
        <br><br>
        <a href="index.jsp" style="color:#d1fae5; text-decoration:none;">Volver al Inicio</a>
    </div>
</body>
</html>
