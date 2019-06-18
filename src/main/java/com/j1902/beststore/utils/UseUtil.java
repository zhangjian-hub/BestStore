package com.j1902.beststore.utils;

import com.zj.pojo.MySource;
import com.zj.server.MySourceServer;
import com.zj.to.SourcePaging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class UseUtil {
    public static String getIpAddress(HttpServletRequest request) {

        String ipAddress = request.getHeader("x-forwarded-for");

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknow".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();

            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡获取本机配置的IP地址
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inetAddress.getHostAddress();
            }
        }

        //对于通过多个代理的情况，第一个IP为客户端真实的IP地址，多个IP按照','分割
        if (null != ipAddress && ipAddress.length() > 15) {
            //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }

        return ipAddress;
    }

    public static int getIndex(HttpServletRequest req){
        int index = 1;
        String index1 = req.getParameter("index");
        if (index1 != null && !"".equals(index1)) {
            index = Integer.parseInt(index1);
        }
        return index;
    }

    public static int getCount(HttpServletRequest req){
        int count = 5;
        String count1 = req.getParameter("count");
        if (count1 != null && !"".equals(count1)) {
            count = Integer.parseInt(count1);
        }
        return count;
    }

    public static void sort(MySourceServer mySourceServer,SourcePaging sourcePaging, String order, int index, int count, HttpSession session, HttpServletRequest req, HttpServletResponse resp, boolean b1, boolean b2) {
        sourcePaging = mySourceServer.getAllSort(sourcePaging, index, count, session, b1, b2);
        System.out.println("sourcePaging = " + sourcePaging);
        setName(mySourceServer,sourcePaging);
        session.setAttribute("ALL_SOURCES", sourcePaging);
    }

    public static void setName(MySourceServer mySourceServer,SourcePaging sourcePaging){
        List<MySource> mySources = sourcePaging.getAllSources();
        if (mySources != null && mySources.size() > 0) {
            for (MySource mySource : mySources) {
                mySource.setName(mySourceServer.getName(mySource.getNameid()));
            }
        }
    }
}
