/**
 * Edu Reis - 2023
 *
 * Classe responsável pela implementação de usuário
 */

package com.internetbanking.edu.internetbankingedu.model.service.impl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.internetbanking.edu.internetbankingedu.exceptions.ErroAutenticacaoException;
import com.internetbanking.edu.internetbankingedu.exceptions.RegraNegocioException;
import com.internetbanking.edu.internetbankingedu.model.User;
import com.internetbanking.edu.internetbankingedu.model.service.UserService;
import com.internetbanking.edu.internetbankingedu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	UserRepository repository;
	private List<User> user;
	
	public UserServiceImpl( UserRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public User autenticar( String cpf, String senha ) {
		
		Optional<User> user = repository.findByCpf( cpf );
		
		if( !user.isPresent( ) ) {
			throw new ErroAutenticacaoException("Usuário não cadastrado!");
		}
		
		if( !user.get( ).getSenha( ).equals( senha ) ) {
			throw new ErroAutenticacaoException("Senha inválida!");
		}
		
		return user.get();
		
	}
	
	@Override
	@Transactional
	public User save( User user ) {
		if ( !isCpfValido( user.getCpf( ) ) )
		{
			throw new RegraNegocioException( "CPF Inválido!" );
		}
		
		validarCpf( user.getCpf( ) );
		return repository.save(user);
	}
	
	@Override
	public void validarCpf( String cpf ) {
		boolean existe = repository.existsByCpf( cpf );
		if( existe ) {
			throw new RegraNegocioException( "Usuário já cadastrado para este cpf!" );
		}
	}

	@Override
	public Optional<User> obterPorId( Long idUser ) {
		return repository.findById( idUser );
	}

	@Override
	public Optional<User> findByCpf( String cpf ) {
		return repository.findByCpf( cpf );
	}

	@Override
	@Transactional( readOnly = true )
	public List<User> returnUsers() {
			Example example = Example.of(  
					 ExampleMatcher.matching()
					 .withIgnoreCase()
					 .withStringMatcher( StringMatcher.CONTAINING )
					 .isAnyMatching()
		);

		return repository.findAll( example );
	}

	@Override
	public List<User> findAll( ) {
		return repository.findAll( );
	}
	
	private boolean isCpfValido( String cpf ) 
	{
		if (cpf.equals("00000000000") ||
	            cpf.equals("11111111111") ||
	            cpf.equals("22222222222") || cpf.equals("33333333333") ||
	            cpf.equals("44444444444") || cpf.equals("55555555555") ||
	            cpf.equals("66666666666") || cpf.equals("77777777777") ||
	            cpf.equals("88888888888") || cpf.equals("99999999999") ||
	            (cpf.length() != 11))
	            return false;

	     char dig10, dig11;
	     int sm, i, r, num, peso;

	     try {
	    	 // Calculo do 1o. Digito Verificador
	         sm = 0;
	         peso = 10;
	         
	         for( i=0; i<9; i++ ) {
	            num = (int)(cpf.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	         }

	         r = 11 - (sm % 11);

	         if ((r == 10) || (r == 11))
	            dig10 = '0';
	         else dig10 = (char)(r + 48); 
	         
	         sm = 0;
	         peso = 11;

	         for(i=0; i<10; i++) {
	            num = (int)(cpf.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	         }

	         r = 11 - (sm % 11);
	         if ((r == 10) || (r == 11))
	         {
	            dig11 = '0';
	         }
	         else
	         {
	        	 dig11 = (char)(r + 48);
	         }

	         if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
	         {
	        	 return true;
	         }
	         else 
	         {
	        	 return false;
	         }       
	         
	       } catch ( InputMismatchException erro ) {
	          return false;
	       }
	}
}