package cn.com.colibri.itsystem.enums;

import lombok.Getter;
/*********************************************************************************************************
 * Copyright (c) 个人
 * All rights reserved.
 *
 * 文件名称:public enum DeleteFlagEnum{ }
 *
 * 摘    要：
 * 版    本：1.0
 * 作    者： liuxueli
 * 创建于：2019-05-24 05:00:56
 * 最后修改时间：
 *
 *********************************************************************************************************/
@Getter
public enum DeleteFlagEnum {
    /**已删除*/
    YES(1,"已删除"),
    /**未删除*/
    NO(0,"未删除");
    private Integer value;

    private String dec;

    private DeleteFlagEnum(Integer value,String dec){
        this.value = value;
        this.dec = dec;
    }
}
