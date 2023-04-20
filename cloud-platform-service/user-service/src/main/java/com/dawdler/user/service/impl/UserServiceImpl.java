package com.dawdler.user.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import com.dawdler.user.entity.ShopUser;
import com.dawdler.user.service.UserService;
import com.dawdler.user.service.dto.UserDTO;
import com.dawdler.user.service.mapper.ShopUserMapper;

@RestController
public class UserServiceImpl implements UserService {

    @Resource
    private ShopUserMapper shopUserMapper;


    @Override
    public List<ShopUser> queryByPage(UserDTO userDTO, Integer pageNo, Integer pageSize) {
        return  shopUserMapper.queryByPage(userDTO);
    }



}
