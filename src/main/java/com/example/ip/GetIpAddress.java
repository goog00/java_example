package com.example.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class GetIpAddress {  
    public static void main(String[] args) {  
        try {  
            String outerIp = getOuterIp();  
            String innerIp = getInnerIp();  
            System.out.println("外网IP地址: " + outerIp);  
            System.out.println("内外IP地址: " + innerIp);  
        } catch (IOException e1) {  
            e1.printStackTrace();  
        }  
    }  
      
    private static String getOuterIp() throws IOException {  
        InputStream inputStream = null;  
        try {  
            URL url = new URL("http://1212.ip138.com/ic.asp");  
            URLConnection urlconnnection = url.openConnection();  
            inputStream = urlconnnection.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GB2312");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
            StringBuffer webContent = new StringBuffer();  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                webContent.append(str);  
            }  
            int ipStart = webContent.indexOf("[") + 1;  
            int ipEnd = webContent.indexOf("]");  
            return webContent.substring(ipStart, ipEnd);  
        } finally {  
            if (inputStream != null) {  
                inputStream.close();  
            }  
        }  
    }  
  
    private static String getInnerIp() throws IOException {  
        InetAddress inetAddress = InetAddress.getLocalHost();  
        return inetAddress.getHostAddress();  
    }     
}
