package cn.smbms.service.provider;

import java.util.List;

import cn.smbms.dao.SmbmsProviderMapper;
import cn.smbms.pojo.SmbmsProvider;

/**
 * 供应商业务
 * 
 * @author 梁
 *
 */
public class ProviderServiceImpl implements ProviderService {
	
	private SmbmsProviderMapper smbmsProviderMapper;
	
	@Override
	public List<SmbmsProvider> selectByExampleService() {
		List<SmbmsProvider> selectByExample = smbmsProviderMapper.selectByExample(null);
		for (SmbmsProvider smbmsProvider : selectByExample) {
			System.out.println(smbmsProvider.toString());
		}
		
		return selectByExample;
	}
	
	@Override
	public List<SmbmsProvider> selectByExampleService(String name) {
		
		return null;
		
	}
	
	@Override
	public boolean insertSelectiveService(SmbmsProvider provider) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
