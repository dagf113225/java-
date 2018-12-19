package com.server.serverservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread   extends  Thread {

    Socket socket;
    public ServerThread( Socket socket)
    {
        this.socket=socket;
    }
    public void  run()
    {
        try
        {
            System.out.println("产生一个子线程保持对客户机的应答,线程的名字是:-->"+Thread.currentThread().getName());

            //服务器接受到客户机的消息
            BufferedReader br =  new BufferedReader(new InputStreamReader(socket.getInputStream(),"gbk"));
            String  serverReceiverMsg=br.readLine();

            System.out.println("服务器得到的客户端发送的消息为:"+serverReceiverMsg);

            System.out.println("请服务器构建消息**********");
            //服务器构建消息发送客户机
            BufferedReader  sbr =  new BufferedReader(new InputStreamReader(System.in));
            String  servermsg=sbr.readLine();


            //发送给客户端端
            //PrintWriter可以构建字符流和字节流，高级流
            PrintWriter pw=  new PrintWriter(socket.getOutputStream());
            pw.println(servermsg);
            pw.flush();//立即发送到目标
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }
}
