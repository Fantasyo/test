package cn.com.colibri.itsystem.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/*********************************************************************************************************
 * Copyright (c) 
 * All rights reserved.
 *
 * 文件名称:public class MaintainOrderDetailVO{ } 
 * 
 * 摘    要： maintainOrder详情VO
 * 版    本：1.0
 * 作    者：liuxueli
 * 创建于：2019-05-24 05:27:31
 * 最后修改时间：
 * 
 *********************************************************************************************************/
@Setter
@Getter
@ApiModel(value = "maintainOrder详情实体")
public class MaintainOrderDetailVO {
    
    /**ID*/
    @NotNull(message = "ID不能为空")
    @ApiModelProperty(value = "ID",required = true)
	private Long id;

	/**工号*/
	@NotNull(message = "工号不能为空")
    @ApiModelProperty(value = "工号",required = true)
	private Integer jobNumber;
	
	/**真实姓名*/
	@NotNull(message = "真实姓名不能为空")
    @ApiModelProperty(value = "真实姓名",required = true)
	private String realName;
	
	/**部门*/
	@NotNull(message = "部门不能为空")
    @ApiModelProperty(value = "部门",required = true)
	private String department;
	
	/**问题描述*/
	@NotNull(message = "问题描述不能为空")
    @ApiModelProperty(value = "问题描述",required = true)
	private String description;
	
	/**维修类别*/
	@NotNull(message = "维修类别不能为空")
    @ApiModelProperty(value = "维修类别",required = true)
	private Integer maintainType;
	
	/**状态，1、未分配，2、待处理，3、挂起，4、已完成*/
	@NotNull(message = "状态，1、未分配，2、待处理，3、挂起，4、已完成不能为空")
    @ApiModelProperty(value = "状态，1、未分配，2、待处理，3、挂起，4、已完成",required = true)
	private Integer status;
	
	/**备注*/
	@NotNull(message = "备注不能为空")
    @ApiModelProperty(value = "备注",required = true)
	private String remak;
	
	/**创建时间*/
	@NotNull(message = "创建时间不能为空")
    @ApiModelProperty(value = "创建时间",required = true)
	private java.util.Date createTime;
	
	/**结束时间*/
	@NotNull(message = "结束时间不能为空")
    @ApiModelProperty(value = "结束时间",required = true)
	private java.util.Date endTime;
	
	/**处理人ID*/
	@NotNull(message = "处理人ID不能为空")
    @ApiModelProperty(value = "处理人ID",required = true)
	private Long userId;
	
    
  }
