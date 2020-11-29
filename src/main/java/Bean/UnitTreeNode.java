package main.java.Bean;

public class UnitTreeNode {
    private int opid;
    private String id;
    private String name;
    private String pid;

    public UnitTreeNode(String _id, String _name, String _pid) {
        this.id = _id;
        this.name = _name;
        this.pid = _pid;
    }

    public UnitTreeNode() {
        this.pid = "NULL";
        this.id = "NULL";
        this.name = "NULL";
    }

    public void show() {
        System.out.println(this.id + " " + this.name + " " + this.pid);
    }

    public int getOpid() {return opid;}

    public void setOpid(int opid) {this.opid = opid;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
