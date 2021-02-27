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


@Api(value = "课程管理接口", tags = "课程管理接口")
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
    /**
     * 删除课程
     */
    @ApiOperation(value = "删除课程", notes = "删除课程")
    @PostMapping(value = "/delete")
    @ResponseBody
    public Result delete(@RequestBody Long id){
        if (targetService.removeById(id)){
            return ResultFactory.success("删除成功",null);
        }else {
            return ResultFactory.failed("删除失败",null);
        }
    }
    /**
     * 新增课程
     */
    @ApiOperation(value = "新增课程", notes = "新增课程")
    @PostMapping(value = "/add")
    @ResponseBody
    public Result add(@RequestBody Course course){
        if (targetService.save(course)){
            return ResultFactory.success("新增成功",null);
        }else {
            return ResultFactory.failed("新增失败",null);
        }
    }
    /**
     * 修改课程
     */
    @ApiOperation(value = "修改课程", notes = "修改课程")
    @PostMapping(value = "/edit")
    @ResponseBody
    public Result edit(@RequestBody Course course){
        if (targetService.updateById(course)){
            return ResultFactory.success("修改成功",null);
        }else {
            return ResultFactory.failed("修改失败",null);
        }
    }
}
