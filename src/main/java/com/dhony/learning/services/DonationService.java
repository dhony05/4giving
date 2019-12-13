package com.dhony.learning.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dhony.learning.DTOs.DonationDTO;
import com.dhony.learning.Repositories.DonationRepository;

import com.dhony.learning.Repositories.PhotoRepository;
import com.dhony.learning.mapper.DonationMapper;
import com.dhony.learning.models.Donation;
import com.dhony.learning.models.Photo;


@Service
public class DonationService {
	
	
	@Autowired
    private PhotoRepository photoRepo;
	@Autowired
	private DonationRepository donationRepo;
	
	@Autowired
	private DonationMapper donationMapper;
	
 
    public String addPhoto(String title, MultipartFile file) throws IOException { 
        Photo photo = new Photo(title); 
        photo.setImage(
          new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        photo = photoRepo.insert(photo); return photo.getId(); 
    }
 
    public Photo getPhoto(String id) { 
        return photoRepo.findById(id).get(); 
    }
    
    
    public List<DonationDTO> findAll(Boolean availables) {
		List<Donation> donationList = new ArrayList<>();
		
		
		
		if (availables != null && !availables == false) {
			donationList = donationRepo.findAllByIsAvailable(availables);
		}
		
	
		
		
	
//		else {
//			donationList = donationRepo.findAll();
//		}
		System.out.println(donationList);
		return donationList.stream().map(d -> donationMapper.toDto(d)).collect(Collectors.toList());
	}
    
    public List<DonationDTO> findAllByEmail(String email){
    	
    	List<Donation> donationByEmail = new ArrayList<>();
    	if(email != null && !email.isEmpty()) {
    		donationByEmail = donationRepo.findAllByEmail(email);
    	}
    	return donationByEmail.stream().map(d -> donationMapper.toDto(d)).collect(Collectors.toList());
    }
    
    public List<DonationDTO> findAllByState(String state){
    	List<Donation> donationByStates = new ArrayList<>();
    	
    	if(state != null && !state.isEmpty()) {
    		donationByStates = donationRepo.findAllByState(state);
    	}
		return donationByStates.stream().map(d -> donationMapper.toDto(d)).collect(Collectors.toList());
		
	}
    public List<DonationDTO> findAllByCity(String state, String city){
    	List<Donation> donationByCity = new ArrayList<>();
    	
    	if(city != null && !city.isEmpty()) {
    		donationByCity = donationRepo.findAllByCity(city);
    		donationByCity = donationByCity.stream()
    				.filter(s -> s.getState().equalsIgnoreCase(state))
    				.collect(Collectors.toList());
    	}
    	
    	
		return donationByCity.stream().map(d -> donationMapper.toDto(d)).collect(Collectors.toList());
		
	}
    
    public List<DonationDTO> findAllByZipCode(int zipCode){
    	List<Donation> donationByZipCode = new ArrayList<>();
    	
    	if(!(zipCode <0) && !(zipCode == 0)) {
    		donationByZipCode = donationRepo.findAllByZipcode(zipCode);
    	}
		return donationByZipCode.stream().map(d -> donationMapper.toDto(d)).collect(Collectors.toList());
		
	}
    
    public DonationDTO findOne(String id) {
		Optional<Donation> donationOp = donationRepo.findById(id);
		if (donationOp.isPresent()) {
			return donationMapper.toDto(donationOp.get());
		}
		return null;
	}
    
	public DonationDTO save(DonationDTO donation) {
		Donation entity = donationMapper.toEntity(donation);
		
		//findLocationByState(donation.getLocation());
//		entity.setLocation(donationRepo.findAllByLocationState(donation.getLocation()));
		//entity.setState(donationRepo.findAllByState(donation.getState()));
		Donation saved = donationRepo.save(entity);
		return donationMapper.toDto(saved);
	}
	
	public DonationDTO update(DonationDTO donation, String id) {
		Optional<Donation> findById = donationRepo.findById(id);
		if (findById.isPresent()) {
			Donation d = findById.get();
			d.setItemName(donation.getItemName());
			d.setItemQuantity(donation.getItemQuantity());
			d.setCategory(donation.getCategory());
			d.setAvailable(donation.isAvailable());
			d.setDonorFirstName(donation.getDonorFirstName());
			d.setDonorLastName(donation.getDonorLastName());
			d.setEmail(donation.getEmail());
			d.setCreatedDate(donation.getCreatedDate());
			d.setState(donation.getState());
			d.setCity(donation.getCity());
			d.setZipcode(donation.getZipCode());
	
			//d.setPrice(donation.getPrice());
			d.setDescription(donation.getDescription());

			d.setPhotos(donation.getPhotos());
			Donation saved = donationRepo.save(d);
			return donationMapper.toDto(saved);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public void delete(String id) {
		donationRepo.deleteById(id);
	}


	
	
    
    

}
