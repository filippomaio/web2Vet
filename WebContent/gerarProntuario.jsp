<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- icon de patinhas lá de cima -->
	<link rel=" icon" href="bootstrap/favicon.ico"  type="image/x-icon">
	<link rel=" shortcut icon" href="bootstrap/favicon.ico"  type="image/x-icon">
	<title>Gerar prontuário</title>
</head>
<body>
	<% LoginController usuario = (LoginController)request.getAttribute("usuario");%>
	<%@include file="headerSistema.jsp"%>
 	<div class="container-fluid">
      <div class="row">      
        <%@include file="barraLateral.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h4">Digite o nome do animal </h1>
          </div>
           <form class="form-inline">
		        <div class="input-group">
		          <input type="text" class="form-control col-xs-4"  placeholder="" aria-label="pesquisar" aria-describedby="pesquisar">
		          <div class="input-group-prepend">
		            <span class="input-group-text" id="pesquisa"><span data-feather="search"></span></span>
		          </div>
		        </div>
	      </form> 
	      <div class="table-responsive mt-3">
            <table class="table table-striped table-sm text-center">
              <thead>
                <tr>
                  <th>Nome do animal</th>
                  <th>Cpf do dono</th>
                  <th>Código do prontuário</th>
                  <th>Prontuário </th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Nutellinha</td>
                  <td>16301178700</td>
                  <td>0001</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td>
                </tr>
               
              </tbody>
            </table>
          </div>       
        </main>
      </div>
    </div>
    
    
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