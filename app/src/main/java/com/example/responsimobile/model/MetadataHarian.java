package com.example.responsimobile.model;

import com.google.gson.annotations.SerializedName;

public class MetadataHarian {

	@SerializedName("last_update")
	private Object lastUpdate;

	public Object getLastUpdate(){
		return lastUpdate;
	}
}