package com.kanghe.notes.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PageResult<T> implements Serializable {

    /**
     * 分页总记录数
     */
    private int count;
    /**
     * 查询的列表内容
     */
    private List<T> list;
    /**
     * 总页数
     */
    private int totalPages;
    /**
     * 页码
     */
    private int pageNo;
    /**
     * 页大小
     */
    private int pageSize;

    public PageResult(int count, List<T> list, int pageNo, int pageSize) {
        this.count = count;
        this.list = list;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        if (count % pageSize == 0) {
            this.totalPages = count / pageSize;
        } else {
            this.totalPages = count / pageSize + 1;
        }
    }

}
