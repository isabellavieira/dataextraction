package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "camel_bug_file_revision")
@Entity
public class CamelFileAndRevisionFix {

	@Id
	private Integer id;

	@Column(name = "bug_id")
	private Integer bug_id;
	
	@Column(name = "file_fix", columnDefinition="TEXT")
	private String file_fix;
	
	

	@Column(name = "revision_fix")
	private String revision_fix;
	
	@Column(name = "link_fix", columnDefinition="TEXT")
	private String link_fix;
	
	

	public String getLink_fix() {
		return link_fix;
	}

	public void setLink_fix(String link_fix) {
		this.link_fix = link_fix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBug_id() {
		return bug_id;
	}

	public void setBug_id(Integer bug_id) {
		this.bug_id = bug_id;
	}

	public String getFile_fix() {
		return file_fix;
	}

	public void setFile_fix(String file_fix) {
		this.file_fix = file_fix;
	}

	public String getRevision_fix() {
		return revision_fix;
	}

	public void setRevision_fix(String revision_fix) {
		this.revision_fix = revision_fix;
	}
	
	

}