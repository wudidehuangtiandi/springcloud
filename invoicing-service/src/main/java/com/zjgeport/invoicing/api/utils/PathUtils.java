package com.zjgeport.invoicing.api.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PathUtils {

    @Value("${file.upload}")
    private String uploadpath;

    //创建文件夹并生成路径
    public String getpath(){

        String path= uploadpath + new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        // 判断并创建文件夹
        File myfile = new File(path);
        if (!myfile.exists()) {
            myfile.mkdirs();//创一个文件夹
        }
        return path;
    }

}
