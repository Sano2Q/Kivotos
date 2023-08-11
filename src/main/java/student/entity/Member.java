package student.entity;

public class Member {
    private Integer mid;
    private String mname;
    private String username;
    private String password;
    private int role;
    private String age;
    private String birthday;
    private String height;
    private String grade;
    private String hobby;
    private Integer club;
    private String clubName;

    public Member() {
    }

    public Member(Integer mid, String mname, String username, String password, int role, String age, String birthday, String height, String grade, String hobby, Integer club) {
        this.mid = mid;
        this.mname = mname;
        this.username = username;
        this.password = password;
        this.role = role;
        this.age = age;
        this.birthday = birthday;
        this.height = height;
        this.grade = grade;
        this.hobby = hobby;
        this.club = club;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getClub() {
        return club;
    }

    public void setClub(Integer club) {
        this.club = club;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
