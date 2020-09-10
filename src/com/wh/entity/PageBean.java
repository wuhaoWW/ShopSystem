package com.wh.entity;

public class PageBean {
    private  int nowPage;//当前页
    private  int total;//总记录数
    private  int pageCount;//总页数
    private  int SelectXiaBiao;//下标
    private  int pageSize=3;//每页的记录数

    public PageBean(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        int  pageCount=total%pageSize==0 ? total/pageSize:total/pageSize+1 ;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSelectXiaBiao() {
        int SelectXiaBiao=  (nowPage-1)*pageSize;
        return SelectXiaBiao;
    }

    public void setSelectXiaBiao(int selectXiaBiao) {
        SelectXiaBiao = selectXiaBiao;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageBean() {
    }

    public PageBean(int nowPage, int total, int pageCount, int selectXiaBiao, int pageSize) {
        this.nowPage = nowPage;
        this.total = total;
        this.pageCount = pageCount;
        SelectXiaBiao = selectXiaBiao;
        this.pageSize = pageSize;
    }
}
