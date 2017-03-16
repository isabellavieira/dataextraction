package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "derby_bug_file_revision_update")
@Entity
public class DerbyFileAndRevisionFixUpdate {

	@Id
	private Integer id;

	@Column(name = "bug_id")
	private Integer bug_id;
	
	@Column(name = "bug_id_git")
	private String bug_id_git;

	@Column(name = "file_fix", columnDefinition = "TEXT")
	private String file_fix;

	@Column(name = "revision_fix")
	private String revision_fix;

	@Column(name = "link_fix", columnDefinition = "TEXT")
	private String link_fix;

	@Column(name = "commit_git")
	private String commit_git;

	@Column(name = "git_svn_id")
	private String git_svn_id;

	@Column(name = "description_git", columnDefinition = "TEXT")
	private String description_git;

	@Column(name = "revision_on_git")
	private Integer revision_on_git;

	
	
	public String getCommit_git() {
		return commit_git;
	}

	public void setCommit_git(String commit_git) {
		this.commit_git = commit_git;
	}

	public String getGit_svn_id() {
		return git_svn_id;
	}

	public void setGit_svn_id(String git_svn_id) {
		this.git_svn_id = git_svn_id;
	}

	public String getDescription_git() {
		return description_git;
	}

	public void setDescription_git(String description_git) {
		this.description_git = description_git;
	}

	public Integer getRevision_on_git() {
		return revision_on_git;
	}

	public void setRevision_on_git(Integer revision_on_git) {
		this.revision_on_git = revision_on_git;
	}

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

	public String getBug_id_git() {
		return bug_id_git;
	}

	public void setBug_id_git(String bug_id_git) {
		this.bug_id_git = bug_id_git;
	}
	
	

}