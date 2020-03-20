package com.hjx.wc;

import java.io.*;
import java.util.ArrayList;

/**
    该类可以将文件读取到strs字符数组中
*/
public class readFile {
    public ArrayList<String> ReadFile(String filePath)throws Exception{
        ArrayList<String> strs = new ArrayList<String>();
        String line;
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line=br.readLine())!=null){
            strs.add(line);
        }
        br.close();
        return strs;
    }
}
