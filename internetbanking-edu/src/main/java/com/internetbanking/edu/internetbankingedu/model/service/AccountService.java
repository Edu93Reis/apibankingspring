package com.internetbanking.edu.internetbankingedu.model.service;

import java.util.Optional;

import com.internetbanking.edu.internetbankingedu.model.Account;

public interface AccountService {
	
	Account save( Account account );
	
	Optional<Account> findByAccountNumber( String numConta );
	
	Optional<Account> findById( Long idConta );

}
