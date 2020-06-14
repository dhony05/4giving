package com.dhony.learning.services;

import java.util.List;

import com.dhony.learning.DTOs.DonationDTO;

public interface DonationServiceInterface {
	
	public List<DonationDTO> findAll(Boolean availables);
	
	public List<DonationDTO> findAllByEmail(String email);
	
	public List<DonationDTO> findAllByState(String state);
	
	public List<DonationDTO> findAllByCity(String state, String city);
	
	public List<DonationDTO> findAllByZipCode(int zipCode);
	
	public DonationDTO findById(String id);
	
	public DonationDTO save(DonationDTO donation);

	public DonationDTO update(DonationDTO donation, String id);
	
	public void deleteById(String id);
}
