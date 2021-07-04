package com.example.responsimobile.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataHarian {

	@SerializedName("metadata")
	private MetadataHarian metadataHarian;

	@SerializedName("content")
	private ArrayList<ContentItemDataHarian> content;

	public MetadataHarian getMetadataHarian(){
		return metadataHarian;
	}

	public ArrayList<ContentItemDataHarian> getContent(){
		return content;
	}
}