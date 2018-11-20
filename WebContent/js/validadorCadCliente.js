var nomeDonoCadCliente = false;
var CPFDonoCadCliente = false;
var EnderecoDonoCadCliente = false;
var telefoneDonoCadCliente = false;

//validacao do nome do animal CadCliente
document.getElementById("nomeDonoCadDono").addEventListener("blur", function(){
    var nome = document.getElementById("nomeDonoCadDono").value;
    var RegExp = /^[a-zA-ZéúíóáÉÚÍÓÁèùìòàçÇÈÙÌÒÀõãñÕÃÑêûîôâÊÛÎÔÂëÿüïöäËYÜÏÖÄ\-\ \s]+$/;
    if (RegExp.test(nome) == false) {
        //$(this).focus();
        $("#errorNomeDonoCadDono").text("Por favor, insira um nome válido");
        $(this).addClass("errorInput");
        
        nomeDonoCadCliente = false;
    } else {
        $("#errorNomeDonoCadDono").text("");
        nomeDonoCadCliente = true;
    } 
});

//validacao do CPF do cliente CadCliente
document.getElementById("cpfDonoCadDono").addEventListener("blur", function(){
    if (!TestaCPF($(this).val())) {
        $("#errorCPFDonoCadDono").text("Por favor, insira um CPF válido");
        $(this).addClass("errorInput");
        
        CPFDonoCadCliente = false;
    } else {
        $("#errorCPFDonoCadDono").text("");
        CPFDonoCadCliente = true;
    } 
});

//validacao do endereço do cliente CadCliente
document.getElementById("enderecoDonoCadDono").addEventListener("blur", function(){
	if ($(this).val().length < 4) {
        $("#errorEnderecoDonoCadDono").text("Por favor, insira um endereço válido");
        $(this).addClass("errorInput");
        
        EnderecoDonoCadCliente = false;
    } else {
        $("#errorEnderecoDonoCadDono").text("");
        EnderecoDonoCadCliente = true;
    } 
});

//Máscara do telefone
var SPMaskBehavior = function (val) {
   return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
 },
 spOptions = {
   onKeyPress: function(val, e, field, options) {
       field.mask(SPMaskBehavior.apply({}, arguments), options);
     }
 };
 
 $('#telefoneDonoCadDono').mask(SPMaskBehavior, spOptions);
 
//Validação do telefone do cliente CadCliente
 $('#telefoneDonoCadDono').blur(function(){
     if($(this).val().length < 14){
         //$(this).focus();
         $("#errorTelefoneDonoCadDono").text("Por favor, digite um número de telefone válido");
         $(this).addClass("errorInput");
         telefoneDonoCadCliente = false;
     }else{
         $("#errorTelefoneDonoCadDono").text("");
         telefoneDonoCadCliente = true;
     }
 });

//disparo do botao CadCliente
 document.getElementById("CadastroDono").addEventListener("click", function(event){
     if(nomeDonoCadCliente && CPFDonoCadCliente && EnderecoDonoCadCliente && telefoneDonoCadCliente){  
         $("#errorSubmitCadDono").text("");
                             
     }else{
         event.preventDefault();
         $("#errorSubmitCadDono").text("Por favor, preencha corretamente todos os campos");
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