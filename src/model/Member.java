package model;

public class Member {
    static int idCounter = 1;

    private int memberId;
    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {
        this.memberId = idCounter++;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (%s)", memberId, name, email);
    }
}