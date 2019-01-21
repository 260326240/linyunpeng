package com.linyunpeng.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class transBase64 {
	
	public static String getImageStr(String imgFile) {
		InputStream inputStream = null;
		byte[] data = null;
		try {
			inputStream = new FileInputStream(imgFile);
			data = new byte[inputStream.available()];
			inputStream.read(data);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 加密
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}
	public static boolean generateImage(String imgStr, String path) {
		if (imgStr == null)
		return false;
		BASE64Decoder decoder = new BASE64Decoder();
		

			// 解密
		try {
			imgStr=imgStr.toString().replaceAll("/+/g","%2B");
			byte[] b = decoder.decodeBuffer(imgStr.toString().replaceAll("\r\n", ""));
			
			
			// 处理数据
//			for (int i = 0; i < b.length; ++i) {
//			if (b[i] < 0) {
//			b[i] += 256;
//			}
//			}
//			OutputStream out = new FileOutputStream(path);
//			out.write(b);
//			out.flush();
//			out.close();
//			FileOutputStream out = new FileOutputStream(new File(path));
//			out.write(b);
//			out.close();
			System.out.println("b="+b);
			Files.write(Paths.get(path), b, StandardOpenOption.CREATE);
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	
		}

	public static boolean generateImage1(String imgStr, String path) {
		if (imgStr == null)
		return false;
		BASE64Decoder decoder = new BASE64Decoder();
		
			// 解密
		try {
			byte[] b = decoder.decodeBuffer(imgStr);
			// 处理数据
			for (int i = 0; i < b.length; ++i) {
			if (b[i] < 0) {
			b[i] += 256;
			}
			}
			OutputStream out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	
		}
	
//	public static String readFile() {
//        String pathname = "C:\\Users\\huanxiang\\Pictures\\input.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
//        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
//        //不关闭文件会导致资源的泄露，读写文件都同理
//        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
//        String line,str="";
//        try (FileReader reader = new FileReader(pathname);
//             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
//        ) {
//            //网友推荐更加简洁的写法
//            while ((line = br.readLine()) != null) {
//                // 一次读入一行数据
//            	str+=line;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//                //System.out.println(str);
//                return str;
//    }
	
	
	public static void main(String[] args) {
	//	String strImg1 = getImageStr("C:\\Users\\huanxiang\\Pictures\\0.jpg");
		//System.out.println(strImg1.substring(200));
		
	//	generateImage(readFile(), "C:\\Users\\huanxiang\\Pictures\\7.jpg");
	}

}
