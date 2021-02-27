package com.mju.bishe.service.impl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mju.bishe.entity.Course;
import com.mju.bishe.mapper.CourseMapper;
import com.mju.bishe.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CourseServiceImpl extends ServiceImpl<CourseMapper,Course> implements CourseService {
    @Autowired
    CourseMapper courseMapper;
}
