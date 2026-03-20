import java.util.Scanner;
import model.Member;
import service.MemberService;
import service.PostService;
import service.CommentService;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MemberService memberService = new MemberService();
        PostService postService = new PostService();
        CommentService commentService = new CommentService();

        Member loginMember = null;

        while (true) {
            System.out.println("\n=== 메인 메뉴 ===");
            System.out.println("1. 회원가입");
            System.out.println("2. 회원목록");
            System.out.println("3. 로그인");
            System.out.println("4. 게시글 목록");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {

                case 1: // 회원가입
                    System.out.print("이름: ");
                    String name = sc.nextLine();
                    System.out.print("이메일: ");
                    String email = sc.nextLine();
                    System.out.print("비밀번호: ");
                    String pw = sc.nextLine();

                    memberService.join(name, email, pw);
                    break;

                case 2: // 회원목록
                    memberService.listAll();
                    break;

                case 3: // 로그인
                    System.out.print("이메일: ");
                    String loginEmail = sc.nextLine();
                    System.out.print("비밀번호: ");
                    String loginPw = sc.nextLine();

                    loginMember = memberService.login(loginEmail, loginPw);
                    break;

                case 4: // 게시글 메뉴
                    postMenu(sc, postService, commentService, loginMember);
                    break;

                case 5:
                    System.out.println("프로그램 종료");
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public static void postMenu(Scanner sc, PostService postService,
                                CommentService commentService,
                                Member loginMember) {

        while (true) {
            System.out.println("\n=== 게시글 목록 ===");
            postService.listAllWithComments(commentService);

            System.out.println("\n1. 글 작성");
            System.out.println("2. 글 삭제");
            System.out.println("3. 댓글 작성");
            System.out.println("4. 댓글 삭제");
            System.out.println("5. 뒤로가기");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {

                case 1: // 글 작성
                    if (loginMember == null) {
                        System.out.println("로그인 후 이용하세요.");
                        break;
                    }

                    System.out.print("제목: ");
                    String title = sc.nextLine();
                    System.out.print("내용: ");
                    String content = sc.nextLine();

                    postService.write(loginMember, title, content);

                    break;

                case 2: // 글 삭제
                    if (loginMember == null) {
                        System.out.println("로그인 후 이용하세요.");
                        break;
                    }

                    postService.listAll();

                    System.out.print("삭제할 글 번호: ");
                    int postId = sc.nextInt();

                    postService.delete(postId, loginMember);
                    break;

                case 3: // 댓글 작성
                    if (loginMember == null) {
                        System.out.println("로그인 후 이용하세요.");
                        break;
                    }

                    postService.listAll();

                    System.out.print("게시글 번호: ");
                    int pId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("댓글 내용: ");
                    String cmt = sc.nextLine();

                    commentService.write(pId, loginMember, cmt);
                    commentService.listByPost(pId); // 댓글 목록
                    break;

                case 4: // 댓글 삭제
                    if (loginMember == null) {
                        System.out.println("로그인 후 이용하세요.");
                        break;
                    }

                    postService.listAll();

                    System.out.print("게시글 번호: ");
                    int pId2 = sc.nextInt();

                    commentService.listByPost(pId2);

                    System.out.print("삭제할 댓글 번호: ");
                    int commentId = sc.nextInt();

                    commentService.delete(commentId, loginMember);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

}