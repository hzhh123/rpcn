package com.hd.rpcn.voc2007;

public class object {
	String name;
	String pose;
	String truncated;
	String difficult; 
	bndbox bndbox;
	private String rate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPose() {
		return pose;
	}
	public void setPose(String pose) {
		this.pose = pose;
	}
	public String getTruncated() {
		return truncated;
	}
	public void setTruncated(String truncated) {
		this.truncated = truncated;
	}
	public String getDifficult() {
		return difficult;
	}
	public void setDifficult(String difficult) {
		this.difficult = difficult;
	}
	public bndbox getBndbox() {
		return bndbox;
	}
	public void setBndbox(bndbox bndbox) {
		this.bndbox = bndbox;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "object [name=" + name + ", pose=" + pose + ", truncated="
				+ truncated + ", difficult=" + difficult + ", bndbox=" + bndbox
				+ ", rate=" + rate + "]";
	}
	
}
