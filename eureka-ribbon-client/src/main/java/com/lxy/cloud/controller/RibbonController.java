package com.lxy.cloud.controller;

import com.lxy.cloud.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    RibbonService ribbonService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam(required = false,defaultValue = "lxy") String name) {
        return ribbonService.hi(name);
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/testRibbon")
    public String testRibbon() {
        ServiceInstance instance = loadBalancerClient.choose("stores");
        return instance.getHost() + ":" + instance.getPort();
    }
}
