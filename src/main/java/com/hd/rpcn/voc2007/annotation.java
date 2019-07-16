package com.hd.rpcn.voc2007;

import java.util.ArrayList;
import java.util.List;

/**
 *      
 * @author hyg
 *
 */
public class annotation {
	String folder;
	String filename; 
	source source;
	owner owner;
	size size;
	String segmented;
	List<object> object = new ArrayList<object>();
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public source getSource() {
		return source;
	}
	public void setSource(source source) {
		this.source = source;
	}
	public owner getOwner() {
		return owner;
	}
	public void setOwner(owner owner) {
		this.owner = owner;
	}
	public size getSize() {
		return size;
	}
	public void setSize(size size) {
		this.size = size;
	}
	public String getSegmented() {
		return segmented;
	}
	public void setSegmented(String segmented) {
		this.segmented = segmented;
	}
	public List<object> getObject() {
		return object;
	}
	public void setObject(List<object> object) {
		this.object = object;
	}
	@Override
	public String toString() {
		return "annotation [folder=" + folder + ", filename=" + filename
				+ ", source=" + source + ", owner=" + owner + ", size=" + size
				+ ", segmented=" + segmented + ", object=" + object + "]";
	} 
	
}
