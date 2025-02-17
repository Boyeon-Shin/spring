package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemoryRepository;

public class FixDiscountPolicy implements DiscountPolicy {
    MemberRepository memberRepository = new MemoryMemoryRepository();

    private int discountFixAmount = 1000;   //1000원 할인

    @Override
    public int discount(final Member member, int quantity) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
