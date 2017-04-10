package VO;

public class loandtl_vo {
	private int id;
	private int amount;
	private String desc;
	private loanmst_vo lv;
	private emp_dtl_vo ev;
	

	public emp_dtl_vo getEv() {
		return ev;
	}

	public void setEv(emp_dtl_vo ev) {
		this.ev = ev;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public loanmst_vo getLv() {
		return lv;
	}

	public void setLv(loanmst_vo lv) {
		this.lv = lv;
	}

}
