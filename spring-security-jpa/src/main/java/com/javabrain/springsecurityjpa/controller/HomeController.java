package com.javabrain.springsecurityjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String showHome() {
		return ("<h>Welcome</h>");
	}
	
	@GetMapping("/user")
	public String user() {
		return ("<h>Welcome user</h>");
	}
	@GetMapping("/admin")
	public String admin() {
		return ("<h>Welcome Admin</h>");
	}

}
