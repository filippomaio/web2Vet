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
                  <th>Cpf </th>
                  <th>Animais</th>
                  <th>Gerenciar</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Angelo</td>
                  <td>95429218866</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
                </tr>
                <tr>
                  <td>Agnes</td>
                  <td>16301178700</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
                </tr>
                <tr>
                  <td>Beatriz</td>
                  <td>16301178700</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
                </tr>
                <tr>
                  <td>Carla</td>
                  <td>13698978711</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
                </tr>
                <tr>
                  <td>Daniel</td>
                  <td>98859289800</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
                </tr>
                <tr>
                  <td>Filippo</td>
                  <td>000000000000</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
                </tr>
                <tr>
                  <td>Julia</td>
                  <td>11122233300</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
                </tr>
                <tr>
                  <td>Marcello</td>
                  <td>222333444555</td>                  
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
                </tr>
                <tr>
                  <td>Lucas</td>
                  <td>000000000000</td>                  
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
                </tr>
                <tr>
                  <td>Nathan</td>
                  <td>78722260633</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
                </tr>
                <tr>
                  <td>Paula</td>
                  <td>29217862200</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td> 
                  <td><button type="button" class="btn btn-secondary"><a href="">Gerenciar</a></button></td> 
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