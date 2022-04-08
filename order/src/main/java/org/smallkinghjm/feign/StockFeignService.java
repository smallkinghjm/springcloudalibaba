package org.smallkinghjm.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * name 指定调用rest接口所对应的服务名
 * path 指定调用rest接口所在的Controller指定的RequestMapping的值（若是Controller类上没有，这里就不用写）
 */
@FeignClient(name = "stock-service",path = "/stock")
public interface StockFeignService {//接口名字一般根据调用的xxController写xxFeignService,如这里这里时调用了StockController

    /**
     * 需要调用的方法
     */
    @RequestMapping("/reduct")
    String demo();
}
