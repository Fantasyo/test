package cn.com.colibri.itsystem.dao;

import java.util.List;
import java.util.Map;

import cn.com.colibri.itsystem.domain.MaintainOrder;
import cn.com.colibri.itsystem.domain.criteria.MaintainOrderCriteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/*********************************************************************************************************
 * Copyright (c) 
 * All rights reserved.
 *
 * 文件名称:public class MaintainOrderDao{ }
 * 
 * 摘    要： 
 * 版    本：1.0
 * 作    者：liuxueli
 * 创建于：2019-05-24 05:27:31
 * 最后修改时间：
 * 
 *********************************************************************************************************/
@Repository("maintainOrderDao")
public interface MaintainOrderDao {
	long countByCriteria(MaintainOrderCriteria example);
    
    int countPage(Map<String, Object> map);
    
    List<MaintainOrder> queryPageList(Map<String, Object> map);

    int deleteByCriteria(MaintainOrderCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(MaintainOrder record);
    
    void batchInsert(List<MaintainOrder> list);

    int insertSelective(MaintainOrder record);

    List<MaintainOrder> selectByCriteria(MaintainOrderCriteria example);

    MaintainOrder selectByPrimaryKey(Long id);

    int updateByCriteriaSelective(@Param("record") MaintainOrder record, @Param("example") MaintainOrderCriteria example);

    int updateByCriteria(@Param("record") MaintainOrder record, @Param("example") MaintainOrderCriteria example);

    int updateByPrimaryKeySelective(MaintainOrder record);
    
    int updateByIdAndResource(MaintainOrder record);

    int updateByPrimaryKey(MaintainOrder record);
    
    void batchUpdate(List<MaintainOrder> list);

}