package com.kanghe.notes.dto;

import com.kanghe.notes.common.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(value = "QueryTeamPageDTO", description = "")
@Getter
@Setter
public class QueryTeamPageDTO extends PageParam implements Serializable {

    @ApiModelProperty(value = "编码", name = "code", required = false)
    private String code;

    @ApiModelProperty(value = "名称", name = "name", required = false)
    private String name;

    @ApiModelProperty(value = "状态（0-启用，1-禁用）", name = "status", required = false)
    private Integer status;

    @ApiModelProperty(value = "医生编码", name = "drCode", required = false)
    private String drCode;

}
