package cn.com.colibri.itsystem.service.impl;


import java.util.List;
import java.util.Map;

import cn.com.colibri.itsystem.dao.MaintainOrderDao;
import cn.com.colibri.itsystem.domain.MaintainOrder;
import cn.com.colibri.itsystem.domain.criteria.MaintainOrderCriteria;
import cn.com.colibri.itsystem.service.MaintainOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcloud.utils.StringUtil;
import com.hcloud.exception.ServiceException;
import com.hcloud.page.Page;

/*********************************************************************************************************
 * Copyright (c) 个人
 * All rights reserved.
 *
 * 文件名称:public class MaintainOrderServiceImpl{ } 
 * 
 * 摘    要： 
 * 版    本：1.0
 * 作    者：liuxueli
 * 创建于：2019-05-24 05:27:31
 * 最后修改时间：
 * 
*********************************************************************************************************/
@Service("maintainOrderService")
public class MaintainOrderServiceImpl  implements MaintainOrderService {

	@Autowired
	private MaintainOrderDao maintainOrderDao;
	@Override
	public long countByCriteria(MaintainOrderCriteria maintainOrderCriteria) throws ServiceException {
		return maintainOrderDao.countByCriteria(maintainOrderCriteria);
	}
    
    @Override
    public int countPage(Map<String, Object> map) throws ServiceException {
		return maintainOrderDao.countPage(map);
	}
    
    @Override
    public List<MaintainOrder> queryPageList(Map<String,Object> map) throws ServiceException {
		return maintainOrderDao.queryPageList(map);
	}

	@Override
    public int deleteByCriteria(MaintainOrderCriteria maintainOrderCriteria) throws ServiceException {
		return maintainOrderDao.deleteByCriteria(maintainOrderCriteria);
	}

	@Override
    public int deleteByPrimaryKey(Long id) throws ServiceException {
		return maintainOrderDao.deleteByPrimaryKey(id);
	}
 
 	@Override
    public int insert(MaintainOrder maintainOrder) throws ServiceException {
		return maintainOrderDao.insert(maintainOrder);
	}
    
    @Override
    public void batchInsert(List<MaintainOrder> maintainOrderList) throws ServiceException {
		 maintainOrderDao.batchInsert(maintainOrderList);
	}

	@Override
    public int insertSelective(MaintainOrder maintainOrder) throws ServiceException {
		return maintainOrderDao.insertSelective(maintainOrder);
	}

