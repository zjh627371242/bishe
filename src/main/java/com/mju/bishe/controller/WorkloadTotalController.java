package com.mju.bishe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mju.bishe.common.Result;
import com.mju.bishe.entity.WorkloadTotal;
import com.mju.bishe.service.WorkloadTotalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Api(value = "教师任务总工作量接口", tags = "教师任务总工作量接口")
@RestController
@RequestMapping("workloadTotal")
public class WorkloadTotalController {
    @Autowired
    private WorkloadTotalService targetService;
    /**
     * 获取分页数据
     */
    @ApiOperation(value = "获取分页数据", notes = "获取分页数据")
    @PostMapping(value = "/list")
    @ResponseBody
    public Result<IPage<WorkloadTotal>> list(@RequestBody Map map){
        return targetService.getList(map);
    }
}
