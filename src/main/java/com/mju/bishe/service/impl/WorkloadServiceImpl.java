package com.mju.bishe.service.impl;


import com.mju.bishe.mapper.WorkloadMapper;
import com.mju.bishe.service.WorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkloadServiceImpl implements WorkloadService {
    @Autowired
    WorkloadMapper workloadMapper;

}
