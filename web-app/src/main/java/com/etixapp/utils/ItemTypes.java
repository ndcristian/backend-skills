package com.etixapp.utils;

import java.util.Arrays;

public enum ItemTypes {
	CAT1("cat1","cat11"),
	CAT2("cat2", "cat22"),
	CAT3("cat3", "cat33"),
	CAT4("cat4", "cat44");

	private String type;
	private String folderName;

	private ItemTypes(String type, String folderName) {
		this.type = type;
		this.folderName = folderName;
	}

	public String getType() {
		return type;
	}

	public String getFolderName() {
		return folderName;
	}

	public static ItemTypes findValueByType(String type) throws Exception {
		return Arrays.stream(ItemTypes.values()).filter(v ->
				v.getType().equals(type)).findFirst().orElseThrow(() -> new Exception(String.format("Type not found: '%s'", type)));
	}
}
