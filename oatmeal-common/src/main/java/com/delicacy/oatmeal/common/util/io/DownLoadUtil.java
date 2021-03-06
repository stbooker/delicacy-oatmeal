package com.delicacy.oatmeal.common.util.io;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/***
 * 下载文件工具类
 */
public class DownLoadUtil {
    private static final String CONTENT_TYPE = "application/x-msdownload";


    public static boolean downLoadFile(HttpServletResponse response, String filename, File file) {
        FileInputStream input = null;
        OutputStream out = null;
        try {
            //设置response的编码方式
            response.setContentType(CONTENT_TYPE);
            //写明要下载的文件的大小
            response.setContentLength((int) file.length());
            //设置附加文件名
            response.setHeader("Content-Disposition", "attachment;filename=\"" + new String
                    (filename.getBytes("UTF-8"), "iso-8859-1") + "\"");
            //读出文件到i/o流
            input = new FileInputStream(file);
            //从response对象中得到输出流,准备下载
            out = response.getOutputStream();
            if (input != null && out != null) { // 判断输入或输出是否准备好
                int temp = 0;
                try {
                    while ((temp = input.read()) != -1) { // 开始拷贝
                        out.write(temp); // 边读边写
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.flush();
                    out.close();//关闭输出流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }
}
