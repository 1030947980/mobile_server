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
    List<ArticalInfor> getPageArticalInfor(int current_page,int pageSize);
    int getArticalTotal();
    void changeArticalState(int artical_id,int artical_state);
    ArticalInfor getArticalInforById(int artical_id);
    //某用户的发帖
    List<ArticalInfor> getAllArticalInforUser(int user_id);
    int getAllArticalInforUserTotal(int user_id);
    List<ArticalInfor> getPageUserPostArticalInfor(int user_id,int current_page,int pageSize);
    //显示列表
    List<ArticalInfor> getPageArticalInforUser(int current_page,int pageSize);
    int getArticalTotalUser();
    void newArtical(int user_id,String artical_title,String artical_describe,
                   String artical_content,String artical_time,String artical_imgUrl);
    /**
     * 发帖评论
     */
    List<ArticalComment> getAllArticalComment();
    List<ArticalComment> getPageArticalComment(int current_page);
    int getArticalCommentTotal();
    void changeArticalCommentState(int comment_id,int comment_state);
    List<ArticalComment> getArticalCommentByArticalId(int artical_id);
    void sendCommentArtical(int artical_id,int user_id,String comment_content,String comment_time);
    List<ArticalComment> getAllUserArticalCommentByuserId(int user_id);

    /**
     * 发帖回复
     */
    List<Replay> getAllArticalReplay();
    List<Replay> getPageArticalReplay(int current_page);
    int getArticalReplayTotal();
    void changeArticalReplayState(int replay_id,int replay_state);
    List<Replay> getArticalReplayByCommentId(int comment_id);
    void sendReplayArtical(int replayUser_id,int comment_id,String replay_content,String replay_time);
    List<Replay> getAllUserArticalReplayByuserId(int replayUser_id);
}
