package cn.com.colibri.itsystem.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*********************************************************************************************************
 * Copyright (c) 
 * All rights reserved.
 *
 * 文件名称:public class UserDetailVO{ } 
 * 
 * 摘    要： 用户表详情VO
 * 版    本：1.0
 * 作    者： liuxueli
 * 创建于：2019-05-24 05:00:56
 * 最后修改时间：
 * 
 *********************************************************************************************************/
@Data
@ApiModel(value = "用户表详情实体")
public class UserDetailVO {
    
    /**ID*/
    @ApiModelProperty(value = "ID",required = true)
	private Integer id;

	/**用户名*/
	@NotNull(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名",required = true)
	private String userName;
	
	/**密码*/
	@NotNull(message = "密码不能为空")
    @ApiModelProperty(value = "密码",required = true)
	private String password;
	
	/**创建时间*/
	@NotNull(message = "创建时间不能为空")
    @ApiModelProperty(value = "创建时间",required = true)
	private java.util.Date creatTime;
	
	/**修改时间*/
	@NotNull(message = "修改时间不能为空")
    @ApiModelProperty(value = "修改时间",required = true)
	private java.util.Date modifyTime;
	
	/**是否删除，0代表未删除，1代表已删除*/
	@NotNull(message = "是否删除，0代表未删除，1代表已删除不能为空")
    @ApiModelProperty(value = "是否删除，0代表未删除，1代表已删除",required = true)
	private Integer deleteFlag;
	
	/**地址 1、石岩，2、帝光，3、宏发，4、中山，5、南山，6、苏州，7、成都，8.、坪山，9、郑州，10、宁德*/
	@NotNull(message = "地址 1、石岩，2、帝光，3、宏发，4、中山，5、南山，6、苏州，7、成都，8.、坪山，9、郑州，10、宁德不能为空")
    @ApiModelProperty(value = "地址 1、石岩，2、帝光，3、宏发，4、中山，5、南山，6、苏州，7、成都，8.、坪山，9、郑州，10、宁德",required = true)
	private Integer address;
	
    
  }
