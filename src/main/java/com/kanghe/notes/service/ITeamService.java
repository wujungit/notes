package com.kanghe.notes.service;

import com.kanghe.notes.common.PageResult;
import com.kanghe.notes.dto.AddTeamDTO;
import com.kanghe.notes.dto.QueryTeamPageDTO;

public interface ITeamService {

    public PageResult<?> queryPage(QueryTeamPageDTO dto);

    public String add(AddTeamDTO dto);

}
