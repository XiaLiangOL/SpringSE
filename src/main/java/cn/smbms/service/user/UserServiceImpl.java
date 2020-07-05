package cn.smbms.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.dao.SmbmsUserMapper;
import cn.smbms.dto.QueryVo;
import cn.smbms.pojo.SmbmsUser;
import cn.smbms.pojo.example.SmbmsUserExample;
import cn.smbms.pojo.example.SmbmsUserExample.Criteria;
import cn.smbms.tools.Constants;
import cn.smbms.tools.page.Page;

@Transactional(rollbackFor = RuntimeException.class)
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SmbmsUserMapper smbmsUserMapper;
	
	public void setSmbmsUserMapper(SmbmsUserMapper smbmsUserMapper) {
		this.smbmsUserMapper = smbmsUserMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS,
	        rollbackFor = RuntimeException.class)
	public boolean insertSelective(SmbmsUser user) {
		
		try {
			if (smbmsUserMapper.insertSelective(user) == 1) {
				System.out.println("成功");
			}
			return true;
			
		}
		catch (RuntimeException e) {
			throw e;
		}
	}
	
	@Override
	public SmbmsUser findUsers(SmbmsUser user) {
		SmbmsUserExample example = new SmbmsUserExample();
		Criteria createCriteria = example.createCriteria();
		if (user.getUsercode() != null)
			createCriteria.andUsercodeEqualTo(user.getUsercode());
		if (user.getUserpassword() != null)
			createCriteria.andUserpasswordEqualTo(user.getUserpassword());
		if (user.getUsername() != null)
			createCriteria.andUsernameEqualTo(user.getUsername());
		return smbmsUserMapper.selectByExample(example).get(0);
	}
	
	@Override
	public boolean modifyUserInformation(SmbmsUser user) {
		System.out.println("进入");
		if (smbmsUserMapper.updateByPrimaryKeySelective(user) == 1) {
			System.out.println("成功");
			return true;
		}
		else {
			System.out.println("失败");
			return false;
		}
	}
	
	@Override
	public boolean deleteUserInformation(Integer id) {
		if (smbmsUserMapper.deleteByPrimaryKey((long) id) == 1) {
			System.out.println("成功");
			return false;
			
		}
		else {
			System.out.println("err");
			return false;
		}
	}
	
	@Override
	public boolean modifyUserpwd(SmbmsUser user) throws RuntimeException {
		if (smbmsUserMapper.updateByPrimaryKeySelective(user) == 1)
			System.out.println("成功");
		
		return true;
	}
	
	@Override
	public List<SmbmsUser> smbmsUsers() {
		return smbmsUserMapper.smbmsUsers(0, smbmsUserMapper.sumUser());
	}
	
	@Override
	public Page<SmbmsUser> sumUser(QueryVo vo) {
		Page<SmbmsUser> page = new Page<SmbmsUser>();
		page.setSize(5);
		vo.setSize(5);
		vo.setSize(5);
		if (null != vo) {
			// 判断当前页
			if (null != vo.getPage()) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			}
			page.setTotal(smbmsUserMapper.sumUser());
			page.setRows(smbmsUserMapper.smbmsUsers(vo.getStartRow(), vo.getSize()));
		}
		
		return page;
	}
	
	@Override
	public List<SmbmsUser> userList(SmbmsUser user, Integer page) {
		List<SmbmsUser> pagingQueryUser = smbmsUserMapper.pagingQueryUser(user, (page - 1) * Constants.pageSize, Constants.pageSize);
		return pagingQueryUser;
	}
	
	@Override
	public Integer userInteger() {
		Integer sumUser = smbmsUserMapper.sumUser();
		System.out.println("fdsafdsafsd" + sumUser);
		return sumUser;
	}
	
}
