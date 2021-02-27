package com.mju.bishe.controller;

import com.mju.bishe.service.TeacherService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "教师信息处理接口", tags = "教师信息处理接口")
@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService targetService;

}
