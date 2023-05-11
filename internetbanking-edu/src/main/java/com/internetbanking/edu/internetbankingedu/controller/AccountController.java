/**
 * Edu Reis - 2023
 *
 * Classe responsável pelo tratamento de negócio das Contas
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internetbanking.edu.internetbankingedu.dto.model.user.AccountDTO;
import com.internetbanking.edu.internetbankingedu.model.Account;
import com.internetbanking.edu.internetbankingedu.model.service.AccountService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( "api/netbanking/contas" )
public class AccountController 
{
	private static final Logger logger = Logger.getLogger( AccountController.class );
	
	@Autowired
	private AccountService service;
	
	private AccountController( AccountService service ) 
	{
		this.service = service;
	}
	
	@PostMapping
	@ApiOperation(value = "Accounts's register of the API")
	public ResponseEntity salvar( @RequestBody AccountDTO dto ) 
	{
		
		try {
			Account contaSalva = service.save( dto.convertDTOToEntity( ) );
			
			return new ResponseEntity( contaSalva, HttpStatus.CREATED );
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@GetMapping( "/getConta" )
	@ApiOperation(value = "Route to return one account")
	public ResponseEntity getConta( @RequestParam(value = "idConta", required = true) Long id )
	{
		Optional<Account> conta = service.findById( id );
		
		if( Objects.isNull( conta ) )
		{
			return ResponseEntity.badRequest( ).body( "Erro ao buscar conta!" );
		}
		
		if( !conta.isPresent( ) )
		{
			return ResponseEntity.badRequest( ).body( "Conta não encontrada!" );
		}
		
		return ResponseEntity.ok( conta );
	}

	@GetMapping( "/isPlanoExclusive" )
	@ApiOperation(value = "Route to get plano exclusive status at register")
	public ResponseEntity isPlanoExclusive( @RequestBody AccountDTO dto )
	{
		if( Objects.isNull( dto ) )
		{
			return ResponseEntity.badRequest( ).body( "Erro ao acessar conta!" );
		}
		
		return ResponseEntity.ok( dto.isPlanoExclusive( ) );
	}

	@PutMapping( "/atualizaConta" )
	@ApiOperation(value = "Route to alter register of plano exclusive attribute")
	public ResponseEntity updateIsPlanoExclusive( @RequestBody AccountDTO dto )
	{
		Optional<Account> conta = service.findByAccountNumber( dto.getNumConta( ) );
		
		if( !conta.isPresent( ) )
		{
			return ResponseEntity.badRequest( ).body( "Erro ao acessar conta!" );
		}
		
		try {
			conta.get().setPlanoExclusive( dto.isPlanoExclusive( ) );
			service.updateIsPlanoExclusive( conta.get( ) );
		
			return ResponseEntity.ok( dto.convertDTOToEntity( ) );
		}catch( Exception e ){
			return ResponseEntity.badRequest( ).body( e.getMessage( ) );
		}
	}
	
	//transformar em trigger para tualizar saldo da conta ao receber movimentacao
//	@PutMapping( "/atualizaSaldo" )
//	@ApiOperation(value = "Route to alter register of account's balance")
//	public ResponseEntity updateSaldo( @RequestBody AccountDTO dto )
//	{
//		Optional<Account> conta = service.findByAccountNumber( dto.getNumConta( ) );
//		
//		if( !conta.isPresent( ) )
//		{
//			return ResponseEntity.badRequest( ).body( "Erro ao acessar conta!" );
//		}
//		
//		try {
////			conta.get( ).setSaldo(  ); //adiciona entrada saida
//			
//			
//		}catch( Exception e ) {
//			return ResponseEntity.badRequest( ).body( e.getMessage( ) );
//		}
//		
//	}
	
	@GetMapping
	@ApiOperation(value = "Route to return all accounts of the API")
	public ResponseEntity returnAllAccounts( )
	{
		List<Account> contas = service.returnAllAccounts( );
		
		if( Objects.isNull( contas ) )
		{
			return ResponseEntity.badRequest( ).body( "Erro ao listar contas" );
		}
		
		if( contas.isEmpty( ) )
		{
			return ResponseEntity.badRequest( ).body( "Não há contas cadastradas!" );
		}
		
		return ResponseEntity.ok( contas );
	}
	
	
}
