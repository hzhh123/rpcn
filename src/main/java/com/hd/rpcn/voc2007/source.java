package com.hd.rpcn.voc2007;

public class source {
	String database;
	String annotation;
	String image;
	String flickrid;
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getAnnotation() {
		return annotation;
	}
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFlickrid() {
		return flickrid;
	}
	public void setFlickrid(String flickrid) {
		this.flickrid = flickrid;
	}

	@Override
	public String toString() {
		return "source{" +
				"database='" + database + '\'' +
				", annotation='" + annotation + '\'' +
				", image='" + image + '\'' +
				", flickrid='" + flickrid + '\'' +
				'}';
	}
}
