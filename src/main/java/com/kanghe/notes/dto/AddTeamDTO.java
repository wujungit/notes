package com.kanghe.notes.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "AddTeamDTO", description = "")
@Getter
@Setter
public class AddTeamDTO implements Serializable {

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称", name = "name", required = true)
    private String name;

    @NotBlank(message = "简介不能为空")
    @ApiModelProperty(value = "简介", name = "profile", required = true)
    private String profile;

    @NotBlank(message = "擅长不能为空")
    @ApiModelProperty(value = "擅长", name = "good", required = true)
    private String good;

    @NotBlank(message = "图片URL不能为空")
    @ApiModelProperty(value = "图片URL", name = "pictureUrl", required = true)
    private String pictureUrl;

    @NotNull(message = "状态不能为空")
    @ApiModelProperty(value = "状态（0-启用，1-禁用）", name = "status", required = true)
    private Integer status;

    @ApiModelProperty(value = "医生编码列表", name = "drCodes", required = false)
    private List<String> drCodes;

    @ApiModelProperty(value = "商品编码列表", name = "goodsCodes", required = false)
    private List<String> goodsCodes;

}
