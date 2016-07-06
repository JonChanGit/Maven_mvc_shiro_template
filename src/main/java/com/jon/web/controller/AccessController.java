package com.jon.web.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jon.web.entity.SysUser;
import com.jon.web.service.imp.IUserManager;
import com.jon.web.util.Constantes;
import com.jon.web.util.JsonTool;

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
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request){//User user
		
		
		return Constantes.MVC_VIEW_ROOT_PATH + "index";
	}
	
	
	 
	
}
