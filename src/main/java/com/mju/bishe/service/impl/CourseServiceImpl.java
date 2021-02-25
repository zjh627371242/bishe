package com.mju.bishe.service.impl;


import com.mju.bishe.mapper.CourseMapper;
import com.mju.bishe.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
}
