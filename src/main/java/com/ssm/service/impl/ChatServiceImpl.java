package com.ssm.service.impl;

import com.ssm.dao.ChatDao;
import com.ssm.pojo.ChatMessage;
import com.ssm.pojo.ChatUser;
import com.ssm.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    ChatDao chatDao;

    @Override
    public List<ChatMessage> getChatByChatId(int chatId) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChat_id(chatId);
        return chatDao.getChatByChatId(chatMessage);
    }

    @Override
    public String sendMessage(int chat_id, int from_id, int to_id, String message, long chat_time) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChat_id(chat_id);
        chatMessage.setFrom_id(from_id);
        chatMessage.setTo_id(to_id);
        chatMessage.setMessage(message);
        chatMessage.setChat_time(chat_time);
        chatDao.sendMessage(chatMessage);
        return "SUCCESS";
    }

    @Override
    public int getChatId(int user_id1, int user_id2) {
        return chatDao.getChatId(user_id1,user_id2);
    }

    @Override
    public List<ChatUser> getChatUser(int user_id) {
        return chatDao.getChatUser(user_id);
    }
}
