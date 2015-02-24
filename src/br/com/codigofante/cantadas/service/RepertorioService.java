package br.com.codigofante.cantadas.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.codigofante.cantadas.modelo.Repertorio;
import br.com.codigofante.cantadas.modelo.Usuario;

public interface RepertorioService {
	
	void adiciona(Repertorio repertorio);
	void criaRepertorioPadrao(Repertorio criadas,Repertorio recebidas,Usuario usuario);
	void criaRepertorioCriadas(Repertorio criadas, Usuario usuario);
	void criaRepertorioRecebidas(Repertorio recebidas,Usuario usuario);
	void adicionaNovoRepertorio(Repertorio repertorio, Usuario usuario);
	List<Repertorio> listaRepertoriosDoUsuario(Usuario usuario);
	Repertorio buscaRepertorioPeloId(Long idRepertorio);
	void excluirRepertorio(Repertorio repertorio);
	Repertorio repertorioDaCantada(Long idCantada);
	void atualizarRepertorio(Repertorio repertorio,HttpSession sessao);

}
