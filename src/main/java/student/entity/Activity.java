package student.entity;

import java.sql.Date;

public class Activity {
    private Integer aid;
    private String aname;
    private String asynopsis;
    private Date starttime;
    private Date endtime;
    private String place;
    private Integer anumber;
    private Integer club;
    private String clubName;
    private String aleader;

    public Activity() {
    }

    public Activity(Integer aid, String aname, String asynopsis, Date starttime, Date endtime, String place, Integer anumber, Integer club, String aleader) {
        this.aid = aid;
        this.aname = aname;
        this.asynopsis = asynopsis;
        this.starttime = starttime;
        this.endtime = endtime;
        this.place = place;
        this.anumber = anumber;
        this.club = club;
        this.aleader = aleader;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAsynopsis() {
        return asynopsis;
    }

    public void setAsynopsis(String asynopsis) {
        this.asynopsis = asynopsis;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getAnumber() {
        return anumber;
    }

    public void setAnumber(Integer anumber) {
        this.anumber = anumber;
    }

    public Integer getClub() {
        return club;
    }

    public void setClub(Integer club) {
        this.club = club;
    }

    public String getAleader() {
        return aleader;
    }

    public void setAleader(String aleader) {
        this.aleader = aleader;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
