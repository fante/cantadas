package br.com.codigofante.cantadas.service;

import java.util.List;

import br.com.codigofante.cantadas.modelo.Cantada;

public interface CantadaService {
	
	void adicionaCantada(Cantada cantada);
	List<Cantada> listaCantadasDoRepertorio(Long idRepertorio);
	void excluirCantada(Long idCantada);
	Cantada buscaCantadaPorId(Long idCantada);
	void atualizaCantada(Cantada cantada);
	
}
