<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- icon de patinhas lá de cima -->
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
          <form action="Cliente.do?acao=gerenciar" method="POST">
			<select id="Clientes" name="Clientes">
			<%
			List listaIdCliente = (List)session.getAttribute("idClientes");
  			List listaCpf = (List)session.getAttribute("cpfClientes");
  			List listaNomeCliente = (List)session.getAttribute("nomeClientes");
  			for(int i = 0; i < listaIdCliente.size(); i++) {
  				String id = listaIdCliente.get(i).toString();
  				String cpf = listaCpf.get(i).toString();
    			String nome = listaNomeCliente.get(i).toString();
 			%>
			<option value=<%=id%>> <%=nome%> - <%=cpf%> </option>																
 			<% } //fecha for
			%>
			</select><br>
			<input type="submit" value="Gerenciar" name="btnGerenciar">
		  </form>
		  <button name="btnVisualizarAnimais">Visualizar Animais</button>
          <div class="table-responsive">
            <table class="table table-striped table-sm text-center">
              <thead>
                <tr>
                  <th>Nome</th>
                  <th>Idade </th>
                  <th>Tipo </th>
                  <th>Cor </th>
                  <th>Gerenciar</th>
                </tr>
              </thead>
              <tbody>
              	                
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