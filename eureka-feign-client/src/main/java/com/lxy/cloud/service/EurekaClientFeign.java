package com.lxy.cloud.service;

import com.lxy.cloud.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",configuration = FeignConfig.class)
public interface EurekaClientFeign {
    @GetMapping(value = "/hi")
    String sayHiClient(@RequestParam(value = "name") String  name);
}
