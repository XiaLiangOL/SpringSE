package cn.smbms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.smbms.tools.PageSupport;

/**
 * 创建类的工厂 * @author 梁
 *
 */
@Configuration
public class config {
	/**
	 * <bean class="cn.smbms.tools.PageSupport" id="pageSupport" />
	 * 
	 * @return
	 */
	@Bean
	public PageSupport pageSupport() {
		return new PageSupport();
	}
	
}
