package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.v3.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    //handler == 컨트롤러 (어댑터다 해당 컨트톨러를 처리할 수 있늕 판단하는 메서드)
    boolean supports(Object handler);

    //어댑터는 실제 핸들러를 호출하고, 그 결과로 ModelView 반환
    //이전 버전: 프론트 컨트롤러가 실제 컨트롤러를 호출
    //현재 버전: 이 어댑터를 통해 실제 컨트롤러가 호출됨
    ModelView handle(HttpServletRequest reqest, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
