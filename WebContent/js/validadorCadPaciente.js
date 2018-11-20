var nomeAnimalCadPaciente = false;
var idadeAnimalCadPaciente = false;
var tipoAnimalCadPaciente = false;
var corAnimalCadPaciente = false;
var cpfDonoCadPaciente = false;

//validacao do nome do animal CadPaciente
document.getElementById("nomeAnimalCadPaciente").addEventListener("blur", function(){
    var nome = document.getElementById("nomeAnimalCadPaciente").value;
    var RegExp = /^[a-zA-ZéúíóáÉÚÍÓÁèùìòàçÇÈÙÌÒÀõãñÕÃÑêûîôâÊÛÎÔÂëÿüïöäËYÜÏÖÄ\-\ \s]+$/;
    if (RegExp.test(nome) == false) {
        //$(this).focus();
        $("#errorNomeAnimalCadPaciente").text("Por favor, insira um nome válido");
        $(this).addClass("errorInput");
        
        nomeAnimalCadPaciente = false;
    } else {
        $("#errorNomeAnimalCadPaciente").text("");
        nomeAnimalCadPaciente = true;
    } 
});

//validacao da idade do animal CadPaciente
document.getElementById("idadeAnimalCadPaciente").addEventListener("blur", function(){
	if ($(this).val().length < 1) {
        $("#errorIdadeAnimalCadPaciente").text("Por favor, insira uma idade válida");
        $(this).addClass("errorInput");
        
        idadeAnimalCadPaciente = false;
    } else {
        $("#errorIdadeAnimalCadPaciente").text("");
        idadeAnimalCadPaciente = true;
    } 
});

//validacao da idade do animal CadPaciente
document.getElementById("tipoAnimalCadPaciente").addEventListener("blur", function(){
	if ($(this).val().length < 1) {
        $("#errorTipoAnimalCadPaciente").text("Por favor, insira um tipo válido");
        $(this).addClass("errorInput");
        
        tipoAnimalCadPaciente = false;
    } else {
        $("#errorTipoAnimalCadPaciente").text("");
        tipoAnimalCadPaciente = true;
    } 
});

//validacao da cor do animal CadPaciente
document.getElementById("corAnimalCadPaciente").addEventListener("blur", function(){
	if ($(this).val().length < 4) {
        $("#errorCorAnimalCadPaciente").text("Por favor, insira uma cor válida");
        $(this).addClass("errorInput");
        
        corAnimalCadPaciente = false;
    } else {
        $("#errorCorAnimalCadPaciente").text("");
        corAnimalCadPaciente = true;
    } 
});

//validacao do CPF do cliente CadPaciente
document.getElementById("cpfClienteCadPaciente").addEventListener("blur", function(){
    if (!TestaCPF($(this).val())) {
        $("#errorCPFDonoCadPaciente").text("Por favor, insira um CPF válido");
        $(this).addClass("errorInput");
        
        cpfDonoCadPaciente = false;
    } else {
        $("#errorCPFDonoCadPaciente").text("");
        cpfDonoCadPaciente = true;
    } 
});


//disparo do botao CadPaciente
document.getElementById("cadastroPaciente").addEventListener("click", function(event){
    if(nomeAnimalCadPaciente && idadeAnimalCadPaciente && tipoAnimalCadPaciente && corAnimalCadPaciente && cpfDonoCadPaciente){  
        $("#errorSubmitCadPaciente").text("");
                           
    }else{
        event.preventDefault();
        $("#errorSubmitCadPaciente").text("Por favor, preencha corretamente todos os campos");
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