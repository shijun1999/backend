package com.kootour.common;

public class ErrorInfo {

	// Name of item in form
	private String itemName;
	// Error or information ID (defind in message_kootour.properties )
	private String errMsg;
	// Error[INT_ERROR_KBN] or Information[INT_INFO_KBN]
	private int errKbn;
	// The order to dislpay
	private int dispOrder;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public int getErrKbn() {
		return errKbn;
	}
	public void setErrKbn(int errKbn) {
		this.errKbn = errKbn;
	}
	public int getDispOrder() {
		return dispOrder;
	}
	public void setDispOrder(int dispOrder) {
		this.dispOrder = dispOrder;
	}
}
