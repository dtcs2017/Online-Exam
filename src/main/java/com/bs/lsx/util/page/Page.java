package com.bs.lsx.util.page;

/**
 * <ul>
 * <li>文件名称:</li>
 * <li>文件描述:分页类接口 </li>
 * <li>版权所有: 版权所有(C)2001-2006</li>
 * <li>公   司:</li>
 * <li>内容摘要: </li>
 * <li>其他说明: </li>
 * <li>完成日期：2010-4-12</li>
 * <li>修改记录0：无</li>
 * </ul>
 *
 * @version 1.0
 */
public interface Page {
    /**
     * 是否是第一页
     *
     * @return
     */
    boolean isFirstPage();

    /**
     * 是否是最后一页
     *
     * @return
     */
    boolean isLastPage();

    /**
     * 是否有下一页
     *
     * @return
     */
    boolean hasNextPage();

    /**
     * 是否有上一页
     *
     * @return
     */
    boolean hasPreviousPage();

    /**
     * 获得最后一页的是第几页数
     *
     * @return
     */
    int getLastPageNumber();

    /**
     * 获得当前页面的所有数据
     *
     * @return
     */
    Object getThisPageElements();

    /**
     * 获得所有记录的总数
     *
     * @return
     */
    int getTotalNumberOfElements();

    /**
     * 获得当前页面的第一条记录的记录数
     *
     * @return
     */
    int getThisPageFirstElementNumber();

    /**
     * 获得当前页面的最后一条记录的记录数
     *
     * @return
     */
    int getThisPageLastElementNumber();

    /**
     * 获得下一页的页码数
     *
     * @return
     */
    int getNextPageNumber();

    /**
     * 获得上一页的页码数
     *
     * @return
     */
    int getPreviousPageNumber();

    /**
     * 获得每一页显示的记录条数
     *
     * @return
     */
    int getPageSize();

    /**
     * 获得当前页面的页码编号
     *
     * @return
     */
    int getThisPageNumber();
}
