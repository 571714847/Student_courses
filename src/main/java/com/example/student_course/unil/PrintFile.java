package com.example.student_course.unil;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintFile {

    /**
     * 2.用java语言统计任一磁盘目录下文件夹总数、文件总数，并打印文件名存在2个以上重复字母的文件路径[10分]
     * 思路：
     * 1、文件夹可能有多级
     * 2、使用递归调用
     */
    public static void main(String[] args) {
        //定义数组用于存储文件夹总数、文件总数
        int []arr = new int[2];
        //创建文件对象
        File file = new File("C:\\Users\\86152\\Desktop\\新建文件夹");
        fileCount(file,arr);
        System.out.println("-------------");
        System.out.println("文件夹总数："+arr[0]);
        System.out.println("文件总数："+arr[1]);
    }
    /**
     * 用于统计磁盘目录下文件夹总数、文件总数，并打印文件名存在2个以上重复字母的文件路径
     * @param file 	给定的目录文件
     * @param arr	用于记录文件夹总数、文件总数的数组：arr[0]--文件夹总数，arr[1]--文件总数
     */
    private static void fileCount(File file,int []arr) {
        //判断文件是否存在
        if(file.exists()) {
            //判断文件是否是文件夹
            if(file.isDirectory()) {
                //是文件夹，将文件夹统计数组元素自增1
                arr[0]++;
                //获取文件夹的所有文件列表
                File []files = file.listFiles();
                //遍历文件列表数组
                for(File f:files) {
                    if(f.exists()) {
                        //递归调用fileCount()
                        fileCount(f,arr);
                    }
                }
            }else {
                //是文件，将文件统计数组元素自增1
                arr[1]++;
                //获取文件名
                String fileName = file.getName();
                //判断文件名是否存在重复字母
                if(doubleChar2(fileName)) {
                    System.out.println(fileName);
                }
            }
        }
    }
    //判断文件名是否存在重复字母
    private static boolean doubleChar(String fileName) {
        //取出文件名的第一个字符
       String str1 = fileName.substring(0,1);
        //循环遍历文件名的其余字符
        for(int i=1;i<fileName.length()-1;i++) {
            //依次取出后续的字符
            String str2 = fileName.substring(i,i+1);
            //判断连续的str1是否跟str2相同
            if(str1.equals(str2)) {
                return true;
            }
            //将字符依次后移一位
            str1 = str2;
        }
        return false;
    }

    private static boolean doubleChar2(String fileName){
        String []arr = fileName.split("");
        Set<String> filaname = new HashSet<String>(Arrays.asList(arr));
        if(filaname.size()<arr.length){
            return true;
        }
        return false;
    }
}