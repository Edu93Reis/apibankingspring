package com.internetbanking.edu.internetbankingedu.dto.model.user;

/**
 * Edu Reis - 2023
 *
 * Classe de Data trasfer object do Account
 */

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.internetbanking.edu.internetbankingedu.model.Account;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( callSuper = false )
public class AccountDTO  extends RepresentationModel<AccountDTO>
{
	@Getter
	private Long idConta;
	
	@Getter
	@NotNull
	private String numConta;

	@Getter
	private BigDecimal cpf;

	@Getter
	@NotNull( message = "Preencha o campo Data de Nascimento" )
	private Date dataNascimento;
	
	@Getter
	private boolean isPlanoExclusive;
	
	public AccountDTO (  )
	{
		
	}
	
	/**
	 * Convert usuario para DTO
	 * 
	 * @return User object
	 */
	public Account convertDTOToEntity( )
	{
		return new ModelMapper( ).map( this, Account.class );
	}
}
