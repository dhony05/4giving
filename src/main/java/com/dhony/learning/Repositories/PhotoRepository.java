package com.dhony.learning.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dhony.learning.models.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> { }
