package cn.smbms.dao;

import cn.smbms.pojo.SmbmsBill;
import cn.smbms.pojo.example.SmbmsBillExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmbmsBillMapper {
	int countByExample(SmbmsBillExample example);
	
	int deleteByExample(SmbmsBillExample example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(SmbmsBill record);
	
	int insertSelective(SmbmsBill record);
	
	List<SmbmsBill> selectByExample(SmbmsBillExample example);
	
	SmbmsBill selectByPrimaryKey(Long id);
	
	int updateByExampleSelective(@Param("record") SmbmsBill record, @Param("example") SmbmsBillExample example);
	
	int updateByExample(@Param("record") SmbmsBill record, @Param("example") SmbmsBillExample example);
	
	int updateByPrimaryKeySelective(SmbmsBill record);
	
	int updateByPrimaryKey(SmbmsBill record);
}