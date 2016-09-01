//Auto Generated 

package com.kootour.model;

import java.util.ArrayList;
import java.util.List;

import com.kootour.action.BaseAction;
import com.kootour.common.PulldownValueBean;
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.CourseScheduleEntity;
import com.kootour.mapper.entity.ExtraOptionEntity;
import com.kootour.mapper.entity.ScheduleOptionEntity;

public class LocalhostCoursePreviewModel extends BaseAction {
	private String langId;
	private String touristIdentiNo;
	private String courseIdentiNo;
	private String localhostIdentiNo;
	private String courseType;
	private String fullName;
	private String shortName;
	private String indexChar;
	private String locationKey;
	private String searchWord;
	private String courseContent;
	private String additionalInfo;
	private String duration;
	private String durationUnit;
	private String tourLocation;
	private String meetupLocation;
	private String maxTouristNum;
	private String minTouristNum;
	private String moneyUnit;
	private String price;
	private String discountPrice;
	private String unitName;
	private String infantFree;
	private String workDay;
	private String personOrGroup;
	private String personOrGroupText;
	private String adventure;
	private String cultureArts;
	private String festivalEvents;
	private String foodDrink;
	private String historical;
	private String leisureSports;
	private String natureRural;
	private String nightlifeParty;
	private String shoppingMarket;
	private String otherType1;
	private String otherType2;
	private String otherType3;
	private String okFlg;
	private String stateDisp;
	private String cityDisp;
	private String useLangId;
	private List<CoursePictureEntity> coursePictureListDisp = new ArrayList<CoursePictureEntity>();
		private List<CourseScheduleEntity> courseScheduleListDisp = new ArrayList<CourseScheduleEntity>();
	private List<ScheduleOptionEntity> scheduleOptionListDisp = new ArrayList<ScheduleOptionEntity>();
	private List<String> scoreIconListDisp = new ArrayList<String>();
	private List<String> notWorkDays = new ArrayList<String>();
	private List<String> touristMinMaxList = new ArrayList<String>();
	private List<String> timeTable = new ArrayList<String>();
	private String scoreDisp;
	private String reviewNumDisp;
	private String localhostPictureDisp;
	private String localhostFullNameDisp;
	private String localhostEmailDisp;
	private String localhostMemoDisp;
	private String workDatesDisp;
	private List<CourseInExclusionModel> inclusionListDisp = new ArrayList<CourseInExclusionModel>();
	private List<CourseInExclusionModel> exclusionListDisp = new ArrayList<CourseInExclusionModel>();
	private String touristNum;
	private String bgnTime;
	private String reservationDate;
	private List<ExtraOptionModel> extraOptionListDisp = new ArrayList<ExtraOptionModel>();
	private String createTime;
	private String modifyTime;
	private String favoriteIdentiNo;
	private String extraOptionIDs;

	public String getExtraOptionIDs() {
		return extraOptionIDs;
	}

	public void setExtraOptionIDs(String extraOptionIDs) {
		this.extraOptionIDs = extraOptionIDs;
	}

	public String getFavoriteIdentiNo() {
		return favoriteIdentiNo;
	}

	public void setFavoriteIdentiNo(String favoriteIdentiNo) {
		this.favoriteIdentiNo = favoriteIdentiNo;
	}

	public String getCourseIdentiNo() {
		return courseIdentiNo;
	}

	public void setCourseIdentiNo(String courseIdentiNo) {
		this.courseIdentiNo = courseIdentiNo;
	}

	public String getLocalhostIdentiNo() {
		return localhostIdentiNo;
	}

