package application.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import application.model.Record;

public class CSVUtil {

	public static String TYPE_EXCEL = "application/vnd.ms-excel";
	public static String TYPE_CSV = "text/csv";
	static String[] HEADERs = { "Id", "Title", "Description", "Published" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (TYPE_CSV.equals(file.getContentType()) || TYPE_EXCEL.equals(file.getContentType())) {
			return true;
		}

		return false;
	}

	public static List<Record> csvToRecords(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Record> records = new ArrayList<Record>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Record record = new Record(csvRecord.get("profileName"), csvRecord.get("transactionDate"),
						csvRecord.get("transactionAmount"), csvRecord.get("transactionNarrative"),
						csvRecord.get("transactionDescription"), csvRecord.get("transactionID"),
						csvRecord.get("transactionType"), csvRecord.get("walletReference"),
						csvRecord.getRecordNumber());

				records.add(record);
			}

			Collections.sort(records, Comparator.comparing(Record::getLineNumber));

			return records;
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "fail to parse CSV file:" + e.getMessage());
		}
	}
}
