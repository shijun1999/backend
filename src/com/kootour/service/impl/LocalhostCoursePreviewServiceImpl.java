package com.kootour.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.common.ErrorInfo;
import com.kootour.common.KooConst;
import com.kootour.common.KooUtil;
import com.kootour.mapper.entity.CourseCommentEntity;
import com.kootour.mapper.entity.CourseDetailEntity;
import com.kootour.mapper.entity.CourseEntity;
import com.kootour.mapper.entity.CourseInExclusionEntity;
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.ExtraOptionEntity;
import com.kootour.mapper.entity.FavoriteEntity;
import com.kootour.service.CourseScheduleService;
import com.kootour.service.LocalhostCoursePreviewService;
import com.kootour.service4db.CourseCommentService4DB;
import com.kootour.service4db.CourseInExclusionService4DB;
import com.kootour.service4db.CoursePictureService4DB;
import com.kootour.service4db.CourseScheduleService4DB;
import com.kootour.service4db.CourseService4DB;
import com.kootour.service4db.ExtraOptionService4DB;
import com.kootour.service4db.FavoriteService4DB;
import com.kootour.service4db.LocalhostService4DB;
import com.kootour.service4db.ScheduleOptionService4DB;
import com.kootour.service4db.SequenceService4DB;
import com.kootour.service4db.TouristService4DB;

@Configuration
@Service
public class LocalhostCoursePreviewServiceImpl implements LocalhostCoursePreviewService {
	@Autowired
	private CourseService4DB courseService4DB;
	@Autowired
	private LocalhostService4DB localhostService4DB;
	@Autowired
	private CourseCommentService4DB courseCommentService4DB;
	@Autowired
	private TouristService4DB touristService4DB;
	@Autowired
	private CoursePictureService4DB coursePictureService4DB;
	@Autowired
	private CourseScheduleService4DB courseScheduleService4DB;
	@Autowired
	private ScheduleOptionService4DB scheduleOptionService4DB;
	@Autowired
	private CourseInExclusionService4DB courseInExclusionService4DB;
	@Autowired(required = false)
	private ExtraOptionService4DB extraOptionService4DB;
	
	@Autowired(required = false)
	private CourseScheduleService courseScheduleService = new CourseScheduleServiceImpl();

	@Autowired(required = false)
	private SequenceService4DB sequenceService4DB;
	@Autowired
	private FavoriteService4DB favoriteService4DB;

	private static Logger logger = Logger.getLogger(LocalhostCoursePreviewServiceImpl.class);

