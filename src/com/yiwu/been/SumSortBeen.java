package com.yiwu.been;

public class SumSortBeen {
    private Integer id;
    private String remark,activenumsum;

    public SumSortBeen() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getActivenumsum() {
        return activenumsum;
    }

    public void setActivenumsum(String activenumsum) {
        this.activenumsum = activenumsum;
    }

    @Override
    public String toString() {
        return "SumSortBeen{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                ", activenumsum='" + activenumsum + '\'' +
                '}';
    }
}
