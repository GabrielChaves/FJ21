package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;

public class GeraTabelas {
	public static void main(String [] args){
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("tarefas");
		factory.close();
	}
}
