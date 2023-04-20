package com.dawdler.gateway.boostrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
* @ClassName: GatewayServiceApplication 
* @Description: 网关服务的启动类
* @author jackson.song
* @date 2021年5月17日
*
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {
	public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}
