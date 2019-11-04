package com.yiwu.dao;

import com.yiwu.been.SumSortBeen;
import com.yiwu.been.RemarkSortBeen;
import com.yiwu.been.Top10forBeen;

import java.util.List;

public interface EchartsDemoDao {

    List<Top10forBeen> getTop10(String cate);
    List<RemarkSortBeen> getRemarkSort(String cate);
    List<SumSortBeen> getSumkSort();



}
