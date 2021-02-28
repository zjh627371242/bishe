package com.mju.bishe.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mju.bishe.common.Result;
import com.mju.bishe.entity.Teacher;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TeacherService extends IService<Teacher> {
    Result delete(Long id);
    Result addTeacher(Teacher teacher);

    Result edit(Teacher teacher);

    Result selectById(Long id);
}
