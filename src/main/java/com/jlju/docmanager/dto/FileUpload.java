package com.jlju.docmanager.dto;

/**
 * Created by zyz on 2016/11/21.
 */
public class FileUpload {

    private  String fileName;
    private String savePath;
    public FileUpload(){

    }
    public FileUpload(String fileName, String savePath) {
        this.fileName = fileName;
        this.savePath = savePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
