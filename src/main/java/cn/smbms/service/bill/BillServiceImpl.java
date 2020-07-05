package cn.smbms.service.bill;

import java.util.List;

import cn.smbms.dao.SmbmsBillMapper;
import cn.smbms.pojo.SmbmsBill;
import cn.smbms.pojo.example.SmbmsBillExample;

/**
 * 商品业务
 * 
 * @author 梁
 *
 */
public class BillServiceImpl implements BillService {
	
	private SmbmsBillMapper smbmsBillMapper;
	
	@Override
	public List<SmbmsBill> selectByExampleService(String name, Integer id, Integer isPayment) {
		SmbmsBillExample billExample = new SmbmsBillExample();
		SmbmsBillExample.Criteria createCriteria = billExample.createCriteria();
		createCriteria.andProductnameLike("%" + name + "%");
		createCriteria.andProvideridEqualTo(id);
		createCriteria.andIspaymentEqualTo(isPayment);
		List<SmbmsBill> selectByExample = smbmsBillMapper.selectByExample(billExample);
		
		return selectByExample;
	}
	
	@Override
	public boolean deleteByPrimaryKey(Long id) {
		
		if (smbmsBillMapper.deleteByPrimaryKey(id) == 1) {
			System.out.println("成功");
		}
		return false;
	}
	
	@Override
	public boolean updateByExampleSelective(SmbmsBill bill) {
		
		if (smbmsBillMapper.updateByPrimaryKeySelective(bill) == 1) {
			System.out.println("成功");
		}
		return true;
	}
}
