package com.ssm.controller;

import com.ssm.dao.NewsDao;
import com.ssm.pojo.NewsComment;
import com.ssm.pojo.NewsInfor;
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

    @RequestMapping("/getPageNewsInfor")
    public List<NewsInfor> getPageNewsInfor(@RequestParam("current_page")int current_page){
        return newsService.getPageNewsInfor(current_page);
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
}
