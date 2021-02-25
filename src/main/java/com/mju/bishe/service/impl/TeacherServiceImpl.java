package com.mju.bishe.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mju.bishe.entity.Teacher;
import com.mju.bishe.mapper.TeacherMapper;
import com.mju.bishe.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
}
