package com.example.demosecurity.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "login-page";
	}
	
	@GetMapping("/leaders")
	public String forLeads() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String forAdmins() {
		return "systems";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
	
	
	

}
