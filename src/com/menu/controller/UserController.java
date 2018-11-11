package com.menu.controller;

import com.menu.pojo.User;
import com.menu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 登录
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("user/login.html")
	public String login(User user, Model model, HttpSession session) {
		
		User u = userService.getUserByUsername(user);
		
		if(u != null) {
			if(u.getPassword().equals(user.getPassword())) {
				// 登陆成功
				session.setAttribute("user", u);
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("error", "用户名或密码错误！");
				return "login";
			}
		}else {
			model.addAttribute("error", "用户名或密码错误！");
			return "login";
		}
		
	}
	
	/**
	 * 注销登录
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("user/logout.html")
	public String logout(Model model, HttpSession session) {
		
		session.removeAttribute("user");
		
		return "login";
	}
	
	/**
	 * 注册
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("user/register.html")
	public String register(User user, Model model) {
		
		User u = userService.getUserByUsername(user);
		
		if(u != null) {
			// 存在
			model.addAttribute("error", "该用户已存在！");
			return "register";
		}
		
		userService.insertUser(user);
		model.addAttribute("error", "注册成功！请登录");
		
		return "login";
	}
	
}
