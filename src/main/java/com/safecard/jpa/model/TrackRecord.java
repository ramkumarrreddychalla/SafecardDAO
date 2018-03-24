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

	@Column(name = "PAN_NO")
	private String panNumber;

	@Column(name = "PAN_SEQ_NO")
	private String panSequenceNumber;

	@Column(name = "SVC_CODE")
	private String serviceCode;

	@Column(name = "EXPIRY_DATE")
	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	@Column(name = "EFFECTIVE_DATE")
	@Temporal(TemporalType.DATE)
	private Date effDate;

	@Column(name = "CARDHOLDER_NAME")
	private String cardHolderName;

	@Column(name = "TRACK1_DATA")
	private String track1Data;

	@Column(name = "TRACK2_DATA")
	private String track2Data;

	@Column(name = "CVV_CODE1")
	private String cvvCode1;

	@Column(name = "CVV_CODE2")
	private String cvvCode2;

	@Column(name = "PIN")
	private String pin;

	@Column(name = "CREATE_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;

	@Column(name = "JOB_ID")
	private long jobId;

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPanSequenceNumber() {
		return panSequenceNumber;
	}

	public void setPanSequenceNumber(String panSequenceNumber) {
		this.panSequenceNumber = panSequenceNumber;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getTrack1Data() {
		return track1Data;
	}

	public void setTrack1Data(String track1Data) {
		this.track1Data = track1Data;
	}

	public String getTrack2Data() {
		return track2Data;
	}

	public void setTrack2Data(String track2Data) {
		this.track2Data = track2Data;
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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
}
