<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- icon de patinhas l� de cima -->
	<link rel=" icon" href="bootstrap/favicon.ico"  type="image/x-icon">
	<link rel=" shortcut icon" href="bootstrap/favicon.ico"  type="image/x-icon">
	<title>Editar Paciente</title>
</head>
<body>
	<%@include file="headerSistema.jsp"%>
 	<div class="container-fluid">
      <div class="row">      
        <%@include file="barraLateral.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Editar Animal</h1>
          </div>
           <form action="Animal.do?acao=editar" method="POST"> 
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="nomeAnimalCadPaciente" value="<%=session.getAttribute("idAnimalEditar")%>" disabled>                  
                  <input type="hidden" name="idAnimal" id="demo-name" value="<%=session.getAttribute("idAnimalEditar")%>"/>
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="nomeAnimalCadPaciente" name="nome" value="<%=session.getAttribute("nomeAnimalEditar")%>">                  
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="idadeAnimalCadPaciente" data-mask="00" name="idade" value="<%=session.getAttribute("idadeAnimalEditar")%>">                  
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="tipoAnimalCadPaciente" name="tipo" value="<%=session.getAttribute("tipoAnimalEditar")%>">                 
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="corAnimalCadPaciente" name="cor" value="<%=session.getAttribute("corAnimalEditar")%>">                  
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="cpfClienteAnimalCadPaciente" name="cpfCliente" value="<%=session.getAttribute("cpfClienteAnimalEditar")%>">                  
                </div><br>
                <div class="mensagens_erros">
                	 ${message}
                </div>               
                <div class="form-label-group mt-3">
                  <input type="submit" value="Editar" id="cadastroPaciente" class="btn btn-lg btn btn-dark">
                </div>
           </form>
          
        </main>
      </div>
    </div>
    
    
    <!-- Bootstrap  JavaScript aqui -->
    <!-- Obs.: a gente bota aqui em baixo pra carregar mais r�pido -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="bootstrap/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="bootstrap/assets/js/vendor/popper.min.js"></script>
    <script src="bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bootstrap/dist/js/mask.min.js"></script>
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    
    <script>
      feather.replace()
    </script>

</body>
</html>