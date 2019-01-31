package com.young.sys.badminton.util;

import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class FileUploadUtil {

    //文件上传
    public static String uploadFile(MultipartFile file, HttpServletRequest request, String key) {
        if (ObjectUtils.isEmpty(file)) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String path = request.getServletContext().getRealPath(File.separator + key + File.separator);
        File pathFile = new File(path);
        //判断上传文件的保存目录是否存在
        if (!pathFile.exists() && !pathFile.isDirectory()) {
            //创建目录
            pathFile.mkdir();
        }
        String newFileName = key + "_" + genUID() + suffix;
        File tempFile = new File(path, newFileName);
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            try {
                tempFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            file.transferTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return File.separator + key + File.separator + newFileName;
    }

    private static String genUID() {
        // 取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        // 加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        // 如果不足三位前面补0
        return millis + String.format("%03d", end3);
    }
}
