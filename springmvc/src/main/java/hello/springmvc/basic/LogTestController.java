package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestController {

    //현재 나의 클래스 지정 getLogger(LogTestController.class) 동일
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        String age = "18";

        log.trace("trace log = {} {}", name, age);
        log.debug("debug log = {}", name);   //개발 서버에서
        log.info("info log = {}", name);     //비지니스 정보, 운영시스템에서도 봐야 될 정보
        log.warn("warn log = {}", name);     //경고
        log.error("error log = {}", name);   //에러

        return "ok";
    }
}
