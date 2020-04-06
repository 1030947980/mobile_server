package com.ssm.util;

import com.zhenzi.sms.ZhenziSmsClient;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ZhenziSms {


    private static final String SYMBOLS = "0123456789"; // 验证码由范围内数字组成
    // 验证码带字母
    // private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new SecureRandom();

    private static ZhenziSms instance;
    //单例模式构造方法私有化
    private ZhenziSms(){

    }
    public static ZhenziSms getInstance() {
        if (instance == null) {
            //静态属性指向单例该类
            instance = new ZhenziSms();
        }
        //返回静态属性
        return instance;
    }

    /**
     * 生成6位随机数，发送验证短信，并将验证码返回给控制层生成cookie
     */
    public String sendMessage(String phone) throws Exception {
        String code = getNonce_str();
        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com",
                "102561", "3d8791f5-8cfa-4468-b9e7-13cb5b3f0ef8");

        Map<String, String> params = new HashMap<String, String>();
        params.put("message", "您的验证码是:"+code+"，5分钟内输入有效，请勿泄露。");
        params.put("number", phone);
        String result = client.send(params);
        System.out.println("发送的结果为："+result);
        return  code;
    }

    /**
     * 获取长度为 6 的随机数字
     * @return 随机数字
     */
    public static String getNonce_str() {

        // 如果需要4位，那 new char[4] 即可，其他位数同理可得
        char[] nonceChars = new char[6];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }

        return new String(nonceChars);
    }

}
