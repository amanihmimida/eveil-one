package com.upem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.upem.models.User;
import com.upem.repository.UserRepository;


@RestController
@RequestMapping("/api/user")
public class APiController {

	@Autowired
	UserRepository repo;
	@GetMapping("/get")
	public String addAlien()
	{
		return "home";
	}

	@GetMapping("/lola")
	public User test(User u) {
		User a= new User();
		a.setId(1);
		a.setMail("lladjscc@gmail.com");
		a.setMdp("lola");
		a.setNom("laoala");
		a.setPrenom("lalaa");
		return a;
	}

	@PostMapping("/add")
	public String addDemandeOffre(@RequestBody User dep) {
		
		System.out.println(dep);
		repo.save(dep);
		return "yes";
		
		/*if(repo.save(dep) != null) {
			return true;
		}
		return false;*/
	}
	
	@GetMapping("/getAll")
	public List<User> getusers() {
		return (List<User>) repo.findAll();
	}

}
