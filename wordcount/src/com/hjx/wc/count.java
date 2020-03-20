package com.hjx.wc;

import java.util.ArrayList;

public class count {

    //返沪单词数目
    public int getWordNum(String str){
        boolean flag = false;
        int num = 0;
        int length;
        char[] wn = str.toCharArray();
        length = wn.length;
        for(int i=0;i<length;i++){
            //当是一个新单词的时候才+1
            if(((wn[i]>=65 && wn[i]<=90) || (wn[i]>=97 && wn[i]<=122)) && flag == false){
                flag = true;
                num++;
            }else if((wn[i]>=65 && wn[i]<=90) || (wn[i]>=97 && wn[i]<=122)){
                //如果不是新单词就跳过
                continue;
            }else{
                //一个单词结束时就设为false
                flag = false;
            }
        }
        return num;
    }


    //返回字符数目
    public int getCharNum(String str){
        char[] cn = str.toCharArray();
        return cn.length;
    }


    //返回代码行数
    public int getCodeLineNum(ArrayList<String> str){
        int num = 0;
        boolean flag = true;
        for(int i=0;i<str.size();i++){
            String temp = str.get(i).trim();
            if(temp.startsWith("/*"))
                flag = false;
            else if(temp.endsWith("*/"))
                flag = true;
            else if(temp.startsWith("//") || temp.equals(""))
                num+=0;
            else if(flag)
                num+=1;
        }
        return num;
    }

    //返回注释行数
    public int getNoteLineNum(ArrayList<String> str){
        int num = 0;
        boolean flag = false;
        for(int i=0;i<str.size();i++){
            String temp = str.get(i).trim();
             //单行注释直接+1
            if(temp.startsWith("//"))
                num += 1;
            //多行注释，先+1并设置布尔变量，知道遇到*/才结束+1
            else if(temp.startsWith("/*")){
                num += 1;
                flag = true;
            }
            else if(temp.endsWith("*/")){
                num += 1;
                flag = false;
            }
            else if(flag == true)
                num += 1;
        }
        return num;
    }

    //返回空行数
    public int getEmptyLineNum(ArrayList<String> str){
        int num = 0;
        for(int i=0;i<str.size();i++){
            String temp = str.get(i).trim();
            if(temp.equals("") || temp.equals("}") || temp.equals("{"))
                num += 1;
        }
        return num;
    }
}
