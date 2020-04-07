package com.ssm.util;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name="BitCoinDataCenter",urlPatterns = "/BitCoinDataCenter",loadOnStartup=1) //标记为Servlet不是为了其被访问，而是为了便于伴随Tomcat一起启动
public class BitCoinDataCenter extends HttpServlet implements Runnable{



    public void init(ServletConfig config){
     //     startup();
    }
    public static void main(String[] args) {
        BitCoinDataCenter bitCoinDataCenter = new BitCoinDataCenter();
        bitCoinDataCenter.startup();

    }

    public  void startup(){
        new Thread(this).start();
    }
    @Override
    public void run() {

      //  while(1==1){

//            //每隔1-3秒就产生一个新价格
//            int duration = 1000+new Random().nextInt(2000);
//            try {
//                Thread.sleep(duration);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            //新价格围绕100000左右50%波动
//            String getmessage = "时间"+duration;
//
//            //查看的人越多，价格越高
//            int total = ServerManager.getTotal();
//            System.out.println("message:"+getmessage);
//
//            String messageFormat = "{\"getmessage\":\"%s\",\"total\":%d}";
//            String message = String.format(messageFormat, getmessage,total);
//            //广播出去
//            ServerManager.broadCast(message);
       // }
    }
}