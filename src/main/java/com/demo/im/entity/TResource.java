package com.demo.im.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class TResource {
    private Integer uId;

    private String resname;

    private String type;

    private String value;
    
    private List<Role> roles;

    public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname == null ? null : resname.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
    
    public String getRoleAuthorities() {
		List<String> roleAuthorities = new ArrayList<String>();
		for (Role role : roles) {
			roleAuthorities.add(role.getRolecode());
		}
		return StringUtils.join(roleAuthorities.toArray(), ",");
	}
}