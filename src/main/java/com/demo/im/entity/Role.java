package com.demo.im.entity;

public class Role {
    private Integer uId;

    private String rolecode;

    private String rolename;

    private String type;

    private RoleGroup rgId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public RoleGroup getRgId() {
        return rgId;
    }

    public void setRgId(RoleGroup rgId) {
        this.rgId = rgId;
    }
}