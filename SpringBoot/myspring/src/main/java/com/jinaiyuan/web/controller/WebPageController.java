package com.jinaiyuan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPageController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://www.baidu.com");
        // 渲染templates文件夹下的index.html文件
        return "index";
    }
}
