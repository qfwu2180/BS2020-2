package com.pojo;

import java.io.Serializable;

import com.util.Page;

public class Banji extends Page implements Serializable {
    private Integer bid;

    /**
     * 班号
     */
    private String bh;

    /**
     * 所属教师
     */
    private Integer tid;
    private Myuser myuser;

    /**
     * 扩展列
     */
    private String kz;

    /**
     * 扩展列
     */
    private String kz1;

    private static final long serialVersionUID = 1L;

    
    public Myuser getMyuser() {
		return myuser;
	}

	public void setMyuser(Myuser myuser) {
		this.myuser = myuser;
	}

	public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getKz() {
        return kz;
    }

    public void setKz(String kz) {
        this.kz = kz == null ? null : kz.trim();
    }

    public String getKz1() {
        return kz1;
    }

    public void setKz1(String kz1) {
        this.kz1 = kz1 == null ? null : kz1.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bid=").append(bid);
        sb.append(", bh=").append(bh);
        sb.append(", tid=").append(tid);
        sb.append(", kz=").append(kz);
        sb.append(", kz1=").append(kz1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}