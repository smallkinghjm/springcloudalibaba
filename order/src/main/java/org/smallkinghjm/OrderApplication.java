package org.smallkinghjm;

import org.ribbon.RuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RibbonClients(value = {
        @RibbonClient(name = "stock-service",configuration = RuleConfig.class)
})
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OrderApplication.class, args);
//        printConfig(run);
    }

    //动态感知nacos-config的配置
    private static void printConfig(ConfigurableApplicationContext run){
        while (true){
            String userName = run.getEnvironment().getProperty("user.name");
            String password = run.getEnvironment().getProperty("user.password");
            System.out.println("name:"+userName+";password:"+password);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
