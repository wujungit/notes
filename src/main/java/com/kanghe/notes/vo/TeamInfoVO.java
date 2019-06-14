package com.kanghe.notes.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TeamInfoVO implements Serializable {
    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 成员数量
     */
    private Integer drNum;

    /**
     * 推荐商品数量
     */
    private Integer recGoodsNum;

    /**
     * 状态（0-启用，1-禁用）
     */
    private Integer status;
}
