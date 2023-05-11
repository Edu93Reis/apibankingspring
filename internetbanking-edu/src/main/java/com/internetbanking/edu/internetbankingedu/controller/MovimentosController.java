/**
 * Edu Reis - 2023
 *
 * Classe responsável pelo tratamento de negócio de Lancamentos
 */

package com.internetbanking.edu.internetbankingedu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internetbanking.edu.internetbankingedu.dto.model.user.MovimentosDTO;
import com.internetbanking.edu.internetbankingedu.model.Account;
import com.internetbanking.edu.internetbankingedu.model.Movimentos;
import com.internetbanking.edu.internetbankingedu.model.User;
import com.internetbanking.edu.internetbankingedu.model.service.AccountService;
import com.internetbanking.edu.internetbankingedu.model.service.MovimentosService;
import com.internetbanking.edu.internetbankingedu.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( "/api/netbanking/movimentos" )
public class MovimentosController 
{
	
	@Autowired
	private MovimentosService movimentoService;

	private UserService usuarioService;

	private AccountService contaService;
	
	@PostMapping
	@ApiOperation(value = "Route to insert account's registers")
	public ResponseEntity insereMovimento( @RequestBody Movimentos movimento )
	{
		if( Objects.isNull( movimento ) )
		{
			return ResponseEntity.badRequest( ).body( "Dados de movimentação inválidas!" );
		}
		
		Movimentos movto = movimentoService.insereMovimento( movimento );
		
		return ResponseEntity.ok( movto );
	}
	
	@GetMapping("{id}/saldo")
	@ApiOperation(value = "Route to get account's registers by period and user")
	public ResponseEntity obterMovimentoData( @RequestBody Movimentos movimento, @PathVariable( "idUser" ) Long idUser,
											  @PageableDefault(page = 1, size = 10, sort = {"id"}) Pageable pageable ) 
	{
		Optional<User> usuario = usuarioService.obterPorId( idUser );
		
		if( !usuario.isPresent( ) ) {
			return new ResponseEntity( HttpStatus.NOT_FOUND );
		}
		
		if( existeMovimentoUsuarioPeriodo( movimento, idUser ) )
		{
			Page<Movimentos> movimentos = movimentoService.findBetweenDates( movimento, pageable );
			
			return ResponseEntity.ok( movimentos );
		} else {
			return ResponseEntity.badRequest( ).body( "Não há movimento para período" );
		}
	}

	private boolean existeMovimentoUsuarioPeriodo(Movimentos movimento, Long idUser) {
		// TODO Auto-generated method stub
		return false;
	}

//	@GetMapping("{id}/movimentacao")
//	@ApiOperation(value = "Route to get account's registers by user")
//	public ResponseEntity obterMovimentacao( @PathVariable("idUser") Long id ) {
//		Optional<User> usuario = usuarioService.obterPorId( id );
//		
//		Optional<Account> conta = contaService.findById( usuario.get().getIdConta( ) );
//		
//		if( !usuario.isPresent( ) ) {
//			return new ResponseEntity( HttpStatus.NOT_FOUND );
//		}
//		
//		ArrayList< MovimentosDTO > movimentacao = movimentoService.getMovimentosPorUsuario( conta.get().getIdConta() );
//	    return ResponseEntity.ok( movimentacao );
//	}
	
	public BigDecimal atualizaValorPorTaxa( BigDecimal valor )
	{
			
		if( valor.intValue( ) >= 100 && valor.intValue( ) <=300 )
		{
			valor.multiply( new BigDecimal( 1.004 ) );
		}
		
		if( valor.intValue( ) > 300 )
		{
			valor.multiply( new BigDecimal( 1.01 ) );
		}
		
		return valor;
	}
	
}
