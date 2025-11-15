package com.Team4.PFT;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User, Long>{
	
	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);
	

}
