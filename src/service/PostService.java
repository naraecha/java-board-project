package service;

import model.Member;
import model.Post;
import java.util.ArrayList;

public class PostService {

    private ArrayList<Post> posts = new ArrayList<>();

    public Post write(Member author, String title, String content) {
        // TODO 5-1: Post 생성 → 리스트 추가 → 메시지 출력 → 반환
        Post post = new Post(author.getMemberId(), author.getName(),
                title, content);

        posts.add(post);

        System.out.println("게시글이 작성되었습니다.");

        return post;
    }

    public void listAll() {
        // TODO 5-2: 비어있으면 안내, 아니면 전체 출력
        if (posts.isEmpty()) {
            System.out.println("게시글이 없습니다.");
            return;
        }

        for (Post p : posts) {
            System.out.println(p); // toString 자동 호출
        }
    }

    public Post findById(int postId) {
        // TODO 5-3: postId 일치하는 Post 반환, 없으면 null
        for (Post p : posts) {
            if (p.getPostId() == postId) {
                return p;
            }
        }
        return null;
    }

    public boolean delete(int postId, Member loginMember) {

        // TODO 6-1: findById()로 게시글 조회, null이면 메시지 출력 후 false 반환
        Post post = findById(postId);
        if (post == null) {
            System.out.println("게시글이 존재하지 않습니다.");
            return false;
        }

        // TODO 6-2: 작성자 ID와 로그인 회원 ID 비교, 다르면 경고 후 false 반환
        if (post.getMemberId() != loginMember.getMemberId()) {
            System.out.println("본인이 작성한 글만 삭제할 수 있습니다.");
            return false;
        }

        // TODO 6-3: 리스트에서 게시글 제거 후 완료 메시지, true 반환
        posts.remove(post);
        System.out.println("삭제 완료");

        return true;
    }
    public void listAllWithComments(CommentService commentService) {
        if (posts.isEmpty()) {
            System.out.println("게시글이 없습니다.");
            return;
        }

        for (Post p : posts) {
            System.out.println(p);
            commentService.listByPost(p.getPostId());
        }
    }

}