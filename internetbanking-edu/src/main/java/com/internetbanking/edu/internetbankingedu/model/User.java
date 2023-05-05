/**
 * Edu Reis - 2023
 *
 * Classe responsável pela camada de modelagem do usuário
 */

package com.internetbanking.edu.internetbankingedu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.internetbanking.edu.internetbankingedu.dto.model.user.UserDTO;
import com.internetbanking.edu.internetbankingedu.enums.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idUser;

	@Column( nullable = false )
	private String nome;

	@Column( nullable = false )
	private String cpf;
	
	@Column( nullable = false )
	private Date dataNascimento;
	
	@Column( nullable = false )
	private String senha;
	
	@Enumerated( EnumType.STRING )
	private RoleEnum role;
	
	@Column( nullable = false )
	private int account;
	
	public User( Long idUser )
	{
		this.idUser = idUser;
	}
	
	/**
	 * Verifica se usuário é admin
	 * 
	 * @return boolean
	 */
	public boolean isAdmin( )
	{
		return RoleEnum.ROLE_ADMIN.toString( ).equals( this.role.toString( ) );
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
	
}