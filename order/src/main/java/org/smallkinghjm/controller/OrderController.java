package org.smallkinghjm.controller;

import lombok.extern.slf4j.Slf4j;
import org.smallkinghjm.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    StockFeignService stockFeignService;

    @RequestMapping("/add")
    public String orderAdd(){
        log.info("下单");
        String msg = stockFeignService.demo();
        return msg+"下单成功";
    }
}
