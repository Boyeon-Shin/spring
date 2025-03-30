package hello.servlet.web.springmvc.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component("/springmvc/request-handler")
public class MyRequestHandler implements HttpRequestHandler {

    @Override
    public void handleRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("MyRequestHandler.handleRequest");
    }
}
