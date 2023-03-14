package com.zensar.SB_by_Sharad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/hi")
	public String Hellos() {
		return"<h1>hiiiiiiiiiiii</h1>";

	}
}
