package cn.com.colibri.itsystem.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.com.colibri.itsystem.domain.MaintainOrder;
import cn.com.colibri.itsystem.domain.criteria.MaintainOrderCriteria;
import com.hcloud.exception.ServiceException;
import com.hcloud.page.Page;

/*********************************************************************************************************
 * Copyright (c) 个人
 * All rights reserved.
 *
 * 文件名称:public class MaintainOrderService{ } 
 * 
 * 摘    要： 
 * 版    本：1.0
 * 作    者：liuxueli
 * 创建于：2019-05-24 05:27:31
 * 最后修改时间：
 * 
*********************************************************************************************************/
public interface MaintainOrderService {

	long countByCriteria(MaintainOrderCriteria example);
    
    int countPage(Map<String, Object> map);
    
    List<MaintainOrder> queryPageList(Map<String, Object> map);

    int deleteByCriteria(MaintainOrderCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(MaintainOrder record);
    
    void batchInsert(List<MaintainOrder> list);

    int insertSelective(MaintainOrder record);

    List<MaintainOrder> selectByCriteriaList(MaintainOrder maintainOrder);

    MaintainOrder selectByPrimaryKey(Long id);

    int updateByCriteriaSelective(MaintainOrder record, MaintainOrderCriteria example);

    int updateByCriteria(MaintainOrder record, MaintainOrderCriteria example);

    int updateByPrimaryKeySelective(MaintainOrder record);
    
    int updateByIdAndResource(MaintainOrder record);

    int updateByPrimaryKey(MaintainOrder record);
    
    Page<MaintainOrder> queryMaintainOrderPage(Integer pageSize, Integer pageNumber, MaintainOrder record) throws ServiceException;
    
    void batchUpdate(List<MaintainOrder> list);
    
}