package model;

import javax.persistence.*;

@Table(name = "CVEData")
@Entity
public class CVEData  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "CVEID")
	private String CVEID;

	@Column(name = "CWEID")
	private String CWEID;

	@Column(name = "VulnerabilityType")
	private String VulnerabilityType;

	@Column(name = "PublishDate")
	private String publishDate;

	@Column(name = "updateDate")
	private String updateDate;

	@Column(name = "score")
	private String score;

	@Column(name = "GainedAccessLevel")
	private String gainedAccessLevel;
	@Column(name = "access")
	private String access;

	@Column(name = "complexity")
	private String complexity;
	@Column(name = "authentication")
	private String authentication;
	@Column(name = "configuration")
	private String configuration;

	@Column(name = "integrity")
	private String integrity;

	@Column(name = "Avail")
	private String avail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCVE() {
		return CVEID;
	}

	public void setCVE(String cVE) {
		this.CVEID = cVE;
	}

	public String getCWE() {
		return CWEID;
	}

	public void setCWE(String cWE) {
		this.CWEID = cWE;
	}

	public String getVulnerabilityType() {
		return VulnerabilityType;
	}

	public void setVulnerabilityType(String vulnerabilityType) {
		VulnerabilityType = vulnerabilityType;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getGainedAccessLevel() {
		return gainedAccessLevel;
	}

	public void setGainedAccessLevel(String gainedAccessLevel) {
		this.gainedAccessLevel = gainedAccessLevel;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getConfiguration() {
		return configuration;
	}

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

	public String getIntegrity() {
		return integrity;
	}

	public void setIntegrity(String integrity) {
		this.integrity = integrity;
	}

	public String getAvail() {
		return avail;
	}

	public void setAvail(String avail) {
		this.avail = avail;
	}

}