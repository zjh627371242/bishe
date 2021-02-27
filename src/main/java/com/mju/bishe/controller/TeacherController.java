package com.mju.bishe.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mju.bishe.common.PageParams;
import com.mju.bishe.common.Result;
import com.mju.bishe.common.ResultFactory;
import com.mju.bishe.entity.Course;
import com.mju.bishe.entity.Teacher;
import com.mju.bishe.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "教师信息处理接口", tags = "教师信息处理接口")
@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService targetService;
    /**
     * 获取分页数据
     */
    @ApiOperation(value = "获取分页数据", notes = "获取分页数据")
    @PostMapping(value = "/list")
    @ResponseBody
    public Result<IPage<Teacher>> list(@RequestBody Map map){
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper();
        PageParams pageParams=new PageParams(map);
        return ResultFactory.success(targetService.page(pageParams,queryWrapper));
    }
    /**
     * 删除教师信息
     */
    @ApiOperation(value = "删除教师信息", notes = "删除教师信息")
    @PostMapping(value = "/delete")
    @ResponseBody
    public Result delete(@RequestBody Long id){
        return targetService.delete(id);
    }
    /**
     * 新增教师
     */
    @ApiOperation(value = "新增教师", notes = "新增教师")
    @PostMapping(value = "/add")
    @ResponseBody
    public Result add(@RequestBody Teacher teacher){
        return targetService.addTeacher(teacher);
    }
    /**
     * 修改教师
     */
    @ApiOperation(value = "修改教师", notes = "修改教师")
    @PostMapping(value = "/edit")
    @ResponseBody
    public Result edit(@RequestBody Teacher teacher){
        return targetService.edit(teacher);
    }
}
