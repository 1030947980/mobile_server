package com.ssm.controller;


import com.ssm.pojo.ArticalComment;
import com.ssm.pojo.ArticalInfor;
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
    @RequestMapping("/getAllAticalInfor")
    public List<ArticalInfor> getAllAticalInfor(){
        return articalService.getAllAticalInfor();
    }
    @RequestMapping("/getPageArticalInfor")
    public List<ArticalInfor> getPageArticalInfor(@RequestParam("current_page")int current_page){
        return articalService.getPageArticalInfor(current_page);
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
    /**
     * 发帖回复
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
}
