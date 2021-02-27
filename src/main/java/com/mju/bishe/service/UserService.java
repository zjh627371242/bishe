package com.mju.bishe.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mju.bishe.common.Result;
import com.mju.bishe.entity.User;

import java.util.Map;

public interface UserService extends IService<User> {
    Result loginCheck(Map map);
}
