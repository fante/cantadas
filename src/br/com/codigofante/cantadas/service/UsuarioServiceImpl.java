package br.com.codigofante.cantadas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.codigofante.cantadas.modelo.Usuario;

@Repository
public class UsuarioServiceImpl implements UsuarioService {

	@PersistenceContext
	EntityManager manager;
	@Autowired
	PaqueraService paqueraService;
	@Transactional
	public void adicionaUsuario(Usuario usuario){
		manager.persist(usuario);
		
	}

	@Transactional
	public List<Usuario> listaTodosUsuarios() {
		Query query = manager.createQuery("select usuarios from Usuario usuarios");
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
		
	}

	@Override
	@Transactional
	public boolean usuarioExiste(Usuario usuario, HttpSession sessao) {
		List<Usuario> usuarioEncontrado = this.buscaUsuarioPorEmailESenha(usuario);
		if (usuarioEncontrado.size()==1){
			for (Usuario usuarioLogado : usuarioEncontrado) {
				this.buscaUsuarioPorPreferencia(sessao);
				paqueraService.listaPaquerasPendentesDoUsuario(usuarioLogado.getIdUsuario(), sessao);
				sessao.setAttribute("usuarioLogado", usuarioLogado);
				return true;
			}
		}
		return false;
	}

	@Override
	@Transactional
	public Usuario buscaUsuario(Usuario usuario) {
		Long id = (long) usuario.getIdUsuario();
		Usuario usuarioEncontrado = manager.find(Usuario.class,id );
		return usuarioEncontrado;
	}

	@Override
	@Transactional
	public void atualizaDadosDoUsuario(Usuario usuario) {
		manager.merge(usuario);
	}

	@Override
	@Transactional
	public void excluirConta(Long idUsuario) {
		Usuario usuario = this.buscaUsuarioPorId(idUsuario);
		manager.remove(usuario);
	}

	@Override
	@Transactional
	public Usuario buscaUsuarioPorId(Long idUsuario) {
		Query query = manager.createQuery("select usuario from Usuario as usuario where usuario.idUsuario = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		List<Usuario> usuarioEncontrado = query.getResultList();
		for (Usuario usuario : usuarioEncontrado) {
			return usuario;
		}
		return null;
	}

	@Override
	@Transactional
	public List<Usuario> buscaUsuarioPorPreferencia(HttpSession sessao/*Argumentos de preferência do usuário*/) {
		List<Usuario> usuariosPreferidos = this.listaTodosUsuarios();
		sessao.setAttribute("usuariosPreferidos", usuariosPreferidos);
		return usuariosPreferidos;
	}

	@Override
	@Transactional
	public List<Usuario> buscaUsuarioPorEmailESenha(Usuario usuario) {
		Query query = manager.createQuery("select usuario from Usuario as usuario where usuario.email = :usuarioEmail and usuario.senha = :usuarioSenha");
		query.setParameter("usuarioEmail", usuario.getEmail());
		query.setParameter("usuarioSenha", usuario.getSenha());
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}

}
