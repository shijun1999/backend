package com.kootour.common;

public class PulldownValueBean {

	public PulldownValueBean(String key, String value) {
		super();
		this.key = key;
		this.value = value;

	}

	String key;
	String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {

		// return "PulldownValueBean [key=" + key + ", value=" + value + "]";
		return key;

	}

	public boolean eqauls(Object obj) {
		if (obj == null) {
			return false;
		}
		PulldownValueBean actuel = null;
		if (obj instanceof PulldownValueBean) {
			actuel = (PulldownValueBean) obj;
		}

		if (!key.equals(actuel.getKey()) || !value.equals(actuel.value)) {
			return false;
		}
		return true;

	}

}
