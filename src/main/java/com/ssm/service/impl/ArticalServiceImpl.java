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
    public List<ArticalInfor> getPageArticalInfor(int current_page,int pageSize) {
        int currentIndex = (current_page-1)*pageSize;
        return articalDao.getPageArticalInfor(currentIndex,pageSize);
    }
    @Override
    public int getArticalTotal() {
        return articalDao.getArticalTotal();
    }
    @Override
    public void changeArticalState(int artical_id, int artical_state) {
        articalDao.changeArticalState(artical_id, artical_state);
    }

    @Override
    public ArticalInfor getArticalInforById(int artical_id) {
        articalDao.viewsArtical(artical_id);
        return articalDao.getArticalInforById(artical_id);
    }

    @Override
    public List<ArticalInfor> getAllArticalInforUser(int user_id) {
        return articalDao.getAllArticalInforUser(user_id);
    }

    @Override
    public int getAllArticalInforUserTotal(int user_id) {
        return articalDao.getAllArticalInforUserTotal(user_id);
    }

    @Override
    public List<ArticalInfor> getPageUserPostArticalInfor(int user_id, int current_page, int pageSize) {
        int currentIndex = (current_page-1)*15;
        return articalDao.getPageUserPostArticalInfor(user_id,currentIndex,pageSize);
    }

    @Override
    public List<ArticalInfor> getPageArticalInforUser(int current_page, int pageSize) {
        int currentIndex = (current_page-1)*15;
        return articalDao.getPageArticalInforUser(currentIndex,pageSize);
    }

    @Override
    public int getArticalTotalUser() {
        return articalDao.getArticalTotalUser();
    }

    @Override
    public void newArtical(int user_id, String artical_title, String artical_describe, String artical_content, String artical_time, String artical_imgUrl) {
        ArticalInfor articalInfor = new ArticalInfor();
        articalInfor.setUser_id(user_id);
        articalInfor.setArtical_title(artical_title);
        articalInfor.setArtical_describe(artical_describe);
        articalInfor.setArtical_content(artical_content);
        articalInfor.setArtical_imgUrl(artical_imgUrl);
        articalInfor.setArtical_time(artical_time);
        articalDao.newArtical(articalInfor);
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

    @Override
    public List<ArticalComment> getArticalCommentByArticalId(int artical_id) {
        return articalDao.getArticalCommentByArticalId(artical_id);
    }

    @Override
    public void sendCommentArtical(int artical_id, int user_id, String comment_content, String comment_time) {
        ArticalComment articalComment = new ArticalComment();
        articalComment.setArtical_id(artical_id);
        articalComment.setUser_id(user_id);
        articalComment.setComment_content(comment_content);
        articalComment.setComment_time(comment_time);
        articalDao.sendCommentArtical(articalComment);
    }

    @Override
    public List<ArticalComment> getAllUserArticalCommentByuserId(int user_id) {
        return articalDao.getAllUserArticalCommentByuserId(user_id);
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

    @Override
    public List<Replay> getArticalReplayByCommentId(int comment_id) {
        return articalDao.getArticalReplayByCommentId(comment_id);
    }

    @Override
    public void sendReplayArtical(int replayUser_id, int comment_id, String replay_content, String replay_time) {
        Replay replay = new Replay();
        replay.setReplayUser_id(replayUser_id);
        replay.setComment_id(comment_id);
        replay.setReplay_content(replay_content);
        replay.setReplay_time(replay_time);
        articalDao.sendReplayArtical(replay);
    }

    @Override
    public List<Replay> getAllUserArticalReplayByuserId(int replayUser_id) {
        return articalDao.getAllUserArticalReplayByuserId(replayUser_id);
    }
}
