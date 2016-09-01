package com.kootour.common;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

public class KooUtil {
	public static String date2String(java.util.Date date, String pattern) {

		if ((date == null) || (pattern == null) || pattern.isEmpty()) {
			return null;
		}
		String formatString = null;

		formatString = new SimpleDateFormat(pattern).format(date);

		return (formatString);
	}

	public static Date string2Date(String date, String pattern) {

		if ((date == null) || (pattern == null) || pattern.isEmpty()) {
			return null;
		}
		Date formatedDate = null;

		try {
			formatedDate = new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			return null;
		}
		return (formatedDate);
	}

	public static boolean isNotNull(String tStr) {

		if ((tStr == null) || tStr.isEmpty()) {
			return false;
		}
		return (true);
	}
	public static boolean isNotNull(Double dPattern) {

		if (dPattern == null) {
			return false;
		}
		return (true);
	}
	public static boolean isNotDate(String tStr) {

		if (tStr == null || tStr.isEmpty()) {
			return (true);
		} else {
			try {

				DateUtils.parseDateStrictly(tStr, new String[]{KooConst.ST_yyyyMMdd});
			} catch (ParseException e) {
				return (true);
			}
			return (false);
		}
	}

	public static boolean isNotInt(String tStr) {

		return (!NumberUtils.isNumber(tStr));
	}

	public static boolean isNotDouble(String tStr) {

		return (!NumberUtils.isNumber(tStr));
	}

	public static boolean isTooLargeDouble(String tStr, int tSize) {
		int dotIdx = tStr.indexOf(".");
		return (dotIdx > tSize);
	}

	public static boolean isTooLargeInt(String tStr, int tSize) {

		return ((tStr.length() > tSize));
	}

	public static boolean isTooLargeString(String tStr, int tSize) {

		return ((tStr.length() > tSize));
	}

	public static boolean isTooLargeInt(int tItn, int tSize) {
		String tStr = String.valueOf(tItn);
		return ((tStr.length() > tSize));
	}

	public static boolean isTooLargeDouble(Double tDouble, int tSize) {
		String tStr = String.valueOf(tDouble);
		int dotIdx = tStr.indexOf(".");
		return (dotIdx > tSize);
	}
	
	public static List<String> getStarName(Double score) {
		List<String> starList = new ArrayList<String>();
		if (score >= 4) {
			starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			if (score - 4 >= 0.75) {
				starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			} else if (score - 4 >= 0.5) {
				starList.add(KooConst.STR_IMAGES_PATH + "star_50.png");
			} else {
				starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			}
		} else if (score >= 3) {
			starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			if (score - 3 >= 0.75) {
				starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			} else if (score - 3 >= 0.5) {
				starList.add(KooConst.STR_IMAGES_PATH + "star_50.png");
			} else {
				starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			}
			starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
		} else if (score >= 2) {
			starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			if (score - 2 >= 0.75) {
				starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			} else if (score - 2 >= 0.5) {
				starList.add(KooConst.STR_IMAGES_PATH + "star_50.png");
			} else {
				starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			}
			starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
		} else if (score >= 1) {
			starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			if (score - 1 >= 0.75) {
				starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			} else if (score - 1 >= 0.5) {
				starList.add(KooConst.STR_IMAGES_PATH + "star_50.png");
			} else {
				starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			}
			starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
		} else if (score >= 0) {
			if (score >= 0.75) {
				starList.add(KooConst.STR_IMAGES_PATH + "star_100.png");
			} else if (score >= 0.5) {
				starList.add(KooConst.STR_IMAGES_PATH + "star_50.png");
			} else {
				starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			}
			starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
			starList.add(KooConst.STR_IMAGES_PATH + "star_0.png");
		}
		return starList;
	}
	
	public static String formatDuration(String tDuration) {
		String retVal = "";

		DecimalFormat df1 = new DecimalFormat("###.##");
		retVal = df1.format(Double.parseDouble(tDuration));
		return (retVal);
	}

	public static String formatDurationUnit(String tDurationUnit) {
		String retVal = "";

		switch (tDurationUnit) {
		case KooConst.ST_DURATION_UNIT_DAY:
			retVal = KooConst.ST_DURATION_UNIT_NAME_DAY;
			break;
		case KooConst.ST_DURATION_UNIT_HOUR:
			retVal = KooConst.ST_DURATION_UNIT_NAME_HOUR;
			break;
		case KooConst.ST_DURATION_UNIT_MINUTE:
			retVal = KooConst.ST_DURATION_UNIT_NAME_MINUTE;
			break;
		}
		return (retVal);
	}
	public static String formatLang(String tLang) {

		String strLang ="";
		String[] usedLanArr=tLang.split(";");
		for (String t:usedLanArr){
			if (strLang.length()==0){
				strLang=convertLangName(t);
			}else{
				strLang= strLang +"&"+convertLangName(t);
			}
		}
		return (strLang);

	}

	public static String convertLangName(String tLang) {

		String strLang ="English";
		switch (tLang) {
		case "en":
			strLang = "English";
			break;
		case "zh":
			strLang = "Chinese";
			break;
		case "ja":
			strLang = "Japanese";
			break;
		default:
			strLang = "English";
			break;			
		}
		return (strLang);

	}

	public static String formatMoney(String tUnitName, String tValStr) {
		String retVal = "";
		if (tValStr == null) {
			retVal = "";
		} else {
			int dotIdx = tValStr.indexOf(".");
			if (dotIdx < 1) {
				retVal = tUnitName + tValStr;
			} else {
				retVal = tUnitName + tValStr.substring(0, dotIdx);
			}

		}
		return (retVal);
	}


}
