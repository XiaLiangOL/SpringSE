package cn.smbms.service.role;

import java.util.List;

import cn.smbms.pojo.SmbmsRole;

/**
 * 角色业务
 * 
 * @author 梁
 *
 */
public interface RoleService {
	
	/**
	 * 按名字查询角色列表
	 * 
	 * @param name
	 *            可以是模糊查询
	 * @return
	 */
	List<SmbmsRole> selectByExample(String name);
	
	/**
	 * 添加角色
	 * 
	 * @param role
	 *            角色实体
	 * @return
	 */
	int insertSelective(SmbmsRole role);
	
	/**
	 * 查询全部角色名和id
	 * 
	 * @return
	 */
	public List<SmbmsRole> getRoleList();
}
