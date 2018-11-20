var nomeAnimalConPaciente = false;
var cpfDonoConPaciente = false;
var motivoConPaciente = false;
var tratamentoConPaciente = false;
var matriculaProfessorConPaciente = false;

//validacao do nome do animal ConPaciente
document.getElementById("nomeAnimalConPaciente").addEventListener("blur", function(){
    var nome = document.getElementById("nomeAnimalConPaciente").value;
    var RegExp = /^[a-zA-ZÈ˙ÌÛ·…⁄Õ”¡Ë˘ÏÚ‡Á«»ŸÃ“¿ı„Ò’√—Í˚ÓÙ‚ €Œ‘¬Îˇ¸Ôˆ‰ÀY‹œ÷ƒ\-\ \s]+$/;
    if (RegExp.test(nome) == false) {
        //$(this).focus();
        $("#errorNomeAnimalConPaciente").text("Por favor, insira um nome v·lido");
        $(this).addClass("errorInput");
        
        nomeAnimalConPaciente = false;
    } else {
        $("#errorNomeAnimalConPaciente").text("");
        nomeAnimalConPaciente = true;
    } 
});

//validacao do CPF do cliente ConPaciente
document.getElementById("cpfDonoConPaciente").addEventListener("blur", function(){
    if (!TestaCPF($(this).val())) {
        $("#errorCPFDonoConPaciente").text("Por favor, insira um CPF v·lido");
        $(this).addClass("errorInput");
        
        cpfDonoConPaciente = false;
    } else {
        $("#errorCPFDonoConPaciente").text("");
        cpfDonoConPaciente = true;
    } 
});

//validacao do motivo da consulta ConPaciente
document.getElementById("motivoConPaciente").addEventListener("blur", function(){
	if ($(this).val().length < 2) {
        $("#errorMotivoConPaciente").text("Por favor, insira um motivo v·lido");
        $(this).addClass("errorInput");
        
        motivoConPaciente = false;
    } else {
        $("#errorMotivoConPaciente").text("");
        motivoConPaciente = true;
    } 
});

//validacao do tratamento ConPaciente
document.getElementById("tratamentoConPaciente").addEventListener("blur", function(){
	if ($(this).val().length < 2) {
        $("#errorTratamentoConPaciente").text("Por favor, insira um tratamento v·lido");
        $(this).addClass("errorInput");
        
        tratamentoConPaciente = false;
    } else {
        $("#errorTratamentoConPaciente").text("");
        tratamentoConPaciente = true;
    } 
});

//validacao da matricula do professor ConPaciente
document.getElementById("matriculaProfessorConPaciente").addEventListener("blur", function(){
	if ($(this).val().length < 1) {
        $("#errorMatriculaProfessorConPaciente").text("Por favor, insira uma matrÌcula v·lida");
        $(this).addClass("errorInput");
        
        matriculaProfessorConPaciente = false;
    } else {
        $("#errorMatriculaProfessorConPaciente").text("");
        matriculaProfessorConPaciente = true;
    } 
});


//disparo do botao ConPaciente
document.getElementById("consultarPaciente").addEventListener("click", function(event){
    if(nomeAnimalConPaciente && cpfDonoConPaciente && motivoConPaciente && tratamentoConPaciente && matriculaProfessorConPaciente){  
        $("#errorSubmitConsultarPaciente").text("");
                           
    }else{
        event.preventDefault();
        $("#errorSubmitConsultarPaciente").text("Por favor, preencha corretamente todos os campos");
        $(this).addClass("errorInput");
    }

});









function TestaCPF(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;
    //retirar . e -
    strCPF = strCPF.replace(/\D+/g, '');
  if (strCPF == "00000000000") return false;
     
  for (i=1; i<=9; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
  Resto = (Soma * 10) % 11;
   
    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10)) ) return false;
   
  Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;
   
    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11) ) ) return false;
    return true;
}