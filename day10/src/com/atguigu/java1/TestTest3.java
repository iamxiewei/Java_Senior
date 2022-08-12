package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端
 * 并关闭相应的连接
 * @author xiewei
 * @create 2022-07-18 20:04
 */
public class TestTest3 {
    @Test
    public void client()
    {
        Socket socket= null;
        OutputStream os= null;
        FileInputStream fis= null;
        ByteArrayOutputStream baos= null;
        try {
            socket = new Socket(InetAddress.getLocalHost(),9090);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("表格数据卷积操作.png"));
            byte[] buffer=new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1)
            {
                os.write(buffer,0,len);
            }
            socket.shutdownOutput();

            InputStream is=socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bufferr=new byte[20];
            int len1;
            while ((len1=is.read(buffer))!=-1)
            {
                baos.write(buffer,0,len1);
            }
            System.out.println(baos.toString());
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
            try {
                baos.close();
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
        OutputStream os = null;
        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("复制图片2.jpg"));
            byte[] buffer=new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1)
            {
                fos.write(buffer,0,len);
            }
            System.out.println("图片传输完成");
            os = socket.getOutputStream();
            os.write("你好， 美女， 照片我已经收到， 非常漂亮！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                fos.close();
                is.close();
                socket.close();
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
