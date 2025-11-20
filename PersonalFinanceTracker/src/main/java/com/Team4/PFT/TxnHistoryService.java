package com.Team4.PFT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Team4.PFT.DTOs.TxnHistoryDTO;

@Service
public class TxnHistoryService {
	@Autowired
	private TxnHistoryRepository txnHistoryRepository;
	@Autowired
	private LoginRepository loginRepository;
	
	
	//This is the service for consuming the CSV and addidng to DB.
	public void uploadCSV(MultipartFile file, Long userId) throws IOException {
		
		User user = loginRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found by ID"));
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
			String line;
			boolean isFirstLine = true;
			
			while ((line = reader.readLine()) != null) {
				if (isFirstLine) {
					isFirstLine = false;
					continue;
				}
				
				//If CSV format is same as Scotia (Filter,Date,Description,Sub-description,Type of Transaction,Amount,Balance) this will support it. 
				TxnHistory txn = new TxnHistory();
				txn.setTxnId(UUID.randomUUID());
				txn.setUser(user);
				String[] fields = line.split(",");
				txn.setTxnDate(LocalDate.parse(fields[1].trim().replace("\"", "")));
				txn.setDescription(fields[2].toString().replace("\"", ""));
				txn.setSubDescription(fields[3].toString().replace("\"", ""));
				txn.setTxnType(fields[4].toString().replace("\"", ""));
				txn.setTxnAmount(Double.parseDouble(fields[5].trim().replace("\"", "")));
				txn.setBalance(Double.parseDouble(fields[5].trim().replace("\"", "")));
				
				txnHistoryRepository.save(txn);
				
				
			}
		}
	}
	
	
	//Getting all txn data for user and returning it in list.
	public List<TxnHistoryDTO> getAllHistory(Long userId) throws IOException {
		List<TxnHistory> txns = txnHistoryRepository.findByUser_userId(userId);
				
		return txns.stream()
				.map(TxnHistoryDTO::new)
				.collect(Collectors.toList());
		
	}
}
