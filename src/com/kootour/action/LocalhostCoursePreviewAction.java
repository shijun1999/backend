//Auto Generated 

package com.kootour.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.beans.factory.annotation.Autowired;

import com.kootour.common.KooConst;
import com.kootour.common.KooUtil;
import com.kootour.mapper.entity.CourseDetailEntity;
import com.kootour.mapper.entity.CourseInExclusionEntity;
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.CourseScheduleEntity;
import com.kootour.mapper.entity.ExtraOptionEntity;
import com.kootour.mapper.entity.ScheduleOptionEntity;
import com.kootour.model.CourseInExclusionModel;
import com.kootour.model.ExtraOptionModel;
//import com.kootour.mapper.entity.CourseDetailEntity;
import com.kootour.model.LocalhostCoursePreviewModel;
import com.kootour.service.LocalhostCoursePreviewService;
import com.kootour.service.impl.LocalhostCoursePreviewServiceImpl;

@Results({ @Result(name = "gotobookSummary", value = "bookSummary!load", type = ServletActionRedirectResult.class),
		@Result(name = "gotochangedate", value = "calendar!load", type = ServletActionRedirectResult.class) })
public class LocalhostCoursePreviewAction extends LocalhostCoursePreviewModel {

	@Autowired(required = false)
	private LocalhostCoursePreviewService localhostCoursePreviewService = new LocalhostCoursePreviewServiceImpl();

//	@Autowired(required = false)
//	private CommonService commonService = new CommonServiceImpl();

	public String load() {
		String rtnStr = "success";

		String strSysdate = "20160712";

		String strLangId = "en";

		Map<String, Object> paraMap = new HashMap<String, Object>();
		CourseDetailEntity inCourseDetailEntity = copyEntityAction2Entity((LocalhostCoursePreviewModel) this);

		inCourseDetailEntity.setLangId(strLangId);
		inCourseDetailEntity.setTouristIdentiNo(inCourseDetailEntity.getCurTouristIdentiNo());

		CourseDetailEntity outCourseDetailEntity = new CourseDetailEntity();
		outCourseDetailEntity = localhostCoursePreviewService.load(inCourseDetailEntity, paraMap);

		copyEntity2EntityAction(outCourseDetailEntity);

		formatEntityAction();
		
		return rtnStr;
	}

