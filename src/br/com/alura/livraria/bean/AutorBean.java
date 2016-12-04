package br.com.alura.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.alura.livraria.dao.AutorDAO;
import br.com.alura.livraria.model.Autor;
import br.com.alura.livraria.util.JpaUtil;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void gravar() {

		EntityManager em = new JpaUtil().getEntityManager();
		AutorDAO dao = new AutorDAO(em);
		
		dao.persist(autor);
		
		System.out.println("Gravou o Autor: " + autor.getNome());
		clear();
	}
	
	public void clear(){
		autor = new Autor();
	}

}
