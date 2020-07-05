/**
 * 
 */
package cn.smbms.service.role;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.SmbmsRoleMapper;
import cn.smbms.pojo.SmbmsRole;
import cn.smbms.pojo.example.SmbmsRoleExample;

/**
 * 角色业务
 * 
 * @author 梁
 *
 */
@Service
public class RoleSrviceImpl implements RoleService {
	@Resource
	private SmbmsRoleMapper smbmsRoleMapper;
	
	@Override
	public List<SmbmsRole> selectByExample(String name) {
		SmbmsRoleExample example = new SmbmsRoleExample();
		SmbmsRoleExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andRolenameLike("%" + name + "%");
		return smbmsRoleMapper.selectByExample(example);
	}
	
	@Override
	public int insertSelective(SmbmsRole role) {
		
		return smbmsRoleMapper.insertSelective(role);
	}
	
	@Override
	public List<SmbmsRole> getRoleList() {
		return smbmsRoleMapper.selectByExample(new SmbmsRoleExample());
	}
	
}
