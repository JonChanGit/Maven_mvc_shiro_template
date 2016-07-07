package com.jon.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jon.web.entity.dto.ActiveUser;
import com.jon.web.util.constantes.Constantes;

/**
 * 
 *
 * @Title: AccessController.java
 * @Package com.jon.web.controller
 * @Description: 仪表板入口
 * @author JonChan
 * @date 2016年5月22日 上午7:13:25
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/admin_access")
public class AccessController {

	/**
	 * 登陆成功入口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request,Model model) {// User user

		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		//model.addAttribute("activeUser", activeUser);

		//现在不用Model，直接保存在session中
		HttpSession session = request.getSession();
		
		if(session.getAttribute("activeUser") == null){
			session.setAttribute("activeUser", activeUser);
		}
		
		return Constantes.MVC_VIEW_ROOT_PATH + "index";
	}

	/**
	 * 没有访问权限页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/no_Permissions")
	public String toNoPermissions(Model model) {// User userHttpServletRequest
		return Constantes.MVC_VIEW_ROOT_PATH + "no_Permissions";
	}

}
