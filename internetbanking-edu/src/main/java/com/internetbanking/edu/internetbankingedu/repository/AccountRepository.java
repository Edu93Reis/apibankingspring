/**
 * Edu Reis - 2023
 *
 * Interface responsável pelo contrato da conta em banco do usuário
 */

package com.internetbanking.edu.internetbankingedu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internetbanking.edu.internetbankingedu.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> 
{
	Optional<Account> findByAccountNumber( String numConta );
}
