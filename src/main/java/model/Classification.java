//package model;
//
//import security.br.ufal.ic.classification.ODCStructures;
//
//import javax.persistence.*;
//
//@Table(name = "Classification")
//@Entity
//public class Classification {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	@Column(name = "file_path")
//	private String file_path;
//
//	@Column(name = "version")
//	private String version;
//
//	@Column(name = "path")
//	private String path;
//
//	@Column(name = "module")
//	private String module;
//
//	@Column(name = "dateAge")
//	private Integer dateAge;
//
//	@Column(name = "dateMonth")
//	private Integer dateMonth;
//
//	@Column(name = "CVEID")
//	private String CVEID;
//
//	@Column(name = "dateT")
//	private String dateT;
//
//	@Column(name = "func")
//	private String func;
//
//	@Column(name = "commit")
//	private String commit;
//
//	@Column(name = "vulnerability")
//	private int vulnerability;
//
//	@Column(name = "timestamp")
//	private Float timestamp;
//
//	@Column(name = "typeofChange")
//	private String typeofChange;
//
//	@Column(name = "P_ID")
//	private String P_ID;
//
//	public String getP_ID() {
//		return P_ID;
//	}
//
//	public void setP_ID(String p_ID) {
//		P_ID = p_ID;
//	}
//
//	@Column(name = "typeOfStructure")
//	private ODCStructures typeOfStructure;
//
//	public String getTypeofChange() {
//		return typeofChange;
//	}
//
//	public void setTypeofChange(String typeofChange) {
//		this.typeofChange = typeofChange;
//	}
//
//	public ODCStructures getTypeOfStructure() {
//		return typeOfStructure;
//	}
//
//	public void setTypeOfStructure(ODCStructures typeOfStructure) {
//		this.typeOfStructure = typeOfStructure;
//	}
//
//
//	public void setDateAge(Integer dateAge) {
//		this.dateAge = dateAge;
//	}
//
//	public void setDateMonth(Integer dateMonth) {
//		this.dateMonth = dateMonth;
//	}
//
//	public int getVulnerability() {
//		return vulnerability;
//	}
//
//	public void setVulnerability(int vulnerability) {
//		this.vulnerability = vulnerability;
//	}
//
//	public String getCommit() {
//		return commit;
//	}
//
//	public void setCommit(String commit) {
//		this.commit = commit;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getFile() {
//		return file_path;
//	}
//
//	public void setFile(String file) {
//		this.file_path = file;
//	}
//
//	public String getFunction() {
//		return func;
//	}
//
//	public void setFunction(String function) {
//		this.func = function;
//	}
//
//	public String getCVEID() {
//		return CVEID;
//	}
//
//	public void setCVEID(String cVEID) {
//		CVEID = cVEID;
//	}
//
//	public String getFile_path() {
//		return file_path;
//	}
//
//	public void setFile_path(String file_path) {
//		this.file_path = file_path;
//	}
//
//	public String getFunc() {
//		return func;
//	}
//
//	public void setFunc(String func) {
//		this.func = func;
//	}
//
//	public String getPath() {
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}
//
//	public String getModule() {
//		return module;
//	}
//
//	public void setModule(String module) {
//		this.module = module;
//	}
//
//	public String getVersion() {
//		return version;
//	}
//
//	public void setVersion(String version) {
//		this.version = version;
//	}
//
//	public String getDateT() {
//		return dateT;
//	}
//
//	public void setDateT(String string) {
//		this.dateT = string;
//	}
//
//	public int getDateAge() {
//		return dateAge;
//	}
//
//	public void setDateAge(int dateAge) {
//		this.dateAge = dateAge;
//	}
//
//	public int getDateMonth() {
//		return dateMonth;
//	}
//
//	public void setDateMonth(int dateMonth) {
//		this.dateMonth = dateMonth;
//	}
//
//
//	public Float getTimestamp() {
//		return timestamp;
//	}
//
//	public void setTimestamp(Float timestamp) {
//		this.timestamp = timestamp;
//	}
//}