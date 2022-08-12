package com.atguigu.exer;

import org.junit.Test;

/**
 * @author xiewei
 * @create 2022-07-06 15:57
 */
public class String_exer {
    @Test
    public void String_trim()
    {
        String s=new java.lang.String(" abcd ");
        char []s_char=s.toCharArray();
        String s1=s.trim();
//        System.out.println(s1);

        String s2=null;
        int i=0;
        for(;i<s_char.length;i++)
        {
            if(s_char[i]==' ')
                continue;
            else break;

        }
        int j=s_char.length-1;
        for(;j>=i;j--)
        {
            if(s_char[j]==' ')
                continue;
            else break;
        }
        char s_new_char[]=new char[s.length()];
        int m=0;
        for(int k=i;k<=j;k++)
        {
            s_new_char[m++]=s_char[k];
        }
        //难点：末尾的空格如何去掉
        System.out.println(new java.lang.String(s_new_char));
//        System.out.println(s2);
    }

    public String reverse(String str,int startIndex,int endIndex)
    {
        if(str!=null)
        {
            char[] arr=str.toCharArray();
            for(int x=startIndex,y=endIndex;x<y;x++,y--)
            {
                char temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
            }
            return new String(arr);
        }
        return null;
    }



    @Test
    public void testReverse()
    {
        String str="abcdefg";
        String str1=reverse(str,1,5);
        System.out.println(str1);
    }

    //方式二
    public String reverse1(String str,int startIndex,int endIndex)
    {
        String reverseStr=str.substring(0,startIndex);
        for(int i=endIndex;i>=startIndex;i--)
        {
            reverseStr+=str.charAt(i);
        }
        reverseStr+=str.substring(endIndex+1);
        return reverseStr;
    }

    public String reverse2(String str,int startIndex,int endIndex)
    {
        if(str!=null)
        {
            StringBuilder builder=new StringBuilder(str.length());

            //第一部分
            builder.append(str.substring(0,startIndex));
            //第二部分
            for(int i=endIndex;i>=startIndex;i--)
            {
                builder.append(str.charAt(i));
            }
            builder.append(str.substring(endIndex+1));
            return builder.toString();
        }
        else return null;

    }

    /*
    * 获取subStr在mainStr中出现的次数
    *
    *
    * */
    public int getCount(String mainStr,String subStr)
    {
        int mainLength=mainStr.length();
        int subLength=subStr.length();
        int count=0;
        int index=0;
        if(mainLength>=subLength)
        {

//            while((index=mainStr.indexOf(subStr))!=-1)
//            {
//                count++;
//                mainStr=mainStr.substring(index+ subStr.length());
//            }

            while((index=mainStr.indexOf(subStr,index))!=-1)
            {
                count++;
                index+=subLength;
            }
            return count;
        }
        else
        {
            return 0;
        }
    }


}


