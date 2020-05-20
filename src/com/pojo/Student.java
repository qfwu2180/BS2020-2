package com.pojo;

import java.io.Serializable;

import com.util.Page;

public class Student extends Page implements Serializable {
    private Integer stid;

    /**
     * 学号
     */
    private String xh;

    private String name;

    private String sex;

    /**
     * 班号
     */
    private String bh;
    private Banji bj;

    private String xuenian;

    private String login;

    private String pwd;

    /**
     * 学生角色
     */
    private String role;

    private String mail ;
    
    
    public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Banji getBj() {
		return bj;
	}

	public void setBj(Banji bj) {
		this.bj = bj;
	}

	private static final long serialVersionUID = 1L;

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public String getXuenian() {
        return xuenian;
    }

    public void setXuenian(String xuenian) {
        this.xuenian = xuenian == null ? null : xuenian.trim();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login == null ? null : login.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stid=").append(stid);
        sb.append(", xh=").append(xh);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", bh=").append(bh);
        sb.append(", xuenian=").append(xuenian);
        sb.append(", login=").append(login);
        sb.append(", pwd=").append(pwd);
        sb.append(", role=").append(role);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}