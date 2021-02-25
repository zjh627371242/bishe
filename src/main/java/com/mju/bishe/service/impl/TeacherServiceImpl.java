package com.mju.bishe.service.impl;


import com.mju.bishe.mapper.TeacherMapper;
import com.mju.bishe.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
}
