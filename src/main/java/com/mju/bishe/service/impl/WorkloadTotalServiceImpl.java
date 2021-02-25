package com.mju.bishe.service.impl;

import com.mju.bishe.mapper.WorkloadTotalMapper;
import com.mju.bishe.service.WorkloadTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkloadTotalServiceImpl implements WorkloadTotalService {
    @Autowired
    WorkloadTotalMapper workloadTotalMapper;

}
