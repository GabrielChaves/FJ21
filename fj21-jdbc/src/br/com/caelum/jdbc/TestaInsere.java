package br.com.caelum.jdbc;

import java.util.Calendar;

public class TestaInsere {
	public static void main (String [] args){
		Contato contato = new Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato!caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		//Grave nossa conexao
		ContatoDao dao = new ContatoDao();
		
		//metodo elegante
		dao.adiciona(contato);
		
		System.out.println("Gravado!");
	}
}
