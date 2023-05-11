/**
 * Edu Reis - 2023
 *
 * Classe responsável pela camada de modelagem da conta em banco do usuário
 */

package com.internetbanking.edu.internetbankingedu.model;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import com.internetbanking.edu.internetbankingedu.dto.model.user.AccountDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name="Conta" )
public class Account {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name="idconta", nullable = false )
	private Long idConta;
	
	@Column( name="numconta", nullable = false )
	private String numConta;
	
	@Column( name="saldo" )
	private BigDecimal saldo;
	
	@Column( name="isplanoexclusive" )
	private int isPlanoExclusive;
	
	public Account( )
	{
		super( );
	}
	
	public Account( Long idConta, String numConta, BigDecimal saldo, int isPlanoExclusive ) {
		super( );
		this.idConta = idConta;
		this.numConta = numConta;
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

	public void setPlanoExclusive( int isPlanoExclusive ) {
		this.isPlanoExclusive = isPlanoExclusive;
	}

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
