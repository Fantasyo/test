package cn.com.colibri.itsystem.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.colibri.itsystem.dao.UserDao;
import cn.com.colibri.itsystem.domain.User;
import cn.com.colibri.itsystem.domain.criteria.UserCriteria;
import cn.com.colibri.itsystem.enums.DeleteFlagEnum;
import cn.com.colibri.itsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcloud.utils.StringUtil;
import com.hcloud.exception.ServiceException;
import com.hcloud.page.Page;



/*********************************************************************************************************
 * Copyright (c) 个人
 * All rights reserved.
 *
 * 文件名称:public class UserServiceImpl{ } 
 * 
 * 摘    要： 
 * 版    本：1.0
 * 作    者： liuxueli
 * 创建于：2019-05-24 05:00:56
 * 最后修改时间：
 * 
*********************************************************************************************************/
@Service("userService")
public class UserServiceImpl  implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public long countByCriteria(UserCriteria userCriteria) throws ServiceException {
		return userDao.countByCriteria(userCriteria);
	}
    
    @Override
    public int countPage(Map<String, Object> map) throws ServiceException {
		return userDao.countPage(map);
	}
    
    @Override
    public List<User> queryPageList(Map<String,Object> map) throws ServiceException {
		return userDao.queryPageList(map);
	}

	@Override
    public int deleteByCriteria(UserCriteria userCriteria) throws ServiceException {
		return userDao.deleteByCriteria(userCriteria);
	}

	@Override
    public int deleteByPrimaryKey(Long id) throws ServiceException {
		return userDao.deleteByPrimaryKey(id);
	}
 
 	@Override
    public int insert(User user) throws ServiceException {
		user.setCreatTime(new Date());
		user.setDeleteFlag(DeleteFlagEnum.NO.getValue());
		return userDao.insert(user);
	}
    
    @Override
    public void batchInsert(List<User> userList) throws ServiceException {
		 userDao.batchInsert(userList);
	}

	@Override
    public int insertSelective(User user) throws ServiceException {
		return userDao.insertSelective(user);
	}

	@Override
    public List<User> selectByCriteriaList(User user) throws ServiceException {
    	UserCriteria userCriteria=new UserCriteria();
		UserCriteria.Criteria createCriteria = userCriteria.createCriteria();

		if(StringUtil.isNotEmpty(user.getUserName())){
			createCriteria.andUserNameEqualTo(user.getUserName());
		}
		if(StringUtil.isNotEmpty(user.getPassword())){
			createCriteria.andPasswordEqualTo(user.getPassword());
		}
		if(StringUtil.isNotEmpty(user.getCreatTime())){
			createCriteria.andCreatTimeEqualTo(user.getCreatTime());
		}
		if(StringUtil.isNotEmpty(user.getModifyTime())){
			createCriteria.andModifyTimeEqualTo(user.getModifyTime());
		}
		if(StringUtil.isNotEmpty(user.getDeleteFlag())){
			createCriteria.andDeleteFlagEqualTo(user.getDeleteFlag());
		}
		if(StringUtil.isNotEmpty(user.getAddress())){
			createCriteria.andAddressEqualTo(user.getAddress());
		}
		List<User> list = userDao.selectByCriteria(userCriteria);
		return list;
	}

	@Override
    public User selectByPrimaryKey(Long id) throws ServiceException {
		return userDao.selectByPrimaryKey(id);
	}

	@Override
    public int updateByCriteriaSelective(User user, UserCriteria userCriteria) throws ServiceException {
		return userDao.updateByCriteriaSelective(user,userCriteria);
	}

	@Override
    public int updateByCriteria(User user,UserCriteria userCriteria) throws ServiceException {
		return userDao.updateByCriteria(user,userCriteria);
	}

	@Override
    public int updateByPrimaryKeySelective(User user) throws ServiceException {
		return userDao.updateByPrimaryKeySelective(user);
	}
    
    @Override
    public int updateByIdAndResource(User user) throws ServiceException {
		return userDao.updateByIdAndResource(user);
	}

	/**
	 * 根据ID修改对象
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	@Override
    public int updateByPrimaryKey(User user) throws ServiceException {
		return userDao.updateByPrimaryKey(user);
	}
	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNumber
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public Page<User> queryUserPage(Integer pageSize,Integer pageNumber,User user) throws ServiceException{
		UserCriteria userCriteria=new UserCriteria();
		UserCriteria.Criteria createCriteria = userCriteria.createCriteria();
		if(pageNumber==null||pageNumber<=0){
			pageNumber=1;
		}
		if(pageSize==null||pageSize<=0){
			pageSize=10;
		}
		if(StringUtil.isNotEmpty(user.getUserName())){
			createCriteria.andUserNameEqualTo(user.getUserName());
		}
		if(StringUtil.isNotEmpty(user.getPassword())){
			createCriteria.andPasswordEqualTo(user.getPassword());
		}
		if(StringUtil.isNotEmpty(user.getCreatTime())){
			createCriteria.andCreatTimeEqualTo(user.getCreatTime());
		}
		if(StringUtil.isNotEmpty(user.getModifyTime())){
			createCriteria.andModifyTimeEqualTo(user.getModifyTime());
		}
		if(StringUtil.isNotEmpty(user.getDeleteFlag())){
			createCriteria.andDeleteFlagEqualTo(user.getDeleteFlag());
		}
		if(StringUtil.isNotEmpty(user.getAddress())){
			createCriteria.andAddressEqualTo(user.getAddress());
		}
		userCriteria.setOffset((pageNumber-1)*pageSize);
		userCriteria.setLimit(pageSize);
		List<User> list = userDao.selectByCriteria(userCriteria);
		long count = userDao.countByCriteria(userCriteria);
		Page<User> page=new Page<User>(list, count, pageNumber, pageSize);
		return page;
	}
	
	@Override
    public void batchUpdate(List<User> userList) throws ServiceException {
		 userDao.batchUpdate(userList);
	}
	
}