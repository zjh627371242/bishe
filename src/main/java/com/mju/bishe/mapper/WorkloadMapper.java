package com.mju.bishe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mju.bishe.common.PageParams;
import com.mju.bishe.entity.Workload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface WorkloadMapper extends BaseMapper<Workload> {

    IPage<Workload> getList(@Param("page") PageParams page, @Param("queryfilter") Map<String, Object> queryfilter);
}
