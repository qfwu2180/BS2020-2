package com.pojo;

import java.io.Serializable;
import java.util.Date;

import com.util.Page;

public class Stuzuoye extends Page  implements Serializable {
    private Integer stuzyid;

    private Integer stid;
    private Student stu;

    private String fujian;

    private String socre;

    private Date createtime;

    private String banji;
    private Banji bj; //班级对象

    private String kemu;

    /**
     * 作业id
     */
    private Integer zyid;
    
    private Zuoye zy;
    
    /**
     * 作业截图
     */
    private String pic;

    private static final long serialVersionUID = 1L;

    
    
    public Banji getBj() {
		return bj;
	}

	public void setBj(Banji bj) {
		this.bj = bj;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Zuoye getZy() {
		return zy;
	}

	public void setZy(Zuoye zy) {
		this.zy = zy;
	}

	public Integer getStuzyid() {
        return stuzyid;
    }

    public void setStuzyid(Integer stuzyid) {
        this.stuzyid = stuzyid;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getFujian() {
        return fujian;
    }

    public void setFujian(String fujian) {
        this.fujian = fujian == null ? null : fujian.trim();
    }

    public String getSocre() {
        return socre;
    }

    public void setSocre(String socre) {
        this.socre = socre == null ? null : socre.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji == null ? null : banji.trim();
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu == null ? null : kemu.trim();
    }

    public Integer getZyid() {
        return zyid;
    }

    public void setZyid(Integer zyid) {
        this.zyid = zyid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuzyid=").append(stuzyid);
        sb.append(", stid=").append(stid);
        sb.append(", fujian=").append(fujian);
        sb.append(", socre=").append(socre);
        sb.append(", createtime=").append(createtime);
        sb.append(", banji=").append(banji);
        sb.append(", kemu=").append(kemu);
        sb.append(", zyid=").append(zyid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}