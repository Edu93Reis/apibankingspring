/**
 * Edu Reis - 2023
 *
 * Classe responsável pela camada de modelagem do usuário
 */

package com.internetbanking.edu.internetbankingedu.model;

import java.math.BigDecimal;
import java.util.Date;

import org.modelmapper.ModelMapper;

import com.internetbanking.edu.internetbankingedu.dto.model.user.MovimentosDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name="Movimento" )
public class Movimentos {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name="idmovimento", nullable = false )
	private Long idMovimento;

	@Column( name="saldodata" )
	private BigDecimal saldoData;

	@Column( name="entrada" )
	private BigDecimal entrada;

	@Column( name="saida" )
	private BigDecimal saida;
	
	@Column( name="dataatualizacao", nullable = false )
	private Date dataAtualizacao;
	
	@Column( name="idconta", nullable = false )
	private int idConta;
	
	public Movimentos( Long idMovimento )
	{
		this.idMovimento = idMovimento;
	}
	
	public Movimentos( )
	{
		super( );
	}

	public Movimentos( Long idMovimento, BigDecimal saldoData, BigDecimal entrada, BigDecimal saida,
					   Date dataAtualizacao, int idConta ) 
	{
		super();
		this.idMovimento = idMovimento;
		this.saldoData = saldoData;
		this.entrada = entrada;
		this.saida = saida;
		this.dataAtualizacao = dataAtualizacao;
		this.idConta = idConta;
	}

	public Movimentos( BigDecimal saldoData, BigDecimal entrada, BigDecimal saida, Date dataAtualizacao ) 
	{
		super();
		this.saldoData = saldoData;
		this.entrada = entrada;
		this.saida = saida;
		this.dataAtualizacao = dataAtualizacao;
	}

	/**
	 * Metodo para conversão de Movimento para DTO
	 * 
	 * @return MovimentosDTO
	 */
	public MovimentosDTO convertEntityToDTO( )
	{
		return new ModelMapper( ).map( this, MovimentosDTO.class );
	}

	public Long getIdMovimento() {
		return idMovimento;
	}

	public BigDecimal getSaldoData() {
		return saldoData;
	}

	public BigDecimal getEntrada() {
		return entrada;
	}

	public BigDecimal getSaida() {
		return saida;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdMovimento(Long idMovimento) {
		this.idMovimento = idMovimento;
	}

	public void setSaldoData(BigDecimal saldoData) {
		this.saldoData = saldoData;
	}

	public void setEntrada(BigDecimal entrada) {
		this.entrada = entrada;
	}

	public void setSaida(BigDecimal saida) {
		this.saida = saida;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	
}
