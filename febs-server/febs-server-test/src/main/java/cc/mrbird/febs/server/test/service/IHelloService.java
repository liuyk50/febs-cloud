package cc.mrbird.febs.server.test.service;

import cc.mrbird.febs.common.entity.FebsServerConstant;
import cc.mrbird.febs.server.test.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @FeignClient注解标注表明这是一个Feign Client
 * value表示远程服务器名称
 * contextId表示Feign Client别名，避免重名使得报错
 * fallbackFactory出错回退使用该方法
 */
@FeignClient(value = FebsServerConstant.FEBS_SERVER_SYSTEM, contextId = "helloServiceClient",
        fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);
}
