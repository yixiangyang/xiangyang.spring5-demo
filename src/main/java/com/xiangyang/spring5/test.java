package com.xiangyang.spring5;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author yixiangyang
 * @Date 2022/1/12 11:08
 */
public class test {

    public static void main(String[] args) throws IOException {
        String file = "src/main/resources/input.txt";
        List<String> allLines = Files.readAllLines(Paths.get(file));
        //条件a
        if(allLines !=null && allLines.size() ==1){
            for (String line : allLines) {
                //反转字符串 写入文件
                if(line.contains("\\n")){
                    test.WriteStringToFile("/Users/yixiangyang/work/xiangyangLearn/xiangyang.spring5-demo/src/main/resources/output.txt", Arrays.asList(new StringBuffer(line).reverse().toString()));
                }
            }
        }
       //条件b 多行list反转
        if(allLines !=null && allLines.size()>1){
            Collections.reverse(allLines);
            test.WriteStringToFile("/Users/yixiangyang/work/xiangyangLearn/xiangyang.spring5-demo/src/main/resources/output.txt",allLines);
        }

        //条件c
    }

    public static void WriteStringToFile(String filePath,List<String> allLines) {
        try {
            File file = new File(filePath);
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            for (String line : allLines) {
                ps.println(line);// 往文件里写入字符串
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
