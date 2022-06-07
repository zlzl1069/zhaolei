package cn.bdqn.pojo;

import java.util.List;

public class PageBean<students> {
    private int totalPageCount=0;
    //页大小，每页显示记录数
    private int pageSize;
    //总数
    private int totalCount;
    //当前页
    private int currPageNo;
    //每页信息集合
    private List<students>lists;

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public List<students> getLists() {
        return lists;
    }

    public void setLists(List<students> lists) {
        this.lists = lists;
    }
}
