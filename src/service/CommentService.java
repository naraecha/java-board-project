package service;

import model.Comment;
import model.Member;
import java.util.ArrayList;

public class CommentService {

    private ArrayList<Comment> comments = new ArrayList<>();

    public Comment write(int postId, Member author, String content) {
        // TODO 8-1: Comment 생성 → 추가 → 메시지 출력 → 반환
        Comment comment = new Comment(postId, author.getMemberId(), author.getName(), content);

        comments.add(comment);

        System.out.println("댓글이 작성되었습니다.");

        return comment;
    }

    public void listByPost(int postId) {
        // TODO 8-2: 임시 result 리스트에 postId 일치 댓글만 추려서 출력
        ArrayList<Comment> result = new ArrayList<>();

        for (Comment c : comments) {
            if (c.getPostId() == postId) {
                result.add(c);
            }
        }

        if (result.isEmpty()) {
            System.out.println("댓글이 없습니다.");
            return;
        }

        for (Comment c : result) {
            System.out.println(c);
        }
    }

    public boolean delete(int commentId, Member loginMember) {
        // TODO 8-3: commentId로 찾기 → 권한 체크 → 삭제
        Comment target = null;

        for (Comment c : comments) {
            if (c.getCommentId() == commentId) {
                target = c;
                break;
            }
        }

        if (target == null) {
            System.out.println("댓글이 존재하지 않습니다.");
            return false;
        }

        if (target.getMemberId() != loginMember.getMemberId()) {
            System.out.println("본인이 작성한 댓글만 삭제할 수 있습니다.");
            return false;
        }

        comments.remove(target);
        System.out.println("삭제가 완료되었습니다.");

        return true;

    }
}