package com.yiwu.been;

public class Top10forBeen {
    private Integer id;
    private String remark,uid,commentsCount;

    public Top10forBeen() {
    }

    public Integer getId() {
        return id;
    }

    public String getRemark() {
        return remark;
    }

    public String getUid() {
        return uid;
    }

    public String getCommentsCount() {
        return commentsCount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setCommentsCount(String commentsCount) {
        this.commentsCount = commentsCount;
    }

    @Override
    public String toString() {
        return "Top10forBeen{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                ", uid='" + uid + '\'' +
                ", commentsCount='" + commentsCount + '\'' +
                '}';
    }
}
