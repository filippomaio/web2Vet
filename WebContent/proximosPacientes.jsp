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
	<title>Pr�ximos Pacientes</title>
</head>
<body>
	<%@include file="headerSistema.jsp"%>
 	<div class="container-fluid">
      <div class="row">      
        <%@include file="barraLateral.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Pr�ximos Pacientes</h1>
          </div>
          <div class="table-responsive">
            <table class="table table-striped table-sm text-center">
              <thead>
                <tr>
                  <th>Nome do animal</th>
                  <th>�ltimo atendimento</th>
                  <th>Pr�ximo atendimento</th>
                  <th>Prontu�rio</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Amora</td>
                  <td>12/10/2018</td>
                  <td>29/11/2018</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td>
                </tr>
                <tr>
                  <td>Astolfo</td>
                  <td>13/10/2018</td>
                  <td>01/12/2018</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td>
                </tr>
                <tr>
                  <td>Berlim</td>
                  <td>15/10/2018</td>
                  <td>02/12/2018</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td>                
                </tr>
                <tr>
                  <td>Cebolinha</td>
                  <td>16/10/2018</td>
                  <td>03/12/2018</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td>
                </tr>            
                <tr>
                  <td>Nutellinha</td>
                  <td>16/10/2018</td>
                  <td>05/12/2018</td>
                  <td><button type="button" class="btn btn-secondary"><a href="">Visualizar</a></button></td>  
                </tr>
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