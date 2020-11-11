package com.injari.web.company;

import java.sql.Blob;
import java.sql.Timestamp;

public class CompanyDTO {
	private int cid;
	private String cname;
	private String shotinfo;
	private String info;
	private Blob pic;
	private String inteviewinfo;
	private String etcinfo;
	private int ccount;
	private Timestamp mkdate;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getShotinfo() {
		return shotinfo;
	}
	public void setShotinfo(String shotinfo) {
		this.shotinfo = shotinfo;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Blob getPic() {
		return pic;
	}
	public void setPic(Blob pic) {
		this.pic = pic;
	}
	public String getInteviewinfo() {
		return inteviewinfo;
	}
	public void setInteviewinfo(String inteviewinfo) {
		this.inteviewinfo = inteviewinfo;
	}
	public String getEtcinfo() {
		return etcinfo;
	}
	public void setEtcinfo(String etcinfo) {
		this.etcinfo = etcinfo;
	}
	public int getCcount() {
		return ccount;
	}
	public void setCcount(int ccount) {
		this.ccount = ccount;
	}
	public Timestamp getMkdate() {
		return mkdate;
	}
	public void setMkdate(Timestamp mkdate) {
		this.mkdate = mkdate;
	}
	
}
