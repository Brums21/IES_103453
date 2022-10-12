package com.lab2_3_c.al_c;

public class AlCApplication {

	private final long id;
	private final String content;

	public AlCApplication(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}