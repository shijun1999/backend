package com.kootour.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.CourseEntity;
import com.kootour.mapper.entity.CourseInExclusionEntity;
import com.kootour.mapper.entity.CourseScheduleEntity;
import com.kootour.mapper.entity.TouristEntity;
import com.kootour.mapper.entity.UserOrderEntity;
import com.kootour.model.LocalhostExclusiveDateModel;
import com.kootour.model.LocalhostReceivedBookingModel;
import com.kootour.service.CourseScheduleService;
import com.kootour.service4db.CourseInExclusionService4DB;
import com.kootour.service4db.CourseScheduleService4DB;
import com.kootour.service4db.CourseService4DB;
import com.kootour.service4db.TouristService4DB;
import com.kootour.service4db.UserOrderService4DB;
import com.kootour.transfer.ExclusiveDateTransfer;
import com.kootour.transfer.ReceivedBookingTransfer;

@Configuration
@Service
public class CourseScheduleServiceImpl implements CourseScheduleService {

	@Resource
	CourseService4DB courseService4DB;

	@Resource
	CourseScheduleService4DB courseScheduleService4DB;

	@Resource
	CourseInExclusionService4DB courseInExclusionService4DB;

	@Resource
	UserOrderService4DB userOrderService4DB;

	@Resource
	TouristService4DB touristService4DB;

