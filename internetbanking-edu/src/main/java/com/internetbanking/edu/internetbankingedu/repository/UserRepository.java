package com.internetbanking.edu.internetbankingedu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internetbanking.edu.internetbankingedu.model.User;

public interface UserRepository extends JpaRepository<User, Long> 
{

	Optional<User> findByCPF( String cpf );

	boolean existsByCPF( String cpf );
	
}
