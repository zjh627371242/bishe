package com.mju.bishe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mju.bishe.common.PageParams;
import com.mju.bishe.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    IPage<Course> list(@Param("pageParams") PageParams pageParams,@Param("map") Map<Object,String> map);
}
