package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.ModelView;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(final Map<String, String> paramMap) {
        List<Member> memberList = memberRepository.findAll();

        ModelView mv = new ModelView("members");
        mv.getModel().put("memberList", memberList);

        return mv;
    }
}
