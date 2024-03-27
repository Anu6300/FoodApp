package com.jsp.foodapp.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.UserDao;

import com.jsp.foodapp.entities.User;

@Controller
public class UserController {
	
	@Autowired
	UserDao udao;
	
	@RequestMapping("/adduser")
	public ModelAndView addUser()
	{
		ModelAndView mav=new ModelAndView("CreateUser");
		User user=new User();
		mav.addObject("User", user);
		return mav;                           
	}

	@RequestMapping("/saveuser")
	public ModelAndView  saveUser(@ModelAttribute("User") User u)
	{
		ModelAndView mav=new ModelAndView("loginuser");
		udao.saveUser(u);
		return mav; 
	}
	
	@RequestMapping("/validateuser")
	public ModelAndView loginValidation(ServletRequest req,HttpSession session)
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		User user=udao.Login(email, password);
		if(user==null)
		{
			ModelAndView mav=new ModelAndView("loginuser");
			mav.addObject("msg","invalid credentials");
			return mav;
		}
		else {
			ModelAndView mav=new ModelAndView("useroptions");
			session.setAttribute("User", user);
			return mav;
		}
	}
	
	

}
