/**
 * Edu Reis - 2023
 *
 * Classe responsável pela iplementação da conta em banco do usuário
 */

package com.internetbanking.edu.internetbankingedu.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Edu Reis - 2023
 *
 * Classe responsável pela camada de serviço da conta
 */

import org.springframework.stereotype.Service;

import com.internetbanking.edu.internetbankingedu.model.Movimentos;
import com.internetbanking.edu.internetbankingedu.model.service.MovimentosService;
import com.internetbanking.edu.internetbankingedu.repository.MovimentosRepository;

@Service
public class MovimentosServiceImpl implements MovimentosService
{

	@Autowired
	MovimentosRepository repository;
	private List<Movimentos> movimentos;
	
	public MovimentosServiceImpl( MovimentosRepository repository ) 
	{
		super();
		this.repository = repository;
	}
	
	@Override
	public void update( Movimentos movimento ) 
	{
		repository.save( movimento );
	}

	@Override
	public Page<Movimentos> findBetweenDates( Movimentos movimentos, Pageable pageable )
	{
		return repository.findBetweenDates( movimentos, pageable );
	}

	@Override
	public Page<Movimentos> getMovimentos( Long idConta, Pageable pageable ) 
	{
		return repository.getMovimentos( idConta, pageable );
	}
	
	@Override
	public Movimentos insereMovimento( Movimentos movimento )
	{
		return repository.save( movimento );
//		return repository.insereMovimento( movimento );
	}
	
	
}