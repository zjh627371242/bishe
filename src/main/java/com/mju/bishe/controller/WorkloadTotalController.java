package com.mju.bishe.controller;

import com.mju.bishe.service.WorkloadTotalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "教师任务总工作量接口", tags = "教师任务总工作量接口")
@RestController
@RequestMapping("workloadTotal")
public class WorkloadTotalController {
    @Autowired
    private WorkloadTotalService targetService;
}
