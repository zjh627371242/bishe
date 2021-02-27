package com.mju.bishe.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mju.bishe.common.Result;
import com.mju.bishe.common.ResultFactory;
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
        return ResultFactory.success("删除成功");
    }

    @Override
    public Result addTeacher(Teacher teacher) {
        int insert = teacherMapper.insert(teacher);
        if (insert>0){
            WorkloadTotal workloadTotal = new WorkloadTotal();
            workloadTotal.setSchoolTerm(teacher.getSchoolTerm());
            workloadTotal.setSchoolYear(teacher.getSchoolYear());
            workloadTotal.setTheoreticalWordloadTotal(teacher.getTheoreticalWordloadTotal());
            workloadTotal.setPracticalWordloadTotal(teacher.getPracticalWordloadTotal());
            workloadTotal.setTeacherId(teacher.getId());
            int insert1 = workloadTotalMapper.insert(workloadTotal);
            if (insert1>0){
                return ResultFactory.success("添加成功",null);
            }
        }
        return ResultFactory.failed("添加失败",null);
    }

    @Override
    public Result edit(Teacher teacher) {
        int i = teacherMapper.updateById(teacher);
        if (i>0){
            WorkloadTotal workloadTotal = new WorkloadTotal();
            workloadTotal.setSchoolTerm(teacher.getSchoolTerm());
            workloadTotal.setSchoolYear(teacher.getSchoolYear());
            workloadTotal.setTheoreticalWordloadTotal(teacher.getTheoreticalWordloadTotal());
            workloadTotal.setPracticalWordloadTotal(teacher.getPracticalWordloadTotal());
            workloadTotal.setTeacherId(teacher.getId());
            QueryWrapper<WorkloadTotal> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("teacher_id",teacher.getId());
            if (workloadTotalMapper.update(workloadTotal,queryWrapper)>0){
                return ResultFactory.success("修改成功",null);
            }
        }
        return ResultFactory.failed("修改失败",null);
    }
}
