package com.Team4.PFT.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Team4.PFT.Entities.User;

import com.Team4.PFT.Entities.UserType;

@Repository
public interface LoginRepository extends JpaRepository<User, Long>{
	
	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);
	

}
