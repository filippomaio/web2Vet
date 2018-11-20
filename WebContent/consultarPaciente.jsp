<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- icon de patinhas lá de cima -->
	<link rel=" icon" href="bootstrap/favicon.ico"  type="image/x-icon">
	<link rel=" shortcut icon" href="bootstrap/favicon.ico"  type="image/x-icon">
	<title>Consultar</title>
</head>
<body>
	<%@include file="headerSistema.jsp"%>
 	<div class="container-fluid">
      <div class="row">      
        <%@include file="barraLateral.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Consulta</h1>
          </div>
            <form action="Prontuario.do" method="POST"> 
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" placeholder="Nome do animal" name="nome" id="nomeAnimalConPaciente" required>                  
                  <span class="errorText" id="errorNomeAnimalConPaciente"></span>
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" placeholder="CPF do dono" data-mask="000.000.000-00" id="cpfDonoConPaciente" name="cpfCliente" required>                  
                  <span class="errorText" id="errorCPFDonoConPaciente"></span>
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" placeholder="Motivo da consulta" id="motivoConPaciente" name="motivo" required>                
                  <span class="errorText" id="errorMotivoConPaciente"></span>
                </div>
                <div class="form-label-group mt-3">
                  <label for="tratamento">Tratamento:</label>
                  <textarea class="form-control" id="tratamentoConPaciente" rows="3" name="tratamento" required></textarea>
                  <span class="errorText" id="errorTratamentoConPaciente"></span>
                </div>
                <label class="mt-3" for="tratamento">Data do retorno:</label>
                <div class="input-group form-group">
                  <input type="date" class="form-control" id="dataRetornoConPaciente" name="dataRetorno" required>                  
                  <span class="errorText" id="errorRetornoConPaciente"></span>
                </div> 
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="matriculaProfessorConPaciente" placeholder="Matrícula do professor responsável" name="matriculaProf" required>                 
                  <span class="errorText" id="errorMatriculaProfessorConPaciente"></span>
                </div>  
                <br>
                <div class="mensagens_erros">
                	 ${message}
                </div>   
                <div class="form-label-group mt-3">
                  <input type="submit" value="Salvar" id="consultarPaciente" class="btn btn-lg btn btn-dark">
                  <span class="errorText" id="errorSubmitConsultarPaciente"></span>
                </div>
          	</form>
          
          
        </main>
      </div>
    </div>
    
    
    <!-- Bootstrap  JavaScript aqui -->
    <!-- Obs.: a gente bota aqui em baixo pra carregar mais rápido -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="bootstrap/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="bootstrap/assets/js/vendor/popper.min.js"></script>
    <script src="bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bootstrap/dist/js/mask.min.js"></script>
    <script src="js/validadorConPaciente.js"></script>
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    <script>
      feather.replace()
    </script>

</body>
</html>