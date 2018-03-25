package com.safecard.jpa.model;

import com.safecard.jpa.converter.DateTimeStampConverter;

import java.util.Date;

import javax.persistence.*;

/**
 * Created by RAMKMADDELA on 02/09/18.
 */

@Entity
@Table(name="TRACKRECORD")
public class TrackRecord {

	private static final long serialVersionUID = -3009157732242241606L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "MESSAGE_TYPE_ID")
	private String messageTypeId;

	@Column(name = "CARD_ISSUANCE_TYPE_ID")
	private String cardIssuanceTypeId;

	@Column(name = "CARD_NUMBER")
	private String pan;


	@Column(name = "PAN_SEQ_NO")
	private String panSequenceNumber;

	@Column(name = "MEMBER_ID")
	private String memberId;

	@Column(name = "CARD_NAME")
	private String cardHolderName;

	@Column(name = "PIN")
	private String pin;

	@Column(name = "PIN_OFFSET")
	private String pinOffset;

	@Column(name = "CVV")
	private String cvv;

	@Column(name = "CVV2")
	private String cvv2;

	@Column(name = "EXPIRATION_DATE")
	@Temporal(TemporalType.DATE)
	private Date expirationDate;

	@Column(name = "MAG_SERVICE_CODE")
	private String magServiceCode;

	@Column(name = "CHIP_SERVICE_CODE")
	private String chipServiceCode;

	@Column(name = "CARD_DESIGN_ID")
	private String cardDesignID;

	@Column(name = "I_CVV")
	private String iCvv;

	@Column(name = "CARD_DEVICE_NAME")
	private String smartcardDeviceName;

	@Column(name = "SVC_CODE")
	private String serviceCode;

	@Column(name = "TRACK1_DISCRETIONARY_DATA")
	private String track1DiscretionaryData;

	@Column(name = "TRACK2_DISCRETIONARY_DATA")
	private String track2DiscretionaryData;

	@Column(name = "CVV_CODE1")
	private String cvvCode1;

	@Column(name = "CVV_CODE2")
	private String cvvCode2;

	@Column(name = "CONTROL_NUMBER")
	private String controlNumber;

	@Column(name = "CREATE_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;

	@Column(name = "FILE_ID")
	private long fileId;

	@Column(name = "JOB_ID")
	private long jobId;

	@Column(name = "RECORD_NUMBER")
	private long recordNumber;

	@Column(name = "KEY_INDEX")
	private String keyIndex;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(String messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public String getCardIssuanceTypeId() {
		return cardIssuanceTypeId;
	}

	public void setCardIssuanceTypeId(String cardIssuanceTypeId) {
		this.cardIssuanceTypeId = cardIssuanceTypeId;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPanSequenceNumber() {
		return panSequenceNumber;
	}

	public void setPanSequenceNumber(String panSequenceNumber) {
		this.panSequenceNumber = panSequenceNumber;
	}

	public String getCardDesignID() {
		return cardDesignID;
	}

	public void setCardDesignID(String cardDesignID) {
		this.cardDesignID = cardDesignID;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public long getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(long recordNumber) {
		this.recordNumber = recordNumber;
	}

	public String getPinOffset() {
		return pinOffset;
	}

	public void setPinOffset(String pinOffset) {
		this.pinOffset = pinOffset;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getCvv2() {
		return cvv2;
	}

	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getMagServiceCode() {
		return magServiceCode;
	}

	public void setMagServiceCode(String magServiceCode) {
		this.magServiceCode = magServiceCode;
	}

	public String getChipServiceCode() {
		return chipServiceCode;
	}

	public void setChipServiceCode(String chipServiceCode) {
		this.chipServiceCode = chipServiceCode;
	}

	public String getiCvv() {
		return iCvv;
	}

	public void setiCvv(String iCvv) {
		this.iCvv = iCvv;
	}

	public String getSmartcardDeviceName() {
		return smartcardDeviceName;
	}

	public void setSmartcardDeviceName(String smartcardDeviceName) {
		this.smartcardDeviceName = smartcardDeviceName;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getTrack1DiscretionaryData() {
		return track1DiscretionaryData;
	}

	public void setTrack1DiscretionaryData(String track1DiscretionaryData) {
		this.track1DiscretionaryData = track1DiscretionaryData;
	}

	public String getTrack2DiscretionaryData() {
		return track2DiscretionaryData;
	}

	public void setTrack2DiscretionaryData(String track2DiscretionaryData) {
		this.track2DiscretionaryData = track2DiscretionaryData;
	}

	public String getCvvCode1() {
		return cvvCode1;
	}

	public void setCvvCode1(String cvvCode1) {
		this.cvvCode1 = cvvCode1;
	}

	public String getCvvCode2() {
		return cvvCode2;
	}

	public void setCvvCode2(String cvvCode2) {
		this.cvvCode2 = cvvCode2;
	}

	public String getKeyIndex() {
		return keyIndex;
	}

	public void setKeyIndex(String keyIndex) {
		this.keyIndex = keyIndex;
	}
}
