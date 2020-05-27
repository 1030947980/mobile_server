package com.ssm.service;

import com.ssm.pojo.NewsComment;
import com.ssm.pojo.NewsInfor;
import com.ssm.pojo.Replay;

import java.util.List;

public interface NewsService {
    /**
     * 资讯
     * @param current_page
     * @return
     */
    List<NewsInfor> getPageNewsInfor(int current_page,int pageSize);
    List<NewsInfor> getAllNewsInfor();
    int getNewsTotal();
    void changeNewsState(int news_id,int news_state);
    NewsInfor getNewsInforById(int news_id);
    void collecdtNews(int news_id);
    List<NewsInfor> getRecommendHotNewNewsinfot(String condition,int current_page,int pageSize);
    int getRecommendHotNewNewsTotal(String condition);
    List<NewsInfor> getBussinessNewsinfor(String bussiness1,String bussiness2,int current_page,int pageSize);
    int getBussinessNewsTotal(String bussiness,String bussiness2);
    /**
     * 资讯评论
     * @return
     */
    List<NewsComment> getAllNewsComment();
    int getNewsCommentTotal();
    List<NewsComment> getPageNewsComment(int current_page);
    void changeNewsCommentState(int comment_id,int comment_state);
    List<NewsComment> getNewsCommentByNewsId(int news_id);
    void sendCommentNews(int news_id,int user_id,String comment_content,String comment_time);
    List<NewsComment> getUserAllNewsCommentByUserId(int user_id);
    /**
     * 资讯回复
     * @return
     */
    List<Replay> getAllNewsReplay();
    List<Replay> getPageNewsReplay(int current_page);
    int getNewsReplayTotal();
    void changeNewsReplayState(int replay_id,int replay_state);
    List<Replay> getNewsReplayByCommentId(int comment_id);
    void sendReplayNews(int replayUser_id,int comment_id,String replay_content,String replay_time);
    List<Replay> getUserAllNewsReplayByUserId(int replayUser_id);
}
