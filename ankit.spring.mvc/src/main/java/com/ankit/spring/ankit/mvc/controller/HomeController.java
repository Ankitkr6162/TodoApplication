package com.ankit.spring.ankit.mvc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ankit.spring.ankit.mvc.model.Todo;

import jakarta.servlet.ServletContext;

@Controller
public class HomeController {
	
	@Autowired
	ServletContext context;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		String str ="home";
		model.addAttribute("page", str);

		List<Todo> list = (List<Todo>) context.getAttribute("list");
		model.addAttribute("todos",list);
		return "home";
	}
	
	@GetMapping("/add")
	public String addTodo(Model model) {
		
		Todo todo = new Todo();
		model.addAttribute( "todo",todo);
		model.addAttribute("page", "add");
		return "home";
		
	}
	
	@RequestMapping(value="/saveTodo", method= RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo")Todo todo, Model model) {
		System.out.println(todo);
		todo.setTodoDate(new Date());
		
		List<Todo> list = (List<Todo>) context.getAttribute("list");
		list.add(todo);
		model.addAttribute("msg","successfully added..");
		return "home";
		
		
	}

}
