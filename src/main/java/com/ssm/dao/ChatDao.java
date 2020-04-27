package com.ssm.dao;

import com.ssm.pojo.ChatMessage;
import com.ssm.pojo.ChatUser;

import java.util.List;

public interface ChatDao {
    List<ChatMessage> getChatByChatId(ChatMessage chatMessage);
    int sendMessage(ChatMessage chatMessage);
    int getChatId(int user_id1,int user_id2);
    List<ChatUser>getChatUser(int user_id);
}
