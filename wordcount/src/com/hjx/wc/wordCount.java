package com.hjx.wc;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class wordCount {
    private readFile rf = null;
    private count ct = null;
    int wordNum = 0;
    int charNum = 0;
    int lineNum = 0;
    int codeLine = 0;
    int noteLine = 0;
    int emptyLine = 0;


    public wordCount() {
        rf = new readFile();
        ct = new count();
    }


    public void count(String filePath) throws Exception {
        ArrayList<String> list = null;
        list = rf.ReadFile(filePath);
        int length = list.size();

        for (int i = 0; i < length; i++) {
            wordNum += ct.getWordNum(list.get(i));
            charNum += ct.getCharNum(list.get(i));
            lineNum += 1;
        }
        codeLine = ct.getCodeLineNum(list);
        noteLine = ct.getNoteLineNum(list);
        emptyLine = ct.getEmptyLineNum(list);
        setEmptyLine(emptyLine);
        setNoteLine(noteLine);
        setCodeLine(codeLine);
        setWordNum(wordNum);
        setCharNum(charNum);
        setLineNum(lineNum);
    }


    public int getWordNum() {
        return wordNum;
    }

    public void setWordNum(int wordNum) {
        this.wordNum = wordNum;
    }

    public int getCharNum() {
        return charNum;
    }

    public int getEmptyLine() {
        return emptyLine;
    }

    public void setEmptyLine(int emptyLine) {
        this.emptyLine = emptyLine;
    }

    public void setCharNum(int charNum) {
        this.charNum = charNum;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }


    public int getNoteLine() {
        return noteLine;
    }

    public int getCodeLine() {
        return codeLine;
    }

    public void setCodeLine(int codeLine) {
        this.codeLine = codeLine;
    }

    public void setNoteLine(int noteLine) {
        this.noteLine = noteLine;
    }
}




