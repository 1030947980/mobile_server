package com.ssm.dao;

import com.ssm.pojo.ArticalComment;
import com.ssm.pojo.ArticalInfor;
import com.ssm.pojo.NewsComment;
import com.ssm.pojo.Replay;

import java.util.List;

public interface ArticalDao {
    /**
     * 发帖
     * @return
     */
    List<ArticalInfor> getAllAticalInfor();
    List<ArticalInfor> getPageArticalInfor(int currentIndex,int pageSize);
    int getArticalTotal();
    int changeArticalState(int artical_id,int artical_state);
    ArticalInfor getArticalInforById(int artical_id);
    List<ArticalInfor> getAllArticalInforUser(int user_id);
    int getAllArticalInforUserTotal(int user_id);
    List<ArticalInfor> getPageUserPostArticalInfor(int user_id,int currentIndex,int pageSize);
    List<ArticalInfor> getPageArticalInforUser(int currentIndex,int pageSize);
    int getArticalTotalUser();
    int viewsArtical(int artical_id);
    int newArtical(ArticalInfor articalInfor);
    /**
     * 发帖评论
     */
    List<ArticalComment> getAllArticalComment();
    List<ArticalComment> getPageArticalComment(int currentIndex);
    int getArticalCommentTotal();
    int changeArticalCommentState(int comment_id,int comment_state);
    List<ArticalComment> getArticalCommentByArticalId(int artical_id);
    int sendCommentArtical(ArticalComment articalComment);
    List<ArticalComment> getAllUserArticalCommentByuserId(int user_id);
    /**
     * 发帖回复
     */
    List<Replay> getAllArticalReplay();
    List<Replay> getPageArticalReplay(int currentIndex);
    int getArticalReplayTotal();
    int changeArticalReplayState(int replay_id,int replay_state);
    List<Replay> getArticalReplayByCommentId(int comment_id);
    int sendReplayArtical(Replay replay);
    List<Replay> getAllUserArticalReplayByuserId(int replayUser_id);
}
