package com.ssm.controller;


import com.ssm.pojo.ArticalComment;
import com.ssm.pojo.ArticalInfor;
import com.ssm.pojo.NewsInfor;
import com.ssm.pojo.Replay;
import com.ssm.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticalController {
    @Autowired
    ArticalService articalService;
    /**
     * 发帖
     */
    @RequestMapping("/uploadImg")
    public String uploadImg(){
        return "SUCCESS";
    }
    @RequestMapping("/getAllAticalInfor")
    public List<ArticalInfor> getAllAticalInfor(){
        return articalService.getAllAticalInfor();
    }
    @RequestMapping("/getPageArticalInfor")
    public List<ArticalInfor> getPageArticalInfor(@RequestParam("current_page")int current_page
            ,@RequestParam("pageSize") int pageSize){
        return articalService.getPageArticalInfor(current_page,pageSize);
    }
    @RequestMapping("/getArticalTotal")
    public int getArticalTotal(){
        return articalService.getArticalTotal();
    }
    @RequestMapping("/changeArticalState")
    public void changeArticalState(@RequestParam("artical_id")int artical_id,
                                   @RequestParam("artical_state")int artical_state){
        articalService.changeArticalState(artical_id, artical_state);
    }
    @RequestMapping("/getArticalInforById")
    public ArticalInfor getArticalInforById(@RequestParam("artical_id")int artical_id){
        return articalService.getArticalInforById(artical_id);
    }
//    某用户的发帖
    @RequestMapping("/getAllArticalInforUser")
    public List<ArticalInfor> getAllArticalInforUser(@RequestParam("user_id")int user_id){
        return articalService.getAllArticalInforUser(user_id);
    }
    @RequestMapping("/getPageUserPostArticalInfor")
    public List<ArticalInfor> getPageUserPostArticalInfor(@RequestParam("user_id")int user_id,
                                                          @RequestParam("current_page")int current_page,
                                                          @RequestParam("pageSize")int pageSize){
        return articalService.getPageUserPostArticalInfor(user_id, current_page, pageSize);
    }
    @RequestMapping("/getAllArticalInforUserTotal")
    public int getAllArticalInforUserTotal(@RequestParam("user_id")int user_id){
        return articalService.getAllArticalInforUserTotal(user_id);
    }
    @RequestMapping("/getPageArticalInforUser")
    public List<ArticalInfor> getPageArticalInforUser(@RequestParam("current_page")int current_page
            ,@RequestParam("pageSize") int pageSize){
        return articalService.getPageArticalInforUser(current_page,pageSize);
    }
    @RequestMapping("/getArticalTotalUser")
    public int getArticalTotalUser(){
        return articalService.getArticalTotalUser();
    }
    @RequestMapping("/newArtical")
    public void newArtical(@RequestParam("user_id")int user_id,
                           @RequestParam("artical_title")String artical_title,
                           @RequestParam("artical_describe")String artical_describe,
                           @RequestParam("artical_content")String artical_content,
                           @RequestParam("artical_time")String artical_time,
                           @RequestParam("artical_imgUrl")String artical_imgUrl){
        articalService.newArtical(user_id, artical_title, artical_describe, artical_content, artical_time, artical_imgUrl);
    }

    /**
     * 发帖评论
     */
    @RequestMapping("/getAllArticalComment")
    public List<ArticalComment> getAllArticalComment(){
        return articalService.getAllArticalComment();
    }
    @RequestMapping("/getPageArticalComment")
    public List<ArticalComment> getPageArticalComment(@RequestParam("current_page")int current_page){
        return articalService.getPageArticalComment(current_page);
    }
    @RequestMapping("/getArticalCommentTotal")
    public int getArticalCommentTotal(){
        return articalService.getArticalCommentTotal();
    }
    @RequestMapping("/changeArticalCommentState")
    public void changeArticalCommentState(@RequestParam("comment_id")int comment_id,
                                   @RequestParam("comment_state")int comment_state) {
        articalService.changeArticalCommentState(comment_id,comment_state);
    }
    @RequestMapping("/getArticalCommentByArticalId")
    public List<ArticalComment> getArticalCommentByArticalId(@RequestParam("artical_id")int artical_id){
        return articalService.getArticalCommentByArticalId(artical_id);
    }
    @RequestMapping("/sendCommentArtical")
    public void sendCommentNews(@RequestParam("artical_id")int artical_id,
                                @RequestParam("user_id")int user_id,
                                @RequestParam("comment_content")String comment_content,
                                @RequestParam("comment_time")String comment_time){
        articalService.sendCommentArtical(artical_id, user_id, comment_content, comment_time);
    }
    @RequestMapping("/getAllUserArticalCommentByuserId")
    public List<ArticalComment> getAllUserArticalCommentByuserId(@RequestParam("user_id")int user_id){
        return articalService.getAllUserArticalCommentByuserId(user_id);
    }
    /**
     * 发帖回复
     */
    @RequestMapping("/getAllArticalReplay")
    public List<Replay> getAllArticalReplay(){
        return articalService.getAllArticalReplay();
    }
    @RequestMapping("/getPageArticalReplay")
    public List<Replay> getPageArticalReplay(@RequestParam("current_page")int current_page){
        return articalService.getPageArticalReplay(current_page);
    }
    @RequestMapping("/getArticalReplayTotal")
    public int getArticalReplayTotal(){
        return articalService.getArticalReplayTotal();
    }
    @RequestMapping("/changeArticalReplayState")
    public void changeArticalReplayState(@RequestParam("replay_id")int replay_id,
                                          @RequestParam("replay_state")int replay_state) {
        articalService.changeArticalReplayState(replay_id,replay_state);
    }
    @RequestMapping("/getArticalReplayByCommentId")
    public List<Replay> getArticalReplayByCommentId(@RequestParam("comment_id")int comment_id){
        return articalService.getArticalReplayByCommentId(comment_id);
    }
    @RequestMapping("/sendReplayArtical")
    public void sendReplayNews(@RequestParam("replayUser_id")int replayUser_id,
                               @RequestParam("comment_id") int comment_id,
                               @RequestParam("replay_content")String replay_content,
                               @RequestParam("replay_time")String replay_time){
        articalService.sendReplayArtical(replayUser_id, comment_id, replay_content, replay_time);
    }
    @RequestMapping("/getAllUserArticalReplayByuserId")
    public List<Replay> getAllUserArticalReplayByuserId(@RequestParam("replayUser_id")int replayUser_id){
        return articalService.getAllUserArticalReplayByuserId(replayUser_id);
    }
    /**
     * 收藏
     */
    @RequestMapping("/newArticalCollection")
    public void newArticalCollection(@RequestParam("artical_id")int artical_id,
                                  @RequestParam("user_id")int user_id){
        articalService.newArticalCollection(artical_id, user_id);
    }
    @RequestMapping("/getArticalCollectionId")
    public int getArticalCollectionId (@RequestParam("artical_id")int artical_id,
                                    @RequestParam("user_id")int user_id){
        return articalService.getArticalCollectionId(artical_id,user_id);
    }
    @RequestMapping("/changeArticalCollectionState")
    public void changeArticalCollectionState (@RequestParam("artical_id")int artical_id,
                                           @RequestParam("user_id")int user_id,
                                           @RequestParam("collection_state")int collection_state){
        articalService.changeArticalCollectionState(artical_id,user_id,collection_state);
    }
    @RequestMapping("/getArticalCollectByUserId")
    public List<ArticalInfor> getArticalCollectByUserId(@RequestParam("user_id") int user_id){
        return articalService.getArticalCollectByUserId(user_id);
    }
}
