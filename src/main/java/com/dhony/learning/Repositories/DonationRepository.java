package com.dhony.learning.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dhony.learning.models.Donation;

@Repository
public interface DonationRepository extends MongoRepository<Donation, String>{

	 
	public List<Donation> findAllByIsAvailable(Boolean availables);
	
	public List<Donation> findAllByState(String state);
	
	public List<Donation> findAllByEmail(String email);
	
	public List<Donation> findAllByCity( String city);
	
	public List <Donation> findAllByZipcode(int zipCode);

}
