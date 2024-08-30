package com.example.springdemo.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springdemo.test.domain.BbsResponseDTO;

@Controller
public class TestController {
    @RequestMapping("/index.kdt")
    public String index() {
        System.out.println("debug >>> test controller index client path : /index.kdt");
        return "index";
    }

    @RequestMapping(value = "/api/bbs/ctrl/test", method = RequestMethod.GET)
    @ResponseBody
    public BbsResponseDTO test() {
        // BbsResponseDTO response = BbsResponseDTO.builder()
        //                             .id(1)
        //                             .title("test")
        //                             .content("test")
        //                             .build();
        // return response;
        return null;
    }
}
