package com.gtu.EngBook.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class FirstController {
	
	
	@RequestMapping(value="/login")
	public String login()
	{
		
		return "Successful";
	}
}
