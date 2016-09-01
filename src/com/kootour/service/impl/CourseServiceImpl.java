package com.kootour.service.impl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kootour.common.BeanUtil;
import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.CourseEntity;
import com.kootour.mapper.entity.CourseInExclusionEntity;
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.CourseScheduleEntity;
import com.kootour.mapper.entity.ExtraOptionEntity;
import com.kootour.mapper.entity.LocationMstEntity;
import com.kootour.mapper.entity.ScheduleOptionEntity;
import com.kootour.model.BaseModel;
import com.kootour.model.CustomizeExtraModel;
import com.kootour.model.LocalhostCourseModel;
import com.kootour.model.UploadImageModel;
import com.kootour.service.CourseService;
import com.kootour.service4db.CourseInExclusionService4DB;
import com.kootour.service4db.CoursePictureService4DB;
import com.kootour.service4db.CourseScheduleService4DB;
import com.kootour.service4db.CourseService4DB;
import com.kootour.service4db.ExtraOptionService4DB;
import com.kootour.service4db.LocationMstService4DB;
import com.kootour.service4db.ScheduleOptionService4DB;
import com.kootour.service4db.SequenceService4DB;
import com.kootour.transfer.CourseTransfer;

@Transactional
@Configuration
@Service
public class CourseServiceImpl implements CourseService {

	@Resource
	CourseService4DB courseService4DB;

	@Resource
	CourseScheduleService4DB courseScheduleService4DB;

	@Resource
	ScheduleOptionService4DB scheduleOptionService4DB;

	@Resource
	CoursePictureService4DB coursePictureService4DB;

	@Resource
	ExtraOptionService4DB extraOptionService4DB;

	@Resource
	CourseInExclusionService4DB courseInExclusionService4DB;
	
	@Resource
	LocationMstService4DB locationMstService4DB;

	@Resource
	SequenceService4DB sequenceService4DB;

