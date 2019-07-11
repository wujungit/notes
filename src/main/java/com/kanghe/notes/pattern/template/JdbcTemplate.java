package com.kanghe.notes.pattern.template;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: W_jun1
 * @Date: 2019/7/11 21:06
 * @Description:
 **/
public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

    private PreparedStatement createPreparedStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    private ResultSet executeQuery(PreparedStatement ps, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            ps.setObject(i, values[i]);
        }
        return ps.executeQuery();
    }

    private void closeStatement(Statement s) throws Exception {
        s.close();
    }

    private void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }

    private void closeConnection(Connection conn) throws Exception {
        conn.close();
    }

    private List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()) {
            Object obj = rowMapper.mapRow(rs, rowNum++);
            result.add(obj);
        }
        return result;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            // 1、获取连接
            Connection conn = this.getConnection();
            // 2、创建语句集
            PreparedStatement ps = this.createPreparedStatement(conn, sql);
            // 3、执行语句集，并且获得结果集
            ResultSet rs = this.executeQuery(ps, values);
            // 4、解析语句集
            List<?> result = this.parseResultSet(rs, rowMapper);
            // 5、关闭结果集
            this.closeResultSet(rs);
            // 6、关闭语句集
            this.closeStatement(ps);
            // 7、关闭连接
            this.closeConnection(conn);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
