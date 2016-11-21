package com.sample.controller;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

    @RequestMapping(value = "/HelloWorld", method = GET)
    public String show() {
        // jspのファイル名
        return "/HelloWorld/test";
    }
}