package com.jlju.docmanager.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Works {
    private String workUuid;
    @NotBlank(message = "著作名称不能为空")
    @Length(min = 4,max = 40,message = "著作名称长度在4-40个字符之间")
    private String workName;
    @NotBlank(message = "出版社不能为空")
    @Length(min = 4,max = 40,message = "出版社长度在4-40个字符之间")
    private String workPublish;
    @NotBlank(message = "ISBN不能为空")
    @Length(min = 4,max = 40,message = "ISBN长度在4-40个字符之间")
    private String workIsbn;
    @NotNull(message = "出版时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date workDate;
    @NotNull(message = "字数不能为空")
    @Min(value = 0,message = "字数必须大于0")
    private Float workCharNumber;
    @NotNull(message = "作者排名不能为空")
    @Min(value = 1,message = "作者排名最小值为1")
    private Integer workTeacherOrder;

    private String workType;

    private String workProductType;
    @NotNull(message = "教师编号尚未选择")
    private Long fkTeacherCode;

    public String getWorkUuid() {
        return workUuid;
    }

    public void setWorkUuid(String workUuid) {
        this.workUuid = workUuid == null ? null : workUuid.trim();
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public String getWorkPublish() {
        return workPublish;
    }

    public void setWorkPublish(String workPublish) {
        this.workPublish = workPublish == null ? null : workPublish.trim();
    }

    public String getWorkIsbn() {
        return workIsbn;
    }

    public void setWorkIsbn(String workIsbn) {
        this.workIsbn = workIsbn == null ? null : workIsbn.trim();
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Float getWorkCharNumber() {
        return workCharNumber;
    }

    public void setWorkCharNumber(Float workCharNumber) {
        this.workCharNumber = workCharNumber;
    }

    public Integer getWorkTeacherOrder() {
        return workTeacherOrder;
    }

    public void setWorkTeacherOrder(Integer workTeacherOrder) {
        this.workTeacherOrder = workTeacherOrder;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getWorkProductType() {
        return workProductType;
    }

    public void setWorkProductType(String workProductType) {
        this.workProductType = workProductType == null ? null : workProductType.trim();
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