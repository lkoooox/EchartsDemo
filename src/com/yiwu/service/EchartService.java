package com.yiwu.service;

import com.yiwu.been.SumSortBeen;
import com.yiwu.been.RemarkSortBeen;
import com.yiwu.been.Top10forBeen;

import java.util.List;

public interface EchartService {
    List<Top10forBeen> GetTop10(String cate );
    List<RemarkSortBeen> GetReamrkSort(String cate);
    List<SumSortBeen> GetSumSort();
}
