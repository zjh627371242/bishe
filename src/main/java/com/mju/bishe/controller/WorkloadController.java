package com.mju.bishe.controller;

import com.mju.bishe.common.ClassCategoryEnum;
import com.mju.bishe.common.Result;
import com.mju.bishe.common.ResultFactory;
import com.mju.bishe.entity.Course;
import com.mju.bishe.entity.Workload;
import com.mju.bishe.service.CourseService;
import com.mju.bishe.service.WorkloadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "教师单个教学任务服务接口", tags = "教师单个教学任务服务接口")
@RestController
@RequestMapping("workload")
public class WorkloadController {

    @Autowired
    private WorkloadService targetService;
    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    @ApiOperation(value = "录入教师单个教学任务信息", httpMethod = "POST")
    public Result save(@RequestBody Workload workload){
        //录入教师单个教学任务信息
        boolean save = targetService.save(workload);
        if (save){
            return ResultFactory.success(null);
        }
        return ResultFactory.failed("录入教师单个教学任务信息失败!",null);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改教师单个教学任务信息", httpMethod = "POST")
    public Result update(@RequestBody Workload workload){
        //录入教师单个教学任务信息
        boolean save = targetService.updateById(workload);
        if (save){
            return ResultFactory.success(null);
        }else {
            return ResultFactory.failed("修改教师单个教学任务信息失败!",null);
        }
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除教师单个教学任务信息", httpMethod = "POST")
    public Result delete(@RequestBody Integer id){
        //录入教师单个教学任务信息
        boolean save = targetService.removeById(id);
        if (save){
            return ResultFactory.success(null);
        }else {
            return ResultFactory.failed("删除教师单个教学任务信息失败!",null);
        }
    }

    @GetMapping("/getOne")
    @ApiOperation(value = "浏览教师单个教学任务信息", httpMethod = "POST")
    public Result<Workload> getOne(@RequestBody Integer id){
        //查询教师单个教学任务信息
        Workload workload = targetService.getById(id);
        if (workload != null){
            //查询课程信息
            Course course = courseService.getById(workload.getCourseId());
            //判断课程是否是理论课
            if (course.getCategory().equals(ClassCategoryEnum.theory)){
                //todo
            }
            //否则是实践课
            else {
                //todo
            }
            workload.setCourse(course);
            return ResultFactory.success(workload);
        }else {
            return ResultFactory.failed("浏览教师单个教学任务信息失败!",null);
        }
    }
}
