package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

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
}
