package cn.com.colibri.itsystem.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.com.colibri.itsystem.domain.User;
import cn.com.colibri.itsystem.domain.criteria.UserCriteria;
import com.hcloud.exception.ServiceException;
import com.hcloud.page.Page;


/*********************************************************************************************************
 * Copyright (c) 个人
 * All rights reserved.
 *
 * 文件名称:public class UserService{ } 
 * 
 * 摘    要： 
 * 版    本：1.0
 * 作    者： liuxueli
 * 创建于：2019-05-24 05:00:56
 * 最后修改时间：
 * 
*********************************************************************************************************/
public interface UserService {

	long countByCriteria(UserCriteria example);
    
    int countPage(Map<String, Object> map);
    
    List<User> queryPageList(Map<String, Object> map);

    int deleteByCriteria(UserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);
    
    void batchInsert(List<User> list);

    int insertSelective(User record);

    List<User> selectByCriteriaList(User user);

    User selectByPrimaryKey(Long id);

    int updateByCriteriaSelective(User record, UserCriteria example);

    int updateByCriteria(User record, UserCriteria example);

    int updateByPrimaryKeySelective(User record);
    
    int updateByIdAndResource(User record);

    int updateByPrimaryKey(User record);
    
    Page<User> queryUserPage(Integer pageSize, Integer pageNumber, User record) throws ServiceException;
    
    void batchUpdate(List<User> list);
    
}