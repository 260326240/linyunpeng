package com.linyunpeng.util;

import com.linyunpeng.model.Linyunpeng;
import com.linyunpeng.model.Linyunpeng_update;

public class copy_class {
	public static Linyunpeng copy_linyunpeng(Linyunpeng_update linyunpeng_update) {
		Linyunpeng linyunpeng = new Linyunpeng();
		linyunpeng.setCropDescribe(linyunpeng_update.getCropDescribe());
		linyunpeng.setCropFahuodi(linyunpeng_update.getCropFahuodi());
		linyunpeng.setCropKucun(linyunpeng_update.getCropKucun());
		linyunpeng.setCropName(linyunpeng_update.getCropName());
		linyunpeng.setCropPrice(linyunpeng_update.getCropPrice());
		linyunpeng.setCropUsername(linyunpeng_update.getCropUsername());
		linyunpeng.setCropYunfei(linyunpeng_update.getCropYunfei());
		//if(linyunpeng_update.getImaAdd1()!=null&&linyunpeng_update.getImaAdd1().length()>10)
		linyunpeng.setImaAdd1(linyunpeng_update.getImaAdd1());
		//if(linyunpeng_update.getImaAdd2()!=null&&linyunpeng_update.getImaAdd2().length()>10)
		linyunpeng.setImaAdd2(linyunpeng_update.getImaAdd2());
		//if(linyunpeng_update.getImaAdd3()!=null&&linyunpeng_update.getImaAdd3().length()>10)
		linyunpeng.setImaAdd3(linyunpeng_update.getImaAdd3());
		//if(linyunpeng_update.getImaTouxiang()!=null&&linyunpeng_update.getImaTouxiang().length()>10)
		linyunpeng.setImaTouxiang(linyunpeng_update.getImaTouxiang());
		return linyunpeng;
	}
}
