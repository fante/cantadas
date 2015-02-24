package br.com.codigofante.cantadas.service;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.codigofante.cantadas.modelo.Paquera;
import br.com.codigofante.cantadas.modelo.Usuario;

@Repository
public class PaqueraServiceImpl implements PaqueraService {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	@Transactional
	public void adiciona(Usuario paquerador, Usuario paquerado,Paquera paquera) {
		paquera.setDataDoEnvio(Calendar.getInstance());
		paquera.setPaquerador(paquerador);
		paquera.setPaquerado(paquerado);
		paquera.setAceito(false);
		manager.persist(paquera);
	}

	@Override
	@Transactional
	public List<Paquera> listaPaquerasPendentesDoUsuario(Long idUsuario,HttpSession sessao) {
		Query query = manager.createQuery("select paquera from Paquera as paquera where id_Paquerado =:idUsuario and aceito=false");
		query.setParameter("idUsuario", idUsuario);
		List<Paquera> paquerasPendentes = query.getResultList();
		sessao.setAttribute("paquerasPendentes", paquerasPendentes);
		return paquerasPendentes;
	}

	@Override
	@Transactional
	public void aceitarPaquera(Long idPaquera) {
		Query query = manager.createQuery("update Paquera set aceito = true where idPaquera =:idPaquera");
		query.setParameter("idPaquera", idPaquera);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void rejeitarPaquera(Long idPaquera) {
		manager.remove(manager.find(Paquera.class, idPaquera));
	}

	@Override
	@Transactional
	public List<Paquera> listaPaquerasDoUsuario(Usuario usuario) {
		Query query = manager.createQuery("select paquera from Paquera as paquera where paquerador =:usuario and aceito=true");
		query.setParameter("usuario", usuario);
		List<Paquera> paquerasDoUsuario = query.getResultList();
		return paquerasDoUsuario;
	}

	@Override
	@Transactional
	public void excluirPaquera(Long idPaquera) {
		manager.remove(manager.find(Paquera.class, idPaquera));
	}

}
