package com.ssm.service.impl;

import com.ssm.dao.NewsDao;
import com.ssm.pojo.NewsComment;
import com.ssm.pojo.NewsInfor;
import com.ssm.pojo.Replay;
import com.ssm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;

    /**
     * 资讯
     * @param current_page
     * @return
     */
    @Override
    public List<NewsInfor> getPageNewsInfor(int current_page) {
        int currentIndex = (current_page-1)*15;
       return newsDao.getPageNewsInfor(currentIndex);
    }
    @Override
    public List<NewsInfor> getAllNewsInfor() {
        return newsDao.getAllNewsInfor();
    }
    @Override
    public int getNewsTotal() {
        return newsDao.getNewsTotal();
    }
    @Override
    public void changeNewsState(int news_id, int news_state) {
        newsDao.changeNewsState(news_id, news_state);
    }
    /**
     * 资讯评论
     * @return
     */
    @Override
    public List<NewsComment> getAllNewsComment() {
        return newsDao.getAllNewsComment();
    }
    @Override
    public int getNewsCommentTotal() {
        return newsDao.getNewsCommentTotal();
    }
    @Override
    public List<NewsComment> getPageNewsComment(int current_page) {
        int currentIndex = (current_page-1)*15;
        return newsDao.getPageNewsComment(currentIndex);
    }
    @Override
    public void changeNewsCommentState(int comment_id, int comment_state) {
        newsDao.changeNewsCommentState(comment_id,comment_state);
    }
    /**
     * 资讯回复
     * @return
     */
    @Override
    public List<Replay> getAllNewsReplay() {
        return newsDao.getAllNewsReplay();
    }
    @Override
    public List<Replay> getPageNewsReplay(int current_page) {
        int currentIndex = (current_page-1)*15;
        return newsDao.getPageNewsReplay(currentIndex);
    }
    @Override
    public int getNewsReplayTotal() {
        return newsDao.getNewsReplayTotal();
    }
    @Override
    public void changeNewsReplayState(int replay_id, int replay_state) {
        newsDao.changeNewsReplayState(replay_id, replay_state);
    }

}
