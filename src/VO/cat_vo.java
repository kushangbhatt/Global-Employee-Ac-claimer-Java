package VO;

public class cat_vo {
	private int id;
	private String cat;
	private String desc;
	examtype_vo ev;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCat() {
		return cat;
	}
	public examtype_vo getEv() {
		return ev;
	}
	public void setEv(examtype_vo ev) {
		this.ev = ev;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
