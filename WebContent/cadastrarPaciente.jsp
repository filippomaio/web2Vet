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
	<title>Cadastro Paciente</title>
</head>
<body>
	<%@include file="headerSistema.jsp"%>
 	<div class="container-fluid">
      <div class="row">      
        <%@include file="barraLateral.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Cadastrar Animal</h1>
          </div>
           <form action="Animal.do?acao=cadastrar" method="POST"> 
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" placeholder="Nome do animal" id="nomeAnimalCadPaciente" name="nome">                  
                  <span class="errorText" id="errorNomeAnimalCadPaciente"></span>
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" placeholder="Idade do animal" id="idadeAnimalCadPaciente" data-mask="00" name="idade">                  
               	  <span class="errorText" id="errorIdadeAnimalCadPaciente"></span>
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" placeholder=" Tipo do animal" id="tipoAnimalCadPaciente" name="tipo">                 
                  <span class="errorText" id="errorTipoAnimalCadPaciente"></span>
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" placeholder=" Cor do animal" id="corAnimalCadPaciente" name="cor">                  
                  <span class="errorText" id="errorCorAnimalCadPaciente"></span>
                </div>               
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" placeholder="CPF do dono" id="cpfClienteCadPaciente" data-mask="000.000.000-00" name="cpfCliente">                 
                  <span class="errorText" id="errorCPFDonoCadPaciente"></span>
                </div><br>
                <div class="mensagens_erros">
                	 ${message}
                </div>               
                <div class="form-label-group mt-3">
                  <input type="submit" value="Cadastrar" id="cadastroPaciente" class="btn btn-lg btn btn-dark">
                  <span class="errorText" id="errorSubmitCadPaciente"></span>
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
    <script src="js/validadorCadPaciente.js"></script>
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    
    <script>
      feather.replace()
    </script>

</body>
</html>