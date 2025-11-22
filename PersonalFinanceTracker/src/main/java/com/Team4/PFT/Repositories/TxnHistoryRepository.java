package com.Team4.PFT.Repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Team4.PFT.Entities.TxnHistory;

@Repository
public interface TxnHistoryRepository extends JpaRepository<TxnHistoryRepository, UUID>{
	
	List<TxnHistoryRepository> findByUser_userId(Long userId);

	void save(com.Team4.PFT.Entities.TxnHistory txn);
	
}
	