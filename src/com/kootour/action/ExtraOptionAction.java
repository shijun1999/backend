//Auto Generated 

package com.kootour.action;

import org.apache.struts2.config.Results;

import com.kootour.common.KooConst;
import com.kootour.common.KooUtil;
import com.kootour.mapper.entity.ExtraOptionEntity;
import com.kootour.model.ExtraOptionModel;

@Results({})
public class ExtraOptionAction extends ExtraOptionModel {

	public void copyEntity2EntityAction(ExtraOptionEntity tEntity) {
		if (tEntity.getExtraOptionIdentiNo() == null) {
			setExtraOptionIdentiNo("");
		} else {
			setExtraOptionIdentiNo(tEntity.getExtraOptionIdentiNo());
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
		if (tEntity.getScheduleOptionIdentiNo() == null) {
			setScheduleOptionIdentiNo("");
		} else {
			setScheduleOptionIdentiNo(tEntity.getScheduleOptionIdentiNo());
		}
		if (tEntity.getDispOrder() == null) {
			setDispOrder("");
		} else {
			setDispOrder(String.valueOf(tEntity.getDispOrder()));
		}
		if (tEntity.getExtraOptionName() == null) {
			setExtraOptionName("");
		} else {
			setExtraOptionName(tEntity.getExtraOptionName());
		}
		if (tEntity.getExtraPrice() == null) {
			setExtraPrice("");
		} else {
			setExtraPrice(String.valueOf(tEntity.getExtraPrice()));
		}
		if (tEntity.getExtraTime() == null) {
			setExtraTime("");
		} else {
			setExtraTime(String.valueOf(tEntity.getExtraTime()));
		}
		if (tEntity.getExtraUnit() == null) {
			setExtraUnit("");
		} else {
			setExtraUnit(tEntity.getExtraUnit());
		}
		if (tEntity.getDelFlg() == null) {
			setDelFlg("");
		} else {
			setDelFlg(tEntity.getDelFlg());
		}
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

	public ExtraOptionEntity copyEntityAction2Entity(ExtraOptionModel tExtraOptionModel) {
		ExtraOptionEntity tEntity = new ExtraOptionEntity();
		// set common info
		tEntity.setExtraOptionIdentiNo(tExtraOptionModel.getExtraOptionIdentiNo());
		tEntity.setCourseIdentiNo(tExtraOptionModel.getCourseIdentiNo());
		tEntity.setLocalhostIdentiNo(tExtraOptionModel.getLocalhostIdentiNo());
		tEntity.setScheduleOptionIdentiNo(tExtraOptionModel.getScheduleOptionIdentiNo());
		if (KooUtil.isNotInt(tExtraOptionModel.getDispOrder())) {
			tEntity.setDispOrder(null);
		} else {
			tEntity.setDispOrder(Integer.parseInt(tExtraOptionModel.getDispOrder()));
		}
		tEntity.setExtraOptionName(tExtraOptionModel.getExtraOptionName());
		if (KooUtil.isNotDouble(tExtraOptionModel.getExtraPrice())) {
			tEntity.setExtraPrice(null);
		} else {
			tEntity.setExtraPrice(Double.parseDouble(tExtraOptionModel.getExtraPrice()));
		}
		if (KooUtil.isNotDouble(tExtraOptionModel.getExtraTime())) {
			tEntity.setExtraTime(null);
		} else {
			tEntity.setExtraTime(Double.parseDouble(tExtraOptionModel.getExtraTime()));
		}
		tEntity.setExtraUnit(tExtraOptionModel.getExtraUnit());
		
		tEntity.setDelFlg(tExtraOptionModel.getDelFlg());
		
		if (KooUtil.isNotDate(tExtraOptionModel.getCreateTime())) {
			tEntity.setCreateTime(null);
		} else {
			tEntity.setCreateTime(KooUtil.string2Date(tExtraOptionModel.getCreateTime(), KooConst.ST_yyyyMMddHHmmss));
		}
		if (KooUtil.isNotDate(tExtraOptionModel.getModifyTime())) {
			tEntity.setModifyTime(null);
		} else {
			tEntity.setModifyTime(KooUtil.string2Date(tExtraOptionModel.getModifyTime(), KooConst.ST_yyyyMMddHHmmss));
		}
		return tEntity;

	}
}
