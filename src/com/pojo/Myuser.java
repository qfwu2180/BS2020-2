package com.pojo;

import java.io.Serializable;

import com.util.Page;

public class Myuser extends Page implements Serializable {
    private Integer uid;

    private String name;

    private String login;

    private String pwd;

    /**
     * 管理员  和 教师
     */
    private String role;

    private String tel;

    private String mail;

    /**
     * 是否保密
     */
    private String isbaomi;

    /**
     * 科目 语文 数学 英语
     */
    private String kemu;

    /**
     * 班级
     */
    private String banji;

    private String sex;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getIsbaomi() {
        return isbaomi;
    }

    public void setIsbaomi(String isbaomi) {
        this.isbaomi = isbaomi == null ? null : isbaomi.trim();
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu == null ? null : kemu.trim();
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji == null ? null : banji.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", name=").append(name);
        sb.append(", login=").append(login);
        sb.append(", pwd=").append(pwd);
        sb.append(", role=").append(role);
        sb.append(", tel=").append(tel);
        sb.append(", mail=").append(mail);
        sb.append(", isbaomi=").append(isbaomi);
        sb.append(", kemu=").append(kemu);
        sb.append(", banji=").append(banji);
        sb.append(", sex=").append(sex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}