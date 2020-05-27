package com.ssm.controller;

import com.ssm.pojo.ArticalComment;
import com.ssm.pojo.NewsComment;
import com.ssm.pojo.NewsInfor;
import com.ssm.pojo.Replay;
import com.ssm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    NewsService newsService;
    /**
     * 资讯
     * @param current_page
     * @return
     */
    @RequestMapping("/getPageNewsInfor")
    public List<NewsInfor> getPageNewsInfor(@RequestParam("current_page")int current_page,
                                            @RequestParam("pageSize")int pageSize){
        return newsService.getPageNewsInfor(current_page,pageSize);
    }
    @RequestMapping("/changeNewsState")
    public void changeNewsState(@RequestParam("news_id")int news_id,
                                @RequestParam("news_state")int news_state){
        newsService.changeNewsState(news_id, news_state);
    }
    @RequestMapping("/getAllNewsInfor")
    public List<NewsInfor> getAllNewsInfor(){
        return newsService.getAllNewsInfor();
    }
    @RequestMapping("/getNewsTotal")
    public int getNewsTotal(){
        return newsService.getNewsTotal();
    }
    @RequestMapping("/getNewsInforById")
    public NewsInfor getNewsInforById(@RequestParam("news_id")int news_id){
        return newsService.getNewsInforById(news_id);
    }
    @RequestMapping("/collecdtNews")
    public void collecdtNews(@RequestParam("news_id")int news_id){
        newsService.collecdtNews(news_id);
    }
    @RequestMapping("/getRecommendHotNewNewsinfot")
    public List<NewsInfor> getRecommendHotNewNewsinfot(@RequestParam("condition") String condition,
                                                       @RequestParam("current_page")int current_page,
                                                       @RequestParam("pageSize")int pageSize){
        return newsService.getRecommendHotNewNewsinfot(condition, current_page, pageSize);
    }
    @RequestMapping("/getRecommendHotNewNewsTotal")
    public int getRecommendHotNewNewsTotal(@RequestParam("condition")String condition){
        return newsService.getRecommendHotNewNewsTotal(condition);
    }
    @RequestMapping("/getBussinessNewsinfor")
    public List<NewsInfor> getBussinessNewsinfor(@RequestParam("bussiness1")String bussiness1,
                                                 @RequestParam("bussiness2")String bussiness2,
                                                 @RequestParam("current_page")int current_page,
                                                 @RequestParam("pageSize")int pageSize){
        return newsService.getBussinessNewsinfor(bussiness1,bussiness2,current_page, pageSize);
    }
    @RequestMapping("/getBussinessNewsTotal")
    public int getBussinessNewsTotal(@RequestParam("bussiness1")String bussiness1,
                                     @RequestParam("bussiness2")String bussiness2){
        return newsService.getBussinessNewsTotal(bussiness1,bussiness2);
    }
    /**
     * 资讯评论
     * @return
     */
    @RequestMapping("/getNewsCommentTotal")
    public int getNewsCommentTotal(){
        return newsService.getNewsCommentTotal();
    }
    @RequestMapping("/getAllNewsComment")
    public List<NewsComment> getAllNewsComment(){
        return newsService.getAllNewsComment();
    }
    @RequestMapping("/getPageNewsComment")
    public List<NewsComment> getPageNewsComment(@RequestParam("current_page")int current_page){
        return newsService.getPageNewsComment(current_page);
    }
    @RequestMapping("/changeNewsCommentState")
    public void changeNewsCommentState(@RequestParam("comment_id")int comment_id,
                                       @RequestParam("comment_state")int comment_state){
        newsService.changeNewsCommentState(comment_id, comment_state);
    }
    @RequestMapping("/getNewsCommentByNewsId")
    public List<NewsComment> getNewsCommentByNewsId(@RequestParam("news_id")int news_id){
        return newsService.getNewsCommentByNewsId(news_id);
    }
    @RequestMapping("/sendCommentNews")
    public void sendCommentNews(@RequestParam("news_id")int news_id,
                                @RequestParam("user_id")int user_id,
                                @RequestParam("comment_content")String comment_content,
                                @RequestParam("comment_time")String comment_time){
        newsService.sendCommentNews(news_id, user_id, comment_content, comment_time);
    }
    @RequestMapping("/getUserAllNewsCommentByUserId")
    public List<NewsComment> getUserAllNewsCommentByUserId(@RequestParam("user_id")int user_id){
        return newsService.getUserAllNewsCommentByUserId(user_id);
    }
    /**
     * 资讯回复
     */
    @RequestMapping("/getAllNewsReplay")
    public List<Replay> getAllNewsReplay(){
        return newsService.getAllNewsReplay();
    }
    @RequestMapping("/getPageNewsReplay")
    public List<Replay> getPageNewsReplay(@RequestParam("current_page")int current_page){
        return newsService.getPageNewsReplay(current_page);
    }
    @RequestMapping("/getNewsReplayTotal")
    public int getNewsReplayTotal(){
        return newsService.getNewsReplayTotal();
    }
    @RequestMapping("/changeNewsReplayState")
    public void changeNewsReplayState(@RequestParam("replay_id")int replay_id,
                                      @RequestParam("replay_state")int replay_state){
        newsService.changeNewsReplayState(replay_id, replay_state);
    }
    @RequestMapping("/getNewsReplayByCommentId")
    public List<Replay> getNewsReplayByCommentId(@RequestParam("comment_id")int comment_id){
        return newsService.getNewsReplayByCommentId(comment_id);
    }
    @RequestMapping("/sendReplayNews")
    public void sendReplayNews(@RequestParam("replayUser_id")int replayUser_id,
                               @RequestParam("comment_id") int comment_id,
                               @RequestParam("replay_content")String replay_content,
                               @RequestParam("replay_time")String replay_time){
        newsService.sendReplayNews(replayUser_id, comment_id, replay_content, replay_time);
    }
    @RequestMapping("/getUserAllNewsReplayByUserId")
    public List<Replay> getUserAllNewsReplayByUserId(@RequestParam("replayUser_id")int replayUser_id){
        return newsService.getUserAllNewsReplayByUserId(replayUser_id);
    }
}