	public void setLocalhostIdentiNo(String localhostIdentiNo) {
		this.localhostIdentiNo = localhostIdentiNo;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getIndexChar() {
		return indexChar;
	}

	public void setIndexChar(String indexChar) {
		this.indexChar = indexChar;
	}

	public String getLocationKey() {
		return locationKey;
	}

	public void setLocationKey(String locationKey) {
		this.locationKey = locationKey;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDurationUnit() {
		return durationUnit;
	}

	public void setDurationUnit(String durationUnit) {
		this.durationUnit = durationUnit;
	}

	public String getTourLocation() {
		return tourLocation;
	}

	public void setTourLocation(String tourLocation) {
		this.tourLocation = tourLocation;
	}

	public String getMeetupLocation() {
		return meetupLocation;
	}

	public void setMeetupLocation(String meetupLocation) {
		this.meetupLocation = meetupLocation;
	}

	public String getMaxTouristNum() {
		return maxTouristNum;
	}

	public void setMaxTouristNum(String maxTouristNum) {
		this.maxTouristNum = maxTouristNum;
	}

	public String getMinTouristNum() {
		return minTouristNum;
	}

	public void setMinTouristNum(String minTouristNum) {
		this.minTouristNum = minTouristNum;
	}

	public String getMoneyUnit() {
		return moneyUnit;
	}

	public void setMoneyUnit(String moneyUnit) {
		this.moneyUnit = moneyUnit;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getInfantFree() {
		return infantFree;
	}

	public void setInfantFree(String infantFree) {
		this.infantFree = infantFree;
	}

	public String getWorkDay() {
		return workDay;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	public String getPersonOrGroup() {
		return personOrGroup;
	}

	public void setPersonOrGroup(String personOrGroup) {
		this.personOrGroup = personOrGroup;
	}

	public String getPersonOrGroupText() {
		return personOrGroupText;
	}

	public void setPersonOrGroupText(String personOrGroupText) {
		this.personOrGroupText = personOrGroupText;
	}

	public String getAdventure() {
		return adventure;
	}

	public void setAdventure(String adventure) {
		this.adventure = adventure;
	}

	public String getCultureArts() {
		return cultureArts;
	}

	public void setCultureArts(String cultureArts) {
		this.cultureArts = cultureArts;
	}

	public String getFestivalEvents() {
		return festivalEvents;
	}

	public void setFestivalEvents(String festivalEvents) {
		this.festivalEvents = festivalEvents;
	}

	public String getFoodDrink() {
		return foodDrink;
	}

	public void setFoodDrink(String foodDrink) {
		this.foodDrink = foodDrink;
	}

	public String getHistorical() {
		return historical;
	}

	public void setHistorical(String historical) {
		this.historical = historical;
	}

	public String getLeisureSports() {
		return leisureSports;
	}

	public void setLeisureSports(String leisureSports) {
		this.leisureSports = leisureSports;
	}

	public String getNatureRural() {
		return natureRural;
	}

	public void setNatureRural(String natureRural) {
		this.natureRural = natureRural;
	}

	public String getNightlifeParty() {
		return nightlifeParty;
	}

	public void setNightlifeParty(String nightlifeParty) {
		this.nightlifeParty = nightlifeParty;
	}

	public String getShoppingMarket() {
		return shoppingMarket;
	}

	public void setShoppingMarket(String shoppingMarket) {
		this.shoppingMarket = shoppingMarket;
	}

	public String getOtherType1() {
		return otherType1;
	}

	public void setOtherType1(String otherType1) {
		this.otherType1 = otherType1;
	}

	public String getOtherType2() {
		return otherType2;
	}

	public void setOtherType2(String otherType2) {
		this.otherType2 = otherType2;
	}

	public String getOtherType3() {
		return otherType3;
	}

	public void setOtherType3(String otherType3) {
		this.otherType3 = otherType3;
	}

	public String getOkFlg() {
		return okFlg;
	}

	public void setOkFlg(String okFlg) {
		this.okFlg = okFlg;
	}

	public String getStateDisp() {
		return stateDisp;
	}

	public void setStateDisp(String stateDisp) {
		this.stateDisp = stateDisp;
	}

	public String getCityDisp() {
		return cityDisp;
	}

	public void setCityDisp(String cityDisp) {
		this.cityDisp = cityDisp;
	}

	public String getUseLangId() {
		return useLangId;
	}

	public void setUseLangId(String useLangId) {
		this.useLangId = useLangId;
	}

	public List<CoursePictureEntity> getCoursePictureListDisp() {
		return coursePictureListDisp;
	}

	public void setCoursePictureListDisp(List<CoursePictureEntity> coursePictureListDisp) {
		this.coursePictureListDisp = coursePictureListDisp;
	}

	public List<CourseScheduleEntity> getCourseScheduleListDisp() {
		return courseScheduleListDisp;
	}

	public void setCourseScheduleListDisp(List<CourseScheduleEntity> courseScheduleListDisp) {
		this.courseScheduleListDisp = courseScheduleListDisp;
	}

	public List<ScheduleOptionEntity> getScheduleOptionListDisp() {
		return scheduleOptionListDisp;
	}

	public void setScheduleOptionListDisp(List<ScheduleOptionEntity> scheduleOptionListDisp) {
		this.scheduleOptionListDisp = scheduleOptionListDisp;
	}

	public List<String> getScoreIconListDisp() {
		return scoreIconListDisp;
	}

	public void setScoreIconListDisp(List<String> scoreIconListDisp) {
		this.scoreIconListDisp = scoreIconListDisp;
	}

	public String getScoreDisp() {
		return scoreDisp;
	}

	public void setScoreDisp(String scoreDisp) {
		this.scoreDisp = scoreDisp;
	}

	public String getReviewNumDisp() {
		return reviewNumDisp;
	}

	public void setReviewNumDisp(String reviewNumDisp) {
		this.reviewNumDisp = reviewNumDisp;
	}

	public String getLocalhostPictureDisp() {
		return localhostPictureDisp;
	}

	public void setLocalhostPictureDisp(String localhostPictureDisp) {
		this.localhostPictureDisp = localhostPictureDisp;
	}

	public String getLocalhostFullNameDisp() {
		return localhostFullNameDisp;
	}

	public void setLocalhostFullNameDisp(String localhostFullNameDisp) {
		this.localhostFullNameDisp = localhostFullNameDisp;
	}

	public String getLocalhostEmailDisp() {
		return localhostEmailDisp;
	}

	public void setLocalhostEmailDisp(String localhostEmailDisp) {
		this.localhostEmailDisp = localhostEmailDisp;
	}

	public String getLocalhostMemoDisp() {
		return localhostMemoDisp;
	}

	public void setLocalhostMemoDisp(String localhostMemoDisp) {
		this.localhostMemoDisp = localhostMemoDisp;
	}

	public String getWorkDatesDisp() {
		return workDatesDisp;
	}

	public void setWorkDatesDisp(String workDatesDisp) {
		this.workDatesDisp = workDatesDisp;
	}

	public List<CourseInExclusionModel> getInclusionListDisp() {
		return inclusionListDisp;
	}

	public void setInclusionListDisp(List<CourseInExclusionModel> inclusionListDisp) {
		this.inclusionListDisp = inclusionListDisp;
	}

	public List<CourseInExclusionModel> getExclusionListDisp() {
		return exclusionListDisp;
	}

	public void setExclusionListDisp(List<CourseInExclusionModel> exclusionListDisp) {
		this.exclusionListDisp = exclusionListDisp;
	}

	public String getTouristNum() {
		return touristNum;
	}

	public void setTouristNum(String touristNum) {
		this.touristNum = touristNum;
	}

	public String getBgnTime() {
		return bgnTime;
	}

	public void setBgnTime(String bgnTime) {
		this.bgnTime = bgnTime;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public List<ExtraOptionModel> getExtraOptionListDisp() {
		return extraOptionListDisp;
	}

	public void setExtraOptionListDisp(List<ExtraOptionModel> extraOptionListDisp) {
		this.extraOptionListDisp = extraOptionListDisp;
	}

	public String getLangId() {
		return langId;
	}

	public void setLangId(String langId) {
		this.langId = langId;
	}

	public String getTouristIdentiNo() {
		return touristIdentiNo;
	}

	public void setTouristIdentiNo(String touristIdentiNo) {
		this.touristIdentiNo = touristIdentiNo;
	}

	public List<String> getNotWorkDays() {
		return notWorkDays;
	}

	public void setNotWorkDays(List<String> notWorkDays) {
		this.notWorkDays = notWorkDays;
	}

	public List<String> getTouristMinMaxList() {
		return touristMinMaxList;
	}

	public void setTouristMinMaxList(List<String> touristMinMaxList) {
		this.touristMinMaxList = touristMinMaxList;
	}

	public List<String> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(List<String> timeTable) {
		this.timeTable = timeTable;
	}

}
