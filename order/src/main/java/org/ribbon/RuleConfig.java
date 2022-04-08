package org.ribbon;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 引入Ribbon修改默认负载均衡策略
 *Ribbon是客户端负载均衡，所以配置在服务消费方，在调用微服务接口时，会在注册中心上获取注册信息服务列表之后缓存到JVM上，实现RPC远程服务调用技术
 * 在spring boot中有两种方式引入(二选一即可）：
 * 1.配置类，即当前的类
 * 2.配置文件，看bootstrap.yaml文件中的
 *
 * 注意：自定义的Ribbon算法配置类不能放在@ComponentScan所扫描的当前包及其子包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊定制化的目的
 */
@Configuration
public class RuleConfig {

    //方法名一定要叫iRule()
    @Bean
    public IRule iRule(){
//        return new BestAvailableRule();//光标放在IRule上，按ctrl+alt+b查看其实现类
//        return new RoundRobinRule();
        return new RandomRule();
    }
}
