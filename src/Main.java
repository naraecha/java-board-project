import model.Member;
import service.CommentService;
import service.MemberService;
import service.PostService;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static MemberService memberService = new MemberService();

    public static void main(String[] args) {

        MemberService memberService = new MemberService();
        PostService postService = new PostService();
        CommentService commentService = new CommentService();

        while (true) {
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 게시글 목록 보기");
            System.out.println("0. 종료");
            System.out.print("▶ 선택 : ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1: Member newmember = inputJoin();
                case 2: Member login = inputLogin();
            }
        }
    }

    // 회원가입
    private static Member inputJoin() {
        System.out.print("이름 입력 : ");
        String name = sc.nextLine();
        sc.nextLine();
        System.out.print("이메일 입력 : ");
        String email = sc.nextLine();
        System.out.print("비밀번호 입력 : ");
        String password = sc.nextLine();
        return memberService.join(name, email, password);
    }

    private static Member inputLogin() {
        System.out.print("이메일 입력 : ");
        String email = sc.nextLine();
        System.out.print("비밀번호 입력 : ");
        String password = sc.nextLine();
        return memberService.login(email, password);
    }

}
