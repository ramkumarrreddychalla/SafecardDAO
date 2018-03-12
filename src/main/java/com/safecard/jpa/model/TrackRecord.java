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

	@Column(name = "LOT_NO")
	private String lotNumber;
	
	@Column(name = "CONTROL_NO")
	private String controlNumber;

	@Column(name = "CARD_NO")
	private String cardNumber;

	@Column(name = "CARDHOLDER_NAME")
	private String cardHolderName;

	@Column(name = "SHIP_NAME")
	private String shipName;

	@Column(name = "EXPIRY_DATE")
	@Temporal(TemporalType.DATE)
	private Date expiryDate;

//	@Column(name = "CVC_CVV2")
//	private String cvc;
//
//	@Column(name = "TRACK1_DATA")
//	private String track1Data;
//
//	@Column(name = "TRACK2_DATA")
//	private String track2Data;

	@Column(name = "CARD_DESIGN_ID")
	private String cardDesignId;

	@Column(name = "CREATE_TS", insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;

	@Column(name = "JOB_ID")
	private String jobId;

	public String getLotNumber() {
		return lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public String getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public long getId() {	return id;	}

	public void setId(long id) {  this.id = id;	}

	//
	//	public String getCvc() {
	//		return cvc;
	//	}
	//
	//	public void setCvc(String cvc) {
	//		this.cvc = cvc;
	//	}
	//
	//	public String getTrack1Data() {
	//		return track1Data;
	//	}
	//
	//	public void setTrack1Data(String track1Data) {
	//		this.track1Data = track1Data;
	//	}
	//
	//	public String getTrack2Data() {
	//		return track2Data;
	//	}
	//
	//	public void setTrack2Data(String track2Data) {
	//		this.track2Data = track2Data;
	//	}

	public String getCardDesignId() {
		return cardDesignId;
	}

	public void setCardDesignId(String cardDesignId) {
		this.cardDesignId = cardDesignId;
	}

	public Date getCreatedDateTime() {		return createdDateTime;	}

	public void setCreatedDateTime(Date createdDateTime) {		this.createdDateTime = createdDateTime;	}

	public TrackRecord() {
	}

	public TrackRecord(String lotNumber, String controlNumber,
					   String cardNumber, String cardHolderName,
					   String shipName, Date expiryDate, String cardDesignId) {
		this.lotNumber = lotNumber;
		this.controlNumber = controlNumber;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.shipName = shipName;
		this.expiryDate = expiryDate;
		this.cardDesignId = cardDesignId;
	}

	public TrackRecord(String lotNumber, String controlNumber,
					   String cardNumber, String cardHolderName,
					   String shipName, String cardDesignId) {
		this.lotNumber = lotNumber;
		this.controlNumber = controlNumber;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.shipName = shipName;
		this.cardDesignId = cardDesignId;
	}

	public TrackRecord(String lotNumber, String cardNumber) {
		this.lotNumber = lotNumber;
		this.cardNumber = cardNumber;
	}
}
