package br.com.codigofante.cantadas.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Repertorio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRepertorio;
	private String nome;
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Calendar dataCriacao;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_Usuario")
	private Usuario usuario;
	@OneToMany(mappedBy="repertorio",cascade=CascadeType.ALL)
	@ElementCollection
	private List<Cantada> cantadas;
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the dataCriacao
	 */
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the idRepertorio
	 */
	public Long getIdRepertorio() {
		return idRepertorio;
	}
	/**
	 * @return the cantadas
	 */
	public List<Cantada> getCantadas() {
		return cantadas;
	}
	/**
	 * @param cantadas the cantadas to set
	 */
	public void setCantadas(List<Cantada> cantadas) {
		this.cantadas = cantadas;
	}
	/**
	 * @param idRepertorio the idRepertorio to set
	 */
	public void setIdRepertorio(Long idRepertorio) {
		this.idRepertorio = idRepertorio;
	}
	
	
}
