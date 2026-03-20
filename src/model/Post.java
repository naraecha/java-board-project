package model;

public class Post {

    // TODO 4-1: static idCounter 필드 선언
    static int idCounter = 0;

    // TODO 4-2: postId, memberId, memberName, title, content 필드 선언
    private int postId;
    private int memberId;
    private String memberName;
    private String title;
    private String content;

    public Post(int memberId, String memberName, String title, String content) {
        // TODO 4-3: 자동 채번 및 필드 초기화
        idCounter++;
        this.postId = idCounter;

        this.memberId = memberId;
        this.memberName = memberName;
        this.title = title;
        this.content = content;
    }

    // TODO 4-4: getter 5개 구현
    public static int getIdCounter() {
        return idCounter;
    }

    public int getPostId() {
        return postId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        // TODO 4-5: "[1] 제목 (작성자: 이름)" 형식
        return "[" + postId + "] 제목 (작성자: " + memberName + ")";
    }
}