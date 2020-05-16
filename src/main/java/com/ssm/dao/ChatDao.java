package com.ssm.dao;

import com.ssm.pojo.ChatMessage;
import com.ssm.pojo.ChatUser;

import java.util.List;

public interface ChatDao {
    /**
     *通过私信id获取所有聊天消息
     * @param chatMessage
     * @return
     */
    List<ChatMessage> getChatByChatId(ChatMessage chatMessage);

    /**
     * 发送私信
     * @param chatMessage
     * @return
     */
    int sendMessage(ChatMessage chatMessage);

    /**
     * 通过2用户的id 获取私信id
     * @param user_id1
     * @param user_id2
     * @return
     */
    String getChatId(int user_id1,int user_id2);

    /**
     * 获取某个用户的私信用户
     * @param user_id
     * @return
     */
    List<ChatUser>getChatUser(int user_id);

    /**
     * 新建私信
     * @param user_id1
     * @param user_id2
     * @return
     */
    int newChat(int user_id1,int user_id2);
}
