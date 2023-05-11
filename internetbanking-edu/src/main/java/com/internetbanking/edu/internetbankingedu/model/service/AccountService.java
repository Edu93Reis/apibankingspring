package com.internetbanking.edu.internetbankingedu.model.service;

import java.util.List;
import java.util.Optional;

import com.internetbanking.edu.internetbankingedu.model.Account;

public interface AccountService {
	
	Account save( Account account );

	void updateIsPlanoExclusive( Account conta );
	
	Optional<Account> findByAccountNumber( String numConta );
	
	Optional<Account> findById( Long idConta );
	
	List<Account> returnAllAccounts( );

}