	@Override
	public KootourMessage save(Map<String, Object> paraMap) {
		String[] ignoreArray = {KooConst.LT_IGNORE_KEY_CREATE_TIME, KooConst.LT_IGNORE_KEY_MODIFY_TIME};
		LocalhostCourseModel inModelLocalhostCourseEntity = (LocalhostCourseModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		UploadImageModel inModelUploadImageEntity = (UploadImageModel) paraMap.get(KooConst.LT_IN_PARAM_UPLOAD_IMAGE_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			CourseEntity inDbCourseEntity = new CourseEntity();
			BeanUtil.copyProperties(inDbCourseEntity, inModelLocalhostCourseEntity, ignoreArray);
			inDbCourseEntity.setCourseIdentiNo(sequenceService4DB.createSequence(KooConst.ST_COURSE));
			inDbCourseEntity.setCourseCode(StringUtils.EMPTY);
			inDbCourseEntity.setLocalhostIdentiNo(inModelLocalhostCourseEntity.getLocalhostEntity().getLocalhostIdentiNo());
			inDbCourseEntity.setFullName(inModelLocalhostCourseEntity.getFullName());
			inDbCourseEntity.setCourseType(inModelLocalhostCourseEntity.getPersonOrGroup());
			inDbCourseEntity.setShortName(StringUtils.EMPTY);
			inDbCourseEntity.setIndexChar(inModelLocalhostCourseEntity.getFullName().substring(0, 1).toUpperCase());
			//TODO location key
			inDbCourseEntity.setLocationKey("$" + inModelLocalhostCourseEntity.getTourLocation() + "$");
			//TODO serach word
			inDbCourseEntity.setSearchWord(StringUtils.EMPTY);
			inDbCourseEntity.setAdditionalInfo(inDbCourseEntity.getAdditionalInfo());
			//TODO money unit
			inDbCourseEntity.setMoneyUnit("$");

			if (inDbCourseEntity.getAdventure() == "false") {
				inDbCourseEntity.setAdventure(StringUtils.EMPTY);
			} else {
				inDbCourseEntity.setAdventure("1");
			}
			if (inDbCourseEntity.getCultureArts() == "false") {
				inDbCourseEntity.setCultureArts(StringUtils.EMPTY);
			} else {
				inDbCourseEntity.setCultureArts("1");
			}
			if (inDbCourseEntity.getFestivalEvents() == "false") {
				inDbCourseEntity.setFestivalEvents(StringUtils.EMPTY);
			} else {
				inDbCourseEntity.setFestivalEvents("1");
			}
			if (inDbCourseEntity.getFoodDrink() == "false") {
				inDbCourseEntity.setFoodDrink(StringUtils.EMPTY);
			} else {
				inDbCourseEntity.setFoodDrink("1");
			}
			if (inDbCourseEntity.getHistorical() == "false") {
				inDbCourseEntity.setHistorical(StringUtils.EMPTY);
			} else {
				inDbCourseEntity.setHistorical("1");
			}
			if (inDbCourseEntity.getLeisureSports() == "false") {
				inDbCourseEntity.setLeisureSports(StringUtils.EMPTY);
			} else {
				inDbCourseEntity.setLeisureSports("1");
			}
			if (inDbCourseEntity.getNatureRural() == "false") {
				inDbCourseEntity.setNatureRural(StringUtils.EMPTY);
			} else {
				inDbCourseEntity.setNatureRural("1");
			}
			if (inDbCourseEntity.getNightlifeParty() == "false") {
				inDbCourseEntity.setNightlifeParty(StringUtils.EMPTY);
			} else {
				inDbCourseEntity.setNightlifeParty("1");
			}
			if (inDbCourseEntity.getShoppingMarket() == "false") {
				inDbCourseEntity.setShoppingMarket(StringUtils.EMPTY);
			} else {
				inDbCourseEntity.setShoppingMarket("1");
			}
			inDbCourseEntity.setOtherType1("0");
			inDbCourseEntity.setOtherType2("0");
			inDbCourseEntity.setOtherType3("0");
			//TODO ok flg
			inDbCourseEntity.setOkFlg(KooConst.LT_OK_FLG_Y);
			inDbCourseEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			courseService4DB.insertOne(inDbCourseEntity);

			String courseInExclusionIdentiNo = sequenceService4DB.createSequence(KooConst.ST_COURSE_IN_EXCLUSION);
			int seq = 0;
			for (String include : inModelLocalhostCourseEntity.getInclusions()) {
				if (StringUtils.isNotEmpty(include)) {
					CourseInExclusionEntity inDbCourseInExclusionEntity = new CourseInExclusionEntity();
					inDbCourseInExclusionEntity.setLangId(inDbCourseEntity.getLangId());
					inDbCourseInExclusionEntity.setCourseInExclusionIdentiNo(courseInExclusionIdentiNo);
					inDbCourseInExclusionEntity.setSequesNo(seq++);
					inDbCourseInExclusionEntity.setCourseIdentiNo(inDbCourseEntity.getCourseIdentiNo());
					inDbCourseInExclusionEntity.setInExclusionType("1");
					inDbCourseInExclusionEntity.setInExclusion(include);
					inDbCourseInExclusionEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
					courseInExclusionService4DB.insertOne(inDbCourseInExclusionEntity);
				}
			}
			for (String exclude: inModelLocalhostCourseEntity.getExclusions()) {
				if (StringUtils.isNotEmpty(exclude)) {
					CourseInExclusionEntity inDbCourseInExclusionEntity = new CourseInExclusionEntity();
					inDbCourseInExclusionEntity.setLangId(inDbCourseEntity.getLangId());
					inDbCourseInExclusionEntity.setCourseInExclusionIdentiNo(courseInExclusionIdentiNo);
					inDbCourseInExclusionEntity.setSequesNo(seq++);
					inDbCourseInExclusionEntity.setCourseIdentiNo(inDbCourseEntity.getCourseIdentiNo());
					inDbCourseInExclusionEntity.setInExclusionType("0");
					inDbCourseInExclusionEntity.setInExclusion(exclude);
					inDbCourseInExclusionEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
					courseInExclusionService4DB.insertOne(inDbCourseInExclusionEntity);
				}
			}

			List<String> uploadImageNameList = inModelUploadImageEntity.getUploadedFileName();
			if (uploadImageNameList != null && uploadImageNameList.size() > 0) {
				for (String fileName : uploadImageNameList) {
			        CoursePictureEntity inDbCoursePictureEntity = new CoursePictureEntity();
			        inDbCoursePictureEntity.setLangId(inModelLocalhostCourseEntity.getLangId());
			        inDbCoursePictureEntity.setLocalhostIdentiNo(inModelLocalhostCourseEntity.getLocalhostEntity().getLocalhostIdentiNo());
			        inDbCoursePictureEntity.setCoursePictureIdentiNo(sequenceService4DB.createSequence(KooConst.ST_COURSEPICTURE));
			        inDbCoursePictureEntity.setFullName(fileName);
			        inDbCoursePictureEntity.setFullPath(fileName);
			        //TODO
			        inDbCoursePictureEntity.setType("1");
			        inDbCoursePictureEntity.setMemo("dummy memo");
			        //TODO
			        inDbCoursePictureEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
			        inDbCoursePictureEntity.setCourseIdentiNo(inDbCourseEntity.getCourseIdentiNo());
			        coursePictureService4DB.insertOne(inDbCoursePictureEntity);
				}
			}

			List<String> uploadedImageCdList = inModelLocalhostCourseEntity.getUploadedCoursePictureIdentiNoList();
			if (uploadedImageCdList != null && uploadedImageCdList.size() > 0) {
				for (String imageCd : uploadedImageCdList) {
			        CoursePictureEntity inDbCoursePictureEntity = new CoursePictureEntity();
			        inDbCoursePictureEntity.setLangId(inModelLocalhostCourseEntity.getLangId());
			        inDbCoursePictureEntity.setCoursePictureIdentiNo(imageCd);

			        List<CoursePictureEntity> outDbCoursePictureEntity = coursePictureService4DB.selectByPK(inDbCoursePictureEntity);
			        for (CoursePictureEntity entity : outDbCoursePictureEntity) {
			        	entity.setCourseIdentiNo(inDbCourseEntity.getCourseIdentiNo());
			        	entity.setCoursePictureIdentiNo(sequenceService4DB.createSequence(KooConst.ST_COURSEPICTURE));
			        	coursePictureService4DB.insertOne(entity);
			        }
				}
			}

			ScheduleOptionEntity inDbScheduleOptionEntity = new ScheduleOptionEntity();
			inDbScheduleOptionEntity.setLangId(inModelLocalhostCourseEntity.getLangId());
			inDbScheduleOptionEntity.setCourseIdentiNo(inDbCourseEntity.getCourseIdentiNo());
			inDbScheduleOptionEntity.setScheduleOptionIdentiNo(sequenceService4DB.createSequence(KooConst.ST_SCHEDULE_OPTION));
			inDbScheduleOptionEntity.setCourseScheuleName(inModelLocalhostCourseEntity.getCourseScheduleName());
			inDbScheduleOptionEntity.setBgnDate(inModelLocalhostCourseEntity.getBgnDate());
			inDbScheduleOptionEntity.setEndDate(inModelLocalhostCourseEntity.getEndDate());
			inDbScheduleOptionEntity.setWorkDay(inModelLocalhostCourseEntity.getWorkDay());
			//TODO infant Free
			inDbScheduleOptionEntity.setInfantFree("1");
			//TODO promotion flg
			inDbScheduleOptionEntity.setPromotionFLg(StringUtils.EMPTY);
			//TODO promotion bgn date
			inDbScheduleOptionEntity.setPromotionBgnDate(StringUtils.EMPTY);
			//TODO promotion end date
			inDbScheduleOptionEntity.setPromotionEndDate(StringUtils.EMPTY);
			//TODO about dicount
			inDbScheduleOptionEntity.setDiscountFlg("0");
			inDbScheduleOptionEntity.setDiscountPercent(0.0d);
			inDbScheduleOptionEntity.setDiscountValue(0.0d);

			inDbScheduleOptionEntity.setLargeDiscountFlg(StringUtils.isEmpty(inModelLocalhostCourseEntity.getLargeGroupLimit())? "0" : inModelLocalhostCourseEntity.getLargeGroupLimit());
			inDbScheduleOptionEntity.setLargeDiscountType("0");
			inDbScheduleOptionEntity.setLargeDiscountPercent(StringUtils.isEmpty(inModelLocalhostCourseEntity.getLargeDiscountPercent())? 0d : Double.parseDouble(inModelLocalhostCourseEntity.getLargeDiscountPercent()));
			inDbScheduleOptionEntity.setLargeDiscountValue(StringUtils.isEmpty(inModelLocalhostCourseEntity.getLargeDiscountValue())? 0d : Double.parseDouble(inModelLocalhostCourseEntity.getLargeDiscountValue()));

			inDbScheduleOptionEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			inDbScheduleOptionEntity.setStartHour(inModelLocalhostCourseEntity.getStartHour());
			inDbScheduleOptionEntity.setLatestStartHour(inModelLocalhostCourseEntity.getLatestStartHour());
			inDbScheduleOptionEntity.setRetailPrice(Double.parseDouble(inModelLocalhostCourseEntity.getRetailPrice()));
			inDbScheduleOptionEntity.setPrice(Double.parseDouble(inModelLocalhostCourseEntity.getPrice()));
			inDbScheduleOptionEntity.setCommision(Double.parseDouble(inModelLocalhostCourseEntity.getCommision()));
			scheduleOptionService4DB.insertOne(inDbScheduleOptionEntity);

			List<CustomizeExtraModel> extraList = inModelLocalhostCourseEntity.getExtra();
			if (extraList != null && extraList.size() > 0) {
				for (CustomizeExtraModel extra : extraList) {
					ExtraOptionEntity extraOptionEntity = new ExtraOptionEntity();
					extraOptionEntity.setLangId(inModelLocalhostCourseEntity.getLangId());
					extraOptionEntity.setExtraOptionIdentiNo(sequenceService4DB.createSequence(KooConst.ST_EXTRA_OPTION));
					extraOptionEntity.setCourseIdentiNo(inDbCourseEntity.getCourseIdentiNo());
					extraOptionEntity.setLocalhostIdentiNo(inModelLocalhostCourseEntity.getLocalhostEntity().getLocalhostIdentiNo());
					extraOptionEntity.setScheduleOptionIdentiNo(inDbScheduleOptionEntity.getScheduleOptionIdentiNo());
					//TODO disp order
					extraOptionEntity.setDispOrder(0);
					extraOptionEntity.setExtraOptionName(extra.getExtraOptionName());
					extraOptionEntity.setExtraPrice(Double.parseDouble(extra.getExtraPrice()));
					extraOptionEntity.setExtraTime(Double.parseDouble(extra.getExtraTime()));
					//TODO extra unit
					extraOptionEntity.setExtraUnit(StringUtils.EMPTY);
					extraOptionEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

					extraOptionService4DB.insertOne(extraOptionEntity);
				}
			}

			//insert course schedule with work day
			String bgnDateStr = inDbScheduleOptionEntity.getBgnDate();
			String endDateStr = inDbScheduleOptionEntity.getEndDate();
			String workDay = inDbScheduleOptionEntity.getWorkDay();
			List<String> workDuration = getDatesBetweenTwoDate(bgnDateStr, endDateStr);
			for (String dateStr : workDuration) {

				CourseScheduleEntity inDbCourseScheduleEntity = new CourseScheduleEntity();
				inDbCourseScheduleEntity.setLangId(inDbCourseEntity.getLangId());
				inDbCourseScheduleEntity.setCourseScheduleIdentiNo(sequenceService4DB.createSequence(KooConst.ST_COURSESCHEDULE));
				inDbCourseScheduleEntity.setCourseIdentiNo(inDbCourseEntity.getCourseIdentiNo());
				inDbCourseScheduleEntity.setLocalhostIdentiNo(inDbCourseEntity.getLocalhostIdentiNo());
				inDbCourseScheduleEntity.setScheduleOptionIdentiNo(inDbScheduleOptionEntity.getScheduleOptionIdentiNo());

				inDbCourseScheduleEntity.setWorkDate(dateStr);
				String status = KooConst.ST_NOT_WORK;

				DayOfWeek dw = LocalDate.parse(dateStr, DateTimeFormatter.BASIC_ISO_DATE).getDayOfWeek();
				status = workDay.contains(String.valueOf(dw.ordinal())) ? KooConst.LT_STATUS_FLG_Y : KooConst.LT_STATUS_FLG_N;
				inDbCourseScheduleEntity.setStatus(status);
				inDbCourseScheduleEntity.setMemo(StringUtils.EMPTY);
				inDbCourseScheduleEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

				courseScheduleService4DB.insertOne(inDbCourseScheduleEntity);
			}

//			List<CustomizeScheduleOptionModel> inModelScheduleOptionEntityList = inModelLocalhostCourseEntity.getSchedules();
//			for (CustomizeScheduleOptionModel inModelScheduleOptionEntity : inModelScheduleOptionEntityList) {
//				ScheduleOptionEntity inDbScheduleOptionEntity = new ScheduleOptionEntity();
//				inDbScheduleOptionEntity.setLangId(inModelLocalhostCourseEntity.getLangId());
//				inDbScheduleOptionEntity.setCourseIdentiNo(inDbCourseEntity.getCourseIdentiNo());
//				inDbScheduleOptionEntity.setCourseScheuleName(inModelScheduleOptionEntity.getCourseScheduleName());
//				inDbScheduleOptionEntity.setBgnDate(inModelScheduleOptionEntity.getBgnDate());
//				inDbScheduleOptionEntity.setEndDate(inModelScheduleOptionEntity.getEndDate());
//				inDbScheduleOptionEntity.setWorkDay(inModelScheduleOptionEntity.getWorkDay());
//				//TODO infant Free
//				inDbScheduleOptionEntity.setInfantFree("1");
//				//TODO promotion flg
//				inDbScheduleOptionEntity.setPromotionFLg(StringUtils.EMPTY);
//				//TODO promotion bgn date
//				inDbScheduleOptionEntity.setPromotionBgnDate(StringUtils.EMPTY);
//				//TODO promotion end date
//				inDbScheduleOptionEntity.setPromotionEndDate(StringUtils.EMPTY);
//				//TODO about dicount
//				inDbScheduleOptionEntity.setDiscountFlg("0");
//				inDbScheduleOptionEntity.setDiscountPercent(0.0d);
//				inDbScheduleOptionEntity.setDiscountValue(0.0d);
//
//				inDbScheduleOptionEntity.setLargeDiscountFlg(StringUtils.isEmpty(inModelScheduleOptionEntity.getLargeGroupLimit()) ? "0" : "1");
//				inDbScheduleOptionEntity.setLargeDiscountType(StringUtils.isEmpty(inModelScheduleOptionEntity.getLargeDiscountPercent()) ? "0" : "1");
//				inDbScheduleOptionEntity.setLargeDiscountPercent(StringUtils.isEmpty(inModelScheduleOptionEntity.getLargeDiscountPercent())? 0d : Double.parseDouble(inModelScheduleOptionEntity.getLargeDiscountPercent()));
//				inDbScheduleOptionEntity.setLargeDiscountValue(StringUtils.isEmpty(inModelScheduleOptionEntity.getLargeDiscountValue())? 0d : Double.parseDouble(inModelScheduleOptionEntity.getLargeDiscountValue()));
//
//				inDbScheduleOptionEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
//
//				List<CustomizeTimeModel> inTimeList = inModelScheduleOptionEntity.getTime();
//				for (CustomizeTimeModel time : inTimeList) {
//					inDbScheduleOptionEntity.setScheduleOptionIdentiNo(sequenceService4DB.createSequence(KooConst.ST_SCHEDULE_OPTION));
//					inDbScheduleOptionEntity.setStartHour(time.getStartHour());
//					inDbScheduleOptionEntity.setLatestStartHour(time.getLatestStartHour());
//					inDbScheduleOptionEntity.setRetailPrice(Double.parseDouble(time.getRetailPrice()));
//					inDbScheduleOptionEntity.setPrice(Double.parseDouble(time.getPrice()));
//					inDbScheduleOptionEntity.setCommision(Double.parseDouble(time.getCommision()));
//					scheduleOptionService4DB.insertOne(inDbScheduleOptionEntity);
//				}
//
//				List<CustomizeExtraModel> extraList = inModelScheduleOptionEntity.getExtra();
//				if (extraList != null && extraList.size() > 0) {
//					for (CustomizeExtraModel extra : extraList) {
//						ExtraOptionEntity extraOptionEntity = new ExtraOptionEntity();
//						extraOptionEntity.setLangId(inModelLocalhostCourseEntity.getLangId());
//						extraOptionEntity.setExtraOptionIdentiNo(sequenceService4DB.createSequence(KooConst.ST_EXTRA_OPTION));
//						extraOptionEntity.setCourseIdentiNo(inDbCourseEntity.getCourseIdentiNo());
//						extraOptionEntity.setLocalhostIdentiNo(inModelLocalhostCourseEntity.getLocalhostEntity().getLocalhostIdentiNo());
//						extraOptionEntity.setScheduleOptionIdentiNo(inDbScheduleOptionEntity.getScheduleOptionIdentiNo());
//						//TODO disp order
//						extraOptionEntity.setDispOrder(0);
//						extraOptionEntity.setExtraOptionName(extra.getExtraOptionName());
//						extraOptionEntity.setExtraPrice(Double.parseDouble(extra.getExtraPrice()));
//						extraOptionEntity.setExtraTime(Double.parseDouble(extra.getExtraTime()));
//						//TODO extra unit
//						extraOptionEntity.setExtraUnit(StringUtils.EMPTY);
//
//						extraOptionService4DB.insertOne(extraOptionEntity);
//					}
//				}
//			}
			retMsg.setHasError(false);
			retMsg.setMessage("Success");
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}
	
	@Override
	public List<CoursePictureEntity> findCoursePictures(Map<String, Object> paraMap) {
		
		List<CoursePictureEntity> resultList = new ArrayList<CoursePictureEntity>(); 
		
		String[] ignoreArray = {KooConst.LT_IGNORE_KEY_CREATE_TIME, KooConst.LT_IGNORE_KEY_MODIFY_TIME};

		CourseTransfer result = new CourseTransfer ();
		CourseEntity inDbCourseEntity = new CourseEntity();

		BaseModel inModelLocalhostCourseEntity = (BaseModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		try {
			BeanUtil.copyProperties(inDbCourseEntity, inModelLocalhostCourseEntity, ignoreArray);
			inDbCourseEntity.setLocalhostIdentiNo(inModelLocalhostCourseEntity.getLocalhostEntity().getLocalhostIdentiNo());

			CourseEntity outCourseEntity = courseService4DB.selectByPK(inDbCourseEntity);
			if (outCourseEntity != null) {
				result.setCourseEntity(outCourseEntity);

				String langId = outCourseEntity.getLangId();
				String courseCd = outCourseEntity.getCourseIdentiNo();

				CoursePictureEntity inCoursePictureEntity = new CoursePictureEntity();
				inCoursePictureEntity.setLangId(langId);
				inCoursePictureEntity.setCourseIdentiNo(courseCd);
				inCoursePictureEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
				resultList = coursePictureService4DB.selectByCondition(inCoursePictureEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public KootourMessage editCourseInit(Map<String, Object> paraMap) {
		String[] ignoreArray = {KooConst.LT_IGNORE_KEY_CREATE_TIME, KooConst.LT_IGNORE_KEY_MODIFY_TIME};

		CourseTransfer result = new CourseTransfer ();
		CourseEntity inDbCourseEntity = new CourseEntity();

		BaseModel inModelLocalhostCourseEntity = (BaseModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			BeanUtil.copyProperties(inDbCourseEntity, inModelLocalhostCourseEntity, ignoreArray);
			inDbCourseEntity.setLocalhostIdentiNo(inModelLocalhostCourseEntity.getLocalhostEntity().getLocalhostIdentiNo());

			CourseEntity outCourseEntity = courseService4DB.selectByPK(inDbCourseEntity);
			if (outCourseEntity == null) {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			} else {
				result.setCourseEntity(outCourseEntity);

				String langId = outCourseEntity.getLangId();
				String courseCd = outCourseEntity.getCourseIdentiNo();
				String localhostCd = outCourseEntity.getLocalhostIdentiNo();

				CoursePictureEntity inCoursePictureEntity = new CoursePictureEntity();
				inCoursePictureEntity.setLangId(langId);
				inCoursePictureEntity.setCourseIdentiNo(courseCd);
				inCoursePictureEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
				List<CoursePictureEntity> outCoursePictureEntityList = coursePictureService4DB.selectByCondition(inCoursePictureEntity);
				result.setCoursePictureEntityList(outCoursePictureEntityList);

				CourseInExclusionEntity inCourseInExclusionEntity = new CourseInExclusionEntity();
				inCourseInExclusionEntity.setLangId(langId);
				inCourseInExclusionEntity.setCourseIdentiNo(courseCd);
				inCourseInExclusionEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
				List<CourseInExclusionEntity> outCourseInExclusionEntityList = courseInExclusionService4DB.selectByCondition(inCourseInExclusionEntity);
				result.setCourseInExclusionEntityList(outCourseInExclusionEntityList);

				ScheduleOptionEntity inScheduleOptionEntity = new ScheduleOptionEntity();
				inScheduleOptionEntity.setLangId(langId);
				inScheduleOptionEntity.setCourseIdentiNo(courseCd);
				inScheduleOptionEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
				List<ScheduleOptionEntity> outScheduleOptionEntityList = scheduleOptionService4DB.selectByCondition(inScheduleOptionEntity);
//				result.setScheduleOptionEntityList(outScheduleOptionEntityList);
				//TODO for 1 schedule option
				result.setScheduleOptionEntity(outScheduleOptionEntityList.get(0));

				ExtraOptionEntity inExtraOptionEntity = new ExtraOptionEntity();
				inExtraOptionEntity.setLangId(langId);
				inExtraOptionEntity.setCourseIdentiNo(courseCd);
				inExtraOptionEntity.setLocalhostIdentiNo(localhostCd);
				inExtraOptionEntity.setScheduleOptionIdentiNo(result.getScheduleOptionEntity().getScheduleOptionIdentiNo());
				List<ExtraOptionEntity> outExtraOptionEntityList = extraOptionService4DB.selectByCondition(inExtraOptionEntity);
				if (outExtraOptionEntityList != null && outExtraOptionEntityList.size() > 0) {
					result.setExtraOptionEntityList(outExtraOptionEntityList);
				} else {
					result.setExtraOptionEntityList(new ArrayList<ExtraOptionEntity> ());
				}
			}
			retMsg.setHasError(false);
			retMsg.setMessage("");
			retMsg.setData(result);
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage updateCourse(Map<String, Object> paraMap) {
		String[] ignoreArray = {KooConst.LT_IGNORE_KEY_CREATE_TIME, KooConst.LT_IGNORE_KEY_MODIFY_TIME};

		CourseEntity inDbCourseEntity = new CourseEntity();

		LocalhostCourseModel inModelLocalhostCourseEntity = (LocalhostCourseModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		UploadImageModel inModelUploadImageEntity = (UploadImageModel) paraMap.get(KooConst.LT_IN_PARAM_UPLOAD_IMAGE_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			BeanUtil.copyProperties(inDbCourseEntity, inModelLocalhostCourseEntity, ignoreArray);
			inDbCourseEntity.setLocalhostIdentiNo(inModelLocalhostCourseEntity.getLocalhostEntity().getLocalhostIdentiNo());

			CourseEntity outCourseEntity = courseService4DB.selectByPK(inDbCourseEntity);
			if (outCourseEntity == null) {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			} else {
				outCourseEntity.setUseLangId(inModelLocalhostCourseEntity.getUseLangId());
				outCourseEntity.setCourseContent(inModelLocalhostCourseEntity.getCourseContent());
				outCourseEntity.setAdditionalInfo(inModelLocalhostCourseEntity.getAdditionalInfo());
				courseService4DB.updateByPK(outCourseEntity);

				List<String> uploadedImageNameList = inModelUploadImageEntity.getUploadedFileName();
				if (uploadedImageNameList != null && uploadedImageNameList.size() > 0) {
					for (String fileName : uploadedImageNameList) {
				        CoursePictureEntity inDbCoursePictureEntity = new CoursePictureEntity();
				        inDbCoursePictureEntity.setLangId(inModelLocalhostCourseEntity.getLangId());
				        inDbCoursePictureEntity.setLocalhostIdentiNo(inModelLocalhostCourseEntity.getLocalhostEntity().getLocalhostIdentiNo());
				        inDbCoursePictureEntity.setCoursePictureIdentiNo(sequenceService4DB.createSequence(KooConst.ST_COURSEPICTURE));
				        inDbCoursePictureEntity.setFullName(fileName);
				        inDbCoursePictureEntity.setFullPath(fileName);
				        //TODO
				        inDbCoursePictureEntity.setType("1");
				        inDbCoursePictureEntity.setMemo("dummy memo");
				        //TODO
				        inDbCoursePictureEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
				        inDbCoursePictureEntity.setCourseIdentiNo(inDbCourseEntity.getCourseIdentiNo());
				        coursePictureService4DB.insertOne(inDbCoursePictureEntity);
					}
				}
				retMsg.setHasError(false);
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage deleteCourse(Map<String, Object> paraMap) {
		String[] ignoreArray = {KooConst.LT_IGNORE_KEY_CREATE_TIME, KooConst.LT_IGNORE_KEY_MODIFY_TIME};

		CourseEntity inDbCourseEntity = new CourseEntity();
		CourseInExclusionEntity inDbCourseInExclusionEntity = new CourseInExclusionEntity();
		CoursePictureEntity inDbCoursePictureEntity = new CoursePictureEntity();
		ScheduleOptionEntity inDbScheduleOptionEntity = new ScheduleOptionEntity();
		ExtraOptionEntity inDbExtraOptionEntity = new ExtraOptionEntity();

		BaseModel inModelLocalhostCourseEntity = (BaseModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			BeanUtil.copyProperties(inDbCourseEntity, inModelLocalhostCourseEntity, ignoreArray);
			inDbCourseEntity.setLocalhostIdentiNo(inModelLocalhostCourseEntity.getLocalhostEntity().getLocalhostIdentiNo());

			CourseEntity outCourseEntity = courseService4DB.selectByPK(inDbCourseEntity);
			if (outCourseEntity == null) {
				retMsg.setHasError(true);
				retMsg.setMessage("No data");
			} else {
				outCourseEntity.setDelFlg(KooConst.LT_DEL_FLG_Y);
				courseService4DB.updateByPK(outCourseEntity);

				String courseCd = outCourseEntity.getCourseIdentiNo();

				inDbCourseInExclusionEntity.setCourseIdentiNo(courseCd);
				inDbCourseInExclusionEntity.setDelFlg(KooConst.LT_DEL_FLG_Y);
				courseInExclusionService4DB.updateByPK(inDbCourseInExclusionEntity);

				inDbCoursePictureEntity.setCourseIdentiNo(courseCd);
				inDbCoursePictureEntity.setDelFlg(KooConst.LT_DEL_FLG_Y);
				coursePictureService4DB.updateByPK(inDbCoursePictureEntity);

				inDbScheduleOptionEntity.setCourseIdentiNo(courseCd);
				inDbScheduleOptionEntity.setDelFlg(KooConst.LT_DEL_FLG_Y);
				scheduleOptionService4DB.updateByPK(inDbScheduleOptionEntity);

				inDbExtraOptionEntity.setCourseIdentiNo(courseCd);
				inDbExtraOptionEntity.setDelFlg(KooConst.LT_DEL_FLG_Y);
				extraOptionService4DB.updateByPK(inDbExtraOptionEntity);
			}
			retMsg.setHasError(false);
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage uploadImage(Map<String, Object> paraMap) {
		KootourMessage retMsg = new KootourMessage();
		UploadImageModel inModelLocalhostCourseEntity = (UploadImageModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		try {
			File srcFile = inModelLocalhostCourseEntity.getFile();
			String srcFileName = inModelLocalhostCourseEntity.getFileFileName();
	        String suffix = srcFileName.substring(srcFileName.lastIndexOf("."));
	        String newName = Calendar.getInstance().getTimeInMillis() + suffix;
	        String newPath = "/home/kootour_dev/webapps/upload/images/" + newName;
//	        String newPath = "C:/upload/" + newName;
	        File destFile = new File(newPath);

	        doCopy(srcFile, destFile);

	        retMsg.setHasError(false);
	        retMsg.setMessage("Upload success.");
	        retMsg.setData(newName);
	        return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	private void doCopy(File src, File dest) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        byte [] buf = new byte [2048];
        int len = -1;
        while((len = bis.read(buf)) != -1) {
            bos.write(buf);
        }
        bis.close();
        bos.close();
	}

	private List<String> getDatesBetweenTwoDate(String bgnDateStr, String endDateStr) throws ParseException {
		List<String> ret = new ArrayList<String> ();
		LocalDate dateBgn = LocalDate.parse(bgnDateStr, DateTimeFormatter.BASIC_ISO_DATE);// "YYYYMMDD"
		LocalDate dateEnd = LocalDate.parse(endDateStr, DateTimeFormatter.BASIC_ISO_DATE);// "YYYYMMDD"
		while (dateBgn.isBefore(dateEnd) || dateBgn.isEqual(dateEnd)) {
			ret.add(dateBgn.format(DateTimeFormatter.BASIC_ISO_DATE));
			dateBgn = dateBgn.plusDays(1);
		}
		return ret;
	}

	@Override
	public KootourMessage deleteImage(Map<String, Object> paraMap) {
		UploadImageModel inModelEntity = (UploadImageModel) paraMap
				.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		String coursePictureCd = inModelEntity.getCoursePictureIdentiNo();
		KootourMessage retMsg = new KootourMessage();
		try {
			CoursePictureEntity inDbCoursePictureEntity = new CoursePictureEntity();
			inDbCoursePictureEntity.setLangId(inModelEntity.getLangId());
			inDbCoursePictureEntity.setCoursePictureIdentiNo(coursePictureCd);
			inDbCoursePictureEntity.setLocalhostIdentiNo(inModelEntity.getLocalhostEntity().getLocalhostIdentiNo());
			inDbCoursePictureEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			List<CoursePictureEntity> outCoursePictureEntityList = coursePictureService4DB.selectByCondition(inDbCoursePictureEntity);

			if (outCoursePictureEntityList != null && outCoursePictureEntityList.size() > 0) {
				for (CoursePictureEntity entity : outCoursePictureEntityList) {
					entity.setDelFlg(KooConst.LT_DEL_FLG_Y);
					coursePictureService4DB.updateByPK(entity);
				}
				retMsg.setHasError(false);
			} else {
				retMsg.setHasError(true);
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}
	
	@Override
	public List<LocationMstEntity> getLocationMstEntityList(String langId) {
		
		LocationMstEntity inLocationMstEntity = new LocationMstEntity();
		inLocationMstEntity.setLangId(langId);
		inLocationMstEntity.setType(KooConst.LOCATION_TYPE_CITY);
		inLocationMstEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
		List<LocationMstEntity> outLocationMstEntityList = locationMstService4DB.selectByCondition(inLocationMstEntity);
		if (outLocationMstEntityList != null && outLocationMstEntityList.size() > 0) {
			outLocationMstEntityList.add(0, new LocationMstEntity());
			return outLocationMstEntityList;
		} else {
			
			outLocationMstEntityList = new ArrayList<LocationMstEntity>();
			outLocationMstEntityList.add(0, new LocationMstEntity());
			return outLocationMstEntityList;
		}
	}
}
