package cn.com.colibri.itsystem.enums;

import lombok.Getter;

/*********************************************************************************************************
 * Copyright (c) 个人
 * All rights reserved.
 *
 *
 * 摘    要：
 * 版    本：1.0
 * 作    者： liuxueli
 * 创建于：2019/5/28,13:09
 * 最后修改时间：
 *
 *********************************************************************************************************/
@Getter
public enum OrderStatusEnum {
    UNDISTRIBUTED(1,"未分配"),

    PENDING(2,"待处理"),

    HAND_UP( 3,"挂起"),

    COMPLETED(4,"已完成");

    private Integer value;

    private String dec;

    private OrderStatusEnum (Integer value, String dec){
        this.value = value;
        this.dec = dec;
    }
}
