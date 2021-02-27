package com.mju.bishe.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mju.bishe.entity.Workload;
import com.mju.bishe.mapper.WorkloadMapper;
import com.mju.bishe.service.WorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class WorkloadServiceImpl extends ServiceImpl<WorkloadMapper, Workload> implements WorkloadService {
    @Autowired
    WorkloadMapper workloadMapper;

}
