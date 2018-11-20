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
	<title>Cadastro Dono</title>
</head>
<body>
	<%@include file="headerSistema.jsp"%>
 	<div class="container-fluid">
      <div class="row">      
        <%@include file="barraLateral.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Cadastrar Dono</h1>
          </div>
            <form action="Cliente.do" method="POST"> 
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="nomeDonoCadDono" placeholder="Nome completo" name="nome">                  
                  <span class="errorText" id="errorNomeDonoCadDono"></span>
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="cpfDonoCadDono" data-mask="000.000.000-00" placeholder="CPF" name="cpf">                  
                  <span class="errorText" id="errorCPFDonoCadDono"></span>
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="enderecoDonoCadDono" placeholder="Endereço" name="endereco">                 
                  <span class="errorText" id="errorEnderecoDonoCadDono"></span>
                </div>
                <div class="form-label-group mt-3">
                  <input type="text" class="form-control" id="telefoneDonoCadDono" placeholder="Telefone">                  
                  <span class="errorText" id="errorTelefoneDonoCadDono"></span>
                </div>               
                <br>
               <div class="mensagens_erros">
                	 ${message}
               </div> 
                <div class="form-label-group mt-3">
                  <input type="submit" value="Cadastrar" id="CadastroDono" class="btn btn-lg btn btn-dark">
                  <span class="errorText" id="errorSubmitCadDono"></span>
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
    <script src="js/validadorCadCliente.js"></script>
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    <script>
      feather.replace()
    </script>

</body>
</html>