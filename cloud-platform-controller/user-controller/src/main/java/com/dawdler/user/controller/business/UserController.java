package com.dawdler.user.controller.business;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dawdler.common.Result;
import com.dawdler.session.user.SessionUser;
import com.dawdler.user.entity.ShopUser;
import com.dawdler.user.service.UserService;
import com.dawdler.user.service.dto.UserDTO;


@RequestMapping(value="/api/user")
@RestController
@EnableDiscoveryClient
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(path = "/user_page", method = RequestMethod.GET)
    public Result<List<ShopUser>> getUserPages(String name) {
        UserDTO dto = new UserDTO();
        dto.setUserName(name);
        return Result.success(userService.queryByPage(dto,0,10));
    }
    
    
    @RequestMapping(path = "/setUser", method = RequestMethod.GET)
    public void setUser(HttpSession session,String name) {
    	SessionUser user = new SessionUser();
    	user.setNickName(name);
    	System.out.println(session);
    	session.setAttribute("session_user", user);
    }




}


