package com.mju.bishe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mju.bishe.common.PageParams;
import com.mju.bishe.common.Result;
import com.mju.bishe.common.ResultFactory;
import com.mju.bishe.entity.Course;
import com.mju.bishe.entity.Workload;
import com.mju.bishe.entity.WorkloadTotal;
import com.mju.bishe.mapper.WorkloadTotalMapper;
import com.mju.bishe.service.WorkloadTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkloadTotalServiceImpl extends ServiceImpl<WorkloadTotalMapper, WorkloadTotal> implements WorkloadTotalService {
    @Autowired
    WorkloadTotalMapper workloadTotalMapper;

    @Override
    public Result<IPage<Workload>> getList(Map map) {
        PageParams page = new PageParams(map);
        IPage<Workload> list = workloadTotalMapper.getList(page,map);
        return ResultFactory.success(list);
    }
}
