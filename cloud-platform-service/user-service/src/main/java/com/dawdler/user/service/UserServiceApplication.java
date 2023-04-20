package com.dawdler.user.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
* @ClassName: UserServiceApplication 
* @Description: 用户服务启动类
* @author jackson.song
* @date 2021年5月17日
*
 */
@Configuration
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.dawdler.user.service.mapper"})
@ServletComponentScan
@EnableTransactionManagement
@EnableScheduling
@EnableCaching
public class UserServiceApplication {


  public static void main(String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }
 

}