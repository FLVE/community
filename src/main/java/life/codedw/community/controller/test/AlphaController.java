package life.codedw.community.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Author wangjiefang
 * @Date 13:52 2020/5/7
 * @Description
 **/
@Controller
@RequestMapping("/alpha")
public class AlphaController {


    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello SpringBoot";
    }

    @RequestMapping("http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println(request.getParameter("code"));

        response.setContentType("text/html;charset=utf-8");
        try(
                PrintWriter out = response.getWriter();
                ) {

            out.write("<h1>社区</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //get请求
    //student?current=3&limit=40
    @RequestMapping(path = "/student",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";

    }

    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@PathVariable int id){
        System.out.println(id);
        return "students";
    }



}
