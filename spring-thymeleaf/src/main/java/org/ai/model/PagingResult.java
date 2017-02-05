package org.ai.model;

import java.util.List;

/**
 * Created by Administrator on 2017/2/5.
 */
public class PagingResult<T> {
    private int total;
    private List<T> rows;

    public PagingResult(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
