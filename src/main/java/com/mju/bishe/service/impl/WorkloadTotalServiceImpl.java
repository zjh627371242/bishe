package com.mju.bishe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mju.bishe.entity.WorkloadTotal;
import com.mju.bishe.mapper.WorkloadTotalMapper;
import com.mju.bishe.service.WorkloadTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkloadTotalServiceImpl extends ServiceImpl<WorkloadTotalMapper, WorkloadTotal> implements WorkloadTotalService {
    @Autowired
    WorkloadTotalMapper workloadTotalMapper;

}
