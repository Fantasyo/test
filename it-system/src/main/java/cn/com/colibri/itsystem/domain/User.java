package cn.com.colibri.itsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*********************************************************************************************************
 * Copyright (c)
 * All rights reserved.
 *
 * 文件名称:public class User{ } 
 * 
 * 摘    要： 用户表
 * 版    本：1.0
 * 作    者：liuxueli
 * 创建于：2019-05-24 04:23:37
 * 最后修改时间：
 * 
 *********************************************************************************************************/
@Data
public class User  implements Serializable  {

	/**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;

	/**ID*/
	private Integer id;

	/**用户名*/
	private String userName;
	/**密码*/
	private String password;
	/**创建时间*/
	private java.util.Date creatTime;
	/**修改时间*/
	private java.util.Date modifyTime;
	/**是否删除，0代表未删除，1代表已删除*/
	private Integer deleteFlag;
	/**地址 1、石岩，2、帝光，3、宏发，4、中山，5、南山，6、苏州，7、成都，8.、坪山，9、郑州，10、宁德*/
	private Integer address;


}