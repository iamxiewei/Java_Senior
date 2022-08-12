package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题：客户端发送文件给服务端；服务端将文件保存在本地
 * @author xiewei
 * @create 2022-07-18 19:23
 */
public class TCPTest2 {
        @Test
    public void client()
        {
            Socket socket= null;
            OutputStream os= null;
            FileInputStream fis= null;
            try {
                socket = new Socket(InetAddress.getLocalHost(),9090);
                os = socket.getOutputStream();
                fis = new FileInputStream(new File("表格数据卷积操作.png"));
                byte[] buffer=new byte[1024];
                int len;
                while((len=fis.read(buffer))!=-1)
                {
                    os.write(buffer,0,len);
                }
                System.out.println("成功发送");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Test
    public void server()
        {
            ServerSocket ss= null;
            Socket socket= null;
            InputStream is= null;
            FileOutputStream fos= null;
            try {
                ss = new ServerSocket(9090);
                socket = ss.accept();
                is = socket.getInputStream();
                fos = new FileOutputStream(new File("复制的数据.jpg"));
                byte[] buffer=new byte[1024];
                int len;
                while ((len=is.read(buffer))!=-1)
                {
                    fos.write(buffer,0,len);
                }
                System.out.println("成功接收");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                    is.close();
                    socket.close();
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
            }

        }




}
