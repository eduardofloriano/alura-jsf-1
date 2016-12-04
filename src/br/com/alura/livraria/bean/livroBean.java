package br.com.alura.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.alura.livraria.model.Livro;


@ManagedBean
public class livroBean {

	private Livro livro = new Livro();

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public void gravar(){
		
		System.out.println("Gravou o livro: " + livro.getTitulo());
		
	}
	
	
	
}
