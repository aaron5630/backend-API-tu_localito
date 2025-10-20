package com.tu.localito.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tu.localito.app.service.UsersService;

@RestController
@RequestMapping("")
public class UsersController {
	private final UsersService userService;

	public UsersController(UsersService userService) {
		this.userService = userService;
	}
	
	
}
