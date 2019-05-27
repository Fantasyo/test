package cn.com.colibri.itsystem.controller;

import cn.com.colibri.itsystem.domain.MaintainOrder;
import cn.com.colibri.itsystem.service.MaintainOrderService;
import cn.com.colibri.itsystem.vo.MaintainOrderDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hcloud.common.ApiResult;
import com.hcloud.common.Code;
import com.hcloud.common.Constants;
import com.hcloud.page.Page;
import com.hcloud.utils.ConvertDtoUtil;


/*********************************************************************************************************
 * Copyright (c) 2018
 * All rights reserved.
 *
 * 文件名称:public class MaintainOrderController{ } 
 * 
 * 摘    要： maintainOrder
 * 版    本：1.0
 * 作    者：liuxueli
 * 创建于：2019-05-24 05:27:31
 * 最后修改时间：
 * 
*********************************************************************************************************/
@Slf4j
@RestController
@RequestMapping("/admin/system/MaintainOrder")
@Api(value = "maintainOrder-接口", description = "maintainOrder-接口")
public class MaintainOrderController {
	
	@Autowired
	private MaintainOrderService maintainOrderService;
	
	@ApiOperation("maintainOrder-列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "String", paramType = "query", required = true),
    })
    @GetMapping(value = "/list")
    public ApiResult<Page<MaintainOrderDetailVO>> maintainOrderList(Integer pageNo, Integer pageSize) throws Exception {
        ApiResult<Page<MaintainOrderDetailVO>> result = new ApiResult<Page<MaintainOrderDetailVO>>();
        MaintainOrder maintainOrder =new MaintainOrder();
        Page<MaintainOrder> queryMaintainOrderPage = maintainOrderService.queryMaintainOrderPage(pageSize, pageNo, maintainOrder);
        List<MaintainOrder> list=new ArrayList<MaintainOrder>(queryMaintainOrderPage.getData());
        List<MaintainOrderDetailVO> dataList=ConvertDtoUtil.listBeanToDto(list,MaintainOrderDetailVO.class);
		Page<MaintainOrderDetailVO> listVo=new Page<MaintainOrderDetailVO>(dataList, queryMaintainOrderPage.getTotalRecord(), queryMaintainOrderPage.getIndex(), queryMaintainOrderPage.getSize());
	    result.setData(listVo);
        result.code(Code.normal).message(Constants.YD_OK_SHOW);
        return result;
    } 
    
    @ApiOperation("maintainOrder-新增")
    @PostMapping(value = "/add")
    public ApiResult addMaintainOrder(  MaintainOrderDetailVO  MaintainOrderDetailVO) throws Exception {
        ApiResult result = new ApiResult();
        MaintainOrder maintainOrder=new MaintainOrder();
        BeanUtils.copyProperties(maintainOrder,  MaintainOrderDetailVO);
        maintainOrderService.insert(maintainOrder);
        result.code(Code.normal).message(Constants.YD_OK_SAVE);
        return result;
    }
    
    @ApiOperation("maintainOrder-编辑")
    @PostMapping(value = "/edit")
    public ApiResult editMaintainOrder(  MaintainOrderDetailVO  MaintainOrderDetailVO) throws Exception  {
        ApiResult result = new ApiResult();
        MaintainOrder maintainOrder=new MaintainOrder();
        BeanUtils.copyProperties(maintainOrder,  MaintainOrderDetailVO);
        maintainOrderService.updateByPrimaryKeySelective(maintainOrder);
        result.code(Code.normal).message(Constants.YD_OK_SAVE);
        return result;
    }
    
    @ApiOperation("maintainOrder-详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "Long", paramType = "query", required = true),
    })
    @GetMapping(value = "/detail")
    public ApiResult<MaintainOrderDetailVO> maintainOrderDetial(  Long id) throws Exception {
        ApiResult<MaintainOrderDetailVO> result = new ApiResult<MaintainOrderDetailVO>();
        MaintainOrder maintainOrder= maintainOrderService.selectByPrimaryKey(id);
        MaintainOrderDetailVO maintainOrderDetailVO=new MaintainOrderDetailVO();
        BeanUtils.copyProperties(maintainOrderDetailVO, maintainOrder);
        result.setData(maintainOrderDetailVO);
        result.code(Code.normal).message(Constants.YD_OK_SAVE);
        return result;
    }
    
    @ApiOperation("maintainOrder-删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "Long", paramType = "query", required = true),
    })
    @PostMapping(value = "/del")
    public ApiResult delMaintainOrder(  Long id) throws Exception {
        ApiResult result = new ApiResult();
        maintainOrderService.deleteByPrimaryKey(id);
        result.code(Code.normal).message(Constants.YD_OK_DELETE);
        return result;
    }
	
}
