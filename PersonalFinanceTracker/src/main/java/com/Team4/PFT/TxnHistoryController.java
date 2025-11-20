package com.Team4.PFT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/txnHistory")
public class TxnHistoryController {
	
	
	@Autowired
	private TxnHistoryService txnHistoryService;
	
	
	//Route that  is used to consume and input CSV data to DB...Scotia's CSV format is currently only supported.
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
	
	
}
