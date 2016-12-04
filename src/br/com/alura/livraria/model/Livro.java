package br.com.alura.livraria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@NamedQuery(name="obterAutoresDoLivro", query="select l.autores from Livro l")

@Entity
@SequenceGenerator(name = "SEQ_LIVRO", sequenceName = "SEQ_LIVRO", initialValue = 1, allocationSize = 1)
public class Livro {

	public static final String OBTER_LIVROS_POR_AUTOR = "obterLivrosPorAutor";
	public static final String OBTER_AUTORES_DO_LIVRO = "obterAutoresDoLivro";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIVRO")
	private int id;
	private String titulo;
	private String isbn;
	private Double preco;
	private String dataLancamento;

	@ManyToMany
	private List<Autor> autores = new ArrayList<Autor>();
	
	public void addAutor(Autor autor){
		this.autores.add(autor);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	
}
