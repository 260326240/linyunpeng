package com.linyunpeng.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChenZeQiang
 * @since 2019-01-20
 */
public class Linyunpeng_update extends Model<Linyunpeng_update> {

	private static final long serialVersionUID = 1L;

	private String cropchangename;

	private String cropName;

	private Double cropPrice;

	private Integer cropKucun;

	private Double cropYunfei;

	private String cropFahuodi;

	private String cropUsername;

	private String cropDescribe;

	private String imaAdd1;

	private String imaAdd2;

	private String imaAdd3;

	private String imaTouxiang;

	public String getCropchangename() {
		return cropchangename;
	}

	public void setCropchangename(String cropchangename) {
		this.cropchangename = cropchangename;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public Double getCropPrice() {
		return cropPrice;
	}

	public void setCropPrice(Double cropPrice) {
		this.cropPrice = cropPrice;
	}

	public Integer getCropKucun() {
		return cropKucun;
	}

	public void setCropKucun(Integer cropKucun) {
		this.cropKucun = cropKucun;
	}

	public Double getCropYunfei() {
		return cropYunfei;
	}

	public void setCropYunfei(Double cropYunfei) {
		this.cropYunfei = cropYunfei;
	}

	public String getCropFahuodi() {
		return cropFahuodi;
	}

	public void setCropFahuodi(String cropFahuodi) {
		this.cropFahuodi = cropFahuodi;
	}

	public String getCropUsername() {
		return cropUsername;
	}

	public void setCropUsername(String cropUsername) {
		this.cropUsername = cropUsername;
	}

	public String getCropDescribe() {
		return cropDescribe;
	}

	public void setCropDescribe(String cropDescribe) {
		this.cropDescribe = cropDescribe;
	}

	public String getImaAdd1() {
		return imaAdd1;
	}

	public void setImaAdd1(String imaAdd1) {
		this.imaAdd1 = imaAdd1;
	}

	public String getImaAdd2() {
		return imaAdd2;
	}

	public void setImaAdd2(String imaAdd2) {
		this.imaAdd2 = imaAdd2;
	}

	public String getImaAdd3() {
		return imaAdd3;
	}

	public void setImaAdd3(String imaAdd3) {
		this.imaAdd3 = imaAdd3;
	}

	public String getImaTouxiang() {
		return imaTouxiang;
	}

	public void setImaTouxiang(String imaTouxiang) {
		this.imaTouxiang = imaTouxiang;
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}

	@Override
	public String toString() {
		return "Linyunpeng_update [cropchangename=" + cropchangename + ", cropName=" + cropName + ", cropPrice="
				+ cropPrice + ", cropKucun=" + cropKucun + ", cropYunfei=" + cropYunfei + ", cropFahuodi=" + cropFahuodi
				+ ", cropUsername=" + cropUsername + ", cropDescribe=" + cropDescribe + ", imaAdd1=" + imaAdd1
				+ ", imaAdd2=" + imaAdd2 + ", imaAdd3=" + imaAdd3 + ", imaTouxiang=" + imaTouxiang + "]";
	}

	
}
