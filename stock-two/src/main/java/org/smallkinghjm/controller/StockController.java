package org.smallkinghjm.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @RequestMapping("/reduct")
    public String demo(){
        return "8082已扣减库存";
    }
}
