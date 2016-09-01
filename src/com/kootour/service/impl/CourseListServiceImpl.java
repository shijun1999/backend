package com.kootour.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.common.BeanUtil;
import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.CourseEntity;
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.UserOrderEntity;
import com.kootour.model.BaseModel;
import com.kootour.model.LocalhostCourseListModel;
import com.kootour.service.CourseListService;
import com.kootour.service4db.CoursePictureService4DB;
import com.kootour.service4db.CourseService4DB;
import com.kootour.service4db.UserOrderService4DB;
import com.kootour.transfer.CourseListTransfer;
@Configuration
@Service
public class CourseListServiceImpl implements CourseListService {

	@Resource
	CourseService4DB courseService4DB;

	@Resource
	CoursePictureService4DB coursePictureService4DB;

	@Resource
	UserOrderService4DB userOrderService4DB;

	@Override
	public KootourMessage load(Map<String, Object> paraMap) {
		String[] ignoreArray = {KooConst.LT_IGNORE_KEY_CREATE_TIME, KooConst.LT_IGNORE_KEY_MODIFY_TIME};

		List<CourseListTransfer> retList =  new ArrayList<CourseListTransfer> ();

		CourseEntity inDbCourseEntity = new CourseEntity();
		LocalhostCourseListModel inModelLocalhostCourseListEntity = (LocalhostCourseListModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			inDbCourseEntity.setLangId(inModelLocalhostCourseListEntity.getLangId());
			inDbCourseEntity.setLocalhostIdentiNo(inModelLocalhostCourseListEntity.getLocalhostEntity().getLocalhostIdentiNo());
			inDbCourseEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			List<CourseEntity> courseEntityList = courseService4DB.selectByCondition(inDbCourseEntity);
			if (courseEntityList != null && courseEntityList.size() > 0) {
				for (CourseEntity courseEntity : courseEntityList) {

					CourseListTransfer courseListTransfer = new CourseListTransfer();

					CoursePictureEntity inDbCoursePictureEntity = new CoursePictureEntity();

					BeanUtil.copyProperties(inDbCoursePictureEntity, courseEntity, ignoreArray);

					inDbCoursePictureEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

					List<CoursePictureEntity> coursePictureEntityList = coursePictureService4DB.selectByCondition(inDbCoursePictureEntity);

					courseListTransfer.setCourseEntity(courseEntity);
					courseListTransfer.setCoursePictureEntityList(coursePictureEntityList);

					UserOrderEntity inDbUserOrderEntity = new UserOrderEntity();
					inDbUserOrderEntity.setLocalhostIdentiNo(courseEntity.getLocalhostIdentiNo());
					inDbUserOrderEntity.setLangId(courseEntity.getLangId());
					inDbUserOrderEntity.setCourseIdentiNo(courseEntity.getCourseIdentiNo());
					inDbUserOrderEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
					List<UserOrderEntity> outUserOrderEntityList = userOrderService4DB.selectByCondition(inDbUserOrderEntity);
					if (outUserOrderEntityList != null && outUserOrderEntityList.size() > 0) {
						courseListTransfer.setCanDelete(false);
					} else {
						courseListTransfer.setCanDelete(true);
					}
					retList.add(courseListTransfer);
				}
				retMsg.setHasError(false);
				retMsg.setData(retList);
			} else {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage updateCourseStatus(Map<String, Object> paraMap) {

		BaseModel inModel = (BaseModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			CourseEntity inDbEntity = new CourseEntity();
			inDbEntity.setLangId(inModel.getLangId());
			inDbEntity.setCourseIdentiNo(inModel.getCourseIdentiNo());

			CourseEntity outDbEntity = courseService4DB.selectByPK(inDbEntity);
			if (outDbEntity == null) {
				retMsg.setHasError(true);
				retMsg.setMessage("No data");
			} else {
				outDbEntity.setOkFlg(outDbEntity.getOkFlg().equals(KooConst.LT_OK_FLG_Y) ? KooConst.LT_OK_FLG_N : KooConst.LT_OK_FLG_Y);
				courseService4DB.updateByPK(outDbEntity);

				retMsg.setHasError(false);
				retMsg.setMessage("Change course status successfully");
				retMsg.setData(outDbEntity.getOkFlg());
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}
}
