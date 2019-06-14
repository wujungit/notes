package com.kanghe.notes.mapper;

import com.kanghe.notes.dto.QueryTeamPageDTO;
import com.kanghe.notes.entity.TeamInfo;
import com.kanghe.notes.vo.TeamInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeamInfo record);

    int insertSelective(TeamInfo record);

    TeamInfo selectByPrimaryKey(Long id);

    List<TeamInfo> selectByName(String name);

    int selectCount(QueryTeamPageDTO dto);

    List<TeamInfoVO> selectList(QueryTeamPageDTO dto);

    int updateByPrimaryKeySelective(TeamInfo record);

    int updateByPrimaryKey(TeamInfo record);
}