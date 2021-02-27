package com.mju.bishe.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mju.bishe.common.PageParams;
import com.mju.bishe.common.Result;
import com.mju.bishe.common.ResultFactory;
import com.mju.bishe.entity.Course;
import com.mju.bishe.mapper.CourseMapper;
import com.mju.bishe.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class CourseServiceImpl extends ServiceImpl<CourseMapper,Course> implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public Result<IPage<Course>> list(Map map) {
        QueryWrapper<Course> queryWrapper=new QueryWrapper();
        queryWrapper.orderByDesc("id");
        PageParams pageParams=new PageParams(map);
        return ResultFactory.success(courseMapper.list(pageParams, map));
    }
}
