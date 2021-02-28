package com.mju.bishe.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mju.bishe.common.Result;
import com.mju.bishe.common.ResultFactory;
import com.mju.bishe.entity.Course;
import com.mju.bishe.entity.Teacher;
import com.mju.bishe.entity.Workload;
import com.mju.bishe.entity.WorkloadTotal;
import com.mju.bishe.mapper.TeacherMapper;
import com.mju.bishe.mapper.WorkloadMapper;
import com.mju.bishe.mapper.WorkloadTotalMapper;
import com.mju.bishe.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    WorkloadTotalMapper workloadTotalMapper;
    @Autowired
    WorkloadMapper workloadMapper;
    @Override
    public Result delete(Long id) {
        teacherMapper.deleteById(id);
        QueryWrapper<Workload> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id",id);
        workloadMapper.delete(queryWrapper);
        QueryWrapper<WorkloadTotal> queryWrapper1 = new QueryWrapper<>();
        queryWrapper.eq("teacher_id",id);
        workloadTotalMapper.delete(queryWrapper1);
        return ResultFactory.success("删除成功",null);
    }

    @Override
    public Result addTeacher(Teacher teacher) {
        int insert = teacherMapper.insert(teacher);
        if (insert>0){
            List<WorkloadTotal> workloadTotalList = teacher.getWorkloadTotalList();
            for (WorkloadTotal workloadTotal : workloadTotalList) {
                workloadTotal.setTeacherId(teacher.getId());
                workloadTotalMapper.insert(workloadTotal);
            }
            return ResultFactory.success("添加成功",null);
        }
        return ResultFactory.failed("添加失败",null);
    }

    @Override
    public Result edit(Teacher teacher) {
        int i = teacherMapper.updateById(teacher);
        if (i>0){
            List<WorkloadTotal> workloadTotalList = teacher.getWorkloadTotalList();
            QueryWrapper<WorkloadTotal> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("teacher_id",teacher.getId());
            int delete = workloadTotalMapper.delete(queryWrapper);
            if (delete>0){
                for (WorkloadTotal workloadTotal : workloadTotalList) {
                    workloadTotal.setTeacherId(teacher.getId());
                    workloadTotalMapper.insert(workloadTotal);
                }
                return ResultFactory.success("修改成功",null);
            }
        }
        return ResultFactory.failed("修改失败",null);
    }

    @Override
    public Result selectById(Long id) {
        Teacher teacher = teacherMapper.selectById(id);
        if (teacher!=null){
            QueryWrapper<WorkloadTotal> queryWrapper = new QueryWrapper();
            queryWrapper.eq("teacher_id",teacher.getId());
            List<WorkloadTotal> workloadTotals = workloadTotalMapper.selectList(queryWrapper);
            if (!CollectionUtils.isEmpty(workloadTotals)){
                teacher.setWorkloadTotalList(workloadTotals);
                return ResultFactory.success(teacher);
            }
            return ResultFactory.failed("查询工作量失败",null);
        }
        return ResultFactory.failed("查询教师信息失败",null);
    }
}
