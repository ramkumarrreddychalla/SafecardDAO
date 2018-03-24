package com.safecard.jpa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by RAMKMADDELA on 02/09/18.
 */

@Entity
@Table(name="JOB")
public class Job {

	private static final long serialVersionUID = -3009157732242241606L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "JOB_ID")
	private long id;

	@Column(name = "JOB_NAME")
	private String jobName;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "JOB_DATE")
	@Temporal(TemporalType.DATE)
	private Date jobDate;

	@Column(name = "CREATE_TS", insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;

	@Column(name = "RECORDS_COUNT")
	private long recordsCount;

	public Job(){}

	public Job(String jobName, String fileName, Date jobDate, Date createdDateTime) {
		this.jobName = jobName;
		this.fileName = fileName;
		this.jobDate = jobDate;
		this.createdDateTime = createdDateTime;
	}

	public Job(String jobName, String fileName, Date jobDate) {
		this.jobName = jobName;
		this.fileName = fileName;
		this.jobDate = jobDate;
	}

	public Job(String jobName, String fileName, Date jobDate, long recordsCount) {
		this.jobName = jobName;
		this.fileName = fileName;
		this.jobDate = jobDate;
		this.recordsCount = recordsCount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getJobDate() {
		return jobDate;
	}

	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public long getRecordsCount() {
		return recordsCount;
	}

	public void setRecordsCount(long recordsCount) {
		this.recordsCount = recordsCount;
	}
}
