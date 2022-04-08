package org.smallkinghjm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public String orderAdd(){
        log.info("下单");
        String msg = restTemplate.getForObject("http://stock-service/stock/reduct/", String.class);
        return msg+"下单成功";
    }
}
