<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- icon de patinhas lá de cima -->
<link rel=" icon" href="bootstrap/favicon.ico" type="image/x-icon">
<link rel=" shortcut icon" href="bootstrap/favicon.ico"
	type="image/x-icon">
<title>Notificacoes</title>
</head>
<body>
	<%@include file="headerSistema.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="barraLateral.jsp"%>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
			<div
				class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
				<h1 class="h2">Notificacoes</h1>
			</div>
			<div class="table-responsive">
				<table class="table table-striped table-sm text-center">
					<thead>
						<tr>
							<th>Id Prontuario</th>
							<th>Animal</th>
							<th>Aluno</th>
							<th>Motivo</th>
							<th>Tratamento</th>
							<th>Data Atendimento</th>
							<th>Data Retorno</th>
							<th>Aprovar</th>
						</tr>
					</thead>
					<tbody>
						<%
							//Prontuario
							List listaIdProntuarios = (List) session.getAttribute("idProntuarios");
							List listaIdAnimaisProntuarios = (List) session.getAttribute("idAnimaisProntuarios");
							List listaCpfAlunosProntuarios = (List) session.getAttribute("cpfAlunosProntuarios");
							List listaCpfProfessoresProntuarios = (List) session.getAttribute("cpfProfessoresProntuarios");
							List listaMotivoProntuarios = (List) session.getAttribute("motivos");
							List listaTratamentoProntuarios = (List) session.getAttribute("tratamentos");
							List listaDataAtendimentos = (List) session.getAttribute("dataAtendimentos");
							List listaDataRetornos = (List) session.getAttribute("dataRetornos");
							List listaAprovados = (List) session.getAttribute("aprovados");

							//Animal
							List listaIdAnimal = (List) session.getAttribute("idAnimais");
							List listaNomeAnimal = (List) session.getAttribute("nomeAnimais");
							List listaTipoAnimal = (List) session.getAttribute("tipoAnimais");
							List listaCorAnimal = (List) session.getAttribute("corAnimais");
							List listaIdadeAnimal = (List) session.getAttribute("idadeAnimais");
							List listaCpfClienteAnimal = (List) session.getAttribute("cpfClientesAnimais");

							//Cliente
							List listaIdCliente = (List) session.getAttribute("idClientes");
							List listaNomeCliente = (List) session.getAttribute("nomeClientes");
							List listaCpfCliente = (List) session.getAttribute("cpfClientes");

							//Medico
							List listaIdMedico = (List) session.getAttribute("idMedicos");
							List listaNomeMedico = (List) session.getAttribute("nomeMedicos");
							List listaCpfMedico = (List) session.getAttribute("cpfMedicos");

							String nomeAnimal = "";
							String nomeAluno = "";
							String eu = session.getAttribute("MeuCPF").toString();
							for (int i = 0; i < listaIdProntuarios.size(); i++) {
								if (listaAprovados.get(i).toString().equals("0")) {
									if(listaCpfProfessoresProntuarios.get(i).toString().equals(eu)){
									String idProntuario = listaIdProntuarios.get(i).toString();
									String idAnimalProntuario = listaIdAnimaisProntuarios.get(i).toString();
									String motivo = listaMotivoProntuarios.get(i).toString();
									String tratamento = listaTratamentoProntuarios.get(i).toString();
									String dataAtendimento = listaDataAtendimentos.get(i).toString();
									String dataRetorno = listaDataRetornos.get(i).toString();
									//Buscar Animal
									for (int j = 0; j < listaIdAnimal.size(); j++) {
										String idAnimal = listaIdAnimal.get(j).toString();
										if (idAnimalProntuario.equals(idAnimal)) {
											nomeAnimal = listaNomeAnimal.get(j).toString();
										}
									}
									//Buscar Aluno
									String cpfAlunosProntuario = listaCpfAlunosProntuarios.get(i).toString();
									for (int j = 0; j < listaIdMedico.size(); j++) {
										String cpfAluno = listaCpfMedico.get(j).toString();
										if (cpfAluno.equals(cpfAlunosProntuario)) {
											nomeAluno = listaNomeMedico.get(j).toString();
										}
									}
						%>
						<tr>
							<td><%=idProntuario%></td>
							<td><%=nomeAnimal%></td>
							<td><%=nomeAluno%></td>
							<td><%=motivo%></td>
							<td><%=tratamento%></td>
							<td><%=dataAtendimento%></td>
							<td><%=dataRetorno%></td>
							<td><button type="button" class="btn btn-secondary">
									<a
										href="Prontuario.do?acao=aprovar&idProntuario=<%=idProntuario%>">OK</a>
								</button></td>
						</tr>
						<%
							}
							}} //fecha for
						%>
					</tbody>
				</table>
			</div>

			</main>
		</div>
	</div>


	<!-- Bootstrap  JavaScript aqui -->
	<!-- Obs.: a gente bota aqui em baixo pra carregar mais rápido -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="bootstrap/assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script src="bootstrap/assets/js/vendor/popper.min.js"></script>
	<script src="bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
	<script>
		feather.replace()
	</script>

</body>
</html>