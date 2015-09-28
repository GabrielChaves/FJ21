package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cicloDeVidaComProblemaDeHeranca", loadOnStartup = 1, initParams = { @WebInitParam(name = "nome", value = "Caelum") })
public class CicloDeVidaComProblemaDeHeranca extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Inicializando a servlet");
		super.init(config);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletConfig config =	 getServletConfig();
		PrintWriter out = resp.getWriter();
		out.println(config.getInitParameter("nome"));
	}

	@Override
	public void destroy() {
		System.out.println("Destruindo a servlet");
		super.destroy();
	}
}