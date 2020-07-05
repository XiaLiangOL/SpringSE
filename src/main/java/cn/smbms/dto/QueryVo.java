package cn.smbms.dto;

import cn.smbms.pojo.SmbmsUser;

/**
 * 业务实体类
 * 
 * @author 梁
 *
 */
public class QueryVo {
	
	public SmbmsUser user;
	
	public SmbmsUser getUser() {
		return user;
	}
	
	public void setUser(SmbmsUser user) {
		this.user = user;
	}
	
	/**
	 * 当前页
	 */
	private Integer	page;
	
	/**
	 * 每页数
	 */
	private Integer	size	 = 10;
	/**
	 * 开始行
	 */
	private Integer	startRow = 0;
	
	public Integer getPage() {
		return page;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Integer getSize() {
		return size;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}
	
	public Integer getStartRow() {
		return startRow;
	}
	
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	
}
