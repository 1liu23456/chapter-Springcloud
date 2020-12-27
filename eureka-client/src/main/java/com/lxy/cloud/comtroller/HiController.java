package com.lxy.cloud.comtroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HiController {
    @Value("${server.port}")
    String port;
    @GetMapping(value = "/hi")
    public String home(@RequestParam String name) {
        return "hi" + name + ", i am from port:" + port;
    }

    @GetMapping(value = "/testRest")
    public String testRest() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.baidu.com/", String.class);
    }
}
