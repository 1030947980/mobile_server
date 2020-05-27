package com.ssm.dao;

import com.ssm.pojo.*;

import java.util.List;

public interface NewsDao {
    /**
     * 获取分页资讯
     * @param currentIndex
     * @return
     */
    List<NewsInfor> getPageNewsInfor(int currentIndex,int pageSize);
    /**
     * 获取所有资讯
     * @return
     */
    List<NewsInfor> getAllNewsInfor();

    NewsInfor  getNewsInforById(int news_id);
    /**
     * 资讯总数
     * @return
     */
    int getNewsTotal();

    /**
     * 收藏
     * @param news_id
     * @return
     */
    int collecdtNews(int news_id);
    List<NewsInfor> getRecommendNewsinfot(int currentIndex,int pageSize);
    int getRecommendNewsTotal();
    List<NewsInfor> getHotNewsinfot(int currentIndex,int pageSize);
    int getHotNewsTotal();
    List<NewsInfor> getNewNewsinfot(int currentIndex,int pageSize);
    int getNewNewsTotal();
    List<NewsInfor> getBussinessNewsinfor(Bussiness bussiness);
    int getBussinessNewsTotal(Bussiness bussiness);
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
    List<NewsComment> getNewsCommentByNewsId(int news_id);
    List<NewsComment> getUserAllNewsCommentByUserId(int user_id);
    /**
     * 发表评论
     */
    int sendCommentNews(NewsComment newsComment);
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

    /**
     * 获取所有资讯回复
     * @return
     */
    List<Replay> getAllNewsReplay();
    List<Replay> getNewsReplayByCommentId(int comment_id);
    List<Replay> getUserAllNewsReplayByUserId(int replayUser_id);
    /**
     * 发表回复
     */
    int sendReplayNews(Replay replay);
    /**
     * 获取分页资讯回复
     * @param currentIndex
     * @return
     */
    List<Replay> getPageNewsReplay(int currentIndex);

    /**
     * 获取回复总数
     * @return
     */
    int getNewsReplayTotal();

    /**
     * 改变资讯回复状态
     * @param replay_id
     * @param replay_state
     * @return
     */
    int changeNewsReplayState(int replay_id,int replay_state);

}
