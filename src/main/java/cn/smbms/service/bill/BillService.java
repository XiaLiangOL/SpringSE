package cn.smbms.service.bill;

import java.util.List;

import cn.smbms.pojo.SmbmsBill;

/**
 * 商品业务
 * 
 * @author 梁
 *
 */
public interface BillService {
	/**
	 * 根据名和商家id和付款状态查询
	 */
	
	List<SmbmsBill> selectByExampleService(String name, Integer id, Integer isPayment);
	
	/**
	 *
	 * 根据id删除商品
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteByPrimaryKey(Long id);
	
	/**
	 * 添加商品
	 * 
	 * @param bill
	 * @return
	 */
	boolean updateByExampleSelective(SmbmsBill bill);
	
}
