package hello.servlet.web.frontcontroller.v3.controller;


import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.ModelView;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(final Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
