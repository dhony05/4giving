package com.dhony.learning.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhony.learning.DTOs.DonationDTO;
import com.dhony.learning.services.DonationService;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class DonationController {
	
	private final DonationService donationService;

	
	public DonationController(DonationService donationService) {
		this.donationService = donationService;
	}
	
	@GetMapping("/donations")
	public List<DonationDTO> getAll()
	{
		System.out.println(donationService.findAll(true).toString());
		return donationService.findAll(true);
		
	}
	
	@GetMapping("/donations/state/{state}")
	public List<DonationDTO> getAllByState(@PathVariable String state){
		return donationService.findAllByState(state);
	}
	
	@GetMapping("/donations/state/{state}/city/{city}")
	public List<DonationDTO> getAllByCity(@PathVariable String state,@PathVariable String city){
		return donationService.findAllByCity(state, city);
	}

	@GetMapping("/donations/{id}")
	public ResponseEntity<DonationDTO> get(@PathVariable String id) {
		DonationDTO donation = donationService.findOne(id);
		return ResponseEntity.ok(donation);
	}
	
	@GetMapping("/donations/email/{email}")
	public List<DonationDTO> getAllByEmail(@PathVariable String email){
		System.out.println(email);
		return donationService.findAllByEmail(email);
	}
	@GetMapping("/donations/zipcode/{zipcode}")
	public List<DonationDTO> getAllByZipcode(@PathVariable int zipcode){
		
		return donationService.findAllByZipCode(zipcode);
	}
	
	@PostMapping("/donations")
	public ResponseEntity<DonationDTO> create(@RequestBody  DonationDTO donation) throws URISyntaxException {
		DonationDTO result = donationService.save(donation);
		return ResponseEntity.created(new URI("/api/donations/" + result.getId())).body(result);
	}

	
	@PutMapping("/donations/{id}")
	public ResponseEntity<DonationDTO> updateJob(@PathVariable String id, @RequestBody @Valid DonationDTO donation) {
		DonationDTO result = donationService.update(donation, id);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/donations/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		donationService.delete(id);
		return ResponseEntity.ok().build();
	}


}
