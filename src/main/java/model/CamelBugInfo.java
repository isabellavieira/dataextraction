package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ApacheDataSetBugsCamel")
@Entity
public class CamelBugInfo {

	@Id
	private Integer id;

	@Column(name = "issue_id")
	private int issue_id;

	@Column(name = "type")
	private String type;

	@Column(name = "status")
	private String status;

	@Column(name = "resolution")
	private String resolution;

	@Column(name = "component")
	private String component;

	@Column(name = "priority")
	private String priority;

	@Column(name = "reporter")
	private String reporter;

	@Column(name = "created")
	private String created;
	
	@Column(name = "assigned")
	private String assigned;
	
	@Column(name = "assignee")
	private String assignee;
	
	@Column(name = "resolved")
	private String resolved;

	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "affected_version")
	private String affected_version;
	
	@Column(name = "fixed_version")
	private String fixed_version;
	
	@Column(name = "votes")
	private int votes;
	
	@Column(name = "watches")
	private int watches;
	
	@Column(name = "description_words")
	private int description_words;
	
	@Column(name = "assingnee_count")
	private int assingnee_count;
	
	@Column(name = "comment_count")
	private int comment_count;
	
	@Column(name = "commenter")
	private int commenter;
	
	@Column(name = "Surprising")
	private int Surprising;
	
	@Column(name = "Dormant")
	private int Dormant;
	
	@Column(name = "Blocker")
	private int Blocker;
	
	@Column(name = "Security")
	private int Security;
	
	@Column(name = "Performance")
	private int Performance;
	
	@Column(name = "Breakage")
	private int Breakage;
	
	@Column(name = "commit_count")
	private int commit_count;
	
	@Column(name = "file_count")
	private String file_count;
	
//	@Column(name = "files", columnDefinition = "TEXT")
//	private String files;

	
	
	
	
	
	
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
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

	
	

	public int getCommenter() {
		return commenter;
	}

	public void setCommenter(int commenter) {
		this.commenter = commenter;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getWatches() {
		return watches;
	}

	public void setWatches(int watches) {
		this.watches = watches;
	}

	public int getDescription_words() {
		return description_words;
	}

	public void setDescription_words(int description_words) {
		this.description_words = description_words;
	}

	public int getAssingnee_count() {
		return assingnee_count;
	}

	public void setAssingnee_count(int assingnee_count) {
		this.assingnee_count = assingnee_count;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public int getCommentator_count() {
		return commenter;
	}

	public void setCommentator_count(int commenter) {
		this.commenter = commenter;
	}

	public int getSurprising() {
		return Surprising;
	}

	public void setSurprising(int surprising) {
		Surprising = surprising;
	}

	public int getDormant() {
		return Dormant;
	}

	public void setDormant(int dormant) {
		Dormant = dormant;
	}

	public int getBlocker() {
		return Blocker;
	}

	public void setBlocker(int blocker) {
		Blocker = blocker;
	}

	public int getSecurity() {
		return Security;
	}

	public void setSecurity(int security) {
		Security = security;
	}

	public int getPerformance() {
		return Performance;
	}

	public void setPerformance(int performance) {
		Performance = performance;
	}

	public int getBreakage() {
		return Breakage;
	}

	public void setBreakage(int breakage) {
		Breakage = breakage;
	}

	public int getCommit_count() {
		return commit_count;
	}

	public void setCommit_count(int commit_count) {
		this.commit_count = commit_count;
	}

	public String getFile_count() {
		return file_count;
	}

	public void setFile_count(String file_count) {
		this.file_count = file_count;
	}

	

//	public String getFiles() {
//		return files;
//	}
//
//	public void setFiles(String files) {
//		this.files = files;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}

	public String getAffected_version() {
		return affected_version;
	}

	public void setAffected_version(String affected_version) {
		this.affected_version = affected_version;
	}

	public String getFixed_version() {
		return fixed_version;
	}

	public void setFixed_version(String fixed_version) {
		this.fixed_version = fixed_version;
	}

	
	
	
	
	
	
	
	
	

}