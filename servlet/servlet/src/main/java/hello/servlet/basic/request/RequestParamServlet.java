package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("!! 전체 파라미터 조회 !!");

        req.getParameterNames().asIterator()
                .forEachRemaining(name -> System.out.println(name + " : " + req.getParameter(name)));
        System.out.println();

        System.out.println("!! 단일 파라미터 조회 !!");
        String username = req.getParameter("username");
        System.out.println("req.getParmeter(username) : " + username);

        System.out.println("!! 이름이 같은 복수 파라미터 조회 !!");
        String[] usernames = req.getParameterValues("username");

        for(String name : usernames){
            System.out.println("username : " + name);
        }

        resp.getWriter().write("OK");
    }
}
