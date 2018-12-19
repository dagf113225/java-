package com.server.serverservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerOne {

    //服务器端的socket
    private Socket socket;


    //服务器端
    private ServerSocket serverSocket;

    public   ServerOne()
    {

        System.out.println("服务器启动服务..........");

        try {
            //保持对客户机的监听，是主线程main
            serverSocket = new ServerSocket(8789);


            while(true)
            {
                //全阻塞,如果客户端有请求，会建立连接，并返回socket对象
                socket=serverSocket.accept();

                System.out.println("客户机和服务器建立了连接，可以进行通信");

                /**
                 * 采用线程，来一个客户机的请求，产生一个线程
                 * 保持对客户机的应答
                 */

                 //由主线程产生子线程保持对各个客户机的应答
                new ServerThread(socket).start();



            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public  static void  main(String[]  args)
    {
        ServerOne  serverone = new ServerOne();

    }
}
