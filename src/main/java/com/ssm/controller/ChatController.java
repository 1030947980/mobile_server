package com.ssm.controller;

import com.ssm.pojo.ChatMessage;
import com.ssm.pojo.ChatUser;
import com.ssm.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {
    @Autowired
    ChatService chatService;

    @RequestMapping("/getChatByChatId")
    public List<ChatMessage> getChatByChatId(@RequestParam("chat_id") int chat_id){
        return chatService.getChatByChatId(chat_id);
    }

    @RequestMapping(value = "/sendMessage")
    public String sendMessage(@RequestParam("chat_id") int chat_id,
                              @RequestParam("from_id") int from_id,
                              @RequestParam("to_id")int to_id,
                              @RequestParam("message")String message,
                              @RequestParam("chat_time")long chat_time)throws Exception{
        //transocket中 广播发送内容
        return chatService.sendMessage(chat_id,from_id,to_id,message,chat_time);
    }

    @RequestMapping(value = "/getChatId")
    public int getChatId(@RequestParam("user_id1") int user_id1,@RequestParam("user_id2") int user_id2){
        String chatId=chatService.getChatId(user_id1,user_id2);
        if(chatId==null){
            return 0;
        }
        return Integer.parseInt(chatId);
    }

    @RequestMapping(value = "/getChatUser")
    public List<ChatUser> getChatUser(@RequestParam("user_id")int user_id){
        return chatService.getChatUser(user_id);
    }

    @RequestMapping(value = "/newChat")
    public String newChat(@RequestParam("user_id1")int user_id1,@RequestParam("user_id2")int user_id2){
        return chatService.newChat(user_id1,user_id2);
    }

}
