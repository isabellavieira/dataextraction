package model;

import javax.persistence.*;

@Table(name = "camel_bug_commit")
@Entity
public class CamelCommitBugId {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "bug_id")
	private Integer bug_id;
	
	@Column(name = "file_fix", columnDefinition="TEXT")
	private String file_fix;
	
	@Column(name = "commit_fix")
	private String commit_fix;
	

	public String getCommit_fix() {
		return commit_fix;
	}

	public void setCommit_fix(String commit_fix) {
		this.commit_fix = commit_fix;
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

	
	

}