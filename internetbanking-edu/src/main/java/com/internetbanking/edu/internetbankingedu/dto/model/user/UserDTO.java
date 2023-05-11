package com.internetbanking.edu.internetbankingedu.dto.model.user;

import java.util.Date;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import com.internetbanking.edu.internetbankingedu.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserDTO extends RepresentationModel<UserDTO>
{
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name="idUsuario", nullable = false )
	private Long idUsuario;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String senha;
	private String role;
	
	private int account;
	
	
	
	public UserDTO() {
		super();
	}

	public UserDTO(Iterable<Link> initialLinks) {
		super(initialLinks);
	}

	public UserDTO(Link initialLink) {
		super(initialLink);
	}
	
	public UserDTO(Long idUsuario, String nome, String cpf, Date dataNascimento, String senha, String role, int account) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.role = role;
		this.account = account;
	}
	
	public UserDTO( String nome, String cpf, Date dataNascimento, String senha, String role ) 
	{
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.role = role;
	}

	public String getSenha( )
	{
//		return BcryptUtil.getHash( this.senha );
		return this.senha;
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getRole() {
		return role;
	}
	
	public int getAccount() {
		return account;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	/**
	 * Convert usuario para DTO
	 * 
	 * @return User object
	 */
	public User convertDTOToEntity( )
	{
		return new ModelMapper( ).map( this, User.class );
	}

	@Override
	public String toString() {
		return "UserDTO [idUsuario=" + idUsuario + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + ", senha=" + senha + ", role=" + role + ", account= " + account + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash( cpf, dataNascimento, idUsuario, nome, role, senha); //account,
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return account == other.account && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(idUsuario, other.idUsuario)
				&& Objects.equals(nome, other.nome) && Objects.equals(role, other.role)
				&& Objects.equals(senha, other.senha);
	}

}