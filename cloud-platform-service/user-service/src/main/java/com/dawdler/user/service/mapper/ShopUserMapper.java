package com.dawdler.user.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dawdler.user.entity.ShopUser;
import com.dawdler.user.service.dto.UserDTO;

@Mapper
public interface ShopUserMapper {
    List<ShopUser> queryByPage(@Param("queryDTO") UserDTO queryDTO);
}