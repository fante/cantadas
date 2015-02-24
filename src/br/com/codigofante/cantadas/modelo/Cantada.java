package br.com.codigofante.cantadas.modelo;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cantada {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCantada;
	private String textoDaCantada;
	@Temporal(TemporalType.DATE)
	private Calendar dataCriacao;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_Repertorio")
	private Repertorio repertorio;
	/**
	 * @return the textoDaCantada
	 */
	public String getTextoDaCantada() {
		return textoDaCantada;
	}
	/**
	 * @param textoDaCantada the textoDaCantada to set
	 */
	public void setTextoDaCantada(String textoDaCantada) {
		this.textoDaCantada = textoDaCantada;
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
	 * @return the repertorio
	 */
	public Repertorio getRepertorio() {
		return repertorio;
	}
	/**
	 * @param repertorio the repertorio to set
	 */
	public void setRepertorio(Repertorio repertorio) {
		this.repertorio = repertorio;
	}
	/**
	 * @return the idCantada
	 */
	public Long getIdCantada() {
		return idCantada;
	}
	/**
	 * @param idCantada the idCantada to set
	 */
	public void setIdCantada(Long idCantada) {
		this.idCantada = idCantada;
	}
	
}
