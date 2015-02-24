package br.com.codigofante.cantadas.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Paquera {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPaquera;
	@ManyToOne()
	@JoinColumn(name="id_Paquerador")
	private Usuario paquerador;
	@ManyToOne()
	@JoinColumn(name="id_Paquerado")
	private Usuario paquerado;
	@Temporal(TemporalType.DATE)
	private Calendar dataDoEnvio;
	@Temporal(TemporalType.DATE)
	private Calendar dataDaResposta;
	private boolean aceito;
	/**
	 * @return the idPaquera
	 */
	public Long getIdPaquera() {
		return idPaquera;
	}
	/**
	 * @param idPaquera the idPaquera to set
	 */
	public void setIdPaquera(Long idPaquera) {
		this.idPaquera = idPaquera;
	}
	/**
	 * @return the paquerador
	 */
	public Usuario getPaquerador() {
		return paquerador;
	}
	/**
	 * @param paquerador the paquerador to set
	 */
	public void setPaquerador(Usuario paquerador) {
		this.paquerador = paquerador;
	}
	/**
	 * @return the paquerado
	 */
	public Usuario getPaquerado() {
		return paquerado;
	}
	/**
	 * @param paquerado the paquerado to set
	 */
	public void setPaquerado(Usuario paquerado) {
		this.paquerado = paquerado;
	}
	/**
	 * @return the dataDoEnvio
	 */
	public Calendar getDataDoEnvio() {
		return dataDoEnvio;
	}
	/**
	 * @param dataDoEnvio the dataDoEnvio to set
	 */
	public void setDataDoEnvio(Calendar dataDoEnvio) {
		this.dataDoEnvio = dataDoEnvio;
	}
	/**
	 * @return the dataDaResposta
	 */
	public Calendar getDataDaResposta() {
		return dataDaResposta;
	}
	/**
	 * @param dataDaResposta the dataDaResposta to set
	 */
	public void setDataDaResposta(Calendar dataDaResposta) {
		this.dataDaResposta = dataDaResposta;
	}
	/**
	 * @return the aceito
	 */
	public boolean isAceito() {
		return aceito;
	}
	/**
	 * @param aceito the aceito to set
	 */
	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}
	
}
