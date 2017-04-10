package VO;

import java.util.Date;

public class leavedtl_vo {
	private int id;
	private Date d1;
	private Date d2;
	private String desc;
	leavemst_vo lv;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getD1() {
		return d1;
	}
	public void setD1(Date d1) {
		this.d1 = d1;
	}
	public Date getD2() {
		return d2;
	}
	public void setD2(Date d2) {
		this.d2 = d2;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public leavemst_vo getLv() {
		return lv;
	}
	public void setLv(leavemst_vo lv) {
		this.lv = lv;
	}
	
	
	
}
