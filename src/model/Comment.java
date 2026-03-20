package model;

public class Comment {

    // TODO 7-1: static idCounter 선언
    static int idCounter = 0;

    // TODO 7-2: commentId, postId, memberId, memberName, content 필드
    private int commentId;
    private int postId;
    private int memberId;
    private String memberName;
    private String content;


    public Comment(int postId, int memberId, String memberName, String content) {
        // TODO 7-3: 자동 채번 및 필드 초기화
        idCounter++;
        this.commentId = idCounter;

        this.postId = postId;
        this.memberId = memberId;
        this.memberName = memberName;
        this.content = content;
    }

    // TODO 7-4: getter 5개 + toString()
    public static int getIdCounter() {
        return idCounter;
    }

    public int getCommentId() {
        return commentId;
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

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return " └ [댓글" + commentId + "] " + memberName + " - " + content;
    }
}