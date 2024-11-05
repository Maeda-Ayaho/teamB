//仮置き。
//現状、いれない
package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
public class HomeController {
    @RequestMapping("/hoge")
    public String index() {
        return "resources/top";
    }
}