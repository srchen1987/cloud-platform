package com.dawdler.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
* @ClassName: UserControllerApplication 
* @Description: 用户服务的启动类
* @author jackson.song
* @date 2021年5月17日
*
 */
@Configuration
//@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@EnableFeignClients(basePackages = {"com.dawdler.user.service"})
//@ServletComponentScan("com.anywide.dawdler.clientplug.web.session")
//@ComponentScan(basePackages = {"com.dawdler.user.controller"})
@SpringBootApplication(scanBasePackages = "com.dawdler.user.controller",exclude = DataSourceAutoConfiguration.class)
public class UserControllerApplication {

  public static void main(String[] args) { 
    SpringApplication.run(UserControllerApplication.class, args);
  }
}