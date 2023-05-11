package com.internetbanking.edu.internetbankingedu.dto.model.user;

/**
 * Edu Reis - 2023
 *
 * Classe de Data trasfer object do Account
 */

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.internetbanking.edu.internetbankingedu.model.Account;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode( callSuper = false )
public class AccountDTO  extends RepresentationModel<AccountDTO>
{
	private Long idConta;
	
	@NotNull
	private String numConta;

	private BigDecimal saldo;

	private int isPlanoExclusive;
	
	public AccountDTO (  )
	{
		super( );
	}
	
	public AccountDTO(Long idConta, @NotNull String numConta, BigDecimal saldo, int isPlanoExclusive) {
		super();
		this.idConta = idConta;
		this.numConta = numConta;
		this.saldo = saldo;
		this.isPlanoExclusive = isPlanoExclusive;
	}

	public AccountDTO( BigDecimal saldo, int isPlanoExclusive) {
		super();
		this.saldo = saldo;
		this.isPlanoExclusive = isPlanoExclusive;
	}
	
	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public int isPlanoExclusive() {
		return isPlanoExclusive;
	}

	public void setPlanoExclusive(int isPlanoExclusive) {
		this.isPlanoExclusive = isPlanoExclusive;
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
