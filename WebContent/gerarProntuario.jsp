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
	<title>Gerar prontuário</title>
</head>
<body>
	<%@include file="headerSistema.jsp"%>
 	<div class="container-fluid">
      <div class="row">      
        <%@include file="barraLateral.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
	      <div class="table-responsive mt-3">
            <table class="table table-striped table-sm text-center">
              <thead>
                <tr>
                  <th>Id Prontuario</th>
                  <th>Cpf do dono</th>
                  <th>Nome Animal</th>
                  <th>Data Atendimento</th>
                  <th>Relatorio</th>
                </tr>
              </thead>
              <tbody>
                <%
				List listaIdProntuarios = (List)session.getAttribute("idProntuarios");
  				List listaIdAnimaisProntuarios = (List)session.getAttribute("idAnimaisProntuarios");
  				List listaDataAtendimentos = (List)session.getAttribute("dataAtendimentos");
  				
  				List listaIdAnimais = (List)session.getAttribute("idAnimais");
  				List listaNomeAnimais = (List)session.getAttribute("nomeAnimais");
  				List listaCpfClientesAnimais = (List)session.getAttribute("cpfClientesAnimais");
  				
  				for(int i = 0; i < listaIdProntuarios.size(); i++) {
  					String idProntuario = listaIdProntuarios.get(i).toString();
  					String idAnimalProntuario = listaIdAnimaisProntuarios.get(i).toString();
  					String dataAtendimento = listaDataAtendimentos.get(i).toString();
					for(int j = 0; j < listaIdAnimais.size(); j++){
						String idAnimal = listaIdAnimais.get(j).toString();
						if(idAnimalProntuario.equals(idAnimal)){					
  							String nomeAnimal = listaNomeAnimais.get(j).toString();
    						String cpfCliente = listaCpfClientesAnimais.get(j).toString();
 				%>
 				<tr>
                  <td><%=idProntuario%></td>
                  <td><%=cpfCliente%></td>
                  <td><%=nomeAnimal%></td>
                  <td><%=dataAtendimento%></td>                  
                  <td><button type="button" class="btn btn-secondary"><a href="Prontuario.do?acao=gerar&idProntuario=<%=idProntuario%>">Gerar</a></button></td> 
				</tr>															
 				<% }}} //fecha for
				%>
               
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