package com.dhony.learning.mapper;

import org.springframework.stereotype.Component;

import com.dhony.learning.DTOs.DonationDTO;
import com.dhony.learning.models.Donation;




@Component
public class DonationMapper {

	
	public Donation toEntity(DonationDTO dto) {
		Donation donation = new Donation();
		donation.setItemName(dto.getItemName());
		donation.setItemQuantity(dto.getItemQuantity());
		donation.setPhotos(dto.getPhotos());
		donation.setAvailable(dto.isAvailable());
		donation.setDescription(dto.getDescription());
		donation.setCreatedDate(dto.getCreatedDate());
		donation.setEmail(dto.getEmail());
		donation.setCategory(dto.getCategory());
		donation.setState(dto.getState());
		donation.setCity(dto.getCity());
		donation.setZipcode(dto.getZipCode());
		return donation;
		
		
		
		
	}
	
	public DonationDTO toDto(Donation entity) {
		DonationDTO donation = new DonationDTO();
		donation.setId(entity.getId());
		donation.setItemName(entity.getItemName());
		donation.setItemQuantity(entity.getItemQuantity());
		donation.setAvailable(entity.isAvailable());
		donation.setPhotos(entity.getPhotos());
		donation.setCategory(entity.getCategory());
		donation.setDonorFirstName(entity.getDonorFirstName());
		donation.setDonorLastName(entity.getDonorLastName());
		donation.setCreatedDate(entity.getCreatedDate());
		donation.setDescription(entity.getDescription());
		donation.setEmail(entity.getEmail());
		donation.setState(entity.getState());
		donation.setCity(entity.getCity());
		donation.setZipCode(entity.getZipcode());
		
		//donation.setLocation(entity.getLocation());
//		Location location = entity.getLocation();
//		if(location != null) {
//			donation.setLocation(new Location(location.getLocationId(),location.getCountry(),location.getState(),location.getCity(),location.getPostCode()));
//		}
		donation.setPhotos(entity.getPhotos());
	
		
		return donation;
		
	}
}
