package service;

import model.Member;
import java.util.ArrayList;

public class MemberService {

    private ArrayList<Member> members = new ArrayList<>();

    public Member join(String name, String email, String password) {

        // TODO 2-1: for-each로 members 순회하며 이메일 중복 체크
        /* TODO */

        // TODO 2-2: Member 생성 → 리스트 추가 → 완료 메시지 출력 → 반환
        /* TODO */
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

    // Q3에서 login() 추가 예정
}