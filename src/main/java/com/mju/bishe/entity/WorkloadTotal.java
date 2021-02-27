package com.mju.bishe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.beans.Transient;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("workload_total")
@ApiModel(value="WorkloadTotal对象", description="")
public class WorkloadTotal implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "教师id")
    private Long teacherId;

    @ApiModelProperty(value = "学年")
    private Integer schoolYear;

    @ApiModelProperty(value = "学期")
    private Integer schoolTerm;

    @ApiModelProperty(value = "学期理论教学总工作量")
    private Double theoreticalWordloadTotal;

    @ApiModelProperty(value = "学期实践教学总工作量")
    private Double practicalWordloadTotal;

    @TableField(exist = false)
    private String teacherName;

    @TableField(exist = false)
    private String positionalTitle;

    @TableField(exist = false)
    private Integer classNum;
}
