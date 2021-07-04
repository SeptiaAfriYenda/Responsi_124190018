package com.example.responsimobile.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseFaskes{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<DataItemFaskes> data;

	public int getStatusCode(){
		return statusCode;
	}

	public ArrayList<DataItemFaskes> getData(){
		return data;
	}
}