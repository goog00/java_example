package com.example.http;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HttpUtils {

    public static void test(String ip) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://ip.taobao.com/service/getIpInfo.php"  + "?ip=" + ip);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        // The underlying HTTP connection is still held by the response object
        // to allow the response content to be streamed directly from the network socket.
        // In order to ensure correct deallocation of system resources
        // the user MUST call CloseableHttpResponse#close() from a finally clause.
        // Please note that if response content is not fully consumed the underlying
        // connection cannot be safely re-used and will be shut down and discarded
        // by the connection manager.
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
//            EntityUtils.consume(entity1);
            String s = EntityUtils.toString(entity1,  "UTF-8");
            System.out.println(s);
        } finally {
            response1.close();
        }
    }

    public static String getIpArea(String ip) throws Exception {

        String path = "http://ip.taobao.com/service/getIpInfo.php?ip="+ip;
        String inputline="";
        String info="";

        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setReadTimeout(10*1000);
            conn.setRequestMethod("GET");

            InputStreamReader inStream = new InputStreamReader(conn.getInputStream(),"UTF-8");
            BufferedReader buffer=new BufferedReader(inStream);

            while((inputline=buffer.readLine())!=null){
                info += inputline;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        JSONObject jsonob = JSONObject.fromObject((JSONObject.fromObject(info).getString("data")));
//        String city = StringEscapeUtils.escapeSql(jsonob.getString("city"));

        return null;
    }

    public static void test3(String ip){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        InputStream is = null;
        String url = "http://ip.taobao.com/service/getIpInfo.php";
        //封装请求参数
        List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("ip", ip));
        String str = "";
        try {
            //转换为键值对
            str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
            System.out.println(str);
            //创建Get请求
            HttpGet httpGet = new HttpGet(url+"?"+str);
            //执行Get请求，
            response = httpClient.execute(httpGet);
            //得到响应体
            HttpEntity entity = response.getEntity();
            if(entity != null){
                is = entity.getContent();
                //转换为字节输入流
                BufferedReader br = new BufferedReader(new InputStreamReader(is, Consts.UTF_8));
                String body = null;
                while((body=br.readLine()) != null){
                    System.out.println(body);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //关闭输入流，释放资源
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //消耗实体内容
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭相应 丢弃http连接
            if(httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
//        test("119.57.68.162");
        test3("119.57.68.162");
//        getIpArea("119.57.68.162");
    }
}