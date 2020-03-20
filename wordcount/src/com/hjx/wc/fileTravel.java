package com.hjx.wc;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fileTravel {
    public ArrayList<String> filePaths;
    Matcher m ;
    String sy =null;

    public fileTravel(ArrayList<String> filePaths,String sy) {
        this.filePaths = filePaths;
        this.sy = sy;
    }
    public fileTravel(ArrayList<String> filePaths){
        this.filePaths = filePaths;
    }


    public void travel(File file){
        //通过正则表达式，进行通配符的查找并且筛选符合要求的文件（此处为txt文件)
        String sy1 = "^["+sy+"].*(.txt)$";
        Pattern p = Pattern.compile(sy1);
        if(file == null)
            return;
        m = p.matcher(file.getName());
        //当找到符合的文件时才将其放进文件的字符串数组中进行调用
        if(m.find() || sy == null)
          filePaths.add(file.getAbsolutePath());
        if(file.isDirectory()){
            for (File files:file.listFiles()){
                //当是文件夹时，继续进行递归
                travel(files);
            }
        }
    }
}
