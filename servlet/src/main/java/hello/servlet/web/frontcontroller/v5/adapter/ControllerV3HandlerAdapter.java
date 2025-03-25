package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.ModelView;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    //ControllerV3을 처리할 수 있는 어댑터를 뜻함
    @Override
    public boolean supports(final Object handler) {
        return (handler instanceof ControllerV3);
    }

    //handler를 컨트롤러 V3로 변환한 다음에 V3형식에 맞도록 호출함
    @Override
    public ModelView handle(final HttpServletRequest request, final HttpServletResponse response,
                            final Object handler) {
        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);
        return mv;
    }

    private Map<String, String> createParamMap(final HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
