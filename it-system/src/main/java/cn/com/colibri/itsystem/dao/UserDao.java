package cn.com.colibri.itsystem.dao;

import java.util.List;
import java.util.Map;

import cn.com.colibri.itsystem.domain.User;
import cn.com.colibri.itsystem.domain.criteria.UserCriteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/*********************************************************************************************************
 * Copyright (c) 
 * All rights reserved.
 *
 * 文件名称:public class UserDao{ } 
 * 
 * 摘    要： 
 * 版    本：1.0
 * 作    者：yanlang
 * 创建于：2019-05-24 05:00:56
 * 最后修改时间：
 * 
 *********************************************************************************************************/
@Repository("userDao")
public interface UserDao {
	long countByCriteria(UserCriteria example);
    
    int countPage(Map<String, Object> map);
    
    List<User> queryPageList(Map<String, Object> map);

    int deleteByCriteria(UserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);
    
    void batchInsert(List<User> list);

    int insertSelective(User record);

    List<User> selectByCriteria(UserCriteria example);

    User selectByPrimaryKey(Long id);

    int updateByCriteriaSelective(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByCriteria(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByPrimaryKeySelective(User record);
    
    int updateByIdAndResource(User record);

    int updateByPrimaryKey(User record);
    
    void batchUpdate(List<User> list);

}