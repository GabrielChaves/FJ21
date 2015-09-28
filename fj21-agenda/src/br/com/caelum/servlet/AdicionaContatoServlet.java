package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
							throws IOException, ServletException{
		Connection connection = (Connection) request.getAttribute("conexao");
		//busca o writer
		PrintWriter out = response.getWriter();
		
		//buscando os paramentros nop request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		//fazendo a conversao da data
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy")
						.parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e){
			out.println("Erro de conversao da data");
			return; //para a execucao do metodo
		}
		
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		//Salva o contato
		ContatoDao dao = new ContatoDao(connection);
		
		
		//imprime o nome do contato que foi adicionado
		out.print("<html>");
		out.print("<body>");
		out.print("Contato " + contato.getNome() + " adicionado com sucesso");
		out.print("</body>");
		out.print("</html>");
	}
}
