<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*" %>
<%@page import="br.com.caelum.agenda.modelo.*" %>
<%@page import="br.com.caelum.agenda.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyy");
			
			
			for (Contato contato : contatos){
			%>
			<tr>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=formatador.format(contato.getDataNascimento().getTime())%> </td>
			</tr>	
		    <%
			}	
		    %>
		</table>
	</body>
</html>