	public void copyEntity2EntityAction(CourseDetailEntity tEntity) {

//		this.copyBaseEntity2Model(tEntity);

		if (tEntity.getLangId() == null) {
			setLangId("");
		} else {
			setLangId(tEntity.getLangId());
		}
		if (tEntity.getFavoriteIdentiNo() == null) {
			setFavoriteIdentiNo("");
		} else {
			setFavoriteIdentiNo(tEntity.getFavoriteIdentiNo());
		}
		if (tEntity.getTouristIdentiNo() == null) {
			setTouristIdentiNo("");
		} else {
			setTouristIdentiNo(tEntity.getTouristIdentiNo());
		}

		if (tEntity.getCourseIdentiNo() == null) {
			setCourseIdentiNo("");
		} else {
			setCourseIdentiNo(tEntity.getCourseIdentiNo());
		}
		if (tEntity.getLocalhostIdentiNo() == null) {
			setLocalhostIdentiNo("");
		} else {
			setLocalhostIdentiNo(tEntity.getLocalhostIdentiNo());
		}
		if (tEntity.getCourseType() == null) {
			setCourseType("");
		} else {
			setCourseType(tEntity.getCourseType());
		}
		if (tEntity.getFullName() == null) {
			setFullName("");
		} else {
			setFullName(tEntity.getFullName());
		}
		if (tEntity.getShortName() == null) {
			setShortName("");
		} else {
			setShortName(tEntity.getShortName());
		}
		if (tEntity.getIndexChar() == null) {
			setIndexChar("");
		} else {
			setIndexChar(tEntity.getIndexChar());
		}
		if (tEntity.getLocationKey() == null) {
			setLocationKey("");
		} else {
			setLocationKey(tEntity.getLocationKey());
		}
		if (tEntity.getSearchWord() == null) {
			setSearchWord("");
		} else {
			setSearchWord(tEntity.getSearchWord());
		}
		if (tEntity.getCourseContent() == null) {
			setCourseContent("");
		} else {
			setCourseContent(tEntity.getCourseContent());
		}
		if (tEntity.getAdditionalInfo() == null) {
			setAdditionalInfo("");
		} else {
			setAdditionalInfo(tEntity.getAdditionalInfo());
		}
		if (tEntity.getDuration() == null) {
			setDuration("");
		} else {
			setDuration(tEntity.getDuration());
		}
		if (tEntity.getDurationUnit() == null) {
			setDurationUnit("");
		} else {
			setDurationUnit(tEntity.getDurationUnit());
		}
		if (tEntity.getTourLocation() == null) {
			setTourLocation("");
		} else {
			setTourLocation(tEntity.getTourLocation());
		}
		if (tEntity.getMeetupLocation() == null) {
			setMeetupLocation("");
		} else {
			setMeetupLocation(tEntity.getMeetupLocation());
		}
		if (tEntity.getMaxTouristNum() == null) {
			setMaxTouristNum("");
		} else {
			setMaxTouristNum(String.valueOf(tEntity.getMaxTouristNum()));
		}
		if (tEntity.getMinTouristNum() == null) {
			setMinTouristNum("");
		} else {
			setMinTouristNum(String.valueOf(tEntity.getMinTouristNum()));
		}
		if (tEntity.getMoneyUnit() == null) {
			setMoneyUnit("");
		} else {
			setMoneyUnit(tEntity.getMoneyUnit());
		}
		if (tEntity.getPrice() == null) {
			setPrice("");
		} else {
			setPrice(String.valueOf(tEntity.getPrice()));
		}
		if (tEntity.getDiscountPrice() == null) {
			setDiscountPrice("");
		} else {
			setDiscountPrice(String.valueOf(tEntity.getDiscountPrice()));
		}
		if (tEntity.getUnitName() == null) {
			setUnitName("");
		} else {
			setUnitName(tEntity.getUnitName());
		}
		if (tEntity.getInfantFree() == null) {
			setInfantFree("");
		} else {
			setInfantFree(tEntity.getInfantFree());
		}
		if (tEntity.getWorkDay() == null) {
			setWorkDay("");
		} else {
			setWorkDay(tEntity.getWorkDay());
		}
		if (tEntity.getPersonOrGroup() == null) {
			setPersonOrGroup("");
		} else {
			setPersonOrGroup(tEntity.getPersonOrGroup());
		}
		if (tEntity.getPersonOrGroupText() == null) {
			setPersonOrGroupText("");
		} else {
			setPersonOrGroupText(tEntity.getPersonOrGroupText());
		}
		if (tEntity.getAdventure() == null) {
			setAdventure("");
		} else {
			setAdventure(tEntity.getAdventure());
		}
		if (tEntity.getCultureArts() == null) {
			setCultureArts("");
		} else {
			setCultureArts(tEntity.getCultureArts());
		}
		if (tEntity.getFestivalEvents() == null) {
			setFestivalEvents("");
		} else {
			setFestivalEvents(tEntity.getFestivalEvents());
		}
		if (tEntity.getFoodDrink() == null) {
			setFoodDrink("");
		} else {
			setFoodDrink(tEntity.getFoodDrink());
		}
		if (tEntity.getHistorical() == null) {
			setHistorical("");
		} else {
			setHistorical(tEntity.getHistorical());
		}
		if (tEntity.getLeisureSports() == null) {
			setLeisureSports("");
		} else {
			setLeisureSports(tEntity.getLeisureSports());
		}
		if (tEntity.getNatureRural() == null) {
			setNatureRural("");
		} else {
			setNatureRural(tEntity.getNatureRural());
		}
		if (tEntity.getNightlifeParty() == null) {
			setNightlifeParty("");
		} else {
			setNightlifeParty(tEntity.getNightlifeParty());
		}
		if (tEntity.getShoppingMarket() == null) {
			setShoppingMarket("");
		} else {
			setShoppingMarket(tEntity.getShoppingMarket());
		}
		if (tEntity.getOtherType1() == null) {
			setOtherType1("");
		} else {
			setOtherType1(tEntity.getOtherType1());
		}
		if (tEntity.getOtherType2() == null) {
			setOtherType2("");
		} else {
			setOtherType2(tEntity.getOtherType2());
		}
		if (tEntity.getOtherType3() == null) {
			setOtherType3("");
		} else {
			setOtherType3(tEntity.getOtherType3());
		}
		if (tEntity.getOkFlg() == null) {
			setOkFlg("");
		} else {
			setOkFlg(tEntity.getOkFlg());
		}
		if (tEntity.getStateDisp() == null) {
			setStateDisp("");
		} else {
			setStateDisp(tEntity.getStateDisp());
		}
		if (tEntity.getCityDisp() == null) {
			setCityDisp("");
		} else {
			setCityDisp(tEntity.getCityDisp());
		}
		if (tEntity.getUseLangId() == null) {
			setUseLangId("");
		} else {
			setUseLangId(tEntity.getUseLangId());
		}

		if (tEntity.getExtraOptionIDs() == null) {
			setExtraOptionIDs("");
		} else {
			setExtraOptionIDs(tEntity.getExtraOptionIDs());
		}

		List<CoursePictureEntity> tmpCoursePictureEntityList = new ArrayList<CoursePictureEntity>();
		for (CoursePictureEntity tmpVal : tEntity.getCoursePictureListDisp()) {
			tmpCoursePictureEntityList.add(tmpVal);
		}
		setCoursePictureListDisp(tmpCoursePictureEntityList);
		List<CourseScheduleEntity> tmpCourseScheduleEntityList = new ArrayList<CourseScheduleEntity>();
		for (CourseScheduleEntity tmpVal : tEntity.getCourseScheduleListDisp()) {
			tmpCourseScheduleEntityList.add(tmpVal);
		}
		setCourseScheduleListDisp(tmpCourseScheduleEntityList);

		List<ScheduleOptionEntity> tmpScheduleOptionEntityList = new ArrayList<ScheduleOptionEntity>();
		for (ScheduleOptionEntity tmpVal : tEntity.getScheduleOptionListDisp()) {
			tmpScheduleOptionEntityList.add(tmpVal);
		}
		setScheduleOptionListDisp(tmpScheduleOptionEntityList);
	
		List<String> tmpStringActionList2 = new ArrayList<String>();
		for (String tmpVal : tEntity.getScoreIconListDisp()) {
			tmpStringActionList2.add(tmpVal);
		}
		setScoreIconListDisp(tmpStringActionList2);

		List<String> tmpStringActionList3 = new ArrayList<String>();
		for (String tmpVal : tEntity.getNotWorkDays()) {
			tmpStringActionList3.add(tmpVal);
		}
		setNotWorkDays(tmpStringActionList3);

		List<String> tmpStringActionList4 = new ArrayList<String>();
		for (String tmpVal : tEntity.getTouristMinMaxList()) {
			tmpStringActionList4.add(tmpVal);
		}
		setTouristMinMaxList(tmpStringActionList4);

		List<String> tmpStringActionList5 = new ArrayList<String>();
		for (String tmpVal : tEntity.getTimeTable()) {
			tmpStringActionList5.add(tmpVal);
		}
		setTimeTable(tmpStringActionList5);

		if (tEntity.getScoreDisp() == null) {
			setScoreDisp("");
		} else {
			setScoreDisp(String.valueOf(tEntity.getScoreDisp()));
		}
		if (tEntity.getReviewNumDisp() == null) {
			setReviewNumDisp("");
		} else {
			setReviewNumDisp(String.valueOf(tEntity.getReviewNumDisp()));
		}
		if (tEntity.getLocalhostPictureDisp() == null) {
			setLocalhostPictureDisp("");
		} else {
			setLocalhostPictureDisp(tEntity.getLocalhostPictureDisp());
		}
		if (tEntity.getLocalhostFullNameDisp() == null) {
			setLocalhostFullNameDisp("");
		} else {
			setLocalhostFullNameDisp(tEntity.getLocalhostFullNameDisp());
		}
		if (tEntity.getLocalhostEmailDisp() == null) {
			setLocalhostEmailDisp("");
		} else {
			setLocalhostEmailDisp(tEntity.getLocalhostEmailDisp());
		}
		if (tEntity.getLocalhostMemoDisp() == null) {
			setLocalhostMemoDisp("");
		} else {
			setLocalhostMemoDisp(tEntity.getLocalhostMemoDisp());
		}
		if (tEntity.getWorkDatesDisp() == null) {
			setWorkDatesDisp("");
		} else {
			setWorkDatesDisp(tEntity.getWorkDatesDisp());
		}
		List<CourseInExclusionModel> tmpCourseInExclusionActionList3 = new ArrayList<CourseInExclusionModel>();
		for (CourseInExclusionEntity tmpVal : tEntity.getInclusionListDisp()) {
			CourseInExclusionAction tmpInclusionListDisp = new CourseInExclusionAction();
			tmpInclusionListDisp.copyEntity2EntityAction(tmpVal);
			tmpCourseInExclusionActionList3.add(tmpInclusionListDisp);
		}
		setInclusionListDisp(tmpCourseInExclusionActionList3);
		List<CourseInExclusionModel> tmpCourseInExclusionActionList4 = new ArrayList<CourseInExclusionModel>();
		for (CourseInExclusionEntity tmpVal : tEntity.getExclusionListDisp()) {
			CourseInExclusionAction tmpExclusionListDisp = new CourseInExclusionAction();
			tmpExclusionListDisp.copyEntity2EntityAction(tmpVal);
			tmpCourseInExclusionActionList4.add(tmpExclusionListDisp);
		}
		setExclusionListDisp(tmpCourseInExclusionActionList4);

		List<ExtraOptionModel> tmpExtraOptionActionList5 = new ArrayList<ExtraOptionModel>();
		for (ExtraOptionEntity tmpVal : tEntity.getExtraOptionListDisp()) {
			ExtraOptionAction tmpExtraOptionListDisp = new ExtraOptionAction();
			tmpExtraOptionListDisp.copyEntity2EntityAction(tmpVal);
			tmpExtraOptionActionList5.add(tmpExtraOptionListDisp);
		}
		setExtraOptionListDisp(tmpExtraOptionActionList5);

		if (tEntity.getCreateTime() == null) {
			setCreateTime("");
		} else {
			setCreateTime(KooUtil.date2String(tEntity.getCreateTime(), KooConst.ST_yyyyMMddHHmmss));
		}
		if (tEntity.getModifyTime() == null) {
			setModifyTime("");
		} else {
			setModifyTime(KooUtil.date2String(tEntity.getModifyTime(), KooConst.ST_yyyyMMddHHmmss));
		}
	}

