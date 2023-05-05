/**
 * Edu Reis - 2023
 *
 * Classe responsável pela implementação de usuário
 */

package com.internetbanking.edu.internetbankingedu.model.service.impl;

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
	
//	public void createUserService( )
//	{
//		if( factory == null )
//		{
//			factory = new userFactoryImpl( );
//		}
//	}
//	
//	public void createUsertList( )
//	{
//		if ( Objects.isNull( user ) )
//		{
//			user = new ArrayList<>();
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
//	public long parseId( JSONObject user )
//	{
//		return Long.valueOf( (int) user.get( "idUsuario" ) );
//	}
//	
//	public String parseNome( JSONObject user )
//	{
//		return String.valueOf( (String) user.get( "nome" ) );
//	}
//
//	public String parseCPF( JSONObject user )
//	{
//		return String.valueOf( (String) user.get( "cpf" ) );
//	}
//
//	public String parseSenha( JSONObject user )
//	{
//		return String.valueOf( (String) user.get( "senha" ) );
//	}
//	
//	public LocalDateTime parseDtNascimento( JSONObject user )
//	{
//		var date  = (String) user.get( "dataNascimento" );
//		return ZonedDateTime.parse( date ).toLocalDateTime( );
//	}
//	
//	public boolean parseIsCliente( JSONObject user )
//	{
//		return new Boolean( (String) user.get("isCliente") );
//	}
//
//	public boolean parseIsAdmin( JSONObject user )
//	{
//		return new Boolean( (String) user.get("isAdmin") );
//	}
//	
//	public void setUserValues( JSONObject jsonUser, User user )
//	{
//		
//	}
//	
//	public User create( JSONObject jsonUser )
//	{
//		createFactory( );
//		
//		User user = factory.createUser( (String) jsonUser.get("idUsuario") );
//		setUserValues( jsonUser, user );
//		
//		return user;
//	}
	
	@Override
	public User autenticar( String cpf, String senha ) {
		
		Optional<User> user = repository.findByCPF( cpf );
		
		if( !user.isPresent( ) ) {
			throw new ErroAutenticacaoException("Usuário não cadastrado!");
		}
		
		if( !user.get().getSenha().equals( senha ) ) {
			throw new ErroAutenticacaoException("Senha inválida!");
		}
		
		return user.get();
		
	}
	
	@Override
	@Transactional
	public User save( User user ) {
		validarCPF( user.getCpf( ) );
		return repository.save(user);
	}
	
	@Override
	public void validarCPF( String cpf ) {
		boolean existe = repository.existsByCPF( cpf );
		if( existe ) {
			throw new RegraNegocioException("Usuário já cadastrado para este cpf!");
		}
	}

	@Override
	public Optional<User> findByCPF( String cpf ) {
		return repository.findByCPF( cpf );
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
	
}