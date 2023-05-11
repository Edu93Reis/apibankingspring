/**
 * Edu Reis - 2023
 *
 * Classe responsável pela camada de serviço do usuário
 */

package com.internetbanking.edu.internetbankingedu.model.service;

import java.util.List;
import java.util.Optional;

import com.internetbanking.edu.internetbankingedu.model.User;

public interface UserService {

	User save( User user );
	
	Optional<User> findByCpf( String cpf );
	
	List<User> findAll();
	
	Optional<User> obterPorId( Long id );

	User autenticar( String cpf, String senha );
	
	void validarCpf( String cpf );
	
	List<User> returnUsers( );

}
