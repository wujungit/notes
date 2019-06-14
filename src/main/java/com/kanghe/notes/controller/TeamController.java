package com.kanghe.notes.controller;

import com.alibaba.fastjson.JSON;
import com.kanghe.notes.common.BaseResult;
import com.kanghe.notes.common.PageResult;
import com.kanghe.notes.dto.AddTeamDTO;
import com.kanghe.notes.dto.QueryTeamPageDTO;
import com.kanghe.notes.service.ITeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(value = "teamApi", tags = "团队管理", description = "团队管理相关接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(value = "/team")
@Slf4j
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @ApiOperation(value = "分页查询团队列表", notes = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/queryPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<?> queryPage(@ApiParam @RequestBody QueryTeamPageDTO dto) {
        log.info("TeamController queryPage req: {}", JSON.toJSONString(dto));
        PageResult result = teamService.queryPage(dto);
        return new BaseResult<>().success(result, "分页查询团队列表成功");
    }

    @ApiOperation(value = "新增团队", notes = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResult<?> add(@ApiParam @RequestBody @Valid AddTeamDTO dto) {
        log.info("TeamController add req: {}", JSON.toJSONString(dto));
        String teamCode = teamService.add(dto);
        return new BaseResult<>().success(teamCode, "新增团队成功");
    }

}
