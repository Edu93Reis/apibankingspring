package com.internetbanking.edu.internetbankingedu.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.internetbanking.edu.internetbankingedu.model.Movimentos;

public interface MovimentosService {
	
	Movimentos insereMovimento( Movimentos movimento );
	
	void update( Movimentos movimento );
	
	Page<Movimentos> findBetweenDates( Movimentos movimentos, Pageable pg );	
	
	Page<Movimentos> getMovimentos( Long idConta, Pageable pageable );

}
