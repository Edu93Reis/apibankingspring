/**
 * Edu Reis - 2023
 *
 * Classe responsável pela iplementação da conta em banco do usuário
 */

package com.internetbanking.edu.internetbankingedu.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Edu Reis - 2023
 *
 * Classe responsável pela camada de serviço da conta
 */

import org.springframework.stereotype.Service;

import com.internetbanking.edu.internetbankingedu.exceptions.RegraNegocioException;
import com.internetbanking.edu.internetbankingedu.model.Account;
import com.internetbanking.edu.internetbankingedu.model.service.AccountService;
import com.internetbanking.edu.internetbankingedu.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService
{

	@Autowired
	AccountRepository repository;
	private List<Account> account;
	
	public AccountServiceImpl( AccountRepository repository ) {
		super();
		this.repository = repository;
	}
	
	@Override
	public Account save( Account conta ) 
	{
		validarConta( conta.getNumConta( ) );
		return repository.save( conta );
	}

	public void validarConta( String numConta ) {
		Optional<Account> conta = repository.findByNumConta( numConta );
		if( !conta.isPresent( ) ) {
			throw new RegraNegocioException( "Conta já cadastrada!" );
		}
	}
	
	@Override
	public void updateIsPlanoExclusive( Account conta ) 
	{
		repository.updateIsPlanoExclusive( conta.isPlanoExclusive( ), conta.getIdConta( ) );
	}

	@Override
	public Optional<Account> findByAccountNumber( String numConta ) 
	{
		return repository.findByNumConta( numConta );
	}

	@Override
	public Optional<Account> findById( Long idConta ) 
	{
		return repository.findById( idConta );
	}
	
	@Override
	public List<Account> returnAllAccounts( )
	{
		return repository.findAll( );
	}
	
	
}