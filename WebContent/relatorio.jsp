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
	<title>Relatorio</title>
</head>
<body>
<%
String idProntuarioGerar = session.getAttribute("idProntuarioGerar").toString();

//Prontuario
List listaIdProntuarios = (List)session.getAttribute("idProntuarios");
List listaIdAnimaisProntuarios = (List)session.getAttribute("idAnimaisProntuarios");
List listaCpfAlunosProntuarios = (List)session.getAttribute("cpfAlunosProntuarios");
List listaCpfProfessoresProntuarios = (List)session.getAttribute("cpfProfessoresProntuarios");
List listaMotivoProntuarios = (List)session.getAttribute("motivos");
List listaTratamentoProntuarios = (List)session.getAttribute("tratamentos");
List listaDataAtendimentos = (List)session.getAttribute("dataAtendimentos");
List listaDataRetornos = (List)session.getAttribute("dataRetornos");

//Animal
List listaIdAnimal = (List)session.getAttribute("idAnimais");
List listaNomeAnimal = (List)session.getAttribute("nomeAnimais");
List listaTipoAnimal = (List)session.getAttribute("tipoAnimais");
List listaCorAnimal = (List)session.getAttribute("corAnimais");
List listaIdadeAnimal = (List)session.getAttribute("idadeAnimais");
List listaCpfClienteAnimal = (List)session.getAttribute("cpfClientesAnimais");

//Cliente
List listaIdCliente = (List)session.getAttribute("idClientes");
List listaNomeCliente = (List)session.getAttribute("nomeClientes");
List listaCpfCliente = (List)session.getAttribute("cpfClientes");

//Medico
List listaIdMedico = (List)session.getAttribute("idMedicos");
List listaNomeMedico = (List)session.getAttribute("nomeMedicos");
List listaCpfMedico = (List)session.getAttribute("cpfMedicos");

//Variaveis
String dataAtendimento = "";
String nomeAnimal = "";
String nomeCliente = "";
String tipo = "";
String cor = "";
String idade = "";
String nomeAluno = "";
String nomeProfessor = "";
String motivo = "";
String tratamento = "";
String dataRetorno = "";

String cpfClienteBuscado = "";
for(int i = 0; i < listaIdProntuarios.size(); i++) {
	String idProntuario = listaIdProntuarios.get(i).toString();
	if(idProntuario.equals(idProntuarioGerar)){
		//Busca Animal
		String idAnimaisProntuario = listaIdAnimaisProntuarios.get(i).toString();
		for(int j = 0; j < listaIdAnimal.size(); j++){
			String idAnimal = listaIdAnimal.get(j).toString();
			if(idAnimaisProntuario.equals(idAnimal)){
				nomeAnimal = listaNomeAnimal.get(j).toString();
				tipo = listaTipoAnimal.get(j).toString();
				cor = listaCorAnimal.get(j).toString();
				idade = listaIdadeAnimal.get(j).toString();
				cpfClienteBuscado = listaCpfClienteAnimal.get(j).toString();
			}
		}
		//Busca Cliente(Dono)
		for(int j = 0; j < listaIdCliente.size(); j++){
			String cpfCliente = listaCpfCliente.get(j).toString();
			if(cpfCliente.equals(cpfClienteBuscado)){
				nomeCliente = listaNomeCliente.get(j).toString();
			}
		}
		//Busca Aluno
		String cpfAlunosProntuario = listaCpfAlunosProntuarios.get(i).toString();
		for(int j = 0; j < listaIdMedico.size(); j++){
			String cpfAluno = listaCpfMedico.get(j).toString();
			if(cpfAluno.equals(cpfAlunosProntuario)){
				nomeAluno = listaNomeMedico.get(j).toString();
			}
		}
		//Busca Professor
		String cpfProfessoresProntuario = listaCpfProfessoresProntuarios.get(i).toString();
		for(int j = 0; j < listaIdMedico.size(); j++){
			String cpfProfessor = listaCpfMedico.get(j).toString();
			if(cpfProfessor.equals(cpfProfessoresProntuario)){
				nomeProfessor = listaNomeMedico.get(j).toString();
			}
		}
		motivo = listaMotivoProntuarios.get(i).toString();
		tratamento = listaTratamentoProntuarios.get(i).toString();
		dataAtendimento = listaDataAtendimentos.get(i).toString();
		dataRetorno = listaDataRetornos.get(i).toString();

%>
Hospital Rurau - Relatório<br>
<br>
Identificação<br>
Caso:<%=dataAtendimento%>	&nbsp;&nbsp;&nbsp;	Nº do prontuario:<%=idProntuarioGerar%><br>
Nome animal:<%=nomeAnimal%>	&nbsp;&nbsp;&nbsp;	Nome dono:<%=nomeCliente%><br>
Espécie:<%=tipo%>	&nbsp;&nbsp;&nbsp;	Raça:<%=cor%>	&nbsp;&nbsp;&nbsp;	Idade:<%=idade%> anos<br>
Aluno:<%=nomeAluno%><br>
Professor responsável:<%=nomeProfessor%><br>
<br>
Motivo<br>
<%=motivo%><br>
<br>
Tratamento<br>
<%=tratamento%><br>
<br>
Data Retorno<br>
<%=dataRetorno%><br>
<br>
<%
	}
}
%>
</body>
</html>