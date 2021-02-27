package com.mju.bishe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mju.bishe.common.Result;
import com.mju.bishe.entity.Workload;
import com.mju.bishe.entity.WorkloadTotal;

import java.util.Map;

public interface WorkloadTotalService extends IService<WorkloadTotal> {

    Result<IPage<Workload>> getList(Map map);
}
