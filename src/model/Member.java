package model;

public class Member {
    // static idCounter 필드 선언
    static int idCounter = 1;

    // postId, memberId, memberName, title, content 필드 선언
    private int memberId;
    private String name;
    private String email;
    private String password;

    // 자동 채번 및 필드 초기화
    public Member(String name, String email, String password) {
        this.memberId = idCounter++;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    /// ////////////////////////
    // getter 5개 구현
    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (%s)", memberId, name, email);
    }
}
