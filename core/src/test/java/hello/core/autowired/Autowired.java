package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.member.Member;
import io.micrometer.common.lang.Nullable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Autowired {

    @Test
    void AutoWired() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        // (required = false) 의존관계가 없으면 이 자체가 호출이 안됨
        @org.springframework.beans.factory.annotation.Autowired(required = false)
        public void setNoBean(Member noBean1) {
            System.out.println("noBean 1= " + noBean1);
        }

        @org.springframework.beans.factory.annotation.Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean 2= " + noBean2);
        }

        @org.springframework.beans.factory.annotation.Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean 3= " + noBean3);
        }
    }
}
