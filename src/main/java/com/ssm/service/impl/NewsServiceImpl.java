package com.ssm.service.impl;

import com.ssm.dao.NewsDao;
import com.ssm.pojo.Bussiness;
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
    public List<NewsInfor> getPageNewsInfor(int current_page,int pageSize) {
        int currentIndex = (current_page-1)*pageSize;
       return newsDao.getPageNewsInfor(currentIndex,pageSize);
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

    @Override
    public NewsInfor getNewsInforById(int news_id) {
        return newsDao.getNewsInforById(news_id);
    }

    @Override
    public void collecdtNews(int news_id) {
        newsDao.collecdtNews(news_id);
    }

    @Override
    public List<NewsInfor> getRecommendHotNewNewsinfot(String condition, int current_page, int pageSize) {
        int currentIndex = (current_page-1)*pageSize;
        if(condition.equals("hot")){
            return newsDao.getHotNewsinfot(currentIndex,pageSize);
        }
        if(condition.equals("new")){
            return newsDao.getNewNewsinfot(currentIndex,pageSize);
        }
        if(condition.equals("recommend")){
            return newsDao.getRecommendNewsinfot(currentIndex,pageSize);
        }
        return null;
    }

    @Override
    public int getRecommendHotNewNewsTotal(String condition) {
        if(condition.equals("hot")){
            return newsDao.getHotNewsTotal();
        }
        if(condition.equals("new")){
            return newsDao.getNewsTotal();
        }
        if(condition.equals("recommend")){
            return newsDao.getRecommendNewsTotal();
        }
        return 0;
    }

    @Override
    public List<NewsInfor> getBussinessNewsinfor(String bussiness1,String bussiness2,int current_page, int pageSize) {
        int currentIndex = (current_page-1)*pageSize;
        Bussiness bussiness = new Bussiness();
        bussiness.setBussiness1(bussiness1);
        bussiness.setBussiness2(bussiness2);
        bussiness.setCurrentIndex(currentIndex);
        bussiness.setPageSize(pageSize);
        return newsDao.getBussinessNewsinfor(bussiness);
    }

    @Override
    public int getBussinessNewsTotal(String bussiness1,String bussiness2) {
        Bussiness bussiness = new Bussiness();
        bussiness.setBussiness1(bussiness1);
        bussiness.setBussiness2(bussiness2);
        return newsDao.getBussinessNewsTotal(bussiness);
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

    @Override
    public List<NewsComment> getNewsCommentByNewsId(int news_id) {
        return newsDao.getNewsCommentByNewsId(news_id);
    }

    @Override
    public void sendCommentNews(int news_id, int user_id, String comment_content, String comment_time) {
        NewsComment newsComment = new NewsComment();
        newsComment.setNews_id(news_id);
        newsComment.setUser_id(user_id);
        newsComment.setComment_content(comment_content);
        newsComment.setComment_time(comment_time);
        newsDao.sendCommentNews(newsComment);
    }

    @Override
    public List<NewsComment> getUserAllNewsCommentByUserId(int user_id) {
        return newsDao.getUserAllNewsCommentByUserId(user_id);
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

    @Override
    public List<Replay> getNewsReplayByCommentId(int comment_id) {
        return newsDao.getNewsReplayByCommentId(comment_id);
    }

    @Override
    public void sendReplayNews(int replayUser_id, int comment_id, String replay_content, String replay_time) {
        Replay replay = new Replay();
        replay.setReplayUser_id(replayUser_id);
        replay.setComment_id(comment_id);
        replay.setReplay_content(replay_content);
        replay.setReplay_time(replay_time);
        newsDao.sendReplayNews(replay);
    }

    @Override
    public List<Replay> getUserAllNewsReplayByUserId(int replayUser_id) {
        return newsDao.getUserAllNewsReplayByUserId(replayUser_id);
    }

}
