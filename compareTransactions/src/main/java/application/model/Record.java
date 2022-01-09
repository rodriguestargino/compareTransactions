package application.model;

public class Record {
	
	private String profileName;
	private String transactionDate;
	private String transactionAmount;
	private String transactionNarrative;
	private String transactionDescription;
	private String transactionID;
	private String transactionType;
	private String walletReference;
	private long lineNumber;
	
	public Record(String profileName, String transactionDate, String transactionAmount, String transactionNarrative,
			String transactionDescription, String transactionID, String transactionType, String walletReference,long lineNumber) {
		super();
		this.profileName = profileName;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionNarrative = transactionNarrative;
		this.transactionDescription = transactionDescription;
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.walletReference = walletReference;
		this.lineNumber = lineNumber;
	}
	
	public Record() {
		super();
	}

	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionNarrative() {
		return transactionNarrative;
	}
	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getWalletReference() {
		return walletReference;
	}
	public void setWalletReference(String walletReference) {
		this.walletReference = walletReference;
	}

	public long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(long lineNumber) {
		this.lineNumber = lineNumber;
	}

}
