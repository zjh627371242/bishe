package com.mju.bishe.entity;

public class Workload{
    private Long id;

    private Integer schoolYear;

    private Integer schoolTerm;

    private Long teacherId;

    private Double theoreticalWordload;

    private Double practicalWordload;

    private String classroom;

    private String classType;

    private String language;

    private Integer studentCount;

    private Integer classHours;

    private Long courseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Double getTheoreticalWordload() {
        return theoreticalWordload;
    }

    public void setTheoreticalWordload(Double theoreticalWordload) {
        this.theoreticalWordload = theoreticalWordload;
    }

    public Double getPracticalWordload() {
        return practicalWordload;
    }

    public void setPracticalWordload(Double practicalWordload) {
        this.practicalWordload = practicalWordload;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public Integer getClassHours() {
        return classHours;
    }

    public void setClassHours(Integer classHours) {
        this.classHours = classHours;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
