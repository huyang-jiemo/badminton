package com.young.sys.badminton.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeChatUtil {
    private static final String APPID="wx9b93f178992ef513";

    private static final String APPSECRET="08bd5d7978f0ea5824bb6e22e7b3302d";

    private static final String apiUrlStr = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+APPSECRET+"&grant_type=authorization_code&js_code=";

    //小程序api接口封装
    public static String getConvert(String urlStr){
        urlStr=apiUrlStr+urlStr;
        String data = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //连接超时
            connection.setConnectTimeout(20000);
            //读取数据超时
            connection.setReadTimeout(19000);
            connection.connect();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine())!=null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            connection.disconnect();
            data = stringBuilder.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return data;
    }
}
