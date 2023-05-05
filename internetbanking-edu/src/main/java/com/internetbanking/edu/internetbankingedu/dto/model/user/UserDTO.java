package com.internetbanking.edu.internetbankingedu.dto.model.user;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.internetbanking.edu.internetbankingedu.model.User;

/**
 * Edu Reis - 2023
 *
 * Classe de Data trasfer object do Usuario
 */

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( callSuper = false )
public class UserDTO extends RepresentationModel<UserDTO>
{
	
	@Getter
	private Long idUsuario;
	
	@Getter
	@NotNull( message = "Preencha o campo nome" )
	@Length( min=3, max=45, message="Nome pode possuir no máximo 45 caracteres" )
	private String nome;

	@Getter
	@NotNull( message = "Preencha o campo CPF" )
	@Length( min=14, max=14, message="CPF deve possuir 14 caracteres" )
	private String cpf;

	@Getter
	@NotNull( message = "Preencha o campo Data de Nascimento" )
	private Date dataNascimento;
	
	@Getter
	@NotNull( message = "Preencha o campo senha" )
	@Length( min=7, max=12, message="Senha deve possuir no máximo 12 caracteres e no mínimo 7 caracteres" )
	private String senha;
	
	@Getter
	private String role;
	
	public UserDTO (  )
	{
		
	}
	
	public String getSenha( )
	{
//		return BcryptUtil.getHash( this.senha );
		return "";
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
	
}