package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseView1() {
        //뷰 이름 정하기
        ModelAndView modelAndView = new ModelAndView("response/hello")
                .addObject("data", "Hello World");
        return modelAndView;
    }


    @RequestMapping("/response-view-v2")
    public String responseView2(Model model) {
        model.addAttribute("data", "Hello World");
        // @Controller에 넣으면서 스트링으로 반환하면 뷰의 논리적인 이름으로 바뀜
        return "response/hello";
    }

    //추천하지 않는 방식
    @RequestMapping("/response/hello")
    public void responseView3(Model model) {
        model.addAttribute("data", "Hello World");
    }
}

