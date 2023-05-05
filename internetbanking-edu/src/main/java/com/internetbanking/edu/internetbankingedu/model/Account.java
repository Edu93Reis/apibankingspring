/**
 * Edu Reis - 2023
 *
 * Classe responsável pela camada de modelagem da conta em banco do usuário
 */

package com.internetbanking.edu.internetbankingedu.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.internetbanking.edu.internetbankingedu.dto.model.user.AccountDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idConta;
	
	@Column( nullable = false )
	private String numConta;
	
	@Column( nullable = false )
	private BigDecimal saldo;
	
	@Column( nullable = false )
	private boolean isPlanoExclusive;
	
//	/**
//	 * Verifica se usuário é do Plano Exclusive
//	 * 
//	 * @return boolean
//	 */
//	public boolean isPlanoExclusive( )
//	{
//		return PlanoEnum.ROLE_ENUM.toString( ).equals( this.isPlanoExclusive.toString( ) );
//	}
	
	/**
	 * Metodo para conversão de Account para DTO
	 * 
	 * @return AccountDTO
	 */
	public AccountDTO convertEntityToDTO( )
	{
		return new ModelMapper( ).map( this, AccountDTO.class );
	}

}
