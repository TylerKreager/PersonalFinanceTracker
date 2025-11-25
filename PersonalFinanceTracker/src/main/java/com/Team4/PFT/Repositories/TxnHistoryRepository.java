package com.Team4.PFT.Repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Team4.PFT.Entities.TxnHistory;
import com.Team4.PFT.Entities.User;

@Repository
public interface TxnHistoryRepository extends JpaRepository<TxnHistory, UUID>{
	
	List<TxnHistory> findByUser_userId(Long userId);

	List<TxnHistory> findByUserAndTxnDateBetween(User user, LocalDate startDate, LocalDate endDate);
	//void save(com.Team4.PFT.Entities.TxnHistory txn);
	
}
	