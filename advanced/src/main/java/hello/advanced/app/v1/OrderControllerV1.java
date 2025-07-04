package hello.advanced.app.v1;

import hello.advanced.app.v0.OrderServiceV0;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class OrderControllerV1{

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 helloTrace;

    @GetMapping("/v1/request")
    public String request(String itemId) {

        TraceStatus status = null;

        try {
            status = helloTrace.begin("OrderControllerV1.request");
            orderService.orderItem(itemId);
            helloTrace.end(status);
        }catch (Exception e){
            helloTrace.exception(status, e);
        }
        return "ok";
    }

}