	@Override
	public CourseDetailEntity load(CourseDetailEntity courseDetailEntity, Map<String, Object> paraMap) {
		CourseDetailEntity rtnResult = new CourseDetailEntity();
		rtnResult=courseDetailEntity;
		List<ErrorInfo> tList = new ArrayList<ErrorInfo>();
//		String strSysDate = courseDetailEntity.getSessionInfo().getCurDate();
		CourseEntity courseParamEntity = new CourseEntity();
		courseParamEntity.setLangId(courseDetailEntity.getLangId());
		courseParamEntity.setCourseIdentiNo(courseDetailEntity.getCourseIdentiNo());

		CourseEntity courseEntity = courseService4DB.selectByPK(courseParamEntity);

		CoursePictureEntity coursePictureParamEntity = new CoursePictureEntity();
		coursePictureParamEntity.setLangId(courseDetailEntity.getLangId());
		coursePictureParamEntity.setCourseIdentiNo(courseDetailEntity.getCourseIdentiNo());
		coursePictureParamEntity.setLocalhostIdentiNo(courseDetailEntity.getLocalhostIdentiNo());
		List<CoursePictureEntity> coursePictureEntityList = coursePictureService4DB
				.selectByCondition(coursePictureParamEntity);
		if (coursePictureEntityList.isEmpty()) {
			ErrorInfo tErrorInfo = new ErrorInfo();
			tErrorInfo.setItemName(KooConst.INFO_MSG_PARAM003 + "[selectByCondition]");
			tErrorInfo.setErrKbn(KooConst.INT_INFO_KBN);
			tErrorInfo.setErrMsg(KooConst.INFO_MSG_002);
			tErrorInfo.setDispOrder(1);
			tList.add(tErrorInfo);
		} else {

			for (int i = 0; i < coursePictureEntityList.size(); i++) {
				coursePictureEntityList.get(i)
						.setFullPath(KooConst.LT_UPLOAD_IMAGES_PATH + coursePictureEntityList.get(i).getFullPath());
			}
			rtnResult.setCoursePictureListDisp(coursePictureEntityList);
		}

		rtnResult = convertToCourseDetailEntity(courseEntity, rtnResult);
		CourseInExclusionEntity courseInExclusionParamEntity = new CourseInExclusionEntity();
		courseInExclusionParamEntity.setLangId(courseDetailEntity.getLangId());
		courseInExclusionParamEntity.setCourseIdentiNo(courseDetailEntity.getCourseIdentiNo());
		List<CourseInExclusionEntity> courseInExclusionEntityList = courseInExclusionService4DB
				.selectByCondition(courseInExclusionParamEntity);

		if (courseInExclusionEntityList.isEmpty()) {
			ErrorInfo tErrorInfo = new ErrorInfo();
			tErrorInfo.setItemName(KooConst.INFO_MSG_PARAM017 + "[selectByCondition]");
			tErrorInfo.setErrKbn(KooConst.INT_INFO_KBN);
			tErrorInfo.setErrMsg(KooConst.INFO_MSG_002);
			tErrorInfo.setDispOrder(1);
			tList.add(tErrorInfo);
		} else {

			List<CourseInExclusionEntity> exclusionListDisp = new ArrayList<CourseInExclusionEntity>();
			List<CourseInExclusionEntity> inclusionListDisp = new ArrayList<CourseInExclusionEntity>();
			CourseInExclusionEntity courseInExclusionEntity = new CourseInExclusionEntity();
			for (int i = 0; i < courseInExclusionEntityList.size(); i++) {
				courseInExclusionEntity = courseInExclusionEntityList.get(i);

				if (courseInExclusionEntity.getInExclusionType().equals(KooConst.ST_COURSE_INCLUSION)) {

					inclusionListDisp.add(courseInExclusionEntity);
				} else {
					exclusionListDisp.add(courseInExclusionEntity);
				}
			}

			rtnResult.setExclusionListDisp(exclusionListDisp);
			rtnResult.setInclusionListDisp(inclusionListDisp);
		}
		rtnResult.setTouristIdentiNo(courseDetailEntity.getTouristIdentiNo());
		rtnResult.setStateDisp(courseDetailEntity.getStateDisp());
		rtnResult.setCityDisp(courseDetailEntity.getCityDisp());
		rtnResult.setWorkDatesDisp(courseDetailEntity.getWorkDatesDisp());

		ExtraOptionEntity extraOptionParamEntity = new ExtraOptionEntity();
		extraOptionParamEntity.setLangId(courseDetailEntity.getLangId());
		extraOptionParamEntity.setCourseIdentiNo(courseDetailEntity.getCourseIdentiNo());
		List<ExtraOptionEntity> extraOptionList = extraOptionService4DB.selectByCondition(extraOptionParamEntity);
		rtnResult.setExtraOptionListDisp(extraOptionList);

		FavoriteEntity favoriteParamEntity = new FavoriteEntity();
		favoriteParamEntity.setTouristIdentiNo(courseDetailEntity.getTouristIdentiNo());
		favoriteParamEntity.setObjIdentiNo(courseDetailEntity.getCourseIdentiNo());
		favoriteParamEntity.setDelFlg(KooConst.ST_NOT_DEL_FLG);
		List<FavoriteEntity> favoriteEntityList = favoriteService4DB.selectByCondition(favoriteParamEntity);
		if (favoriteEntityList != null && favoriteEntityList.size()> 0) {
			rtnResult.setFavoriteIdentiNo(favoriteEntityList.get(0).getFavoriteIdentiNo());
		}else{
			rtnResult.setFavoriteIdentiNo("");
		}
		
		CourseCommentEntity courseCommentParamEntity = new CourseCommentEntity();
		courseCommentParamEntity.setLangId(courseEntity.getLangId());
		courseCommentParamEntity.setCourseIdentiNo(courseEntity.getCourseIdentiNo());

		List<CourseCommentEntity> courseCommentEntityList = courseCommentService4DB
				.selectByCondition(courseCommentParamEntity);

		if (courseCommentEntityList.isEmpty()) {

			ErrorInfo tErrorInfo = new ErrorInfo();
			tErrorInfo.setItemName(KooConst.INFO_MSG_PARAM011 + "[selectByCondition]");
			tErrorInfo.setErrKbn(KooConst.INT_INFO_KBN);
			tErrorInfo.setErrMsg(KooConst.INFO_MSG_002);
			tErrorInfo.setDispOrder(1);
			tList.add(tErrorInfo);
		} else {

			double dTotalScore = 0.0;
			for (int i = 0; i < courseCommentEntityList.size(); i++) {

				double dScore = courseCommentEntityList.get(i).getScore();
				dTotalScore = dTotalScore + dScore;
				List<String> iconList = KooUtil.getStarName(dScore);
				courseCommentEntityList.get(i).setScoreIconListDisp(iconList);
				
			}
			rtnResult.setCourseCommentListDisp(courseCommentEntityList);

			double dScore = dTotalScore / courseCommentEntityList.size();
			List<String> iconList = KooUtil.getStarName(dScore);
			rtnResult.setScoreIconListDisp(iconList);
			rtnResult.setReviewNumDisp(courseCommentEntityList.size());
		}

		return (rtnResult);
	}