	@Override
    public List<MaintainOrder> selectByCriteriaList(MaintainOrder maintainOrder) throws ServiceException {
    	MaintainOrderCriteria maintainOrderCriteria=new MaintainOrderCriteria();
		MaintainOrderCriteria.Criteria createCriteria = maintainOrderCriteria.createCriteria();
		
		if(StringUtil.isNotEmpty(maintainOrder.getJobNumber())){
			createCriteria.andJobNumberEqualTo(maintainOrder.getJobNumber());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getRealName())){
			createCriteria.andRealNameEqualTo(maintainOrder.getRealName());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getDepartment())){
			createCriteria.andDepartmentEqualTo(maintainOrder.getDepartment());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getDescription())){
			createCriteria.andDescriptionEqualTo(maintainOrder.getDescription());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getMaintainType())){
			createCriteria.andMaintainTypeEqualTo(maintainOrder.getMaintainType());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getStatus())){
			createCriteria.andStatusEqualTo(maintainOrder.getStatus());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getRemak())){
			createCriteria.andRemakEqualTo(maintainOrder.getRemak());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getCreateTime())){
			createCriteria.andCreateTimeEqualTo(maintainOrder.getCreateTime());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getEndTime())){
			createCriteria.andEndTimeEqualTo(maintainOrder.getEndTime());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getUserId())){
			createCriteria.andUserIdEqualTo(maintainOrder.getUserId());
		}
		List<MaintainOrder> list = maintainOrderDao.selectByCriteria(maintainOrderCriteria);
		return list;
	}

	@Override
    public MaintainOrder selectByPrimaryKey(Long id) throws ServiceException {
		return maintainOrderDao.selectByPrimaryKey(id);
	}

	@Override
    public int updateByCriteriaSelective(MaintainOrder maintainOrder, MaintainOrderCriteria maintainOrderCriteria) throws ServiceException {
		return maintainOrderDao.updateByCriteriaSelective(maintainOrder,maintainOrderCriteria);
	}

	@Override
    public int updateByCriteria(MaintainOrder maintainOrder,MaintainOrderCriteria maintainOrderCriteria) throws ServiceException {
		return maintainOrderDao.updateByCriteria(maintainOrder,maintainOrderCriteria);
	}

	@Override
    public int updateByPrimaryKeySelective(MaintainOrder maintainOrder) throws ServiceException {
		return maintainOrderDao.updateByPrimaryKeySelective(maintainOrder);
	}
    
    @Override
    public int updateByIdAndResource(MaintainOrder maintainOrder) throws ServiceException {
		return maintainOrderDao.updateByIdAndResource(maintainOrder);
	}

	/**
	 * 根据ID修改对象
	 * @param maintainOrder
	 * @return
	 * @throws ServiceException
	 */
	@Override
    public int updateByPrimaryKey(MaintainOrder maintainOrder) throws ServiceException {
		return maintainOrderDao.updateByPrimaryKey(maintainOrder);
	}
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNumber
	 * @param maintainOrder
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public Page<MaintainOrder> queryMaintainOrderPage(Integer pageSize,Integer pageNumber,MaintainOrder maintainOrder) throws ServiceException{
		MaintainOrderCriteria maintainOrderCriteria=new MaintainOrderCriteria();
		MaintainOrderCriteria.Criteria createCriteria = maintainOrderCriteria.createCriteria();
		if(pageNumber==null||pageNumber<=0){
			pageNumber=1;
		}
		if(pageSize==null||pageSize<=0){
			pageSize=10;
		}
		if(StringUtil.isNotEmpty(maintainOrder.getJobNumber())){
			createCriteria.andJobNumberEqualTo(maintainOrder.getJobNumber());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getRealName())){
			createCriteria.andRealNameEqualTo(maintainOrder.getRealName());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getDepartment())){
			createCriteria.andDepartmentEqualTo(maintainOrder.getDepartment());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getDescription())){
			createCriteria.andDescriptionEqualTo(maintainOrder.getDescription());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getMaintainType())){
			createCriteria.andMaintainTypeEqualTo(maintainOrder.getMaintainType());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getStatus())){
			createCriteria.andStatusEqualTo(maintainOrder.getStatus());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getRemak())){
			createCriteria.andRemakEqualTo(maintainOrder.getRemak());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getCreateTime())){
			createCriteria.andCreateTimeEqualTo(maintainOrder.getCreateTime());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getEndTime())){
			createCriteria.andEndTimeEqualTo(maintainOrder.getEndTime());
		}
		if(StringUtil.isNotEmpty(maintainOrder.getUserId())){
			createCriteria.andUserIdEqualTo(maintainOrder.getUserId());
		}
		maintainOrderCriteria.setOffset((pageNumber-1)*pageSize);
		maintainOrderCriteria.setLimit(pageSize);
		List<MaintainOrder> list = maintainOrderDao.selectByCriteria(maintainOrderCriteria);
		long count = maintainOrderDao.countByCriteria(maintainOrderCriteria);
		Page<MaintainOrder> page=new Page<MaintainOrder>(list, count, pageNumber, pageSize);
		return page;
	}
	
	@Override
    public void batchUpdate(List<MaintainOrder> maintainOrderList) throws ServiceException {
		 maintainOrderDao.batchUpdate(maintainOrderList);
	}
	
}