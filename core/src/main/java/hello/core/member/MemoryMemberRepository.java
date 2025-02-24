package hello.core.member;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store= new HashMap<>();

    @Override
    public void save(final Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(final Long memberId) {
        return store.get(memberId);
    }
}
