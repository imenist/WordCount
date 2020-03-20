package com.hjx.wc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class frameUI extends JFrame{
    public static JFrame jFrame;
    public JTextField textField;
    public JFileChooser fileChooser = new JFileChooser();
    wordCount wc = new wordCount();
    File selectedFile;

    public frameUI() {
        //获得Jframe对象
        jFrame = new JFrame();
        //设置标题
        jFrame.setTitle("Word Count");
        //设置窗口大小
        jFrame.setBounds(600,600,800,100);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        //获得窗口对象进行编辑
        jFrame.getContentPane().add(getContentPane());
        this.setLayout(new FlowLayout());


        //初始化窗口各控件参数
        JLabel label = new JLabel();
        label.setText("文件名称：");
        JButton button = new JButton("选择文件");
        JButton button1 = new JButton("选择文件夹");
        JButton _c = new JButton("-c");
        JButton _w = new JButton("-w");
        JButton _l = new JButton("-l");
        JButton _a = new JButton("-a");
        JButton _s = new JButton("-s");
        textField = new JTextField(20);

        //将各控件添加到窗口上
        getContentPane().add(label);
        getContentPane().add(textField);
        getContentPane().add(button);
        getContentPane().add(button1);
        getContentPane().add(_c);
        getContentPane().add(_w);
        getContentPane().add(_l);
        getContentPane().add(_a);
        getContentPane().add(_s);



        //进行选择文件时，调用自带的fileChooser并获得文件对象，返回其路径于文本框中
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = fileChooser.showOpenDialog(getContentPane());
                if(i == JFileChooser.APPROVE_OPTION){
                    selectedFile = fileChooser.getSelectedFile().getAbsoluteFile();
                    textField.setText(selectedFile.getName());
                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setFileSelectionMode(1);
                int i = fileChooser.showOpenDialog(getContentPane());
                if(i == JFileChooser.APPROVE_OPTION){
                    selectedFile = fileChooser.getSelectedFile().getAbsoluteFile();
                    textField.setText(selectedFile.getName());
                }
            }
        });

        _c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wc.count(selectedFile.toString());
                    JOptionPane.showMessageDialog(null,selectedFile+"字符数:"+wc.getCharNum());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        _l.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wc.count(selectedFile.toString());
                    JOptionPane.showMessageDialog(null,selectedFile+"行数:"+wc.getLineNum());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        _w.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wc.count(selectedFile.toString());
                    JOptionPane.showMessageDialog(null,selectedFile+"单词数:"+wc.getWordNum());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        _a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wc.count(selectedFile.toString());
                    JOptionPane.showMessageDialog(null,selectedFile+"\n"+"空行数:"+wc.getLineNum()+
                            "\n"+"代码行:"+wc.getCodeLine()+"\n"+"注释行:"+wc.getNoteLine());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        //选择_s函数时进行文件夹的递归，并自动将符合要求的文件以对话框的形式输出其数据
        _s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePaths = selectedFile.getAbsolutePath();
                File currentFile = new File(filePaths);
                try {
                    fileTravelUI(currentFile);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


        jFrame.setVisible(true);
    }

    public static void fileTravelUI(File currentFile) throws Exception {
        if(currentFile.isFile()){
            showFile(currentFile);
        }
        else if(currentFile == null){
            return;
        }
        else if(currentFile.isDirectory()){
            for(File files : currentFile.listFiles())
                fileTravelUI(files);
        }
    }

    public static void showFile(File file) throws Exception {
        wordCount wc = new wordCount();
        wc.count(file.getAbsolutePath());
        JOptionPane.showMessageDialog(null,file.getName()+"\n"+"空行数:"+wc.getLineNum()+
                "\n"+"代码行:"+wc.getCodeLine()+"\n"+"注释行:"+wc.getNoteLine());
    }
}
