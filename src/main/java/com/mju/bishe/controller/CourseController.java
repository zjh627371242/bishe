package com.mju.bishe.controller;

import com.mju.bishe.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "服务接口", tags = "服务接口")
@RestController
@RequestMapping("course")
public class CourseController {
@Autowired
private CourseService targetService;

}
