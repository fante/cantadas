package br.com.codigofante.cantadas.modelo;


import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuario;
	private String email;
	private String senha;
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	@ElementCollection
	private List<Repertorio> repertorios;
	@OneToMany(mappedBy="paquerador", cascade=CascadeType.ALL)
	@ElementCollection
	private List<Paquera> paqueras;
	
	/**
	 * @return the repertorios
	 */
	public List<Repertorio> getRepertorios() {
		return repertorios;
	}

	/**
	 * @param repertorios the repertorios to set
	 */
	public void setRepertorios(List<Repertorio> repertorios) {
		this.repertorios = repertorios;
	}

	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the email
	 */
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param email the email to set
	 */
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void recuperaId(Usuario usuario) {
		
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
}
