package com.internetbanking.edu.internetbankingedu.dto.model.user;

/**
 * Edu Reis - 2023
 *
 * Classe de Data trasfer object do Account
 */

import java.math.BigDecimal;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.internetbanking.edu.internetbankingedu.model.Account;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode( callSuper = false )
public class MovimentosDTO  extends RepresentationModel<MovimentosDTO>
{
	private Long idMovimento;
	
	@NotNull
	private BigDecimal saldoData;

	@NotNull
	private BigDecimal entrada;
	
	@NotNull
	private BigDecimal saida;

	@NotNull
	private Date dataAtualizacao;
	
	private int idConta;
	
	public MovimentosDTO (  )
	{
		super( );
	}
	
	public MovimentosDTO( Long idMovimento, @NotNull BigDecimal saldoData, @NotNull BigDecimal entrada,
			@NotNull BigDecimal saida, @NotNull Date dataAtualizacao, int idConta )
	{
		super();
		this.idMovimento = idMovimento;
		this.saldoData = saldoData;
		this.entrada = entrada;
		this.saida = saida;
		this.dataAtualizacao = dataAtualizacao;
		this.idConta = idConta;
	}

	public MovimentosDTO( @NotNull BigDecimal saldoData, @NotNull BigDecimal entrada,
			@NotNull BigDecimal saida, @NotNull Date dataAtualizacao )
	{
		super();
		this.saldoData = saldoData;
		this.entrada = entrada;
		this.saida = saida;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Long getIdMovimento() {
		return idMovimento;
	}

	public void setIdMovimento(Long idMovimento) {
		this.idMovimento = idMovimento;
	}

	public BigDecimal getSaldoData() {
		return saldoData;
	}

	public void setSaldoData(BigDecimal saldoData) {
		this.saldoData = saldoData;
	}

	public BigDecimal getEntrada() {
		return entrada;
	}

	public void setEntrada(BigDecimal entrada) {
		this.entrada = entrada;
	}

	public BigDecimal getSaida() {
		return saida;
	}

	public void setSaida(BigDecimal saida) {
		this.saida = saida;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
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