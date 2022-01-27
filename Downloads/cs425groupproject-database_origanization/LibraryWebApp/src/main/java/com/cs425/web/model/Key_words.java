package com.cs425.web.model;

public class Key_words {

	private String D_ID;
	private String key_words;
	
	public String getD_ID() {
		return D_ID;
	}
	public void setD_ID(String iD) {
		D_ID = iD;
	}
	public String getKey_words() {
		return key_words;
	}
	public void setKey_words(String key_words) {
		this.key_words = key_words;
	}
	
	@Override
	public String toString() {
		return "Librarians [ID=" + D_ID + ", key_words=" + key_words + "]";
	}
}
