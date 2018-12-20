package com.server.serverservicepool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreadTwo   extends   Thread{


    Socket socket;
    public ServerThreadTwo( Socket socket)
    {
        this.socket=socket;
    }
    public void  run()
    {
        try
        {
            System.out.println("浜х敓涓�釜瀛愮嚎绋嬩繚鎸佸瀹㈡埛鏈虹殑搴旂瓟,绾跨▼鐨勫悕瀛楁槸:-->"+Thread.currentThread().getName());

            //鏈嶅姟鍣ㄦ帴鍙楀埌瀹㈡埛鏈虹殑娑堟伅
            BufferedReader br =  new BufferedReader(new InputStreamReader(socket.getInputStream(),"gbk"));
            String  serverReceiverMsg=br.readLine();

            System.out.println("鏈嶅姟鍣ㄥ緱鍒扮殑瀹㈡埛绔彂閫佺殑娑堟伅涓�"+serverReceiverMsg);

           /** System.out.println("璇锋湇鍔″櫒鏋勫缓娑堟伅**********");
            //鏈嶅姟鍣ㄦ瀯寤烘秷鎭彂閫佸鎴锋満
            BufferedReader  sbr =  new BufferedReader(new InputStreamReader(System.in));
            String  servermsg=sbr.readLine();**/

            Thread.sleep(40*1000);

            String  servermsg=Thread.currentThread().getName()+", 瀹屾垚鐨勪换鍔″悕绉�"+serverReceiverMsg;
            //鍙戦�缁欏鎴风绔�
            //PrintWriter鍙互鏋勫缓瀛楃娴佸拰瀛楄妭娴侊紝楂樼骇娴�
            PrintWriter pw=  new PrintWriter(socket.getOutputStream());


            pw.println(servermsg);
            pw.flush();//绔嬪嵆鍙戦�鍒扮洰鏍�
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }
}
