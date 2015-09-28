<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<!-- Cria o Dao -->
		
		
		<c:import url="cabecalho.jsp"></c:import>
		
		<table>
			<!-- Percorre contatos montando as linhas da tabela -->
			<c:forEach var="contato" items="${contatos}">
				<tr>
					<td><c:out value="${contato.nome}"/></td>
					<td>
						<c:choose>
							<c:when test="${ empty contato.email }">
								Nao informou email
						</c:when>
							<c:otherwise>	
								${contato.email}	
							</c:otherwise>	
						</c:choose>									
					</td>
					<td>${contato.endereco}</td>
					<!-- <td>${contato.dataNascimento.time}</td> -->
					<td><fmt:formatDate value="${contato.dataNascimento.time }" 
					pattern="dd/MM/yyy" />
					<td>
						<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:import url="rodape.jsp"></c:import>
	</body>
</html>