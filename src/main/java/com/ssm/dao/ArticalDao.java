package com.ssm.dao;

import com.ssm.pojo.ArticalComment;
import com.ssm.pojo.ArticalInfor;
import com.ssm.pojo.Replay;

import java.util.List;

public interface ArticalDao {
    /**
     * 发帖
     * @return
     */
    List<ArticalInfor> getAllAticalInfor();
    List<ArticalInfor> getPageArticalInfor(int currentIndex);
    int getArticalTotal();
    int changeArticalState(int artical_id,int artical_state);
    /**
     * 发帖评论
     */
    List<ArticalComment> getAllArticalComment();
    List<ArticalComment> getPageArticalComment(int currentIndex);
    int getArticalCommentTotal();
    int changeArticalCommentState(int comment_id,int comment_state);
    /**
     * 发帖回复
     */
    List<Replay> getAllArticalReplay();
    List<Replay> getPageArticalReplay(int currentIndex);
    int getArticalReplayTotal();
    int changeArticalReplayState(int replay_id,int replay_state);
}
