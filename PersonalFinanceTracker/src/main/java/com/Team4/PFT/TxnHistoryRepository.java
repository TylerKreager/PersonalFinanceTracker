package com.Team4.PFT;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxnHistoryRepository extends JpaRepository<TxnHistory, UUID>{

	
}
