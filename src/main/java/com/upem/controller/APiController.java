package com.upem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upem.models.Antenne;
import com.upem.models.Device;
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
	@PostMapping("/add")
	public String addDemandeOffre(@RequestBody User dep) {
		System.out.println(dep);
		repo.save(dep);
		return "yes";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		
		System.out.println(user);
		User res= repo.login(user.getMail(), user.getMdp());
		if(res==null) {
			return "500";
		}
		return "200";	
	}
	
	@GetMapping("/getAll")
	public List<User> getusers() {
		return (List<User>) repo.findAll();
	}
	
	
	

}
