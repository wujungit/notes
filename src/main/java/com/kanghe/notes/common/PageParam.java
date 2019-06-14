package com.kanghe.notes.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(value = "PageParam", description = "")
@Getter
@Setter
public class PageParam implements Serializable {

    @ApiModelProperty(value = "页码", name = "pageNo", required = false)
    private Integer pageNo = 1;

    @ApiModelProperty(value = "页数", name = "pageSize", required = false)
    private Integer pageSize = 10;

}
