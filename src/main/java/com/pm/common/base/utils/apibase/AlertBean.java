package com.pm.common.base.utils.apibase;

/**
 * 弹窗bean
 * 
 * @author liangbo
 * @date 2015年5月21日 下午3:38:27
 */
public class AlertBean {

	private Integer alertType; // 默认为0,表示不弹窗

	private String alertTitle; // 弹窗标题

	private String alertMessage; // 弹窗内容

	public AlertBean() {
		this.setAlertType(0);
	}

	public AlertBean(String alertTitle, String alertMessage) {
		this.setAlertType(1);
		this.setAlertTitle(alertTitle);
		this.setAlertMessage(alertMessage);
	}
	
	public AlertBean(int alertType, String alertTitle, String alertMessage) {
		this.setAlertType(alertType);
		this.setAlertTitle(alertTitle);
		this.setAlertMessage(alertMessage);
	}

	public Integer getAlertType() {
		return alertType;
	}

	public void setAlertType(Integer alertType) {
		this.alertType = alertType;
	}

	public String getAlertTitle() {
		return alertTitle;
	}

	public void setAlertTitle(String alertTitle) {
		this.alertTitle = alertTitle;
	}

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
}
