package com.jlju.docmanager.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class QueryCache {
    private Integer cacheId;

    private String fileType;

    private Long fkTeacherCode;

    private String fileName;

    private String filePath;

    private String teacherName;

    private String projectName;

    private Date fileDate;

    private Integer orders;

    private String fkFileUuid;

    public Integer getCacheId() {
        return cacheId;
    }

    public void setCacheId(Integer cacheId) {
        this.cacheId = cacheId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public Long getFkTeacherCode() {
        return fkTeacherCode;
    }

    public void setFkTeacherCode(Long fkTeacherCode) {
        this.fkTeacherCode = fkTeacherCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Date getFileDate() {
        return fileDate;
    }

    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getFkFileUuid() {
        return fkFileUuid;
    }

    public void setFkFileUuid(String fkFileUuid) {
        this.fkFileUuid = fkFileUuid == null ? null : fkFileUuid.trim();
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}