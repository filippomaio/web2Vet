var nomeDonoCadCliente = false;
var CPFDonoCadCliente = false;
var EnderecoDonoCadCliente = false;

//validacao do nome do animal CadCliente
document.getElementById("nomeDonoCadDono").addEventListener("blur", function(){
    var nome = document.getElementById("nomeDonoCadDono").value;
    var RegExp = /^[a-zA-Z���������������������������������������������Y����\-\ \s]+$/;
    if (RegExp.test(nome) == false) {
        //$(this).focus();
        $("#errorNomeDonoCadDono").text("Por favor, insira um nome v�lido");
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
        $("#errorCPFDonoCadDono").text("Por favor, insira um CPF v�lido");
        $(this).addClass("errorInput");
        
        CPFDonoCadCliente = false;
    } else {
        $("#errorCPFDonoCadDono").text("");
        CPFDonoCadCliente = true;
    } 
});

//validacao do endere�o do cliente CadCliente
document.getElementById("enderecoDonoCadDono").addEventListener("blur", function(){
	if ($(this).val().length < 4) {
        $("#errorEnderecoDonoCadDono").text("Por favor, insira um endere�o v�lido");
        $(this).addClass("errorInput");
        
        EnderecoDonoCadCliente = false;
    } else {
        $("#errorEnderecoDonoCadDono").text("");
        EnderecoDonoCadCliente = true;
    } 
});

//disparo do botao CadCliente
 document.getElementById("CadastroDono").addEventListener("click", function(event){
     if(nomeDonoCadCliente && CPFDonoCadCliente && EnderecoDonoCadCliente){  
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