package application.rest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import application.model.Record;
import application.response.ResponseMessage;
import application.response.ResponseMessageRegister;
import application.util.CSVUtil;

@RestController
@RequestMapping("/api/csv")
public class MatchFilesController {
	
	List<ResponseMessageRegister> response = new ArrayList<ResponseMessageRegister>();

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file1") @Valid MultipartFile file1,
			@RequestParam("file2") @Valid MultipartFile file2) throws ResponseStatusException{
		String message = "";
		
		if(file1.isEmpty() || file2.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Not Found File. Please send a CSV file.");
		} else if (CSVUtil.hasCSVFormat(file1) && CSVUtil.hasCSVFormat(file2)) {
			try {
				List<Record> list1 = CSVUtil.csvToRecords(file1.getInputStream());
				List<Record> list2 = CSVUtil.csvToRecords(file2.getInputStream());
				
				List<Record> recordsMatch = processUploadFileMatch(list1, list2);
				Integer recordsUnMatch = countProcessUploadFileUnMatch(list1, list2);

				message = "Uploaded the file successfully";

				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, recordsUnMatch,
						recordsMatch.size(), list1.size(), list2.size()));

			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Could not upload the file");
			}
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Please upload a csv file!");
		}
	}
	
	@GetMapping("/recover")
	public ResponseEntity<List<ResponseMessageRegister>> recoverFile() {
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	private List<Record> processUploadFileMatch(List<Record> list1, List<Record> list2) throws IOException {

		List<Record> math = new ArrayList<Record>();

		math = (List<Record>) list1.stream().filter(item1 -> {
			return list2.stream()
					.filter(item2 -> item2.getProfileName().equalsIgnoreCase(item1.getProfileName()) && 
									 item2.getTransactionAmount().equalsIgnoreCase(item1.getTransactionAmount()) &&
									 item2.getTransactionDate().equalsIgnoreCase(item1.getTransactionDate()) &&
									 item2.getTransactionDescription().equalsIgnoreCase(item1.getTransactionDescription()) &&
									 item2.getTransactionID().equalsIgnoreCase(item1.getTransactionID()) &&
									 item2.getTransactionNarrative().equalsIgnoreCase(item1.getTransactionNarrative()) &&
									 item2.getTransactionType().equalsIgnoreCase(item1.getTransactionType()) &&
									 item2.getWalletReference().equals(item1.getWalletReference()) 
							)
					.findAny()
					.isPresent();
		}).collect(Collectors.toList());

		return math;
	}

	private Integer countProcessUploadFileUnMatch(List<Record> list1, List<Record> list2) throws IOException {
		
		response = new ArrayList<ResponseMessageRegister>();
		
		for (Record record1 : list1) {
			for (Record record2 : list2) {
				if(record1.getLineNumber() == record2.getLineNumber() ) {
					if(!record1.getProfileName().equalsIgnoreCase(record2.getProfileName()) ||
							!record1.getTransactionDate().equalsIgnoreCase(record2.getTransactionDate()) ||
							!record1.getTransactionAmount().equalsIgnoreCase(record2.getTransactionAmount()) ||
							!record1.getTransactionID().equalsIgnoreCase(record2.getTransactionID()) ||
							!record1.getTransactionType().equalsIgnoreCase(record2.getTransactionType()) ||
							!record1.getWalletReference().equalsIgnoreCase(record2.getWalletReference()) ||
							!record1.getTransactionNarrative().equalsIgnoreCase(record2.getTransactionNarrative()) ||
							!record1.getTransactionDescription().equalsIgnoreCase(record2.getTransactionDescription())
							) {
						ResponseMessageRegister responseRegister = new ResponseMessageRegister();
						
						responseRegister.setProfileName(record1.getProfileName());
						responseRegister.setProfileName1(record2.getProfileName());
						
						responseRegister.setTransactionAmount(record1.getTransactionAmount());
						responseRegister.setTransactionAmount1(record2.getTransactionAmount());

						responseRegister.setTransactionDate(record1.getTransactionDate());
						responseRegister.setTransactionDate1(record2.getTransactionDate());

						responseRegister.setTransactionID(record1.getTransactionID());
						responseRegister.setTransactionID1(record2.getTransactionID());

						responseRegister.setTransactionType(record1.getTransactionType());
						responseRegister.setTransactionType1(record2.getTransactionType());

						responseRegister.setWalletReference(record1.getWalletReference());
						responseRegister.setWalletReference1(record2.getWalletReference());
						
						responseRegister.setTransactionNarrative(record1.getTransactionNarrative());
						responseRegister.setTransactionNarrative(record2.getTransactionNarrative());

						response.add(responseRegister);
					}
				}
			}
			
		}

		return response.size();

	}

}
