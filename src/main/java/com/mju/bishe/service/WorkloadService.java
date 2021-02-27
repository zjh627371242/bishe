package com.mju.bishe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mju.bishe.common.Result;
import com.mju.bishe.entity.Workload;

import java.util.Map;

public interface WorkloadService extends IService<Workload> {

    Result<IPage<Workload>> getList(Map map);
}
