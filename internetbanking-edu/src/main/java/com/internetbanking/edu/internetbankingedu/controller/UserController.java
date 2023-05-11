/**
 * Edu Reis - 2023
 *
 * Classe responsável pelo tratamento de negócio do Usuário
 */

package com.internetbanking.edu.internetbankingedu.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internetbanking.edu.internetbankingedu.dto.model.user.UserDTO;
import com.internetbanking.edu.internetbankingedu.enums.RoleEnum;
import com.internetbanking.edu.internetbankingedu.exceptions.ErroAutenticacaoException;
import com.internetbanking.edu.internetbankingedu.model.User;
//import com.internetbanking.edu.internetbankingedu.model.service.AccountService;
import com.internetbanking.edu.internetbankingedu.model.service.UserService;

import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;

@RestController
@RequestMapping( value="/api/usuarios" )
public class UserController 
{

	private static final Logger logger = Logger.getLogger( UserController.class );
	
	@Autowired
	private UserService service;

//	@Autowired
//	private AccountService serviceAccount;
	
	@PostMapping
	public ResponseEntity salvar( 
								  //@RequestHeader(value="banking-api-version", defaultValue="${api.version}") 
								  @Valid @RequestBody UserDTO dto
								 ) 
	{
		
		boolean isPlanoExclusive = false;
		
		try {
			User usuarioSalvo = service.save( dto.convertDTOToEntity( ) );
			
//			if( !Objects.isNull( usuarioSalvo ) )
//			{
//				serviceAccount.update( isPlanoExclusive );
//			}
			
			return new ResponseEntity( usuarioSalvo, HttpStatus.CREATED );
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}

	@PostMapping("/autenticar")
	public ResponseEntity autenticar( @RequestBody UserDTO dto ) {
		
		try {
			User usuarioAutenticado = service.autenticar( dto.getCpf( ), dto.getSenha( ) );
			
			return ResponseEntity.ok( usuarioAutenticado );
		}catch(ErroAutenticacaoException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/listausuario")
	@ApiOperation(value = "Route to return single user of the API")
	public ResponseEntity returnUser( @RequestParam(value = "idUsuario", required = true) Long id ) {
		Optional<User> user = service.obterPorId( id );
		
		if( !user.isPresent() ) {
			return ResponseEntity.badRequest( ).body( "Usuário não encontrado. Usuário não encontrado para o id encontrado!" );
		}
		
		return ResponseEntity.ok( user );
		
	}

	@GetMapping("/{idUsuario}")
	@ApiOperation(value = "Route to return all user of the API")
	public ResponseEntity returnUsers( @RequestParam(value = "idUsuario", required = true ) Long id ) {
		Optional<User> user = service.obterPorId( id );
		
		if( Objects.isNull( user ) )
		{
			return ResponseEntity.badRequest( ).body( "Erro ao listar usuário!" );
		}
			
		if( !user.isPresent() ) {
			return ResponseEntity.badRequest( ).body( "Usuário não encontrado. Usuário não encontrado para o id encontrado!" );
		}
		
		if( !user.get( ).getIsAdmin( ).equals( RoleEnum.ROLE_ADMIN ) )
		{
			return ResponseEntity.badRequest( ).body( "Usuário não possui autorização para listagem de usuários" );
		}
		
		List<User> users = service.returnUsers( );
		
		return ResponseEntity.ok(users);
		
	}
	
}