package com.mju.bishe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("workload")
@ApiModel(value="Workload对象", description="")
public class Workload implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "学年")
    private Integer schoolYear;

    @ApiModelProperty(value = "学期")
    private Integer schoolTerm;

    @ApiModelProperty(value = "教师id")
    private Long teacherId;

    @ApiModelProperty(value = "理论教学工作量")
    private Double theoreticalWordload;

    @ApiModelProperty(value = "实践教学工作量")
    private Double practicalWordload;

    @ApiModelProperty(value = "授课班级")
    private String classroom;

    @ApiModelProperty(value = "班级类型（重复班，开新课）")
    private String classType;

    @ApiModelProperty(value = "教学语言（中文教学、英文教学、双语教学）")
    private String language;

    @ApiModelProperty(value = "班级人数")
    private Integer studentCount;

    @ApiModelProperty(value = "课程计划学时数")
    private Integer classHours;

    @ApiModelProperty(value = "课程id")
    private Long courseId;

    @ApiModelProperty(value = "课程信息")
    @TableField(exist = false)
    private Course course;
}
