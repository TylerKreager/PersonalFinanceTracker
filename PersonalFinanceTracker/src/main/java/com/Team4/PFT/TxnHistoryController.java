package com.Team4.PFT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Team4.PFT.DTOs.TxnHistoryDTO;

@RestController
@RequestMapping("/api/txnHistory")
public class TxnHistoryController {
	
	
	@Autowired
	private TxnHistoryService txnHistoryService;
	
	
	//Route that is used to consume and input CSV data to DB...Scotia's CSV format is currently only supported.
	@PostMapping("upload")
	public ResponseEntity<String> uploadTxnCSV(@RequestParam("file") MultipartFile file, @RequestParam("userId") Long userId) {
		
		try {
			txnHistoryService.uploadCSV(file, userId);
			return ResponseEntity.ok("CSV has been uploaded successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Upload has failed: " + e.getMessage());
		}
	}
	
	//get all txn data for user.
	@GetMapping("/view/{userId}")
	public ResponseEntity<?> viewHistory(@PathVariable Long userId) {
		
		try {
			List<TxnHistoryDTO> history = txnHistoryService.getAllHistory(userId);
			return ResponseEntity.ok(history);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Fetching history has failed!: " + e.getMessage());
		}
	}
}
