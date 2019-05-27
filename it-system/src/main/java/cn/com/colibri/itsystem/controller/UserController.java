package cn.com.colibri.itsystem.controller;

import cn.com.colibri.itsystem.domain.User;
import cn.com.colibri.itsystem.service.UserService;
import cn.com.colibri.itsystem.vo.UserDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

import com.alibaba.fastjson.JSONArray;
import com.hcloud.common.ApiResult;
import com.hcloud.common.Code;
import com.hcloud.common.Constants;
import com.hcloud.page.Page;
import com.hcloud.utils.ConvertDtoUtil;


/*********************************************************************************************************
 * Copyright (c) 2018
 * All rights reserved.
 *
 * 文件名称:public class UserController{ } 
 * 
 * 摘    要： 用户表
 * 版    本：1.0
 * 作    者：yanlang
 * 创建于：2019-05-24 05:00:56
 * 最后修改时间：
 * 
*********************************************************************************************************/
@Slf4j
@RestController
@RequestMapping("/admin/system/User")
@Api(value = "用户表-接口", description = "用户表-接口")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation("用户表-列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "String", paramType = "query", required = true),
    })
    @GetMapping(value = "/list")
    public ApiResult<Page<UserDetailVO>> userList(Integer pageNo, Integer pageSize) throws Exception {
        ApiResult<Page<UserDetailVO>> result = new ApiResult<Page<UserDetailVO>>();
        User user =new User();
        Page<User> queryUserPage = userService.queryUserPage(pageSize, pageNo, user);
        List<User> list=new ArrayList<User>(queryUserPage.getData());
        List<UserDetailVO> dataList=ConvertDtoUtil.listBeanToDto(list,UserDetailVO.class);
		Page<UserDetailVO> listVo=new Page<UserDetailVO>(dataList, queryUserPage.getTotalRecord(), queryUserPage.getIndex(), queryUserPage.getSize());
	    result.setData(listVo);
        result.code(Code.normal).message(Constants.YD_OK_SHOW);
        return result;
    } 
    
    @ApiOperation("用户表-新增")
    @PostMapping(value = "/add")
    public ApiResult addUser(UserDetailVO UserDetailVO) throws Exception {
        ApiResult result = new ApiResult();
        User user=new User();
        BeanUtils.copyProperties(user, UserDetailVO);
        userService.insert(user);
        result.code(Code.normal).message(Constants.YD_OK_SAVE);
        return result;
    }
    
    @ApiOperation("用户表-编辑")
    @PostMapping(value = "/edit")
    public ApiResult editUser(UserDetailVO UserDetailVO) throws Exception  {
        ApiResult result = new ApiResult();
        User user=new User();
        BeanUtils.copyProperties(user, UserDetailVO);
        userService.updateByPrimaryKeySelective(user);
        result.code(Code.normal).message(Constants.YD_OK_SAVE);
        return result;
    }
    
    @ApiOperation("用户表-详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "Long", paramType = "query", required = true),
    })
    @GetMapping(value = "/detail")
    public ApiResult<UserDetailVO> userDetial(Long id) throws Exception {
        ApiResult<UserDetailVO> result = new ApiResult<UserDetailVO>();
        User user= userService.selectByPrimaryKey(id);
        UserDetailVO userDetailVO=new UserDetailVO();
        BeanUtils.copyProperties(userDetailVO, user);
        result.setData(userDetailVO);
        result.code(Code.normal).message(Constants.YD_OK_SAVE);
        return result;
    }
    
    @ApiOperation("用户表-删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "Long", paramType = "query", required = true),
    })
    @PostMapping(value = "/del")
    public ApiResult delUser(Long id) throws Exception {
        ApiResult result = new ApiResult();
        userService.deleteByPrimaryKey(id);
        result.code(Code.normal).message(Constants.YD_OK_DELETE);
        return result;
    }
	
}
