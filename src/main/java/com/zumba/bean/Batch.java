package com.zumba.bean;

public class Batch {
	public int bid;
	public String typeofbatch;
	public String time;
	public Batch() {}

	public Batch(int bid, String typeofbatch, String time) {
		super();
		this.bid = bid;
		this.typeofbatch = typeofbatch;
		this.time = time;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getTypeofbatch() {
		return typeofbatch;
	}

	public void setTypeofbatch(String typeofbatch) {
		this.typeofbatch = typeofbatch;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}