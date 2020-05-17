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
    List<NewsInfor> getPageNewsInfor(int current_page);
    List<NewsInfor> getAllNewsInfor();
    int getNewsTotal();
    void changeNewsState(int news_id,int news_state);
    /**
     * 资讯评论
     * @return
     */
    List<NewsComment> getAllNewsComment();
    int getNewsCommentTotal();
    List<NewsComment> getPageNewsComment(int current_page);
    void changeNewsCommentState(int comment_id,int comment_state);
    /**
     * 资讯回复
     * @return
     */
    List<Replay> getAllNewsReplay();
    List<Replay> getPageNewsReplay(int current_page);
    int getNewsReplayTotal();
    void changeNewsReplayState(int replay_id,int replay_state);
}
