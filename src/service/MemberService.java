package service;

import model.Member;

import java.util.ArrayList;

public class MemberService {

    private ArrayList<Member> members = new ArrayList<>();

    public Member join(String name, String email, String password) {
        for (Member m : members) {
            if (m.getEmail().equals(email)) {
                System.out.println("이미 존재하는 이메일입니다.");
                return null;
            }
        }
        Member newMember = new Member(name, email, password);
        members.add(newMember);
        System.out.println("회원가입 완료");
        return newMember;
    }

    public void listAll() {
        if (members.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        System.out.println("=== 회원 목록 (" + members.size() + "명) ===");
        for (Member m : members)
            System.out.println(m);
    }

    public Member findById(int memberId) {
        for (Member m : members)
            if (m.getMemberId() == memberId) return m;
        return null;
    }
    public Member login(String email, String password) {
        for (Member m : members) {
            if (m.getEmail().equals(email) && m.getPassword().equals(password)) {
                System.out.printf("로그인 성공 : %s님 환영합니다!", m.getName());
                return m;
            }
        }
        System.out.println("이메일 또는 비밀번호가 틀렸습니다.");
        return null;
    }
}