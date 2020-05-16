package com.ssm.service;

import com.ssm.pojo.NewsComment;
import com.ssm.pojo.NewsInfor;

import java.util.List;

public interface NewsService {
    List<NewsInfor> getPageNewsInfor(int current_page);
    List<NewsInfor> getAllNewsInfor();
    int getNewsTotal();
    void changeNewsState(int news_id,int news_state);
    List<NewsComment> getAllNewsComment();
    int getNewsCommentTotal();
    List<NewsComment> getPageNewsComment(int current_page);
    void changeNewsCommentState(int comment_id,int comment_state);
}
