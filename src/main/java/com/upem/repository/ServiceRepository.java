package com.upem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upem.models.Service;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Integer> {

	/*
	@Query(value = "SELECT * FROM iot.device where idf =?1 and cle =?2", nativeQuery = true)
	Service getbyId(String idf, String key);*/
}
