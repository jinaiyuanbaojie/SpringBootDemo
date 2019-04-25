package com.jinaiyuan.web.controller;

import com.jinaiyuan.web.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

@RestController
@RequestMapping("/demo")
public class HelloSprintBootController {

    @RequestMapping("/hello")
    public Map index() {
        Map result = new HashMap<Integer, String>();
        result.put(1, "Chance");
        result.put(2, "Tanner");
        result.put(3, "Andrew");

        //返回json格式
        return result;
    }

    //重定向
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public void foo(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.baidu.com");
    }

    @RequestMapping("/hashcode")
    public int getHashCode() {
        return hashCode();
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("Error Happen.");
    }
}