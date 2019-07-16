package com.hd.rpcn.voc2007;

public class bndbox {
	String xmin;
	String ymin;
	String xmax;
	String ymax;
	public String getXmin() {
		return xmin;
	}
	public void setXmin(String xmin) {
		this.xmin = xmin;
	}
	public String getYmin() {
		return ymin;
	}
	public void setYmin(String ymin) {
		this.ymin = ymin;
	}
	public String getXmax() {
		return xmax;
	}
	public void setXmax(String xmax) {
		this.xmax = xmax;
	}
	public String getYmax() {
		return ymax;
	}
	public void setYmax(String ymax) {
		this.ymax = ymax;
	}
	@Override
	public String toString() {
		return "bndbox [xmin=" + xmin + ", ymin=" + ymin + ", xmax=" + xmax
				+ ", ymax=" + ymax + "]";
	}  
	
}
