package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Honours {
    private String hoUuid;
    @NotBlank(message = "名称不能为空")
    @Length(min = 4,max = 40,message = "名称长度在4-40个字符之间")
    private String hoName;

    private String hoRank;
    @NotNull(message = "起始时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date hoStartDate;
    @NotNull(message = "结束时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date hoEndDate;
    @NotNull(message = "作者排名不能为空")
    @Min(value = 1,message = "作者排名最小值为1")
    private Integer hoTeacherOrder;
    @NotBlank(message = "项目来源不能为空")
    @Length(min = 4,max = 40,message = "名称长度在4-40个字符之间")
    private String hoOrg;
    @NotNull(message = "转化金额不能为空")
    @Min(value = 0,message = "转化金额最小值为0")
    private Float hoMoney;
    @NotNull(message = "教师编号尚未选择")
    private Long fkTeacherCode;

    public String getHoUuid() {
        return hoUuid;
    }

    public void setHoUuid(String hoUuid) {
        this.hoUuid = hoUuid == null ? null : hoUuid.trim();
    }

    public String getHoName() {
        return hoName;
    }

    public void setHoName(String hoName) {
        this.hoName = hoName == null ? null : hoName.trim();
    }

    public String getHoRank() {
        return hoRank;
    }

    public void setHoRank(String hoRank) {
        this.hoRank = hoRank == null ? null : hoRank.trim();
    }

    public Date getHoStartDate() {
        return hoStartDate;
    }

    public void setHoStartDate(Date hoStartDate) {
        this.hoStartDate = hoStartDate;
    }

    public Date getHoEndDate() {
        return hoEndDate;
    }

    public void setHoEndDate(Date hoEndDate) {
        this.hoEndDate = hoEndDate;
    }

    public Integer getHoTeacherOrder() {
        return hoTeacherOrder;
    }

    public void setHoTeacherOrder(Integer hoTeacherOrder) {
        this.hoTeacherOrder = hoTeacherOrder;
    }

    public String getHoOrg() {
        return hoOrg;
    }

    public void setHoOrg(String hoOrg) {
        this.hoOrg = hoOrg == null ? null : hoOrg.trim();
    }

    public Float getHoMoney() {
        return hoMoney;
    }

    public void setHoMoney(Float hoMoney) {
        this.hoMoney = hoMoney;
    }

    public Long getFkTeacherCode() {
        return fkTeacherCode;
    }

    public void setFkTeacherCode(Long fkTeacherCode) {
        this.fkTeacherCode = fkTeacherCode;
    }



    private Teachers teachers;

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }
}