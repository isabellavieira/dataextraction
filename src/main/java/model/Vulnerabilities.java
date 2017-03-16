package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "VULNERABILITIES")
@Entity
public class Vulnerabilities {

	
	@Id
	@Column(name = "V_ID")
	private String V_ID;
	
	@Column(name = "CVE")
	private String CVE;
	
	@Column(name = "ID_ADVISORIES")
	private String ID_ADVISORIES;



	@Column(name = "V_CLASSIFICATION")
	private String V_CLASSIFICATION;

	@Column(name = "V_IMPACT")
	private String V_IMPACT;

	@Column(name = "BUGZILLA_URL")
	private String BUGZILLA_URL;
	
	@Column(name = "PRODUCTS")
	private String PRODUCTS;


	public String getP_URL() {
		return CVE;
	}

	public void setP_URL(String p_URL) {
		CVE = p_URL;
	}
	
	

	public String getCVE() {
		return CVE;
	}

	public void setCVE(String cVE) {
		CVE = cVE;
	}

	public String getID_ADVISORIES() {
		return ID_ADVISORIES;
	}

	public void setID_ADVISORIES(String iD_ADVISORIES) {
		ID_ADVISORIES = iD_ADVISORIES;
	}

	public String getV_CLASSIFICATION() {
		return V_CLASSIFICATION;
	}

	public void setV_CLASSIFICATION(String v_CLASSIFICATION) {
		V_CLASSIFICATION = v_CLASSIFICATION;
	}

	public String getV_IMPACT() {
		return V_IMPACT;
	}

	public void setV_IMPACT(String v_IMPACT) {
		V_IMPACT = v_IMPACT;
	}

	public String getBUGZILLA_URL() {
		return BUGZILLA_URL;
	}

	public void setBUGZILLA_URL(String bUGZILLA_URL) {
		BUGZILLA_URL = bUGZILLA_URL;
	}

	public String getPRODUCTS() {
		return PRODUCTS;
	}

	public void setPRODUCTS(String pRODUCTS) {
		PRODUCTS = pRODUCTS;
	}

	public String getV_ID() {
		return V_ID;
	}

	public void setV_ID(String v_ID) {
		V_ID = v_ID;
	}

	public String getR_ID() {
		return V_CLASSIFICATION;
	}

	public void setR_ID(String r_ID) {
		V_CLASSIFICATION = r_ID;
	}

	public String getP_COMMIT() {
		return BUGZILLA_URL;
	}

	public void setP_COMMIT(String p_COMMIT) {
		BUGZILLA_URL = p_COMMIT;
	}


	public String getBUG_ID() {
		return ID_ADVISORIES;
	}

	public void setBUG_ID(String bUG_ID) {
		ID_ADVISORIES = bUG_ID;
	}

	
	
}