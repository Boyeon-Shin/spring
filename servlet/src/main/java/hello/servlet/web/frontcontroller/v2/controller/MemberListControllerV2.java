package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.MyView;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("mvcMemberListServlet2.service");
        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);
        System.out.println(members);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
