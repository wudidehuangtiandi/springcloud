package com.zjgeport.invoicing.api.utils;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;


public class FileBase64ConvertUitl {



    /**
     * 将文件转成base64 字符串
     * @param path文件路径
     * @return
     * @throws Exception
     */

    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();

        return Base64.getEncoder().encodeToString(buffer);

    }

    /**
     * 将base64字符解码保存文件
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */

    public static String decoderBase64File(String base64Code, String targetPath)
            throws Exception {
        byte[] buffer = new byte[0];
        try {
            String s = base64Code.replaceAll(" ", "+");
            buffer = Base64.getDecoder().decode(s);
        } catch (Exception e) {
            System.out.println(e);
        }
        String realpath=targetPath+ "/"+ UUID.randomUUID().toString() +".png";

        FileOutputStream out = new FileOutputStream(realpath);
        out.write(buffer);
        out.close();

        return realpath;

    }

    /**
     * 将base64字符保存文本文件
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */

    public static void toFile(String base64Code, String targetPath)
            throws Exception {

        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }


    public static void main(String[] args) {
        try {
            String base64Code = encodeBase64File("F:/testpicture.JPG");
            System.out.println("+++++++++++++++");
            System.out.println(base64Code);
            System.out.println("+++++++++++++++");
            //decoderBase64File(base64Code, "D:/2.tif");
            //toFile(base64Code, "D:\\three.txt");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
