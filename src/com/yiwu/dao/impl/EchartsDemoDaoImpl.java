package com.yiwu.dao.impl;

import com.yiwu.been.SumSortBeen;
import com.yiwu.been.RemarkSortBeen;
import com.yiwu.been.Top10forBeen;
import com.yiwu.dao.BaseDao;
import com.yiwu.dao.EchartsDemoDao;

import java.util.List;

public class EchartsDemoDaoImpl extends BaseDao implements EchartsDemoDao {
    @Override
    public List<Top10forBeen> getTop10(String cate) {
        String sql = "select * from result_comment_top10_table where remark = ?";
        return queryList(Top10forBeen.class, sql,cate);
    }

    @Override
    public List<SumSortBeen> getSumkSort() {
        String sql = "select * from  result_reamrk_sort_table";
        return queryList(SumSortBeen.class, sql);
    }

    @Override
    public List<RemarkSortBeen> getRemarkSort(String cate ) {
        String sql = "select * from result_reposts_comment_sort_table where remark =?";
        return queryList(RemarkSortBeen.class, sql,cate);
    }
}
