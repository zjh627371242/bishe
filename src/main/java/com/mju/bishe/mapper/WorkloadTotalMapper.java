package com.mju.bishe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mju.bishe.common.PageParams;
import com.mju.bishe.entity.WorkloadTotal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface WorkloadTotalMapper extends BaseMapper<WorkloadTotal> {

    IPage<WorkloadTotal> getList(@Param("pageParams") PageParams pageParams, @Param("queryfilter") Map<String, Object> queryfilter);
}
