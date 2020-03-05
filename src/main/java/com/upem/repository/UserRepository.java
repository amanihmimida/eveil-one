package com.upem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upem.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	
	/*@Query(value = "SELECT * FROM sciruse.actors where id =?1", nativeQuery = true)
	Actors getActor(Integer id);*/
}
