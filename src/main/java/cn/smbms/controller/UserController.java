package cn.smbms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;
import cn.smbms.pojo.SmbmsRole;
import cn.smbms.pojo.SmbmsUser;
import cn.smbms.service.role.RoleService;
import cn.smbms.service.user.UserService;

/**
 * 用户权限控制
 * 
 * @author 梁
 *
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired(required = false)
	private UserService	userService;
	@Autowired(required = false)
	private RoleService	roleService;
	@Autowired(required = false)
	private PageSupport	pageSupport;
	
	/**
	 * 用户管理主页
	 */
	@RequestMapping("/userlist")
	public String frame(SmbmsUser user, Model model, @RequestParam(
	        value = "pageIndex", required = false) String pageSupport) {
		this.pageSupport.setCurrentPageNo(pageSupport == null ? 1 : Integer.parseInt(pageSupport));
		System.out.println("用户管理主页" + this.pageSupport.getTotalPageCount());
		this.pageSupport.setPageSize(Constants.pageSize);
		this.pageSupport.setTotalCount(userService.userInteger());
		if (user == null)
			;
		else {
			if (user.getUsername() == null)
				;
			else if (user.getUsername().trim().equals(""))
				user.setUsername(null);
			if (user.getUserrole() == null)
				;
			else if (user.getUserrole().equals(0))
				user.setUserrole(null);
		}
		model.addAttribute("roleList", roleService.getRoleList());
		model.addAttribute("userList", userService.userList(user, this.pageSupport.getCurrentPageNo()));
		model.addAttribute("pageSupport", this.pageSupport);
		model.addAttribute("user", user);
		return "/userlist";
	}
	
	/**
	 * 主页面
	 */
	@RequestMapping("/frame")
	public String userlist(HttpSession session) {
		return "/frame";
	}
	
	/**
	 * 验证登录
	 * 
	 * @return
	 */
	@RequestMapping("/tologin")
	public String tologin(HttpSession session, Model model, SmbmsUser smbmsUser) {
		System.out.println(smbmsUser);
		model.addAttribute("user", smbmsUser);
		if (smbmsUser != null) {
			session.setAttribute(Constants.USER_SESSION, userService.findUsers(smbmsUser));
			return "redirect:/user/frame";
		}
		model.addAttribute("error", "错误");
		return "redirect:/login";
	}
	
	/**
	 * 去登录界面
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String tologin() {
		return "login";
	}
	
	/**
	 * 去添加界面
	 * 
	 * @return
	 */
	@RequestMapping("/touseradd")
	public String toAdd() {
		return "useradd";
	}
	
	/**
	 * 添加判断
	 * 
	 * @return
	 */
	@RequestMapping("/adduser")
	public String AddUser(SmbmsUser user, Model model) {
		System.out.println("fdsafsda" + user.toString());
		userService.insertSelective(user);
		return "redirect:userlist";
	}
	
	@RequestMapping(value = "/userrole", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String userName() {
		List<SmbmsRole> roleList = roleService.getRoleList();
		String jsonString = JSON.toJSONString(roleList);
		System.out.println(jsonString);
		return jsonString;
	}
	
}
