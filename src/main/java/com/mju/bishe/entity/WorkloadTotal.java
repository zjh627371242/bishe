package com.mju.bishe.entity;

public class WorkloadTotal{

    private Long id;

    private Long teacherId;

    private Integer schoolYear;

    private Integer schoolTerm;

    private Double theoreticalWordloadTotal;

    private Double practicalWordloadTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Integer getSchoolTerm() {
        return schoolTerm;
    }

    public void setSchoolTerm(Integer schoolTerm) {
        this.schoolTerm = schoolTerm;
    }

    public Double getTheoreticalWordloadTotal() {
        return theoreticalWordloadTotal;
    }

    public void setTheoreticalWordloadTotal(Double theoreticalWordloadTotal) {
        this.theoreticalWordloadTotal = theoreticalWordloadTotal;
    }

    public Double getPracticalWordloadTotal() {
        return practicalWordloadTotal;
    }

    public void setPracticalWordloadTotal(Double practicalWordloadTotal) {
        this.practicalWordloadTotal = practicalWordloadTotal;
    }
}
