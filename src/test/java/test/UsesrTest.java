package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.smbms.pojo.SmbmsUser;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.page.Page;

public class UsesrTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("scanisterService.xml");
	UserService		   bean	   = context.getBean("userService", UserService.class);
	
	@Test
	public void puTest() {
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println("fsadfs=====>" + string);
		}
		SmbmsUser user = new SmbmsUser();
		user.setId(22L);
		user.setGender(2);
		user.setUsername("黄飞鸿53");
		bean.modifyUserInformation(user);
	}
	
	@Test
	public void smbmsUsersTest() {
		List<SmbmsUser> smbmsUsers = bean.smbmsUsers();
		for (SmbmsUser smbmsUser : smbmsUsers) {
			System.out.println("===>" + smbmsUser.getPhone());
		}
	}
	
}