	@Override
	public KootourMessage receivedBookingInit(Map<String, Object> paraMap) {
		ReceivedBookingTransfer receivedBookingTransfer = new ReceivedBookingTransfer();
		LocalhostReceivedBookingModel inModelEntity = (LocalhostReceivedBookingModel) paraMap
				.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			CourseScheduleEntity inDbCourseSchedule = new CourseScheduleEntity();
			inDbCourseSchedule.setLocalhostIdentiNo(
					inModelEntity.getLocalhostEntity().getLocalhostIdentiNo());
			inDbCourseSchedule.setLangId(inModelEntity.getLangId());
			inDbCourseSchedule.setStatus(KooConst.LT_OK_FLG_Y);
			inDbCourseSchedule.setDelFlg(KooConst.LT_DEL_FLG_N);

			List<CourseScheduleEntity> outCourseScheduleEntityList = courseScheduleService4DB
					.selectDistinctWorkDate(inDbCourseSchedule);

			if (outCourseScheduleEntityList != null && outCourseScheduleEntityList.size() > 0) {
				List<String> workDay = new ArrayList<String>();
				for (CourseScheduleEntity courseScheduleEntity : outCourseScheduleEntityList) {
					workDay.add(courseScheduleEntity.getWorkDate());
				}
				receivedBookingTransfer.setWorkDayList(workDay);

				UserOrderEntity inDbUserOrderEntity = new UserOrderEntity();
				inDbUserOrderEntity.setLocalhostIdentiNo(inDbCourseSchedule.getLocalhostIdentiNo());
				inDbUserOrderEntity.setLangId(inDbCourseSchedule.getLangId());
				inDbUserOrderEntity.setStatus(KooConst.LT_OK_FLG_Y);
				inDbUserOrderEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
				List<UserOrderEntity> outUserOrderEntityList = userOrderService4DB
						.selectByCondition(inDbUserOrderEntity);

				if (outUserOrderEntityList != null && outUserOrderEntityList.size() > 0) {
					receivedBookingTransfer.setUserOrderEntityList(outUserOrderEntityList);
				}
				retMsg.setHasError(false);
				retMsg.setMessage("Success");
				retMsg.setData(receivedBookingTransfer);
			} else {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage fetchOrderBookingDetail(Map<String, Object> paraMap) {
		ReceivedBookingTransfer receivedBookingTransfer = new ReceivedBookingTransfer();
		LocalhostReceivedBookingModel inModelEntity = (LocalhostReceivedBookingModel) paraMap
				.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			CourseEntity inDbCourseEntity = new CourseEntity();
			inDbCourseEntity.setLocalhostIdentiNo(
					inModelEntity.getLocalhostEntity().getLocalhostIdentiNo());
			inDbCourseEntity.setLangId(inModelEntity.getLangId());
			inDbCourseEntity.setCourseIdentiNo(inModelEntity.getCourseIdentiNo());
			inDbCourseEntity.setOkFlg(KooConst.LT_OK_FLG_Y);
			inDbCourseEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			CourseEntity outDbCourseEntity = courseService4DB.selectByPK(inDbCourseEntity);
			receivedBookingTransfer.setCourseEntity(outDbCourseEntity);

			CourseInExclusionEntity inCourseInExclusionEntity = new CourseInExclusionEntity();
			inCourseInExclusionEntity.setLangId(outDbCourseEntity.getLangId());
			inCourseInExclusionEntity.setCourseIdentiNo(outDbCourseEntity.getCourseIdentiNo());
			inCourseInExclusionEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			List<CourseInExclusionEntity> outCourseInExclusionEntityList = courseInExclusionService4DB
					.selectByCondition(inCourseInExclusionEntity);
			receivedBookingTransfer.setCourseInExclusionEntityList(outCourseInExclusionEntityList);

			TouristEntity inDbTouristEntity = new TouristEntity();
			inDbTouristEntity.setLangId(inModelEntity.getLangId());
			inDbTouristEntity.setTouristIdentiNo(inModelEntity.getTouristIdentiNo());
			inDbTouristEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			TouristEntity outDbTouristEntity = touristService4DB.selectByPK(inDbTouristEntity);
			receivedBookingTransfer.setTouristEntity(outDbTouristEntity);

			retMsg.setHasError(false);
			retMsg.setMessage("Success");
			retMsg.setData(receivedBookingTransfer);

			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage exclusiveDateInit(Map<String, Object> paraMap) {
		ExclusiveDateTransfer exclusiveDateTransfer = new ExclusiveDateTransfer();
		LocalhostExclusiveDateModel inModelEntity = (LocalhostExclusiveDateModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			CourseScheduleEntity inDbCourseSchedule = new CourseScheduleEntity();
			inDbCourseSchedule.setLocalhostIdentiNo(
					inModelEntity.getLocalhostEntity().getLocalhostIdentiNo());
			inDbCourseSchedule.setLangId(inModelEntity.getLangId());
			inDbCourseSchedule.setStatus(KooConst.LT_OK_FLG_Y);
			inDbCourseSchedule.setDelFlg(KooConst.LT_DEL_FLG_N);

			List<CourseScheduleEntity> outCourseScheduleEntityList = courseScheduleService4DB
					.selectDistinctWorkDate(inDbCourseSchedule);

			if (outCourseScheduleEntityList != null && outCourseScheduleEntityList.size() > 0) {
				List<String> workDay = new ArrayList<String>();
				for (CourseScheduleEntity courseScheduleEntity : outCourseScheduleEntityList) {
					workDay.add(courseScheduleEntity.getWorkDate());
				}
				exclusiveDateTransfer.setWorkDayList(workDay);

				UserOrderEntity inDbUserOrderEntity = new UserOrderEntity();
				inDbUserOrderEntity.setLocalhostIdentiNo(inDbCourseSchedule.getLocalhostIdentiNo());
				inDbUserOrderEntity.setLangId(inDbCourseSchedule.getLangId());
				inDbUserOrderEntity.setStatus(KooConst.LT_OK_FLG_Y);
				inDbUserOrderEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
				List<UserOrderEntity> outUserOrderEntityList = userOrderService4DB
						.selectByCondition(inDbUserOrderEntity);

				if (outUserOrderEntityList != null && outUserOrderEntityList.size() > 0) {
					List<String> orderDayList = new ArrayList<String>();
					for (UserOrderEntity orderEntity : outUserOrderEntityList) {
						String orderDate = orderEntity.getReservationDate();
						orderDayList.add(orderDate);
					}
					exclusiveDateTransfer.setOrderDayList(orderDayList);
				}

				retMsg.setHasError(false);
				retMsg.setMessage("Success");
				retMsg.setData(exclusiveDateTransfer);

			} else {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage exclusiveDateClickEvent(Map<String, Object> paraMap) {
		LocalhostExclusiveDateModel inModelLocalhostExclusiveDateEntity = (LocalhostExclusiveDateModel) paraMap
				.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		String clickType = inModelLocalhostExclusiveDateEntity.getClickType();
		String clickDay = inModelLocalhostExclusiveDateEntity.getClickDay();

		KootourMessage retMsg = new KootourMessage();
		try {
			CourseScheduleEntity inDbCourseSchedule = new CourseScheduleEntity();
			inDbCourseSchedule.setLangId(inModelLocalhostExclusiveDateEntity.getLangId());
			inDbCourseSchedule.setLocalhostIdentiNo(inModelLocalhostExclusiveDateEntity.getLocalhostEntity().getLocalhostIdentiNo());
			inDbCourseSchedule.setStatus(clickType.equals(KooConst.LT_OK_FLG_Y) ? KooConst.LT_OK_FLG_Y : KooConst.LT_OK_FLG_N);
			inDbCourseSchedule.setWorkDate(clickDay);
			inDbCourseSchedule.setDelFlg(KooConst.LT_DEL_FLG_N);

			List<CourseScheduleEntity> outCourseScheduleEntityList = courseScheduleService4DB.selectByCondition(inDbCourseSchedule);

			if (outCourseScheduleEntityList != null && outCourseScheduleEntityList.size() > 0) {
				for (CourseScheduleEntity entity : outCourseScheduleEntityList) {
					entity.setStatus(clickType.equals(KooConst.LT_OK_FLG_Y) ? KooConst.LT_OK_FLG_N : KooConst.LT_OK_FLG_Y);
					courseScheduleService4DB.updateByPK(entity);
				}
				retMsg.setHasError(false);
			} else {
				retMsg.setHasError(true);
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(e.getMessage());
			return retMsg;
		}
	}
}