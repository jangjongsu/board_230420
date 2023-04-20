package com.jjcompany.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jjcompany.board.command.BCommand;
import com.jjcompany.board.command.BContentCommand;
import com.jjcompany.board.command.BDeleteCommand;
import com.jjcompany.board.command.BModifyCommand;
import com.jjcompany.board.command.BlistCommand;
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
		
		
		
		return "redirect:list";
	
	}
	@RequestMapping(value="/list")
	public String list(Model model) {
		
		BlistCommand command =new BlistCommand();
		command.execute(model);
		
		return "list";
	
	}
	@RequestMapping(value="/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		BContentCommand command =new BContentCommand();
		command.execute(model);
		
		return "contentView";
	
	}
	@RequestMapping(value="/modify_form")
	public String modify_form(HttpServletRequest request, Model model ) {
		
		model.addAttribute("request", request);
		
		BContentCommand command =new BContentCommand();
		command.execute(model);
		
		
		
		return "modifyForm";
	
	}
	@RequestMapping(value="/modify")
	public String modify(HttpServletRequest request, Model model ) {
		
		model.addAttribute("request", request);
		
		BModifyCommand command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest request, Model model ) {
		
		model.addAttribute("request", request);
		
		BDeleteCommand command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
