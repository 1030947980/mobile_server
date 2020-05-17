package com.ssm.service;

import com.ssm.pojo.ArticalComment;
import com.ssm.pojo.ArticalInfor;
import com.ssm.pojo.Replay;

import java.util.List;

public interface ArticalService {
    /**
     * 发帖
     */
    List<ArticalInfor> getAllAticalInfor();
    List<ArticalInfor> getPageArticalInfor(int current_page);
    int getArticalTotal();
    void changeArticalState(int artical_id,int artical_state);
    /**
     * 发帖评论
     */
    List<ArticalComment> getAllArticalComment();
    List<ArticalComment> getPageArticalComment(int current_page);
    int getArticalCommentTotal();
    void changeArticalCommentState(int comment_id,int comment_state);
    /**
     * 发帖回复
     */
    List<Replay> getAllArticalReplay();
    List<Replay> getPageArticalReplay(int current_page);
    int getArticalReplayTotal();
    void changeArticalReplayState(int replay_id,int replay_state);
}
