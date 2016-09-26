package com.renjie120.jsoup.dto;

public enum HouseType {
	BELLOW_90("1"), ABOVE_90_BELLOW_144("2"), ABOVE_144("3");
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private HouseType(String cnName) {
		this.cnName = cnName;
	}
}
