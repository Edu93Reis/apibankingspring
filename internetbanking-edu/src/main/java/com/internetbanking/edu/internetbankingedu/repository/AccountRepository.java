/**
 * Edu Reis - 2023
 *
 * Interface responsável pelo contrato da conta em banco do usuário
 */

package com.internetbanking.edu.internetbankingedu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.internetbanking.edu.internetbankingedu.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> 
{
	
	Optional<Account> findByNumConta( String numConta );
	
	Optional<Account> findById( Long idConta );
	
	@Query(value = "UPDATE Conta SET isPlanoExclusive = ? WHERE idConta = ?", nativeQuery = true )
	void updateIsPlanoExclusive( int isPlanoExclusive, Long idConta );

}