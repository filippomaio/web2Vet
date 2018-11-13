<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>nav do sistema aqui</title>
	<!-- Bootstrap CSS / NÃO PODE MUDAR ISSO, BIA -->
	<link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Obs.: baixar fontawesome e mudar isso dps-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous">
	<!-- Pra ver se para de dar erro -->
	
	
	<!-- Nossas coisinhas aqui -->
	<link href="css/sistema.css" rel="stylesheet">
</head>
<body>

 	 <nav class="col-md-2 d-none d-md-block bg-light sidebar"><br><br><br>
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="bem_vindo.jsp">
                  <span data-feather="home"></span>
                  Início
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="cadastrarPaciente.jsp">
                  <span data-feather="plus"></span>
                  Cadastrar paciente
                </a>
              </li>   
              <li class="nav-item">
                <a class="nav-link" href="consultarPaciente.jsp">
                  <span data-feather="file"></span>
                  Consultar paciente
                </a>
              </li>          
              <li class="nav-item">
                <a class="nav-link" href="cadastrarDono.jsp">
                  <span data-feather="user-plus"></span>
                  Cadastrar dono
                </a>
              </li>
              
            </ul>
            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-2 mb-1 text-muted">
              <span>Gerenciar</span>
            </h6>
            <ul  class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link" href="gerenciarPaciente.jsp">
                  <span data-feather="settings"></span>
                  Pacientes
                </a>
              </li>    
              <li class="nav-item">
                <a class="nav-link" href="gerenciarDono.jsp">
                  <span data-feather="settings"></span>
                  Donos
                </a>
              </li>             
            </ul>
            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-2 mb-1 text-muted">
              <span>Prontuários</span>
            </h6>
            <ul class="nav flex-column mb-2">
              <li class="nav-item">
                <a class="nav-link" href="gerarProntuario.html">
                  <span data-feather="file-text"></span>
                  Gerar prontuário
                </a>
              </li>
            </ul>
            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-2 mb-1 text-muted">
              <span>Relatórios</span>
            </h6>
            <ul class="nav flex-column mb-2">
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Meus relatórios
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Próximos pacientes
                </a>
              </li>
            </ul>
          </div>
    </nav>

 	<!-- Bootstrap  JavaScript aqui -->
    <!-- Obs.: a gente bota aqui em baixo pra carregar mais rápido -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="bootstrap/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="bootstrap/assets/js/vendor/popper.min.js"></script>
    <script src="bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    <script>
      feather.replace()
    </script>

</body>
</html>