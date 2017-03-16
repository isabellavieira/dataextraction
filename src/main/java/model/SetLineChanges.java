package model;

import javax.persistence.*;

@Table(name = "LinesChanged")
@Entity
public class SetLineChanges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "commit_history")
    private String commit;
    @Column(name = "lines_Changed_add", columnDefinition = "TEXT")
    private String lines_Changed_add;
    @Column(name = "lines_Changed_removed", columnDefinition = "TEXT")
    private String lines_Changed_removed;
    @Column(name = "v_id")
    private String v_id;

    @Column(name = "P_ID")
    private String p_id;


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

    @Column(name = "file_path")
    private String file;

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}