package com.server.serverservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.单机能够正常的应答
 * 2.多客户机，服务器端会出现阻塞现象，不能够接受客户机消息
 * main线程一个线程完成连接和应答。
 *
 *
 */
public class Server {

    //服务器端的socket
    private Socket  socket;


    //服务器端
    private ServerSocket  serverSocket;

    public   Server()
    {

        System.out.println("服务器启动服务..........");

        try {
            serverSocket = new ServerSocket(8789);


            while(true)
            {
                //全阻塞,如果客户端有请求，会建立连接，并返回socket对象
                socket=serverSocket.accept();

                System.out.println("客户机和服务器建立了连接，可以进行通信");

                //服务器接受到客户机的消息
                BufferedReader  br =  new BufferedReader(new InputStreamReader(socket.getInputStream(),"gbk"));
                String  serverReceiverMsg=br.readLine();

                System.out.println("服务器得到的客户端发送的消息为:"+serverReceiverMsg);

                System.out.println("请服务器构建消息**********");
                //服务器构建消息发送客户机
                BufferedReader  sbr =  new BufferedReader(new InputStreamReader(System.in));
                String  servermsg=sbr.readLine();


                //发送给客户端端
                //PrintWriter可以构建字符流和字节流，高级流
                PrintWriter  pw=  new PrintWriter(socket.getOutputStream());
                pw.println(servermsg);
                pw.flush();//立即发送到目标


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public  static void  main(String[]  args)
    {
        Server  server = new Server();

    }

}
