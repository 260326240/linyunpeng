package linyunpeng;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.linyunpeng.model.Linyunpeng;
import com.linyunpeng.util.NullStringToEmptyAdapterFactory;

public class test {
	private static final Object String = null;

	//Gson json 转bean测试
	public static void main(String[] args) {
	
		String jsonStr1 = "{\r\n" + 
				"        \"cropName\": \"的身份感到十分\",\r\n" + 
				"        \"cropPrice\": null,\r\n" + 
				"        \"cropKucun\": null,\r\n" + 
				"        \"cropYunfei\": null,\r\n" + 
				"        \"cropFahuodi\": \"\",\r\n" + 
				"        \"cropUsername\": null,\r\n" + 
				"        \"cropDescribe\": \"\",\r\n" + 
				"        \"imaAdd1\": \"http://114.115.245.26:8080/images/linyunpeng/20190107152905ImaAdd1.jpg\",\r\n" + 
				"        \"imaAdd2\": \"\",\r\n" + 
				"        \"imaAdd3\": \"\",\r\n" + 
				"        \"imaTouxiang\": \"\"\r\n" + 
				"    }";
	String jsonStr = "{\"cropName\":\"啦啦啦啦啦\",\"cropPrice\":\"\",\"cropKucun\":\"\",\"cropYunfei\":\"\",\"cropFahuodi\":\"\",\"cropUsername\":\"\",\"cropDescribe\":\"\",\"imaAdd1\":\"\",\"imaAdd2\":\"\",\"imaAdd3\":\"\",\"imaTouxiang\":\"\"}";
	String jsonStr2="{\"cropName\":\"啦啦啦啦啦\",\"cropPrice\":\"\",\"cropKucun\":\"\",\"cropYunfei\":\"\",\"cropFahuodi\":\"\",\"cropUsername\":\"\",\"cropDescribe\":\"\",\"imaAdd1\":\"\",\"imaAdd2\":\"\",\"imaAdd3\":\"\",\"imaTouxiang\":\"\"}\r\n" + 
			"";
	String jsonStr3="{\"cropName\":\"啦啦啦啦啦\",\"cropPrice\":null,\"cropKucun\":null,\"cropYunfei\":null,\"cropFahuodi\":null,\"cropUsername\":null,\"cropDescribe\":null,\"imaAdd1\":null,\"imaAdd2\":null,\"imaAdd3\":null,\"imaTouxiang\":null}\r\n" + 
			"";
//	Gson gson = new GsonBuilder()
//	        .registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory())
//	        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//	        .create();
	GsonBuilder gsonBuilder = new GsonBuilder();
//	gsonBuilder.registerTypeAdapter(String.class, String);
	Gson gson = gsonBuilder.create();
    Linyunpeng p = gson.fromJson(jsonStr3,Linyunpeng.class);
    System.out.println("---->jsonStr convert javaBean " + p.toString());
//	jsonStr=jsonStr.replaceAll("\\\"\\\"","null");
//	System.out.println(jsonStr);
	}

}