	private CourseDetailEntity convertToCourseDetailEntity(CourseEntity courseEntity, CourseDetailEntity tEntity) {

		tEntity.setLangId(courseEntity.getLangId());
		tEntity.setCourseIdentiNo(courseEntity.getCourseIdentiNo());
		tEntity.setLocalhostIdentiNo(courseEntity.getLocalhostIdentiNo());
		tEntity.setCourseType(courseEntity.getCourseType());
		tEntity.setFullName(courseEntity.getFullName());
		tEntity.setShortName(courseEntity.getShortName());
		tEntity.setIndexChar(courseEntity.getIndexChar());
		tEntity.setDuration(courseEntity.getDuration().toString());
		tEntity.setDurationUnit(courseEntity.getDurationUnit());
		tEntity.setLocationKey(courseEntity.getLocationKey());
		tEntity.setSearchWord(courseEntity.getSearchWord());
//		tEntity.setInclusionListDisp(courseEntity.getInclusionListDisp());
//		tEntity.setExclusionListDisp(courseEntity.getExclusionListDisp());
		tEntity.setCourseContent(courseEntity.getCourseContent());
		tEntity.setAdditionalInfo(courseEntity.getAdditionalInfo());
		tEntity.setTourLocation(courseEntity.getTourLocation());
		tEntity.setMeetupLocation(courseEntity.getMeetupLocation());
		tEntity.setMoneyUnit(courseEntity.getMoneyUnit());
//		tEntity.setWorkDay(courseEntity.getWorkDay());
		tEntity.setPersonOrGroup(courseEntity.getPersonOrGroup());
		if (courseEntity.getPersonOrGroup().equals(KooConst.STR_TYPE_DIV_PERSON)) {
			tEntity.setPersonOrGroupText(KooConst.STR_TYPE_PERSON);
		} else {
			tEntity.setPersonOrGroupText(KooConst.STR_TYPE_GROUP);
		}
		tEntity.setMaxTouristNum(courseEntity.getMaxTouristNum());
		tEntity.setMinTouristNum(courseEntity.getMinTouristNum());
		tEntity.setAdventure(courseEntity.getAdventure());
		tEntity.setCultureArts(courseEntity.getCultureArts());
		tEntity.setFestivalEvents(courseEntity.getFestivalEvents());
		tEntity.setFoodDrink(courseEntity.getFoodDrink());
		tEntity.setHistorical(courseEntity.getHistorical());
		tEntity.setLeisureSports(courseEntity.getLeisureSports());
		tEntity.setNatureRural(courseEntity.getNatureRural());
		tEntity.setNightlifeParty(courseEntity.getNightlifeParty());
		tEntity.setShoppingMarket(courseEntity.getShoppingMarket());
		tEntity.setOtherType1(courseEntity.getOtherType1());
		tEntity.setOtherType2(courseEntity.getOtherType2());
		tEntity.setOtherType3(courseEntity.getOtherType3());
		tEntity.setOkFlg(courseEntity.getOkFlg());
		tEntity.setUseLangId(courseEntity.getUseLangId());
//		tEntity.setReviewNumDisp(courseEntity.getReviewNumDisp());
		tEntity.setCreateTime(courseEntity.getCreateTime());
		tEntity.setModifyTime(courseEntity.getModifyTime());
//		tEntity.setCoursePictureListDisp(courseEntity.getCoursePictureListDisp());
		return tEntity;
	}
}
