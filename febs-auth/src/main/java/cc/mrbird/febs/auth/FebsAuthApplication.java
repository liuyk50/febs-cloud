package cc.mrbird.febs.auth;

import cc.mrbird.febs.auth.manager.UserManager;
import cc.mrbird.febs.common.annotation.EnableFebsAuthExceptionHandler;
import cc.mrbird.febs.common.annotation.EnableFebsLettuceRedis;
import cc.mrbird.febs.common.annotation.EnableFebsServerProtect;
import cc.mrbird.febs.common.annotation.FebsCloudApplication;
import cc.mrbird.febs.common.entity.system.SystemUser;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 认证中心，有认证服务（别的微服务可以通过这个名称从注册中心获取FEBS-Auth提供的服务），资源服务（对外提供REST服务
 * ，比如通过Token获取当前登录用户信息，注销当前Token等），加密安全服务（安全配置）
 */
@EnableDiscoveryClient
@SpringBootApplication
@FebsCloudApplication
@EnableFebsAuthExceptionHandler
@EnableFebsLettuceRedis
@MapperScan("cc.mrbird.febs.auth.mapper")
public class FebsAuthApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FebsAuthApplication.class, args);
        String[] names = run.getBeanDefinitionNames();
        for (String ss:names){
            System.out.println(ss);
        }
//        UserManager userManager = (UserManager) run.getBean("userManager");
//        SystemUser mrBird = userManager.findByName("mrbird");
//        String permissions = userManager.findUserPermissions("MrBird");
//        System.out.println(mrBird);
//        System.out.println(permissions);


    }

}
