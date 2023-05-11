package com.internetbanking.edu.internetbankingedu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internetbanking.edu.internetbankingedu.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{

	Optional<User> findById( Long idUser );

	Optional<User> findByCpf( String cpf );

	boolean existsByCpf( String cpf );
	
}
