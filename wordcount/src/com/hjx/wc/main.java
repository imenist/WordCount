package com.hjx.wc;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) throws Exception {
        String filePath,filesPath;
        String choose,sy = "";
        String choose1 = "";
        int que = 0;
        int star = 0;
        wordCount wc = new wordCount();
        Scanner sn = new Scanner(System.in);
        String str = sn.nextLine();
        int line = str.indexOf("-");
        int line1 = str.indexOf("s");
        int pathFile = str.indexOf(":");
        star = str.indexOf("*");
        que = str.indexOf("?");
        choose = str.substring(line,line+2);



        switch (choose){
            case "-c":
                filePath = str.substring(pathFile-1).trim();
                wc.count(filePath);
                System.out.println("文件字符数目:"+wc.getCharNum());
                break;
            case "-w":
                filePath = str.substring(pathFile-1).trim();
                wc.count(filePath);
                System.out.println("文件单词数目："+wc.getWordNum());
                break;
            case "-l":
                filePath = str.substring(pathFile-1).trim();
                wc.count(filePath);
                System.out.println("文件行数:"+wc.getLineNum());
                break;
            case "-a":
                filePath = str.substring(pathFile-1).trim();
                wc.count(filePath);
                System.out.println("文件代码行数:"+wc.getCodeLine());
                System.out.println("文件注释行数:"+wc.getNoteLine());
                System.out.println("文件空行数:"+wc.getEmptyLine());
                break;
            case "-s":
                filesPath = "D:/123456";
                if(line1 != 0){
                    choose1 = str.substring(line1+1,line1+3);
                    if(star != -1)
                        sy = str.substring(line1+4,star);
                    if(que != -1)
                        sy = str.substring(line+4,que);
                }
                //创建数组专门统计符合条件的文件路径
                ArrayList<String> pathsFile = new ArrayList<String>();
                File file = new File(filesPath);
                //建立ft对象进行递归处理
                fileTravel ft = new fileTravel(pathsFile,sy);
                ft.travel(file);
                int length = pathsFile.size();
                //将得到的文件进行wordCount处理并输出
                for(int i=0;i<length;i++){
                    String currentFile = pathsFile.get(i);
                        wc.count(currentFile);
                        System.out.println("文件:"+currentFile);
                        switch (choose1){
                            case "-c" :System.out.println("文件字符数目:"+wc.getCharNum());break;
                            case "-w" :System.out.println("文件单词数目："+wc.getWordNum());break;
                            case "-l" :System.out.println("文件行数:"+wc.getLineNum());break;
                            case "-a" :
                                System.out.println("文件字符数目:"+wc.getCharNum());
                                System.out.println("文件单词数目:"+wc.getWordNum());
                                System.out.println("文件行数:"+wc.getLineNum());
                                System.out.println("文件代码行数:"+wc.getCodeLine());
                                System.out.println("文件注释行数:"+wc.getNoteLine());
                                System.out.println("文件空行数:"+wc.getEmptyLine());
                                break;
                        }
                }
                break;
            case "-x":
                new frameUI();
        }
    }
}
