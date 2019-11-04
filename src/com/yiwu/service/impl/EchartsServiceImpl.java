package com.yiwu.service.impl;

import com.yiwu.been.SumSortBeen;
import com.yiwu.been.RemarkSortBeen;
import com.yiwu.been.Top10forBeen;
import com.yiwu.dao.EchartsDemoDao;
import com.yiwu.dao.impl.EchartsDemoDaoImpl;
import com.yiwu.service.EchartService;

import java.util.List;

public class EchartsServiceImpl implements EchartService {
    EchartsDemoDao echartDemoDaoImpl = new EchartsDemoDaoImpl();
    @Override
    public List<Top10forBeen> GetTop10(String cate ) {
        List<Top10forBeen> list = echartDemoDaoImpl.getTop10(cate);
        return list;
    }

    @Override
    public List<RemarkSortBeen> GetReamrkSort(String cate) {
        List<RemarkSortBeen> list = echartDemoDaoImpl.getRemarkSort(cate);
        return list;
    }

    @Override
    public List<SumSortBeen> GetSumSort() {
        List<SumSortBeen> list = echartDemoDaoImpl.getSumkSort();
        return list;
    }
}
