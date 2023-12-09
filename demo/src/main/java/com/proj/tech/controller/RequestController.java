package com.proj.tech.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/request")
@Transactional
public class RequestController {

    @PostMapping
    @ResponseBody
    public String getRequest() {
        return "<h1>Request Received</h1>";
    }
}
