package br.com.codigofante.cantadas.service;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.codigofante.cantadas.modelo.Repertorio;
import br.com.codigofante.cantadas.modelo.Usuario;

@Service
@Transactional
public class RepertorioServiceImpl implements RepertorioService {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	@Transactional
	public void adiciona(Repertorio repertorio) {
		  manager.merge(repertorio);
	}

	@Override
	@Transactional
	public void criaRepertorioPadrao(Repertorio criadas, Repertorio recebidas, Usuario usuario) {
		this.criaRepertorioCriadas(criadas, usuario);
		this.criaRepertorioRecebidas(recebidas, usuario);
	}

	@Override
	@Transactional
	public void criaRepertorioCriadas(Repertorio criadas, Usuario usuario) {
		criadas.setDataCriacao(Calendar.getInstance());
		criadas.setNome("Cantadas Criadas");
		criadas.setDescricao("Repertório padrão para as cantadas criadas pelo paquerador");
		criadas.setUsuario(usuario);
		this.adiciona(criadas);
	}

	@Override
	@Transactional
	public void criaRepertorioRecebidas(Repertorio recebidas, Usuario usuario) {
		recebidas.setDataCriacao(Calendar.getInstance());
		recebidas.setNome("Cantadas Recebidas");
		recebidas.setDescricao("Repertório padrão para as cantadas recebidas pelo paquerador");
		recebidas.setUsuario(usuario);
		this.adiciona(recebidas);
	}

	@Override
	@Transactional
	public void adicionaNovoRepertorio(Repertorio repertorio, Usuario usuario) {
		repertorio.setDataCriacao(Calendar.getInstance());
		repertorio.setUsuario(usuario);
		this.adiciona(repertorio);
	}

	@Override
	@Transactional
	public List<Repertorio> listaRepertoriosDoUsuario(Usuario usuario) {
		Query query = manager.createQuery("select repertorio from Repertorio as repertorio where repertorio.usuario = :usuario");
		query.setParameter("usuario", usuario);
		List<Repertorio> repertorios = query.getResultList();
		return repertorios;
	}

	@Override
	@Transactional
	public void excluirRepertorio(Repertorio repertorio) {
		manager.remove(this.buscaRepertorioPeloId(repertorio.getIdRepertorio()));
	}

	@Override
	@Transactional
	public Repertorio repertorioDaCantada(Long idCantada) {
		Query query = manager.createQuery("select repertorio from Repertorio as repertorio where repertorio.cantadas.idCantada = :idCantada");
		query.setParameter("idCantada", idCantada);
		List<Repertorio> repertorios = query.getResultList();
		if(repertorios.size()==1){
			for (Repertorio repertorioEncontrado : repertorios) {
				return repertorioEncontrado;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public Repertorio buscaRepertorioPeloId(Long idRepertorio) {
		Repertorio repertorio = manager.find(Repertorio.class, idRepertorio);
		return repertorio;
	}

	@Override
	@Transactional
	public void atualizarRepertorio(Repertorio repertorio,HttpSession sessao) {
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		repertorio.setUsuario(usuario);
		manager.merge(repertorio);
	}
	
}
