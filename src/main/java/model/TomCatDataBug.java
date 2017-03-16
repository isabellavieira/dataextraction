package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "bug_and_files")
@Entity
public class TomCatDataBug implements Cloneable {


  

	@Id
	private Integer id;

	@Column(name = "bug_id")
	private String bug_id;

	@Column(name = "summary")
	private String summary;

	@Column(name = "description")
	private String description;
	
	@Column(name = "add_description",columnDefinition = "TEXT")
	private String add_description;

	@Column(name = "bag_of_word_stemmed")
	private String bag_of_word_stemmed;
	
	
	
	@Column(name = "summary_stemmed")
	private String summary_stemmed;
	
	
	@Column(name = "description_stemmed")
	private String description_stemmed;
	
	@Column(name = "report_time")
	private String report_time;
	
	@Column(name = "report_timestamp")
	private String report_timestamp;
	
	
	@Column(name = "status")
	private String status;
	
	
	@Column(name = "commit")
	private String commit;
	
	@Column(name = "commit_timestamp")
	private String commit_timestamp;
	
	@Column(name = "files")
	private String files;
	
	

	@Column(name = "version")
	private String version;


	  @Override
	    public TomCatDataBug clone() throws CloneNotSupportedException {
	        return (TomCatDataBug) super.clone();
	    }

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getBug_id() {
		return bug_id;
	}



	public void setBug_id(String bug_id) {
		this.bug_id = bug_id;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getBag_of_word_stemmed() {
		return bag_of_word_stemmed;
	}



	public void setBag_of_word_stemmed(String bag_of_word_stemmed) {
		this.bag_of_word_stemmed = bag_of_word_stemmed;
	}



	public String getSummary_stemmed() {
		return summary_stemmed;
	}



	public void setSummary_stemmed(String summary_stemmed) {
		this.summary_stemmed = summary_stemmed;
	}



	public String getDescription_stemmed() {
		return description_stemmed;
	}



	public void setDescription_stemmed(String description_stemmed) {
		this.description_stemmed = description_stemmed;
	}



	public String getReport_time() {
		return report_time;
	}



	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}



	public String getReport_timestamp() {
		return report_timestamp;
	}



	public void setReport_timestamp(String report_timestamp) {
		this.report_timestamp = report_timestamp;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getCommit() {
		return commit;
	}



	public void setCommit(String commit) {
		this.commit = commit;
	}



	public String getCommit_timestamp() {
		return commit_timestamp;
	}



	public void setCommit_timestamp(String commit_timestamp) {
		this.commit_timestamp = commit_timestamp;
	}



	public String getFiles() {
		return files;
	}



	public void setFiles(String files) {
		this.files = files;
	}



	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}

	public String getAdd_description() {
		return add_description;
	}

	public void setAdd_description(String add_description) {
		this.add_description = add_description;
	}
	
	
	
	

	
	

}