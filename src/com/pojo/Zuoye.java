package com.pojo;

import java.io.Serializable;
import java.util.Date;

import com.util.Page;

public class Zuoye  extends Page implements Serializable {
    private Integer zyid;

    private String title;

    private String content;

    /**
     * ���� �����doc�ĵ�
     */
    private String fujian;

    /**
     * �𰸵��ĵ�
     */
    private String daan;

    private Date createtime;

    /**
     * ��ʦ�ı��
     */
    private Integer tid;
    private Myuser t;
    
    /**
     * ���
     */
    private Integer bid;
    private Banji bj;

    /**
     * ��Ŀ  ��ѧ ���� ���� ���� ��ѧ
     */
    private String kemu;

    /**
     * ��ͼ
     */
    private String pic;
    
    

    private static final long serialVersionUID = 1L;

    
    public Banji getBj() {
		return bj;
	}

	public void setBj(Banji bj) {
		this.bj = bj;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getKemu() {
		return kemu;
	}

	public void setKemu(String kemu) {
		this.kemu = kemu;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Myuser getT() {
		return t;
	}

	public void setT(Myuser t) {
		this.t = t;
	}

	public Integer getZyid() {
        return zyid;
    }

    public void setZyid(Integer zyid) {
        this.zyid = zyid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFujian() {
        return fujian;
    }

    public void setFujian(String fujian) {
        this.fujian = fujian == null ? null : fujian.trim();
    }

    public String getDaan() {
        return daan;
    }

    public void setDaan(String daan) {
        this.daan = daan == null ? null : daan.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", zyid=").append(zyid);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", fujian=").append(fujian);
        sb.append(", daan=").append(daan);
        sb.append(", createtime=").append(createtime);
        sb.append(", tid=").append(tid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}