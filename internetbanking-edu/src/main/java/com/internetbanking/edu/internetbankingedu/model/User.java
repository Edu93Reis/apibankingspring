/**
 * Edu Reis - 2023
 *
 * Classe responsável pela camada de modelagem do usuário
 */

package com.internetbanking.edu.internetbankingedu.model;

import java.io.Serializable;
import java.util.Date;

import org.modelmapper.ModelMapper;

import com.internetbanking.edu.internetbankingedu.dto.model.user.UserDTO;
import com.internetbanking.edu.internetbankingedu.enums.RoleEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table( name="Usuario" )
public class User implements Serializable {

	private static final long serialVersionUID = 1200614431683864022L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name="idusuario", nullable = false )
	private Long idUsuario;

	@Column( name="nome", length=45, nullable = false )
	private String nome;

	@Column( name="cpf", length=14, nullable = false )
	private String cpf;
	
	@Column( name="datanascimento", nullable = false )
	private Date dataNascimento;
	
	@Column( name="senha", length=12, nullable = false )
	private String senha;
	
	@Column( name="iscliente", length=1, nullable = false )
	private String isCliente;

	@Column( name="isadmin", length=1, nullable = false )
	private String isAdmin;
	
//	@PrimaryKeyJoinColumn
//	@OneToOne( cascade=CascadeType.ALL )
//	@JoinTable(name="conta",
//			    joinColumns={@JoinColumn(name="idConta",  
//			     referencedColumnName="idConta")},  
//			    inverseJoinColumns={@JoinColumn(name="conta",   
//			     referencedColumnName="conta")}) 
////	@Column( name="conta", nullable = false )
//	private int account;
	
	public User( Long idUsuario )
	{
		this.idUsuario = idUsuario;
	}
	
	public User( )
	{
		super( );
	}
	
	public User( Long idUsuario, String nome, String cpf, Date dataNascimento, String senha, String isCliente, String isAdmin )//, int account ) 
	{
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.isCliente = isCliente;
		this.isAdmin = isAdmin;
//		this.account = account;
	}

	public User(String nome, String cpf, Date dataNascimento, String senha, String isCliente, String isAdmin ) 
	{
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.isCliente = isCliente;
		this.isAdmin = isAdmin;
	}

	/**
	 * Metodo para conversão de User para DTO
	 * 
	 * @return UserDTO
	 */
	public UserDTO convertEntityToDTO( )
	{
		return new ModelMapper( ).map( this, UserDTO.class );
	}
	
	public String getCpf( ) 
	{
		return cpf;
	}
	
	public String getSenha() {
		return senha;
	}

	public Long getIdUser() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getIsAdmin() {
		return isAdmin;
	}
	
	public String getIsCliente() {
		return isCliente;
	}

//	public int getAccount() {
//		return account;
//	}

	public void setIdUser(Long idUsuario) {
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

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public void setIsCliente(String isCliente) {
		this.isCliente = isCliente;
	}

//	public void setAccount(int account) {
//		this.account = account;
//	}
	
}
