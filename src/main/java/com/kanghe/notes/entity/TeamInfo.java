package com.kanghe.notes.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_team_info
 *
 * @author
 */
@Getter
@Setter
public class TeamInfo implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 简介
     */
    private String profile;

    /**
     * 擅长
     */
    private String good;

    /**
     * 图片URL
     */
    private String pictureUrl;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标识(0-正常，1-删除)
     */
    private Integer delFlag;

    /**
     * 备注
     */
    private String remarks;
}