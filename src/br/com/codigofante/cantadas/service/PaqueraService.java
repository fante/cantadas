package br.com.codigofante.cantadas.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.codigofante.cantadas.modelo.Paquera;
import br.com.codigofante.cantadas.modelo.Usuario;

public interface PaqueraService {

	void adiciona(Usuario paquerador, Usuario paquerado,Paquera paquera);

	List<Paquera> listaPaquerasPendentesDoUsuario(Long idUsuario,HttpSession sessao);

	void aceitarPaquera(Long idPaquera);

	void rejeitarPaquera(Long idPaquera);

	List<Paquera> listaPaquerasDoUsuario(Usuario usuario);

	void excluirPaquera(Long idPaquera);

}
