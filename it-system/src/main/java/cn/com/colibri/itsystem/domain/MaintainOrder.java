package cn.com.colibri.itsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*********************************************************************************************************
 * Copyright (c)
 * All rights reserved.
 *
 * 文件名称:public class MaintainOrder{ } 
 * 
 * 摘    要： maintainOrder
 * 版    本：1.0
 * 作    者：liuxueli
 * 创建于：2019-05-24 05:27:31
 * 最后修改时间：
 * 
 *********************************************************************************************************/
@Data
public class MaintainOrder  implements Serializable  {

	/**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;

	/**ID*/
	private Long id;

	/**工号*/
	private Integer jobNumber;
	/**真实姓名*/
	private String realName;
	/**部门*/
	private String department;
	/**问题描述*/
	private String description;
	/**维修类别*/
	private Integer maintainType;
	/**状态，1、未分配，2、待处理，3、挂起，4、已完成*/
	private Integer status;
	/**备注*/
	private String remak;
	/**创建时间*/
	private java.util.Date createTime;
	/**结束时间*/
	private java.util.Date endTime;
	/**处理人ID*/
	private Long userId;

}