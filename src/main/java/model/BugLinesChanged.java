package model;

import javax.persistence.*;

@Table(name = "BugLinesChanged")
@Entity
public class BugLinesChanged {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "commitDiff")
	private String commitDiff;
	@Column(name = "lines_Changed_add", columnDefinition = "TEXT")
	private String lines_Changed_add;
	@Column(name = "lines_Changed_removed", columnDefinition = "TEXT")
	private String lines_Changed_removed;
	@Column(name = "bug_id")
	private String bug_id;
	@Column(name = "file_fix")
	private String file_fix;
	@Column(name = "version")
	private String version;
	
	

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommitDiff() {
		return commitDiff;
	}

	public void setCommitDiff(String commitDiff) {
		this.commitDiff = commitDiff;
	}

	public String getLines_Changed_add() {
		return lines_Changed_add;
	}

	public void setLines_Changed_add(String lines_Changed_add) {
		this.lines_Changed_add = lines_Changed_add;
	}

	public String getLines_Changed_removed() {
		return lines_Changed_removed;
	}

	public void setLines_Changed_removed(String lines_Changed_removed) {
		this.lines_Changed_removed = lines_Changed_removed;
	}

	public String getBug_id() {
		return bug_id;
	}

	public void setBug_id(String bug_id) {
		this.bug_id = bug_id;
	}

	public String getFile_fix() {
		return file_fix;
	}

	public void setFile_fix(String file_fix) {
		this.file_fix = file_fix;
	}

}