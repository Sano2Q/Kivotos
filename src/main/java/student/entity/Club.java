package student.entity;

public class Club {
    private int cid;
    private String cname;
    private String csynopsis;
    private String academy;
    private int cnumber;
    private String cleader;

    public Club() {
    }

    public Club(int cid, String cname, String csynopsis, String academy, int cnumber, String cleader) {
        this.cid = cid;
        this.cname = cname;
        this.csynopsis = csynopsis;
        this.academy = academy;
        this.cnumber = cnumber;
        this.cleader = cleader;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsynopsis() {
        return csynopsis;
    }

    public void setCsynopsis(String csynopsis) {
        this.csynopsis = csynopsis;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public int getCnumber() {
        return cnumber;
    }

    public void setCnumber(int cnumber) {
        this.cnumber = cnumber;
    }

    public String getCleader() {
        return cleader;
    }

    public void setCleader(String cleader) {
        this.cleader = cleader;
    }
}
