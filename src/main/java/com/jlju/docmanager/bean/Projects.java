package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Projects {
    private String proUuid;
    @NotBlank(message = "项目名称不能为空")
    @Length(min = 4,max = 40,message = "项目名称长度在4-40个字符之间")
    private String proName;

    private String proLevel;
    @NotNull(message = "起始时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date proStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date proEndDate;
    @NotBlank(message = "项目来源不能为空")
    @Length(min = 2,max = 20,message = "项目来源长度在2-20个字符之间")
    private String proSource;
    @NotNull(message = "项目经费不能为空")
    @Min(value = 0,message = "项目经费必须大于0")
    private Float proFunds;
    @NotNull(message = "排名不能为空")
    @Min(value = 1,message = "排名最小值为1")
    private Integer proTeacherOrder;
    @NotNull(message = "教师编号尚未选择")
    private Long fkTeacherCode;

    public String getProUuid() {
        return proUuid;
    }

    public void setProUuid(String proUuid) {
        this.proUuid = proUuid == null ? null : proUuid.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getProLevel() {
        return proLevel;
    }

    public void setProLevel(String proLevel) {
        this.proLevel = proLevel == null ? null : proLevel.trim();
    }

    public Date getProStartDate() {
        return proStartDate;
    }

    public void setProStartDate(Date proStartDate) {
        this.proStartDate = proStartDate;
    }

    public Date getProEndDate() {
        return proEndDate;
    }

    public void setProEndDate(Date proEndDate) {
        this.proEndDate = proEndDate;
    }

    public String getProSource() {
        return proSource;
    }

    public void setProSource(String proSource) {
        this.proSource = proSource == null ? null : proSource.trim();
    }

    public Float getProFunds() {
        return proFunds;
    }

    public void setProFunds(Float proFunds) {
        this.proFunds = proFunds;
    }

    public Integer getProTeacherOrder() {
        return proTeacherOrder;
    }

    public void setProTeacherOrder(Integer proTeacherOrder) {
        this.proTeacherOrder = proTeacherOrder;
    }

    public Long getFkTeacherCode() {
        return fkTeacherCode;
    }

    public void setFkTeacherCode(Long fkTeacherCode) {
        this.fkTeacherCode = fkTeacherCode;
    }



    private  Teachers teachers;

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }
}