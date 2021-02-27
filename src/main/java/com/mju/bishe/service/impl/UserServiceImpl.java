package com.mju.bishe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mju.bishe.common.Result;
import com.mju.bishe.common.ResultFactory;
import com.mju.bishe.entity.User;
import com.mju.bishe.mapper.UserMapper;
import com.mju.bishe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Result loginCheck(Map map) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",map.get("name"));
        queryWrapper.eq("password",map.get("password"));
        User user = userMapper.selectOne(queryWrapper);
        if (user!=null){
            return ResultFactory.success(null);
        }
        return ResultFactory.failed("账号或密码错误",null);
    }
}
