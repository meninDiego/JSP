<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recebe Nomes</title>
</head>
<body>

<%
	String nome = request.getParameter("nome");
	out.println("Nome : " + nome);
//Aqui o parametro e null, mas na pagina se colocarmos o nome desse jsp seguido de ? nome = deigo menin
//aparecera na pagina o valor digitado 
	String idade = request.getParameter("idade");
	out.println("Idade : " + idade);
//Aqui passamos mai sum atributo e na url usamo o & para adicionar o 2 atributo
%>
	

</body>
</html>