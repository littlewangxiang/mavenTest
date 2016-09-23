package com.demo.im.entity;

public class RoleGroup {
    private Integer uId;

    private String rgName;

    private String type;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getRgName() {
        return rgName;
    }

    public void setName(String rgName) {
        this.rgName = rgName == null ? null : rgName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}