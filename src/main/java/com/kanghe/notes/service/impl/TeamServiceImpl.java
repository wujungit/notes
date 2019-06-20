package com.kanghe.notes.service.impl;

import com.kanghe.notes.common.PageResult;
import com.kanghe.notes.dto.AddTeamDTO;
import com.kanghe.notes.dto.QueryTeamPageDTO;
import com.kanghe.notes.entity.TeamInfo;
import com.kanghe.notes.enums.ResultEnum;
import com.kanghe.notes.exception.BuzException;
import com.kanghe.notes.mapper.TeamInfoMapper;
import com.kanghe.notes.service.ITeamService;
import com.kanghe.notes.util.CodeUtil;
import com.kanghe.notes.vo.TeamInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements ITeamService {

    private static final String TEAM_PREFIX = "YSTD";

    @Autowired
    private TeamInfoMapper teamInfoMapper;

    @Override
    public PageResult<?> queryPage(QueryTeamPageDTO dto) {
        int count = teamInfoMapper.selectCount(dto);
        if (count == 0) {
            return new PageResult<>(count, new ArrayList<>(), dto.getPageNo(), dto.getPageSize());
        }
        List<TeamInfoVO> list = teamInfoMapper.selectList(dto);
        return new PageResult<>(count, list, dto.getPageNo(), dto.getPageSize());
    }

    @Override
    public String add(AddTeamDTO dto) {
        // 判断团队名称是否相同
        List<TeamInfo> teamInfos = teamInfoMapper.selectByName(dto.getName());
        if (teamInfos != null && teamInfos.size() > 0) {
            throw new BuzException(ResultEnum.DATA_HAS_EXISTS.getCode(), "团队名称已存在");
        }
        // 团队编码
        String teamCode = CodeUtil.prefixRandom(TEAM_PREFIX, 10);
        // 新增团队信息
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setCode(teamCode);
        teamInfo.setName(dto.getName());
        teamInfo.setProfile(dto.getProfile());
        teamInfo.setGood(dto.getGood());
        teamInfo.setPictureUrl(dto.getPictureUrl());
        teamInfo.setDrNum(dto.getDrCodes() != null && dto.getDrCodes().size() > 0 ? dto.getDrCodes().size() : 0);
        teamInfo.setRecGoodsNum(dto.getGoodsCodes() != null && dto.getGoodsCodes().size() > 0 ? dto.getGoodsCodes().size() : 0);
        teamInfo.setStatus(dto.getStatus());
        teamInfoMapper.insertSelective(teamInfo);
        return teamCode;
    }
}
