package cn.smbms.dao;

import cn.smbms.pojo.SmbmsUser;
import cn.smbms.pojo.example.SmbmsUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SmbmsUserMapper {
	int countByExample(SmbmsUserExample example);
	
	int deleteByExample(SmbmsUserExample example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(SmbmsUser record);
	
	int insertSelective(SmbmsUser record);
	
	List<SmbmsUser> selectByExample(SmbmsUserExample example);
	
	SmbmsUser selectByPrimaryKey(Long id);
	
	int updateByExampleSelective(@Param("record") SmbmsUser record, @Param("example") SmbmsUserExample example);
	
	int updateByExample(@Param("record") SmbmsUser record, @Param("example") SmbmsUserExample example);
	
	int updateByPrimaryKeySelective(SmbmsUser record);
	
	int updateByPrimaryKey(SmbmsUser record);
	
	/**
	 * mybatis注解式开发
	 * 
	 * @return
	 */
	@Select("select * from smbms_user limit ${z},${s}")
	List<SmbmsUser> smbmsUsers(@Param("z") Integer z, @Param("s") Integer s);
	
	/**
	 * 查询用户总数
	 * 
	 * @return
	 */
	@Select("select count(1) from smbms_user")
	Integer sumUser();
	
	/**
	 * 分页查询用户
	 * 
	 */
	List<SmbmsUser> pagingQueryUser(@Param("user") SmbmsUser user, @Param("q") Integer q, @Param("y") Integer y);
	
}