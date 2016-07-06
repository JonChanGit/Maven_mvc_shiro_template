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
import com.jon.web.util.JsonTool;

//@Controller
//@RequestMapping("/users")
public class UserController {
	
	/**
	 * 通过Spring注入Manager对象
	 */
	//@Resource(name="userManager")
	private IUserManager userManager;
	
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	//@RequestMapping("/addUser.do")
	public String addUser(SysUser user){
		userManager.addUser(user);
		return "/success";
	}
	
	/**
	 * 查询
	 * @param request
	 * @return
	 */
	//@RequestMapping("/toUser.do")
	public String toUser(HttpServletRequest request){//User user
		
		List<SysUser> list = userManager.getAllUser();
		request.setAttribute("list", list);
		
		return "/UserAnnotation/addUser";
	}
	
	
	/**
	 * 删除
	 * 指定只能用POST访问
	 * @param userId
	 * @param response
	 * @throws IOException
	 */
	//@RequestMapping(value="/deleteUser.do",method=RequestMethod.POST)
	public void deleteUser(String userId,HttpServletResponse response) throws IOException{
		boolean r = false;
		try {
			r  = userManager.deleteUser(Long.parseLong(userId));
		} catch (NumberFormatException e) {
			JsonTool.toJson("参数格式错误", response);
		}
		JsonTool.toJson(r, response);
	}
	
	
	
 
	/**
	 * 获取单个User
	 * @param userId
	 * @param response
	 * @throws IOException
	 */
	//@RequestMapping("/getUser.do")
	public void getUser(String userId,HttpServletResponse response) throws IOException{
		try {
			SysUser u  = userManager.getUser(Long.parseLong(userId));
			JsonTool.toJson(u, response);
		} catch (NumberFormatException e) {
			JsonTool.toJson("参数格式错误", response);
		}
	}
	
	/**
	 * 更新User
	 * @param userId
	 * @param response
	 * @throws IOException
	 */
	//@RequestMapping("/updateUser.do")
	public void updateUser(SysUser user,HttpServletResponse response) throws IOException{
		try {
			if( userManager.updateUser(user)){
				SysUser u  = userManager.getUser(user.getId());
				 JsonTool.toJson(u, response);
			}else{
				JsonTool.toJson("更新失败", response);
			}
		} catch (Exception e) {
			JsonTool.toJson("参数格式错误", response);
		}
	}
	
}
