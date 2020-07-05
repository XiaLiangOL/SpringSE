package cn.smbms.service.user;

import java.util.List;

import cn.smbms.dto.QueryVo;
import cn.smbms.pojo.SmbmsUser;
import cn.smbms.tools.page.Page;

/**
 * 用户业务
 * 
 * @author 梁
 *
 */
public interface UserService {
	/**
	 * 根据用户信息查询详细信息 登录
	 * 
	 * @param user
	 * @return
	 */
	SmbmsUser findUsers(SmbmsUser user);
	
	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	boolean insertSelective(SmbmsUser user);
	
	/**
	 * 修改用户信息
	 */
	boolean modifyUserInformation(SmbmsUser user);
	
	/**
	 * * 删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteUserInformation(Integer id);
	
	/**
	 * 修改用户密码
	 * 
	 */
	boolean modifyUserpwd(SmbmsUser user) throws RuntimeException;
	
	/**
	 * 查询全部
	 * 
	 * @return
	 */
	List<SmbmsUser> smbmsUsers();
	
	/**
	 * 查询用户数据（分页）
	 * 
	 * @return
	 */
	Page<SmbmsUser> sumUser(QueryVo vo);
	
	/**
	 * 分页查询用户
	 * 
	 * @param user
	 *            用户信息
	 * @param currentPag
	 *            当前页
	 * 
	 * @return
	 */
	
	List<SmbmsUser> userList(SmbmsUser user, Integer currentPag);
	
	/**
	 * 查询总数据量
	 */
	Integer userInteger();
	
}