	public CourseDetailEntity copyEntityAction2Entity(LocalhostCoursePreviewModel tCourseDetailModel) {
		CourseDetailEntity tEntity = new CourseDetailEntity();
		// set common info
//		tEntity.setCurTouristIdentiNo(this.getCurTouristIdentiNo());
//		tEntity.setCurDate(this.getCurDate());
//		tEntity.setSessionInfo(this.getSessionInfo());

		tEntity.setLangId(tCourseDetailModel.getLangId());
		tEntity.setFavoriteIdentiNo(tCourseDetailModel.getFavoriteIdentiNo());
		tEntity.setTouristIdentiNo(tCourseDetailModel.getTouristIdentiNo());
		tEntity.setCourseIdentiNo(tCourseDetailModel.getCourseIdentiNo());
		tEntity.setLocalhostIdentiNo(tCourseDetailModel.getLocalhostIdentiNo());
		tEntity.setCourseType(tCourseDetailModel.getCourseType());
		tEntity.setFullName(tCourseDetailModel.getFullName());
		tEntity.setShortName(tCourseDetailModel.getShortName());
		tEntity.setIndexChar(tCourseDetailModel.getIndexChar());
		tEntity.setLocationKey(tCourseDetailModel.getLocationKey());
		tEntity.setSearchWord(tCourseDetailModel.getSearchWord());
		tEntity.setCourseContent(tCourseDetailModel.getCourseContent());
		tEntity.setAdditionalInfo(tCourseDetailModel.getAdditionalInfo());
		tEntity.setDuration(tCourseDetailModel.getDuration());
		tEntity.setTourLocation(tCourseDetailModel.getTourLocation());
		tEntity.setMeetupLocation(tCourseDetailModel.getMeetupLocation());
		tEntity.setExtraOptionIDs(tCourseDetailModel.getExtraOptionIDs());
		tEntity.setReservationDate(tCourseDetailModel.getReservationDate());

		if (KooUtil.isNotInt(tCourseDetailModel.getMaxTouristNum())) {
			tEntity.setMaxTouristNum(null);
		} else {
			tEntity.setMaxTouristNum(Integer.parseInt(tCourseDetailModel.getMaxTouristNum()));
		}
		if (KooUtil.isNotInt(tCourseDetailModel.getMinTouristNum())) {
			tEntity.setMinTouristNum(null);
		} else {
			tEntity.setMinTouristNum(Integer.parseInt(tCourseDetailModel.getMinTouristNum()));
		}
		tEntity.setMoneyUnit(tCourseDetailModel.getMoneyUnit());
		if (KooUtil.isNotDouble(tCourseDetailModel.getPrice())) {
			tEntity.setPrice(null);
		} else {
			tEntity.setPrice(Double.parseDouble(tCourseDetailModel.getPrice()));
		}
		if (KooUtil.isNotDouble(tCourseDetailModel.getDiscountPrice())) {
			tEntity.setDiscountPrice(null);
		} else {
			tEntity.setDiscountPrice(Double.parseDouble(tCourseDetailModel.getDiscountPrice()));
		}
		tEntity.setUnitName(tCourseDetailModel.getUnitName());
		tEntity.setInfantFree(tCourseDetailModel.getInfantFree());
		tEntity.setWorkDay(tCourseDetailModel.getWorkDay());
		tEntity.setPersonOrGroup(tCourseDetailModel.getPersonOrGroup());
		tEntity.setPersonOrGroupText(tCourseDetailModel.getPersonOrGroupText());
		tEntity.setAdventure(tCourseDetailModel.getAdventure());
		tEntity.setCultureArts(tCourseDetailModel.getCultureArts());
		tEntity.setFestivalEvents(tCourseDetailModel.getFestivalEvents());
		tEntity.setFoodDrink(tCourseDetailModel.getFoodDrink());
		tEntity.setHistorical(tCourseDetailModel.getHistorical());
		tEntity.setLeisureSports(tCourseDetailModel.getLeisureSports());
		tEntity.setNatureRural(tCourseDetailModel.getNatureRural());
		tEntity.setNightlifeParty(tCourseDetailModel.getNightlifeParty());
		tEntity.setShoppingMarket(tCourseDetailModel.getShoppingMarket());
		tEntity.setOtherType1(tCourseDetailModel.getOtherType1());
		tEntity.setOtherType2(tCourseDetailModel.getOtherType2());
		tEntity.setOtherType3(tCourseDetailModel.getOtherType3());
		tEntity.setOkFlg(tCourseDetailModel.getOkFlg());
		tEntity.setStateDisp(tCourseDetailModel.getStateDisp());
		tEntity.setCityDisp(tCourseDetailModel.getCityDisp());
		tEntity.setUseLangId(tCourseDetailModel.getUseLangId());
		List<CoursePictureEntity> tmpCoursePictureEntityList = new ArrayList<CoursePictureEntity>();
		for (CoursePictureEntity tmpVal : tCourseDetailModel.getCoursePictureListDisp()) {
			tmpCoursePictureEntityList.add(tmpVal);
		}
		tEntity.setCoursePictureListDisp(tmpCoursePictureEntityList);
		List<String> tmpStringEntityList2 = new ArrayList<String>();
		for (String tmpVal : tCourseDetailModel.getScoreIconListDisp()) {
			tmpStringEntityList2.add(tmpVal);
		}
		tEntity.setScoreIconListDisp(tmpStringEntityList2);

		List<String> tmpStringEntityList3 = new ArrayList<String>();
		for (String tmpVal : tCourseDetailModel.getNotWorkDays()) {
			tmpStringEntityList3.add(tmpVal);
		}
		tEntity.setNotWorkDays(tmpStringEntityList3);

		List<String> tmpStringEntityList4 = new ArrayList<String>();
		for (String tmpVal : tCourseDetailModel.getTouristMinMaxList()) {
			tmpStringEntityList4.add(tmpVal);
		}
		tEntity.setTouristMinMaxList(tmpStringEntityList4);
		
		List<String> tmpStringEntityList5 = new ArrayList<String>();
		for (String tmpVal : tCourseDetailModel.getTimeTable()) {
			tmpStringEntityList5.add(tmpVal);
		}
		tEntity.setTimeTable(tmpStringEntityList5);

		
		if (KooUtil.isNotDouble(tCourseDetailModel.getScoreDisp())) {
			tEntity.setScoreDisp(null);
		} else {
			tEntity.setScoreDisp(Double.parseDouble(tCourseDetailModel.getScoreDisp()));
		}
		if (KooUtil.isNotInt(tCourseDetailModel.getReviewNumDisp())) {
			tEntity.setReviewNumDisp(null);
		} else {
			tEntity.setReviewNumDisp(Integer.parseInt(tCourseDetailModel.getReviewNumDisp()));
		}
		tEntity.setLocalhostPictureDisp(tCourseDetailModel.getLocalhostPictureDisp());
		tEntity.setWorkDatesDisp(tCourseDetailModel.getWorkDatesDisp());
		List<CourseInExclusionEntity> tmpCourseInExclusionEntityList3 = new ArrayList<CourseInExclusionEntity>();
//		for (CourseInExclusionModel tmpVal : tCourseDetailModel.getInclusionListDisp()) {
//			CourseInExclusionEntity tmpCourseInExclusion = new CourseInExclusionEntity();
//			CourseInExclusionAction tmpAction = (CourseInExclusionAction) tmpVal;
//			tmpCourseInExclusion = tmpAction.copyEntityAction2Entity(tmpVal);
//			tmpCourseInExclusionEntityList3.add(tmpCourseInExclusion);
//		}
		tEntity.setInclusionListDisp(tmpCourseInExclusionEntityList3);
		List<CourseInExclusionEntity> tmpCourseInExclusionEntityList4 = new ArrayList<CourseInExclusionEntity>();
//		for (CourseInExclusionModel tmpVal : tCourseDetailModel.getExclusionListDisp()) {
//			CourseInExclusionEntity tmpCourseInExclusion = new CourseInExclusionEntity();
//			CourseInExclusionAction tmpAction = (CourseInExclusionAction) tmpVal;
//			tmpCourseInExclusion = tmpAction.copyEntityAction2Entity(tmpVal);
//			tmpCourseInExclusionEntityList4.add(tmpCourseInExclusion);
//		}
		tEntity.setExclusionListDisp(tmpCourseInExclusionEntityList4);

		List<ExtraOptionEntity> tmpExtraOptionEntityEntityList5 = new ArrayList<ExtraOptionEntity>();
//		for (ExtraOptionModel tmpVal : this.getExtraOptionListDisp()) {
//			ExtraOptionEntity tmpExtraOptionEntity = new ExtraOptionEntity();
//			ExtraOptionAction tmpAction = (ExtraOptionAction) tmpVal;
//			tmpExtraOptionEntity = tmpAction.copyEntityAction2Entity(tmpVal);
//			tmpExtraOptionEntityEntityList5.add(tmpExtraOptionEntity);
//		}

		tEntity.setTouristNum(tCourseDetailModel.getTouristNum());
		tEntity.setBgnTime(tCourseDetailModel.getBgnTime());
		if (KooUtil.isNotDate(tCourseDetailModel.getCreateTime())) {
			tEntity.setCreateTime(null);
		} else {
			tEntity.setCreateTime(KooUtil.string2Date(tCourseDetailModel.getCreateTime(), KooConst.ST_yyyyMMddHHmmss));
		}
		if (KooUtil.isNotDate(tCourseDetailModel.getModifyTime())) {
			tEntity.setModifyTime(null);
		} else {
			tEntity.setModifyTime(KooUtil.string2Date(tCourseDetailModel.getModifyTime(), KooConst.ST_yyyyMMddHHmmss));
		}
		return tEntity;
	}

