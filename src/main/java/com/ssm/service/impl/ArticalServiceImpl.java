package com.ssm.service.impl;

import com.ssm.dao.ArticalDao;
import com.ssm.pojo.ArticalComment;
import com.ssm.pojo.ArticalInfor;
import com.ssm.pojo.Replay;
import com.ssm.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticalServiceImpl implements ArticalService {
    @Autowired
    ArticalDao articalDao;

    /**
     * 发帖
     */
    @Override
    public List<ArticalInfor> getAllAticalInfor() {
        return articalDao.getAllAticalInfor();
    }
    @Override
    public List<ArticalInfor> getPageArticalInfor(int current_page) {
        int currentIndex = (current_page-1)*15;
        return articalDao.getPageArticalInfor(currentIndex);
    }
    @Override
    public int getArticalTotal() {
        return articalDao.getArticalTotal();
    }
    @Override
    public void changeArticalState(int artical_id, int artical_state) {
        articalDao.changeArticalState(artical_id, artical_state);
    }
    /**
     * 发帖评论
     */
    @Override
    public List<ArticalComment> getAllArticalComment() {
        return articalDao.getAllArticalComment();
    }
    @Override
    public List<ArticalComment> getPageArticalComment(int current_page) {
        int currentIndex = (current_page-1)*15;
        return articalDao.getPageArticalComment(currentIndex);
    }
    @Override
    public int getArticalCommentTotal() {
        return articalDao.getArticalCommentTotal();
    }
    @Override
    public void changeArticalCommentState(int comment_id, int comment_state) {
        articalDao.changeArticalCommentState(comment_id, comment_state);
    }

    /**
     * 发帖回复
     * @return
     */
    @Override
    public List<Replay> getAllArticalReplay() {
        return articalDao.getAllArticalReplay();
    }
    @Override
    public List<Replay> getPageArticalReplay(int current_page) {
        int currentIndex = (current_page-1)*15;
        return articalDao.getPageArticalReplay(currentIndex);
    }
    @Override
    public int getArticalReplayTotal() {
        return articalDao.getArticalReplayTotal();
    }
    @Override
    public void changeArticalReplayState(int replay_id, int replay_state) {
        articalDao.changeArticalReplayState(replay_id, replay_state);
    }
}
