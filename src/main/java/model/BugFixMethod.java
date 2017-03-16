package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "bug_fix_methods_general")
@Entity
public class BugFixMethod {

    @Id
    private Integer id;

    @Column(name = "bug_id")
    private String bug_id;

    @Column(name = "description")
    private String description;

    @Column(name = "typeModification")
    private String type_Modification;

    @Column(name = "methods",  columnDefinition = "TEXT")
    private String methods;

    @Column(name = "version")
    private String version;


    @Column(name = "file_changed")
    private String file_chenged;


    @Column(name = "commit_diff")
    private String commit_diff;


    @Column(name = "summary",  columnDefinition = "TEXT")
    private String summary;
    @Column(name = "performance_bug")
    private Integer performance_bug;
    @Column(name = "security_bug")
    private Integer security_bug;

    @Column(name = "affectVersion")
    private String affectVersion;

    @Column(name = "report_timestamp")
    private Float report_timestamp;

    @Column(name = "commit_timestamp")
    private Float commit_timestamp;

    @Column(name = "description_stemmed",  columnDefinition = "TEXT")
    private String description_stemmed;

    @Column(name = "summary_stemmed",  columnDefinition = "TEXT")
    private String summary_stemmed;

    @Column(name = "add_description",  columnDefinition = "TEXT")
    private String add_description;

    @Column(name = "bag_of_word_stemmed",  columnDefinition = "TEXT")
    private String bag_of_word_stemmed;

    @Column(name = "project")
    private String project;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType_Modification() {
        return type_Modification;
    }

    public void setType_Modification(String type_Modification) {
        this.type_Modification = type_Modification;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFile_chenged() {
        return file_chenged;
    }

    public void setFile_chenged(String file_chenged) {
        this.file_chenged = file_chenged;
    }

    public String getCommit_diff() {
        return commit_diff;
    }

    public void setCommit_diff(String commit_diff) {
        this.commit_diff = commit_diff;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPerformance_bug() {
        return performance_bug;
    }

    public void setPerformance_bug(int performance_bug) {
        this.performance_bug = performance_bug;
    }

    public int getSecurity_bug() {
        return security_bug;
    }

    public void setSecurity_bug(int security_bug) {
        this.security_bug = security_bug;
    }

    public String getAffectVersion() {
        return affectVersion;
    }

    public void setAffectVersion(String affectVersion) {
        this.affectVersion = affectVersion;
    }

    public float getReport_timestamp() {
        return report_timestamp;
    }

    public void setReport_timestamp(float report_timestamp) {
        this.report_timestamp = report_timestamp;
    }

    public Float getCommit_timestamp() {
        return commit_timestamp;
    }

    public void setCommit_timestamp(Float commit_timestamp) {
        this.commit_timestamp = commit_timestamp;
    }

    public String getDescription_stemmed() {
        return description_stemmed;
    }

    public void setDescription_stemmed(String description_stemmed) {
        this.description_stemmed = description_stemmed;
    }

    public String getSummary_stemmed() {
        return summary_stemmed;
    }

    public void setSummary_stemmed(String summary_stemmed) {
        this.summary_stemmed = summary_stemmed;
    }

    public String getAdd_description() {
        return add_description;
    }

    public void setAdd_description(String add_description) {
        this.add_description = add_description;
    }

    public String getBag_of_word_stemmed() {
        return bag_of_word_stemmed;
    }

    public void setBag_of_word_stemmed(String bag_of_word_stemmed) {
        this.bag_of_word_stemmed = bag_of_word_stemmed;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
