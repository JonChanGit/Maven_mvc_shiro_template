package com.jon.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jon.web.entity.dto.ActiveUser;
import com.jon.web.util.constantes.Constantes;
import com.jon.web.util.constantes.ConstantesPermission;

/**
 * 
 *
 * @Title: AccessController.java
 * @Package com.jon.web.controller
 * @Description: 文章管理
 * @author JonChan
 * @date 2016年7月7日20:30:22
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	/**
	 * 文章管理入口
	 * 
	 * 使用 @RequiresPermissions("article:show") 注解标明该访问需要"article:show"权限
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	@RequiresPermissions(ConstantesPermission.ARTICLE_SHOW)
	public String toIndex(HttpServletRequest request,Model model) {// User user
		return Constantes.MVC_VIEW_ROOT_PATH + "article_index";
	}

	 

}
