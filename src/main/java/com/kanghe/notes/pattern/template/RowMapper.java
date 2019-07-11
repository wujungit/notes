package com.kanghe.notes.pattern.template;

import java.sql.ResultSet;

/**
 * @Author: W_jun1
 * @Date: 2019/7/12 00:29
 * @Description:
 **/
public interface RowMapper<T> {

    public T mapRow(ResultSet rs, int rowNum) throws Exception;

}
