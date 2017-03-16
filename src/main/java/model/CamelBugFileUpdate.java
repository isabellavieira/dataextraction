package model;

import javax.persistence.*;

@Table(name = "camel_bug_file")
@Entity
public class CamelBugFileUpdate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "issue_id")
	private Integer bug_id;
	
	@Column(name = "files", columnDefinition="TEXT")
	private String files;

	
	
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

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
	
	

}