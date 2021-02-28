package com.mju.bishe.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mju.bishe.common.ClassCategoryEnum;
import com.mju.bishe.common.LanguageEnum;
import com.mju.bishe.common.Result;
import com.mju.bishe.common.ResultFactory;
import com.mju.bishe.entity.Course;
import com.mju.bishe.entity.Teacher;
import com.mju.bishe.entity.Workload;
import com.mju.bishe.entity.WorkloadTotal;
import com.mju.bishe.service.CourseService;
import com.mju.bishe.service.TeacherService;
import com.mju.bishe.service.WorkloadService;
import com.mju.bishe.service.WorkloadTotalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "教师单个教学任务服务接口", tags = "教师单个教学任务服务接口")
@RestController
@RequestMapping("workload")
public class WorkloadController {

    @Autowired
    private WorkloadService targetService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private WorkloadTotalService workloadTotalService;
    @Autowired
    private WorkloadService workloadService;

    @PostMapping("/save")
    @ApiOperation(value = "录入教师单个教学任务信息", httpMethod = "POST")
    public Result save(@RequestBody Workload workload){
        //判断课程是否是理论课
        Course course = courseService.getById(workload.getCourseId());
        if (course.getCategory().equals(ClassCategoryEnum.theory.toString())){
            //当前理论课教学工作量
            double theory = this.getTheory(workload.getClassHours(), workload.getStudentCount(), workload.getClassType(), workload.getLanguage());
//            //查询已经录入的理论课教学工作总量
//            QueryWrapper<Workload> workloadQueryWrapper = new QueryWrapper<>();
//            workloadQueryWrapper.select("SUM(theoretical_wordload) as theoreticalWordload").eq("teacher_id",workload.getTeacherId())
//                    .eq("school_year",workload.getSchoolYear()).eq("school_term",workload.getSchoolTerm());
//            Map<String, Object> workloadMap = workloadService.getMap(workloadQueryWrapper);
//            double currentTheoryTotal = 0;
//            if (workloadMap.containsKey("theoreticalWordload")){
//                currentTheoryTotal = (double) workloadMap.get("theoreticalWordload");
//            }
//            //查询教师教学总工作量
//            QueryWrapper<WorkloadTotal> workloadTotalQueryWrapper = new QueryWrapper<>();
//            workloadTotalQueryWrapper.select("theoretical_wordload_total").eq("school_year",workload.getSchoolYear())
//                    .eq("school_term",workload.getSchoolTerm());
//            WorkloadTotal workloadTotal = workloadTotalService.getOne(workloadTotalQueryWrapper);
//            if (workloadTotal != null){
//                //判断录入理论课教学工作量是否大于教师教学总工作量 大于返回错误
//                if (theory + currentTheoryTotal > workloadTotal.getTheoreticalWordloadTotal()){
//                    return ResultFactory.failed("课程计划学时数超过学期理论教学总工作量",null);
//                }else {
                    //录入教师单个教学任务信息
            workload.setTheoreticalWordload(theory);
                    boolean save = targetService.save(workload);
                    if (save){
                        return ResultFactory.success(null);
                    }
                    return ResultFactory.failed("录入教师单个教学任务信息失败!",null);
//                }
//            }
        }else {//否则是实践课
            double practice = this.getPractice(workload.getClassHours(), workload.getStudentCount(), workload.getClassType(), workload.getLanguage());
            workload.setPracticalWordload(practice);
//            //查询已经录入的实践课教学工作总量
//            QueryWrapper<Workload> workloadQueryWrapper = new QueryWrapper<>();
//            workloadQueryWrapper.select("SUM(practical_wordload) as practicalWordload").eq("teacher_id",workload.getTeacherId())
//                    .eq("school_year",workload.getSchoolYear()).eq("school_term",workload.getSchoolTerm());
//            Map<String, Object> workloadMap = workloadService.getMap(workloadQueryWrapper);
//            double currentPracticeTotal = (double) workloadMap.get("practicalWordload");
//            //查询教师教学总工作量
//            QueryWrapper<WorkloadTotal> workloadTotalQueryWrapper = new QueryWrapper<>();
//            workloadTotalQueryWrapper.select("practical_wordload_total").eq("school_year",workload.getSchoolYear())
//                    .eq("school_term",workload.getSchoolTerm());
//            WorkloadTotal workloadTotal = workloadTotalService.getOne(workloadTotalQueryWrapper);
//            if (workloadTotal != null){
//                //判断录入实践课教学工作量是否大于教师教学总工作量 大于返回错误
//                if (practice + currentPracticeTotal > workloadTotal.getPracticalWordloadTotal()){
//                    return ResultFactory.failed("课程计划学时数超过学期理论教学总工作量",null);
//                }else {
//                    //录入教师单个教学任务信息
//                    boolean save = targetService.save(workload);
//                    if (save){
//                        return ResultFactory.success(null);
//                    }
//                    return ResultFactory.failed("录入教师单个教学任务信息失败!",null);
//                }
//            }
//        }
        //录入教师单个教学任务信息
        boolean save = targetService.save(workload);
        if (save){
            return ResultFactory.success(null);
        }
        return ResultFactory.failed("录入教师单个教学任务信息失败!",null);
    }
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改教师单个教学任务信息", httpMethod = "POST")
    public Result update(@RequestBody Workload workload){
        //录入教师单个教学任务信息
        boolean save = targetService.updateById(workload);
        if (save){
            return ResultFactory.success("编辑成功",null);
        }else {
            return ResultFactory.failed("修改教师单个教学任务信息失败!",null);
        }
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除教师单个教学任务信息", httpMethod = "POST")
    public Result delete(@RequestBody Workload workload){
        //录入教师单个教学任务信息
        boolean save = targetService.removeById(workload.getId());
        if (save){
            return ResultFactory.success("删除成功",null);
        }else {
            return ResultFactory.failed("删除教师单个教学任务信息失败!",null);
        }
    }

    @PostMapping("/getOne")
    @ApiOperation(value = "浏览教师单个教学任务信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "任务id", dataType = "Long",required = true),
    })
    public Result<Workload> getOne(@RequestBody Workload entity){
        //查询教师单个教学任务信息
        Workload workload = targetService.getById(entity.getId());
        if (workload != null){
            //查询课程信息
            Course course = courseService.getById(workload.getCourseId());
            workload.setCourse(course);
            //查询老师信息
            Teacher teacher = teacherService.getById(workload.getTeacherId());
            workload.setTeacher(teacher);
            return ResultFactory.success(workload);
        }else {
            return ResultFactory.failed("浏览教师单个教学任务信息失败!",null);
        }
    }

    @PostMapping("/list")
    @ApiOperation(value = "浏览教师教学任务信息列表", httpMethod = "POST")
    public Result<IPage<Workload>> list(@RequestBody Map map){
        return workloadService.getList(map);
    }

    /**
     * 理论课教学工作量
     * M1=A1*R1
     * A1：理论课计划学时，R1：课程系数（R1=J+L+P）
     **/
    public double getTheory(Integer classHours, Integer studentCount, String classType, String language){
        double J;
        double L;
        double P = 0;
        double R1;
        if (studentCount <= 45){
            J = 1d;
        }else if (45 < studentCount && studentCount <= 90){
            //每人增加0.01 + 上 45人的1
            J = (studentCount - 45) * 0.01 + 1;
        }else{
            //大于 90
            //每人增加 0.005 + 大于45人的0.01 + 45人的1
            J = (studentCount - 90) * 0.005 + (45 * 0.01) + 1;
        }
        if (J >= 1.8){
            J = 1.8;
        }

        //开新班
        if (classType.equals("newClass")){
            L = 0.3;
        }else { //重复班
            L = 0.27;
        }

        //双语
        if (language.equals(LanguageEnum.bilingual.toString())){
            P = 0.5;
        }
        R1 = J + L + P;
        return R1 * classHours;
    }

    /**
     * 实践教学工作量
     * M1=A1*R1
     * A1：理论课计划学时，R1：课程系数（R1=J+L+P）
     **/
    public double getPractice(Integer classHours, Integer studentCount, String classType, String language){
        double J;
        double L;
        double P = 0;
        double R1;
        if (studentCount <= 30){
            J = 1d;
        }else{
            //大于 30
            //每人增加 0.01 + 30人的1
            J = (studentCount - 30) * 0.01 + 1;
        }
        if (J >= 1.3){
            J = 1.3;
        }

        //开新班
        if (classType.equals("newClass")){
            L = 0.3;
        }else { //重复班
            L = 0.27;
        }

        //双语
        if (language.equals(LanguageEnum.bilingual.toString())){
            P = 0.5;
        }
        R1 = J + L + P;
        return R1 * classHours;
    }
}
