package com.ssm.service;

import com.ssm.pojo.ChatMessage;
import com.ssm.pojo.ChatUser;

import java.util.List;

public interface ChatService {
    List<ChatMessage> getChatByChatId(int chatId);
    String sendMessage(int chat_id,int from_id,int to_id,String message,long chat_time);
    String getChatId(int user_id1,int user_id2);
    List<ChatUser> getChatUser(int user_id);
    String newChat(int user_id1,int user_id2);
}
