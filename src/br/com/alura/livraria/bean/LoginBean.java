package br.com.alura.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.alura.livraria.dao.UsuarioDAO;
import br.com.alura.livraria.model.Usuario;
import br.com.alura.livraria.util.JpaUtil;

@ManagedBean
@ViewScoped
public class LoginBean {

	private EntityManager em = new JpaUtil().getEntityManager();
	private UsuarioDAO usuarioDAO = new UsuarioDAO(em);

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public String autenticar() {

		Usuario usuario = usuarioDAO.obterUsuarioPorEmail(this.usuario);

		if (usuario == null) {
			return null;
		} else {
			return "livro.xhtml?faces-redirect=true";
		}
	}

}
