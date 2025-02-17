package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemoryRepository;

public class OrderServiceImpl implements OrderService {
    MemberRepository memberRepository = new MemoryMemoryRepository();
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(final Long memberId, final String itemName, final int itemPrice) {
        final Member member = memberRepository.findById(memberId);
        int discountPrice = 0;
        if (member != null) {
            discountPrice = discountPolicy.discount(member, itemPrice);
        }
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
