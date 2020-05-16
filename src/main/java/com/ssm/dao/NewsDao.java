package com.ssm.dao;

import com.ssm.pojo.NewsComment;
import com.ssm.pojo.NewsInfor;

import java.util.List;

public interface NewsDao {
    /**
     * 获取分页资讯
     * @param currentIndex
     * @return
     */
    List<NewsInfor> getPageNewsInfor(int currentIndex);
    /**
     * 获取所有资讯
     * @return
     */
    List<NewsInfor> getAllNewsInfor();

    /**
     * 资讯总数
     * @return
     */
    int getNewsTotal();

    /**
     * 修改资讯状态
     * @param news_id
     * @param news_state
     * @return
     */
    int changeNewsState(int news_id,int news_state);
    /**
     * 获取所有评论
     * @return
     */
    List<NewsComment> getAllNewsComment();
    /**
     * 获取分页评论
     * @param currentIndex
     * @return
     */
    List<NewsComment> getPageNewsComment(int currentIndex);
    /**
     * 获取评论总数
     * @return
     */
    int getNewsCommentTotal();

    /**
     * 更改评论状态
     */
    int changeNewsCommentState(int comment_id,int comment_state);
}
