package br.com.codigofante.cantadas.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.codigofante.cantadas.modelo.Usuario;

public interface UsuarioService {
	
	void adicionaUsuario(Usuario usuario);
	List<Usuario> listaTodosUsuarios();
	List<Usuario> buscaUsuarioPorPreferencia(HttpSession sessao/*falta argumentos*/);
	Usuario buscaUsuario(Usuario usuario);
	Usuario buscaUsuarioPorId(Long idUsuario);
	boolean usuarioExiste(Usuario usuario,HttpSession sessao);
	void atualizaDadosDoUsuario(Usuario usuario);
	void excluirConta(Long idUsuario);
	List<Usuario> buscaUsuarioPorEmailESenha(Usuario usuario);
	
}
