package com.dhony.learning.DTOs;

import org.bson.types.Binary;


public class PhotoDTO {

	
	private String id;
    
    private String title;
     //size < 16MB)     
    private Binary image;
    
	public PhotoDTO(String id, String title, Binary image) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Binary getImage() {
		return image;
	}
	public void setImage(Binary image) {
		this.image = image;
	}
    
    
}
