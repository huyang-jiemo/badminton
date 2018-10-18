package com.young.sys.badminton.util;

import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

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
        String newFileName = key + "_" + new Date().getTime() + suffix;
        File tempFile = new File(path, newFileName);
        System.out.println(path);
        System.out.println(tempFile.getParentFile());
        System.out.println(tempFile.getPath());
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
}
