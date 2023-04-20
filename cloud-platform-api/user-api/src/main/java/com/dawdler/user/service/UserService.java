package com.dawdler.user.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawdler.user.entity.ShopUser;
import com.dawdler.user.service.dto.UserDTO;

@FeignClient(name = "user-service",contextId = "user-service-UserService")
@Component
public interface UserService {

    @RequestMapping(path = "/user/list", method = RequestMethod.POST)
    List<ShopUser> queryByPage(@RequestBody UserDTO userDTO, @RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize") Integer pageSize);

}
