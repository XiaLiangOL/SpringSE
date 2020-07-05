package cn.smbms.service.provider;

import java.util.List;

import cn.smbms.pojo.SmbmsProvider;

/**
 * 供应商业务
 * 
 * @author 梁
 *
 */
public interface ProviderService {
	/**
	 * 
	 * 查全部供应商
	 * 
	 * @return
	 */
	List<SmbmsProvider> selectByExampleService();
	
	/**
	 * 
	 * 根据名字查所有供应商
	 * 
	 * @param name
	 *            可以模糊查询
	 * @return
	 */
	List<SmbmsProvider> selectByExampleService(String name);
	
	/**
	 * 添加供应商
	 * 
	 * @param provider
	 * @return
	 */
	boolean insertSelectiveService(SmbmsProvider provider);
	
}
