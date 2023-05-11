package com.internetbanking.edu.internetbankingedu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.internetbanking.edu.internetbankingedu.model.Movimentos;

@Repository
public interface MovimentosRepository extends JpaRepository<Movimentos, Long> 
{
	
	@Query( value = "INSERT INTO Movimentos VALUES ( ?, ?, ?, ?, ? )", nativeQuery = true )
	Movimentos insereMovimento( Movimentos movimento );
	
	@Query( value = "SELECT * FROM Movimentos WHERE idConta = ? AND data between ? and ?", nativeQuery = true )
	Page<Movimentos> findBetweenDates( Movimentos movimentos, Pageable pageable );

	@Query( value = "SELECT * FROM Movimentos WHERE idConta = ?", nativeQuery = true )
	Page<Movimentos> getMovimentos( Long idConta, Pageable pageable );
	
}
