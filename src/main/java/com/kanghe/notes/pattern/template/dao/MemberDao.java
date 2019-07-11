package com.kanghe.notes.pattern.template.dao;

import com.kanghe.notes.pattern.template.JdbcTemplate;
import com.kanghe.notes.pattern.template.RowMapper;
import com.kanghe.notes.pattern.template.entity.Member;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Author: W_jun1
 * @Date: 2019/7/11 21:53
 * @Description:
 **/
public class MemberDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<?> query() {
        String sql = "select * from t_member";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUserName(rs.getString("userName"));
                member.setPassword(rs.getString("password"));
                return member;
            }
        }, null);
    }

}
