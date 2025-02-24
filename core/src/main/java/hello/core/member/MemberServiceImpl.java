package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired  //ac.getBean(MemberRepository.class) 느낌으로 빈을 가져옴
    //어떤 구현 객체가 주입될지 알수 없음, 오직 외부에서 결정됨(실행에만 집중)
    public MemberServiceImpl(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
       return   memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
