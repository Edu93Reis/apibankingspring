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

import com.internetbanking.edu.internetbankingedu.model.Account;
import com.internetbanking.edu.internetbankingedu.model.service.AccountService;
import com.internetbanking.edu.internetbankingedu.repository.AccountRepository;
import com.internetbanking.edu.internetbankingedu.repository.UserRepository;

@Service
public class AccountServiceImpl implements AccountService
{

	@Autowired
	AccountRepository repository;
	private List<Account> account;
	
	public AccountServiceImpl( AccountRepository repository) {
		super();
		this.repository = repository;
	}
	
//	public void createAccountService( )
//	{
//		if( factory == null )
//		{
//			factory = new AccountFactoryImpl( );
//		}
//	}
//	
//	public void createAccountList( )
//	{
//		if ( account == null )
//		{
//			account = new ArrayList<>();
//		}
//	}
//	
//	public boolean isJSONValid( String jsonInString )
//	{
//		try
//		{
//			return !Objects.isNull( new ObjectMapper( ).readTree( jsonInString ) ) ;
//		}
//		catch ( IOException e )
//		{
//			return false;
//		}
//	}
//	
//	public long parseId( JSONObject account )
//	{
//		return Long.valueOf( (int) account.get("idConta") );
//	}
//	
//	public String parseNumConta( JSONObject account )
//	{
//		return String.valueOf( (String) account.get( "numConta" ) );
//	}
//	
//	public BigDecimal parseSaldo( JSONObject account )
//	{
//		return new BigDecimal( (String) account.get( "saldo" ) );
//	}
//	
//	public boolean parseIsPlanoExclusive( JSONObject account )
//	{
//		return new Boolean( (String) account.get("bPlanoExclusive") );
//	}
//	
//	public void setAccountValues( JSONObject jsonAccount, Account account )
//	{
//		
//	}
	
	@Override
	public Account save( Account conta ) 
	{
		return repository.save( conta );
	}

	@Override
	public Optional<Account> findByAccountNumber( String numConta ) 
	{
		return repository.findByAccountNumber( numConta );
	}

	@Override
	public Optional<Account> findById( Long idConta ) 
	{
		return repository.findById( idConta );
	}
	
	
}