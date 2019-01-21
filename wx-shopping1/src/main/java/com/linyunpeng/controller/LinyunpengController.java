package com.linyunpeng.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.linyunpeng.model.Linyunpeng;
import com.linyunpeng.model.Linyunpeng_update;
import com.linyunpeng.service.ILinyunpengService;
import com.linyunpeng.util.copy_class;
import com.linyunpeng.util.transBase64;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 鍓嶇鎺у埗鍣�
 * </p>
 *
 * @author RobinYoung10
 * @since 2019-01-06
 */
@Controller
public class LinyunpengController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ILinyunpengService linyunpengService;

	/**
	 * 保存文件方法
	 * 
	 * @param file
	 * @return
	 */
	private void saveFile(MultipartFile file, String path, String filename) throws Exception {
		logger.info("path = {}", path);
		logger.info("filename = {}", filename);
		File filepath = new File(path, filename);
		// 如果路径不存在,就创建一个
		if (!filepath.getParentFile().exists()) {
			filepath.getParentFile().mkdir();
		}
		file.transferTo(new File(path + filename));
	}

	@RequestMapping("/add")
	@ResponseBody
	public List<Linyunpeng> add(Linyunpeng linyunpeng, HttpServletRequest request) throws Exception {
		logger.info("linyunpeng = {}", linyunpeng);

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newNo = df.format(new Date());
		// 将文件名设置为时间+文件名
		String path = request.getServletContext().getRealPath("");
		// home/tomcat8/webapps/linyunpeng/
//linux
		int lastIndex = path.lastIndexOf("/", path.length() - 2);
		logger.info("path = {}", path);
		// path = path.substring(0, lastIndex);
		// logger.info("path = {}", path);
		path += "/images/";
		if (linyunpeng.getImaAdd1() != null && linyunpeng.getImaAdd1().length() > 0) {
			transBase64.generateImage(linyunpeng.getImaAdd1(), path + newNo + "ImaAdd1.jpg");
			linyunpeng.setImaAdd1("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaAdd1.jpg");
		}
		if (linyunpeng.getImaAdd2() != null && linyunpeng.getImaAdd2().length() > 0) {
			transBase64.generateImage(linyunpeng.getImaAdd2(), newNo + "ImaAdd2.jpg");
			linyunpeng.setImaAdd2("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaAdd2.jpg");
		}
		if (linyunpeng.getImaAdd3() != null && linyunpeng.getImaAdd3().length() > 0) {
			transBase64.generateImage(linyunpeng.getImaAdd3(), newNo + "ImaAdd1.jpg");
			linyunpeng.setImaAdd3("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaAdd3.jpg");
		}
		if (linyunpeng.getImaTouxiang() != null && linyunpeng.getImaTouxiang().length() > 0) {
			transBase64.generateImage(linyunpeng.getImaTouxiang(), newNo + "ImaTouxiang.jpg");
			linyunpeng.setImaTouxiang("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaTouxiang.jpg");
		}
//windows
//		int lastIndex = path.lastIndexOf("\\", path.length());
//		logger.info("path = {}", path);
//		path += "\\images\\";
//		if (linyunpeng.getImaAdd1() != null && linyunpeng.getImaAdd1().length() > 0) {
//			logger.info("linyunpeng.getImaAdd1()={}",linyunpeng.getImaAdd1());
//			transBase64.generateImage(linyunpeng.getImaAdd1(), path + newNo + "ImaAdd1.jpg");
//			linyunpeng.setImaAdd1("localhost:8080/linyunpeng/images/" + newNo + "ImaAdd1.jpg");
//		}
//		if (linyunpeng.getImaAdd2() != null && linyunpeng.getImaAdd2().length() > 0) {
//			transBase64.generateImage(linyunpeng.getImaAdd2(), newNo + "ImaAdd2.jpg");
//			linyunpeng.setImaAdd2("localhost:8080/linyunpeng/images/" + newNo + "ImaAdd2.jpg");
//		}
//		if (linyunpeng.getImaAdd3() != null && linyunpeng.getImaAdd3().length() > 0) {
//			transBase64.generateImage(linyunpeng.getImaAdd3(), newNo + "ImaAdd1.jpg");
//			linyunpeng.setImaAdd3("localhost:8080/linyunpeng/images/" + newNo + "ImaAdd3.jpg");
//		}
//		if (linyunpeng.getImaTouxiang() != null && linyunpeng.getImaTouxiang().length() > 0) {
//			transBase64.generateImage(linyunpeng.getImaTouxiang(), newNo + "ImaTouxiang.jpg");
//			linyunpeng.setImaTouxiang("localhost:8080/linyunpeng/images/" + newNo + "ImaTouxiang.jpg");
//		}
//		saveFile();
		if (linyunpeng.getCropName() != null && linyunpeng.getCropName().length() > 0) {
			boolean flag = linyunpengService.save(linyunpeng);
			logger.info("flag:" + flag);
		}
		QueryWrapper<Linyunpeng> wrapper = new QueryWrapper(null);
		List<Linyunpeng> linyunpengList = linyunpengService.list(wrapper);
		logger.info("linyunpengList-size：" + linyunpengList.size());

		return linyunpengList;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("crop_name") String cropName) {
		logger.info("crop_name = {}", cropName);
		QueryWrapper<Linyunpeng> wrapper = new QueryWrapper();
		wrapper.eq("crop_name", cropName);
		boolean flag = linyunpengService.remove(wrapper);
		if (flag) {
			return "delete OK";
		} else {
			return "delete ERROR";
		}
	}

	@RequestMapping("/search")
	@ResponseBody
	public Linyunpeng search(@RequestParam("crop_name") String cropName) {
		logger.info("crop_name = {}", cropName);
		QueryWrapper<Linyunpeng> wrapper = new QueryWrapper();
		wrapper.eq("crop_name", cropName);
		Linyunpeng linyunpeng = linyunpengService.getOne(wrapper);
		if (linyunpeng != null) {
			return linyunpeng;
		} else {
			return new Linyunpeng();
		}
	}

	@RequestMapping("/test")

	public @ResponseBody String getTest(HttpServletRequest request) {

		BufferedReader br;
		try {
			br = request.getReader();
			String str, body = "";
			//接收安卓post数据流
			while ((str = br.readLine()) != null) {
				body += str.trim();
			}	
			//打印接收数据
			//logger.info("==============body===================");
			//logger.info(body);
			//logger.info("==============body===================");
			
			if(body!=null&&body.length()>0) {
				//GSON 字符串转bean
				Gson gson = new GsonBuilder().create();
				Linyunpeng linyunpeng = gson.fromJson(body.replaceAll("\\\"\\\"","null"),Linyunpeng.class);
				logger.info("linyunpeng={}",linyunpeng);
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newNo = df.format(new Date());
				// 将文件名设置为时间+文件名
				String path = request.getServletContext().getRealPath("");
				int lastIndex = path.lastIndexOf("/", path.length() - 2);
				logger.info("path = {}", path);
				path += "/images/";
				try {
					if (linyunpeng.getImaAdd1() != null && linyunpeng.getImaAdd1().length() > 0) {
						transBase64.generateImage(linyunpeng.getImaAdd1(), path + newNo + "ImaAdd1.jpg");
						linyunpeng.setImaAdd1("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaAdd1.jpg");
					}
					if (linyunpeng.getImaAdd2() != null && linyunpeng.getImaAdd2().length() > 0) {
						transBase64.generateImage(linyunpeng.getImaAdd2(), path +newNo + "ImaAdd2.jpg");
						linyunpeng.setImaAdd2("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaAdd2.jpg");
					}
					if (linyunpeng.getImaAdd3() != null && linyunpeng.getImaAdd3().length() > 0) {
						transBase64.generateImage(linyunpeng.getImaAdd3(), path +newNo + "ImaAdd3.jpg");
						linyunpeng.setImaAdd3("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaAdd3.jpg");
					}
					if (linyunpeng.getImaTouxiang() != null && linyunpeng.getImaTouxiang().length() > 0) {
						transBase64.generateImage(linyunpeng.getImaTouxiang(), path +newNo + "ImaTouxiang.jpg");
						linyunpeng.setImaTouxiang("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaTouxiang.jpg");
					}
				
				
					if (linyunpeng.getCropName() != null && linyunpeng.getCropName().length() > 0) {
						boolean flag = linyunpengService.save(linyunpeng);
						logger.info("flag:" + (flag?"成功":"失败"));
					}
				} catch (Exception e) {
					logger.info("图片转码不成功");
					e.printStackTrace();
				}
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/update")

	public @ResponseBody Linyunpeng Update(HttpServletRequest request) {
//
		BufferedReader br;
		try {
			br = request.getReader();
			String str, body = "";
			//接收安卓post数据流
			while ((str = br.readLine()) != null) {
				body += str.trim();
			}	
			//打印接收数据
			//logger.info("==============body===================");
			//logger.info(body);
			//logger.info("==============body===================");
			
			if(body!=null&&body.length()>0) {
			//	GSON 字符串转bean
				Gson gson = new GsonBuilder().create();
				Linyunpeng_update linyunpeng_update = gson.fromJson(body.replaceAll("\\\"\\\"","null"),Linyunpeng_update.class);
				logger.info("linyunpeng_update={}",linyunpeng_update);
				QueryWrapper<Linyunpeng> wrapper = new QueryWrapper();
				wrapper.eq("crop_name", linyunpeng_update.getCropchangename());
				Linyunpeng linyunpeng1 = linyunpengService.getOne(wrapper);
				if (linyunpeng1==null) {
					logger.info("修改不成功，查询无结果");
					return null;
				}
				
				Linyunpeng linyunpeng = copy_class.copy_linyunpeng(linyunpeng_update);
				logger.info("linyunpeng_update={}",linyunpeng_update);
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newNo = df.format(new Date());
				// 将文件名设置为时间+文件名
				String path = request.getServletContext().getRealPath("");
				int lastIndex = path.lastIndexOf("/", path.length() - 2);
				logger.info("path = {}", path);
				path += "/images/";
				try {
					if (linyunpeng.getImaAdd1() != null && linyunpeng.getImaAdd1().length() > 0&&!linyunpeng_update.getImaAdd1().equals("")) {
						transBase64.generateImage(linyunpeng.getImaAdd1(), path + newNo + "ImaAdd1.jpg");
						linyunpeng.setImaAdd1("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaAdd1.jpg");
					}
					if (linyunpeng.getImaAdd2() != null && linyunpeng.getImaAdd2().length() > 0&&!linyunpeng_update.getImaAdd2().equals("")) {
						transBase64.generateImage(linyunpeng.getImaAdd2(), path +newNo + "ImaAdd2.jpg");
						linyunpeng.setImaAdd2("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaAdd2.jpg");
					}
					if (linyunpeng.getImaAdd3() != null && linyunpeng.getImaAdd3().length() > 0&&!linyunpeng_update.getImaAdd3().equals("")) {
						transBase64.generateImage(linyunpeng.getImaAdd3(), path +newNo + "ImaAdd3.jpg");
						linyunpeng.setImaAdd3("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaAdd3.jpg");
					}
					if (linyunpeng.getImaTouxiang() != null && linyunpeng.getImaTouxiang().length() > 0&&!linyunpeng_update.getImaTouxiang().equals("")) {
						transBase64.generateImage(linyunpeng.getImaTouxiang(), path +newNo + "ImaTouxiang.jpg");
						linyunpeng.setImaTouxiang("http://114.115.245.160/linyunpeng/images/" + newNo + "ImaTouxiang.jpg");
					}
				
				
					if (linyunpeng.getCropName() != null && linyunpeng.getCropName().length() > 0) {
						boolean flag = linyunpengService.update(linyunpeng, wrapper);
						logger.info("flag:" + (flag?"成功":"失败"));
					}
				} catch (Exception e) {
					logger.info("图片转码不成功");
					e.printStackTrace();
				}
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
