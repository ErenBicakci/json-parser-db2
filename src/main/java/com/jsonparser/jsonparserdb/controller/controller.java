package com.jsonparser.jsonparserdb.controller;

import com.jsonparser.jsonparserdb.service.JSONParseService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class controller {
    private final JSONParseService jsonParseService;

    @GetMapping
    public String startRequest() throws Exception{
        jsonParseService.parse();
        return "İşlem Başarılı";
    }
}
