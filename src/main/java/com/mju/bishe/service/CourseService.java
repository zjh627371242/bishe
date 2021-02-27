package com.mju.bishe.service;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import com.mju.bishe.common.Result;
import com.mju.bishe.entity.Course;

import java.util.Map;

public interface CourseService extends IService<Course> {
    Result<IPage<Course>> list(Map map);
}
