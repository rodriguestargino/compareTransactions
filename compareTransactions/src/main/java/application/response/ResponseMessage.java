package application.response;

public class ResponseMessage {

	private String message;
	
	private int countUnMatchRecord;
	
	private int countMatchRecord;
	
	private long countRecordList1;

	private long countRecordList2;
	
	public ResponseMessage() {
		super();
	}

	public ResponseMessage(String message) {
		this.message = message;
	}
	
	public ResponseMessage(String message, int countUnMatchRecord, int countMatchRecord, long countRecordList1,
			long countRecordList2) {
		super();
		this.message = message;
		this.countUnMatchRecord = countUnMatchRecord;
		this.countMatchRecord = countMatchRecord;
		this.countRecordList1 = countRecordList1;
		this.countRecordList2 = countRecordList2;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCountUnMatchRecord() {
		return countUnMatchRecord;
	}

	public void setCountUnMatchRecord(int countUnMatchRecord) {
		this.countUnMatchRecord = countUnMatchRecord;
	}

	public int getCountMatchRecord() {
		return countMatchRecord;
	}

	public void setCountMatchRecord(int countMatchRecord) {
		this.countMatchRecord = countMatchRecord;
	}

	public long getCountRecordList1() {
		return countRecordList1;
	}

	public void setCountRecordList1(long countRecordList1) {
		this.countRecordList1 = countRecordList1;
	}

	public long getCountRecordList2() {
		return countRecordList2;
	}

	public void setCountRecordList2(long countRecordList2) {
		this.countRecordList2 = countRecordList2;
	}

}
