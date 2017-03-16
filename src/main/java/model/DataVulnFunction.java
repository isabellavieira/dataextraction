package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "code_header")
@Entity
public class DataVulnFunction {

	@Id
	private String p_id;

	@Column(name = "v_id")
	private String v_id;
	
	
	@Column(name = "cveid")
	private String cveid;

	@Column(name = "p_commit")
	private String p_commit;

	@Column(name = "V_METHOD_DIFF")
	private String V_METHOD_DIFF;

	@Column(name = "v_file")
	private String v_file;
	
	@Column(name = "commit_author")
	private String commit_author;

	
	
	
	public String getCveid() {
		return cveid;
	}

	public void setCveid(String cveid) {
		this.cveid = cveid;
	}

	public String getCommit_author() {
		return commit_author;
	}

	public void setCommit_author(String commit_author) {
		this.commit_author = commit_author;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getV_id() {
		return v_id;
	}

	public void setV_id(String v_id) {
		this.v_id = v_id;
	}

	public String getCommit_fixed() {
		return p_commit;
	}

	public void setCommit_fixed(String commit_fixed) {
		this.p_commit = commit_fixed;
	}

	public String getV_METHOD_DIFF() {
		return V_METHOD_DIFF;
	}

	public void setV_METHOD_DIFF(String v_METHOD_DIFF) {
		V_METHOD_DIFF = v_METHOD_DIFF;
	}

	public String getV_FILE() {
		return v_file;
	}

	public void setV_FILE(String v_FILE) {
		v_file = v_FILE;
	}

	

	



}