	public void formatEntityAction() {

		setDuration(KooUtil.formatDuration(getDuration()));
		setDurationUnit(KooUtil.formatDurationUnit(getDurationUnit()));

		this.setUseLangId(KooUtil.formatLang(this.getUseLangId()));
		
//		List<CourseCommentModel> courseCommentList = new ArrayList<>();
//		for (CourseCommentModel tmpVal : this.getCourseCommentListDisp()) {
//			String dispDate = KooUtil.formatDate(tmpVal.getCommentDate());
//			tmpVal.setCommentDate(dispDate);
//			courseCommentList.add(tmpVal);
//		}

		List<ExtraOptionModel> extraOptionList = new ArrayList<>();
		for (ExtraOptionModel tmpVal : this.getExtraOptionListDisp()) {
			tmpVal.setExtraUnit(KooUtil.formatDurationUnit(tmpVal.getExtraUnit()));
			tmpVal.setExtraTime(KooUtil.formatDuration(tmpVal.getExtraTime()));
			if ("".equals(tmpVal.getExtraUnit())) {
				tmpVal.setExtraUnit(KooConst.ST_DURATION_UNIT_NAME_HOUR);
			}

			tmpVal.setExtraPrice(KooUtil.formatMoney("$", tmpVal.getExtraPrice()));

			extraOptionList.add(tmpVal);
		}
		this.setExtraOptionListDisp(extraOptionList);

	}


}
