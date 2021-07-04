package com.example.responsimobile.model;

import com.google.gson.annotations.SerializedName;

public class ResponseDataHarian{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private DataHarian dataHarian;

	public int getStatusCode(){
		return statusCode;
	}

	public DataHarian getDataHarian(){
		return dataHarian;
	}
}