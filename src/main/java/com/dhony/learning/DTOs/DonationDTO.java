package com.dhony.learning.DTOs;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;


import com.dhony.learning.models.Photo;

public class DonationDTO {

	private String id;
	
	
	@NotNull
	private String itemName;
	
	private int itemQuantity;
	
	private List<Photo> photos ;
	
	
	private Date createdDate;
	
	
	private String category;
	
	private String description;
	@NotNull
	private String state;
	@NotNull
	private String city;
	
	@NotNull
	private int zipCode;
	

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@NotNull
	private boolean isAvailable;
	@NotNull
	private String donorFirstName;
	@NotNull
	private String donorLastName; 
	@NotNull
	private String email;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getDonorFirstName() {
		return donorFirstName;
	}
	public void setDonorFirstName(String donorFirstName) {
		this.donorFirstName = donorFirstName;
	}
	public String getDonorLastName() {
		return donorLastName;
	}
	public void setDonorLastName(String donorLastName) {
		this.donorLastName = donorLastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
