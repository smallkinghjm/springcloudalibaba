package org.smallkinghjm.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.smallkinghjm.feign.StockFeignService;
import org.smallkinghjm.sentinel.BlockHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/order")
@RefreshScope//支持@Value的动态感知
public class OrderController {

    @Value("${user.name}")
    private String name;

    @Autowired
    StockFeignService stockFeignService;

    @RequestMapping("/add")
    /**
     * @SentinelResource流控规则
     * value    定义资源，值就是上面RequestMapping的值
     * blockHandler 流量降级后的处理方法
     * blockHandlerClass    处理方法所在的类
     */
    @SentinelResource(value = "add",blockHandler = "blockHandlerForOrderAdd",blockHandlerClass = BlockHandle.class)
    public String orderAdd(){
        log.info("下单");
        String msg = stockFeignService.demo();
        return msg+"下单成功";
    }

    @RequestMapping("/config")
    public String show(){
        return name;
    }
}
