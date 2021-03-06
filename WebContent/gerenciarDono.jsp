<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- icon de patinhas l� de cima -->
	<link rel=" icon" href="bootstrap/favicon.ico"  type="image/x-icon">
	<link rel=" shortcut icon" href="bootstrap/favicon.ico"  type="image/x-icon">
	<title>Donos</title>
</head>
<body>
	<%@include file="headerSistema.jsp"%>
 	<div class="container-fluid">
      <div class="row">      
        <%@include file="barraLateral.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Donos</h1>
          </div>
          <div class="table-responsive">
            <table class="table table-striped table-sm text-center">
              <thead>
                <tr>
                  <th>Nome</th>
                  <th>CPF</th>
                  <th>Animais</th>
                  <th>Editar</th>
                  <th>Remover</th>
                </tr>
              </thead>
              <tbody>
              	<%
				List listaIdCliente = (List)session.getAttribute("idClientes");
  				List listaNomeCliente = (List)session.getAttribute("nomeClientes");
  				List listaCpfCliente = (List)session.getAttribute("cpfClientes");
  				for(int i = 0; i < listaIdCliente.size(); i++) {
  					String idCliente = listaIdCliente.get(i).toString();
  					String nomeCliente = listaNomeCliente.get(i).toString();
    				String cpfCliente = listaCpfCliente.get(i).toString();
 				%>
 				<tr>
                  <td><%=nomeCliente%></td>
                  <td><%=cpfCliente%></td>
                  <td><button type="button" class="btn btn-secondary"><a href="Animal.do?acao=visualizarAnimalByDono&idCliente=<%=idCliente%>">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="Cliente.do?acao=editar&idCliente=<%=idCliente%>">Editar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="Cliente.do?acao=remover&idCliente=<%=idCliente%>">Remover</a></button></td> 
                </tr>															
 				<% } //fecha for
				%>              
              </tbody>
            </table>
          </div>          
          
        </main>
      </div>
    </div>
    
    
    <!-- Bootstrap  JavaScript aqui -->
    <!-- Obs.: a gente bota aqui em baixo pra carregar mais r�pido -->
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