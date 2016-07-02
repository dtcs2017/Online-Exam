package com.bs.lsx.util.page;

import java.util.List;

/**
 * <ul>
 * <li>文件名称:</li>
 * <li>文件描述: 分页显示bean</li>
 * <li>版权所有: 版权所有(C)2001-2006</li>
 * <li>公 司:</li>
 * <li>内容摘要:</li>
 * <li>其他说明:</li>
 * <li>完成日期：2010-4-12</li>
 * <li>修改记录0：无</li>
 * </ul>
 *
 * @version 1.0
 */
public class PageBean {
    private boolean isFirstPage;// 是否是第一页
    private boolean isLastPage;// 是否是最后一页
    private boolean hasNextPage;// 是否还有下一页
    private boolean hasPreviousPage;// 是否还有上一页
    private int lastPageNumber;// 获得总页数
    private List<Object> thisPageElements;// 当前页的数据
    private int totalNumberOfElements;// 记录总数
    private int nextPageNumber;// 下一页的页码
    private int previousPageNumber;// 上一页的页面
    private int pageSize;// 每一页显示的记录条数
    private int thisPageNumber;// 当前页码

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public int getLastPageNumber() {
        if (lastPageNumber <= 0) {
            lastPageNumber = 1;
        }
        return lastPageNumber;
    }

    public void setLastPageNumber(int lastPageNumber) {
        this.lastPageNumber = lastPageNumber;
    }

    public List<?> getThisPageElements() {
        return thisPageElements;
    }

    public void setThisPageElements(List<Object> thisPageElements) {
        this.thisPageElements = thisPageElements;
    }

    public int getTotalNumberOfElements() {
        return totalNumberOfElements;
    }

    public void setTotalNumberOfElements(int totalNumberOfElements) {
        this.totalNumberOfElements = totalNumberOfElements;
    }

    public int getNextPageNumber() {
        return nextPageNumber;
    }

    public void setNextPageNumber(int nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }

    public int getPreviousPageNumber() {
        return previousPageNumber;
    }

    public void setPreviousPageNumber(int previousPageNumber) {
        this.previousPageNumber = previousPageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getThisPageNumber() {
        if (thisPageNumber <= 0) {
            thisPageNumber = 1;
        }
        return thisPageNumber;
    }

    public void setThisPageNumber(int thisPageNumber) {
        this.thisPageNumber = thisPageNumber;
    }
}
