package br.com.codigofante.cantadas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.codigofante.cantadas.modelo.Cantada;

@Service
@Transactional
public class CantadaServiceImpl implements CantadaService {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	@Transactional
	public void adicionaCantada(Cantada cantada) {
		manager.merge(cantada);
	}

	@Override
	@Transactional
	public List<Cantada> listaCantadasDoRepertorio(Long idRepertorio) {
		Query query = manager.createQuery("select cantada from Cantada as cantada where cantada.repertorio.idRepertorio = :idRepertorio");
		query.setParameter("idRepertorio", idRepertorio);
		List<Cantada> cantadas = query.getResultList();
		return cantadas;
	}

	@Override
	@Transactional
	public void excluirCantada(Long idCantada) {
		manager.remove(this.buscaCantadaPorId(idCantada));
	}

	@Override
	public Cantada buscaCantadaPorId(Long idCantada) {
		Cantada cantada = manager.find(Cantada.class, idCantada);
		return cantada;
	}

	@Override
	public void atualizaCantada(Cantada cantada) {
		manager.merge(cantada);
	}

}
