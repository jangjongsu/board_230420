package com.jjcompany.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jjcompany.board.command.BwriteCommand;

@Controller
public class BoardController {
	
	@RequestMapping(value="/write_Form")
	public String writeForm() {
		
		return "writeForm";
	
	}
	@RequestMapping(value="/write")
	public String write(HttpServletRequest request, Model model ) {
		
		model.addAttribute("request", request);
		
		BwriteCommand command = new BwriteCommand();
		command.execute(model);
		
		
		
		return "redirext:list";
	
	}
}
