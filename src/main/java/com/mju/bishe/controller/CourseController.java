package com.mju.bishe.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mju.bishe.common.PageParams;
import com.mju.bishe.common.Result;
import com.mju.bishe.common.ResultFactory;
import com.mju.bishe.entity.Course;
import com.mju.bishe.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Api(value = "服务接口", tags = "服务接口")
@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService targetService;
    /**
     * 获取分页数据
     */
    @ApiOperation(value = "获取分页数据", notes = "获取分页数据")
    @PostMapping(value = "/list")
    @ResponseBody
    public Result<IPage<Course>> list(@RequestBody Map map){
        QueryWrapper<Course> queryWrapper=new QueryWrapper();
        PageParams pageParams=new PageParams(map);
        return ResultFactory.success(targetService.page(pageParams,queryWrapper));
    }
}
