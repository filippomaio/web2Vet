<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>header do sistema aqui</title>
	<!-- Bootstrap CSS / NÃO PODE MUDAR ISSO, BIA -->
	<link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Obs.: baixar fontawesome e mudar isso dps-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous">	
	<!-- Nossas coisinhas aqui -->
	<link href="css/sistema.css" rel="stylesheet">
</head>
<body>

 <nav  class="navbar navbar-light fixed-top bg-dark flex-md-nowrap p-0 shadow" >
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#" style="background-color: black;">
        <img src="imagens/HOSPITAL2.png" width="200" height="35" class="d-inline-block align-top" alt="">
      </a> 
      <div class="btn-group botao_drop">
        <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <span data-feather="user"></span>Minha conta
        </button>
        <div class="dropdown-menu dropdown-menu-right">
            <a class="dropdown-item" href="#"></a>
            <a class="dropdown-item" href="notificacoes.jsp"><span data-feather="settings"></span>Notificações</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="login.jsp"><span data-feather="log-out"></span>Sair</a>
        </div>
      </div>     
 </nav>

 	<!-- Bootstrap  JavaScript aqui -->
    <!-- Obs.: a gente bota aqui em baixo pra carregar mais rápido -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="bootstrap/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="bootstrap/assets/js/vendor/popper.min.js"></script>
    <script src="bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bootstrap/dist/js/mask.min.js"></script>
    <script src="js/validador.js"></script>
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    <script>
      feather.replace()
    </script>

</body>
</html>